package io.github.moosbusch.permagon.media.svg.impl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.apache.batik.gvt.renderer.ImageRenderer;
import org.apache.batik.gvt.renderer.StaticRenderer;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;


public class SvgImageIcon {

    private ImageTranscoder transcoder;
    private int width;
    private int height;
    private BufferedImage offScreen;
    private final InputStream input;

    public SvgImageIcon(InputStream input, int width, int height) {
        this.input = Objects.requireNonNull(input);
        this.width = Math.max(width, 1);
        this.height = Math.max(height, 1);
        transcode();
    }

    public SvgImageIcon(InputStream input, int size) {
        this(input, size, size);
    }

    private void transcode() {
        ImageTranscoder t = getTranscoder();

        synchronized (SvgImageIcon.this) {
            t.addTranscodingHint(ImageTranscoder.KEY_WIDTH,
                    Float.valueOf(String.valueOf(getWidth())));
            t.addTranscodingHint(ImageTranscoder.KEY_HEIGHT,
                    Float.valueOf(String.valueOf(getHeight())));

            try {
                t.transcode(new TranscoderInput(getInput()), null);
            } catch (TranscoderException ex) {
                Logger.getLogger(SvgImageIcon.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
    }

    protected ImageTranscoder createTranscoder() {
        return new ImageTranscoderImpl();
    }

    protected final void setOffScreen(
            final BufferedImage newOffScreen) {
        if (newOffScreen != null) {
            this.offScreen = newOffScreen;
        }
    }

    protected final InputStream getInput() {
        return input;
    }

    protected final ImageTranscoder getTranscoder() {
        if (this.transcoder == null) {
            this.transcoder = createTranscoder();
        }

        return this.transcoder;
    }

    protected final GraphicsConfiguration getDefaultGraphicsConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return ge.getDefaultScreenDevice().getDefaultConfiguration();
    }

    protected final BufferedImage createCompatibleImage(int width,
            int height, boolean translucent) {
        GraphicsConfiguration config = getDefaultGraphicsConfiguration();

        if (translucent) {
            return config.createCompatibleImage(Math.max(1, width),
                    Math.max(1, height), Transparency.TRANSLUCENT);
        }

        return config.createCompatibleImage(width, height, Transparency.OPAQUE);
    }

    public final BufferedImage getImage() {
        return offScreen;
    }

    public final ImageIcon getImageIcon() {
        BufferedImage img = getImage();

        if (img != null) {
            return new ImageIcon(img);
        }

        return null;
    }

    public final int getHeight() {
        return height;
    }

    public final void setHeight(int height) {
        this.height = height;
        transcode();
    }

    public final int getWidth() {
        return width;
    }

    public final void setWidth(int width) {
        this.width = width;
        transcode();
    }

    public final void paint(Graphics g, int x, int y) {
        if (offScreen != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.drawImage(offScreen, x, y, null);
            g2.dispose();
        }
    }

    private class ImageTranscoderImpl extends ImageTranscoder {

        @Override
        protected ImageRenderer createRenderer() {
            return new StaticRenderer();
        }

        @Override
        public void writeImage(BufferedImage img, TranscoderOutput out)
                throws TranscoderException {
            setOffScreen(img);
        }

        @Override
        public BufferedImage createImage(int width, int height) {
            return createCompatibleImage(getWidth(), getHeight(), true);
        }
    }
}
