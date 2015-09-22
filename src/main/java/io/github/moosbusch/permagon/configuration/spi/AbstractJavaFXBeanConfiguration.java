package io.github.moosbusch.permagon.configuration.spi;

import io.github.moosbusch.permagon.configuration.JavaFXBeanConfiguration;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.HashSet;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyMapProperty;
import javafx.beans.property.ReadOnlyMapWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlySetProperty;
import javafx.beans.property.ReadOnlySetWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanDoublePropertyBuilder;
import javafx.beans.property.adapter.JavaBeanFloatPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanIntegerPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanLongPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanPropertyBuilder;
import javafx.beans.property.adapter.ReadOnlyJavaBeanDoublePropertyBuilder;
import javafx.beans.property.adapter.ReadOnlyJavaBeanFloatPropertyBuilder;
import javafx.beans.property.adapter.ReadOnlyJavaBeanIntegerPropertyBuilder;
import javafx.beans.property.adapter.ReadOnlyJavaBeanLongPropertyBuilder;
import javafx.beans.property.adapter.ReadOnlyJavaBeanObjectPropertyBuilder;
import javafx.beans.property.adapter.ReadOnlyJavaBeanStringPropertyBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableIntegerArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.css.StyleConverter;
import javafx.css.StyleOrigin;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.BoundingBox;
import javafx.geometry.Dimension2D;
import javafx.geometry.HPos;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.geometry.VerticalDirection;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.PaperSource;
import javafx.print.PrintColor;
import javafx.print.PrintQuality;
import javafx.print.PrintSides;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.AmbientLight;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.Axis;
import javafx.scene.chart.Axis.TickMark;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Cell;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.IndexRange;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.scene.control.PopupControl;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeSortMode;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.ChoiceBoxTreeCell;
import javafx.scene.control.cell.ChoiceBoxTreeTableCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.ComboBoxTreeCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.ProgressBarTreeTableCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.InputMethodHighlight;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.CornerRadiiConverter;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.media.EqualizerBand;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Mesh;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.VLineTo;
import javafx.scene.shape.VertexFormat;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.BigIntegerStringConverter;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.ByteStringConverter;
import javafx.util.converter.CharacterStringConverter;
import javafx.util.converter.CurrencyStringConverter;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.DateTimeStringConverter;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;
import javafx.util.converter.LocalTimeStringConverter;
import javafx.util.converter.LongStringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.util.converter.PercentageStringConverter;
import javafx.util.converter.ShortStringConverter;
import javafx.util.converter.TimeStringConverter;
import netscape.javascript.JSException;
import org.apache.felix.framework.Felix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public abstract class AbstractJavaFXBeanConfiguration implements JavaFXBeanConfiguration {

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JFXPanel createJFXPanel() {
        return new JFXPanel();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Shear createShear() {
        return new Shear();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TimeStringConverter createTimeStringConverter() {
        return new TimeStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeTableCell createTreeTableCell() {
        return new TreeTableCell();
    }

//    @Lazy
//    @Bean
//    @Override @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public Stop createStop() {
//        return new Stop();
//    }
    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ChoiceBoxTableCell createChoiceBoxTableCell() {
        return new ChoiceBoxTableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaBeanIntegerPropertyBuilder createJavaBeanIntegerPropertyBuilder() {
        return new JavaBeanIntegerPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Sphere createSphere() {
        return new Sphere();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaBeanLongPropertyBuilder createJavaBeanLongPropertyBuilder() {
        return new JavaBeanLongPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Button createButton() {
        return new Button();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DropShadow createDropShadow() {
        return new DropShadow();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Popup createPopup() {
        return new Popup();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DataFormat createDataFormat() {
        return new DataFormat();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextFlow createTextFlow() {
        return new TextFlow();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Orientation createOrientation() {
        return Orientation.HORIZONTAL;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Line createLine() {
        return new Line();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeCell createTreeCell() {
        return new TreeCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyObjectWrapper createReadOnlyObjectWrapper() {
        return new ReadOnlyObjectWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ColorInput createColorInput() {
        return new ColorInput();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HBox createHBox() {
        return new HBox();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ClipboardContent createClipboardContent() {
        return new ClipboardContent();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Font createFont() {
        return Font.getDefault();
    }

//    @Lazy
//    @Bean
//    @Override @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public Event createEventEvent() {
//        return new Event();
//    }
//    @Lazy
//    @Bean
//    @Override @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public MapValueFactory createMapValueFactory() {
//        return new MapValueFactory();
//    }
    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlySetWrapper createReadOnlySetWrapper() {
        return new ReadOnlySetWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PasswordField createPasswordField() {
        return new PasswordField();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ProgressBar createProgressBar() {
        return new ProgressBar();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaFXBuilderFactory createJavaFXBuilderFactory() {
        return new JavaFXBuilderFactory();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Path createPath() {
        return new Path();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public IntegerProperty createIntegerProperty() {
        return new SimpleIntegerProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ToggleButton createToggleButton() {
        return new ToggleButton();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyJavaBeanBooleanPropertyBuilder createReadOnlyJavaBeanBooleanPropertyBuilder() {
        return new ReadOnlyJavaBeanBooleanPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Rectangle2D createRectangle2D() {
        return new Rectangle2D(0.0d, 0.0d, 0.0d, 0.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BarChart createBarChart(Axis axis, Axis axis1) {
        return new BarChart(axis, axis1);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public Rectangle createRectangle() {
        return new Rectangle();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ChoiceBoxTreeCell createChoiceBoxTreeCell() {
        return new ChoiceBoxTreeCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ProgressBarTableCell createProgressBarTableCell() {
        return new ProgressBarTableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public VerticalDirection createVerticalDirection() {
        return VerticalDirection.DOWN;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Timeline createTimeline() {
        return new Timeline();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ToolBar createToolBar() {
        return new ToolBar();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CornerRadii createCornerRadii() {
        return CornerRadii.EMPTY;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PercentageStringConverter createPercentageStringConverter() {
        return new PercentageStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Separator createSeparator() {
        return new Separator();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Hyperlink createHyperlink() {
        return new Hyperlink();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ComboBoxTreeCell<?> createComboBoxTreeCell() {
        return new ComboBoxTreeCell<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextArea createTextArea() {
        return new TextArea();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public VLineTo createVLineTo() {
        return new VLineTo();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CullFace createCullFace() {
        return CullFace.NONE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StrokeType createStrokeType() {
        return StrokeType.CENTERED;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyObjectProperty createReadOnlyObjectProperty() {
        return new SimpleObjectProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ListView createListView() {
        return new ListView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyFloatWrapper createReadOnlyFloatWrapper() {
        return new ReadOnlyFloatWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FileChooser createFileChooser() {
        return new FileChooser();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Point2D createPoint2D() {
        return new Point2D(0.0d, 0.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Light createLight() {
        return new Light.Distant();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyListProperty createReadOnlyListProperty() {
        return new SimpleListProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextFieldListCell createTextFieldListCell() {
        return new TextFieldListCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PageOrientation createPageOrientation() {
        return PageOrientation.PORTRAIT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public GaussianBlur createGaussianBlur() {
        return new GaussianBlur();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyBooleanWrapper createReadOnlyBooleanWrapper() {
        return new ReadOnlyBooleanWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CheckBoxTreeItem createCheckBoxTreeItem() {
        return new CheckBoxTreeItem();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Tooltip createTooltip() {
        return new Tooltip();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JSException createJSException() {
        return new JSException();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public RadioButton createRadioButton() {
        return new RadioButton();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DialogPane createDialogPane() {
        return new DialogPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ClosePath createClosePath() {
        return new ClosePath();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DateTimeStringConverter createDateTimeStringConverter() {
        return new DateTimeStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Point3D createPoint3D() {
        return new Point3D(0.0d, 0.0d, 0.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PerspectiveTransform createPerspectiveTransform() {
        return new PerspectiveTransform();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Polyline createPolyline() {
        return new Polyline();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PointLight createPointLight() {
        return new PointLight();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SelectionMode createSelectionMode() {
        return SelectionMode.MULTIPLE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public IntegerStringConverter createIntegerStringConverter() {
        return new IntegerStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FontWeight createFontWeight() {
        return FontWeight.NORMAL;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HPos createHPos() {
        return HPos.LEFT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PieChart createPieChart() {
        return new PieChart();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ImageInput createImageInput() {
        return new ImageInput();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ProgressIndicator createProgressIndicator() {
        return new ProgressIndicator();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FontPosture createFontPosture() {
        return FontPosture.REGULAR;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyListWrapper createReadOnlyListWrapper() {
        return new ReadOnlyListWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyMapWrapper createReadOnlyMapWrapper() {
        return new ReadOnlyMapWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FadeTransition createFadeTransition() {
        return new FadeTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public IndexedCell createIndexedCell() {
        return new IndexedCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Cylinder createCylinder() {
        return new Cylinder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleMapProperty<?, ?> createSimpleMapProperty() {
        return new SimpleMapProperty<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlySetProperty<?> createReadOnlySetProperty() {
        return new SimpleSetProperty<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public RotateTransition createRotateTransition() {
        return new RotateTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ToggleGroup createToggleGroup() {
        return new ToggleGroup();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DoubleProperty createDoubleProperty() {
        return new SimpleDoubleProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DateCell createDateCell() {
        return new DateCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleListProperty createSimpleListProperty() {
        return new SimpleListProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PrintSides createPrintSides() {
        return PrintSides.ONE_SIDED;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TilePane createTilePane() {
        return new TilePane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PathTransition createPathTransition() {
        return new PathTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextFieldTableCell createTextFieldTableCell() {
        return new TextFieldTableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StrokeLineCap createStrokeLineCap() {
        return StrokeLineCap.SQUARE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FlowPane createFlowPane() {
        return new FlowPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ObjectProperty createObjectProperty() {
        return new SimpleObjectProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public GridPane createGridPane() {
        return new GridPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Reflection createReflection() {
        return new Reflection();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaBeanFloatPropertyBuilder createJavaBeanFloatPropertyBuilder() {
        return new JavaBeanFloatPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public IndexRange createIndexRange() {
        return new IndexRange(0, 100);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyLongProperty createReadOnlyLongProperty() {
        return new SimpleLongProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeTableColumn createTreeTableColumn() {
        return new TreeTableColumn();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ScrollPane createScrollPane() {
        return new ScrollPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TableRow createTableRow() {
        return new TableRow();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DatePicker createDatePicker() {
        return new DatePicker();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeSortMode createTreeSortMode() {
        return TreeSortMode.ONLY_FIRST_LEVEL;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CycleMethod createCycleMethod() {
        return CycleMethod.NO_CYCLE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ParallelCamera createParallelCamera() {
        return new ParallelCamera();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PrintQuality createPrintQuality() {
        return PrintQuality.NORMAL;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public StackedBarChart createStackedBarChart(Axis axis, Axis axis1) {
        return new StackedBarChart(axis, axis1);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaBeanObjectPropertyBuilder createJavaBeanObjectPropertyBuilder() {
        return new JavaBeanObjectPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeTableView createTreeTableView() {
        return new TreeTableView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Side createSide() {
        return Side.BOTTOM;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BigDecimalStringConverter createBigDecimalStringConverter() {
        return new BigDecimalStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public Felix createFelix() {
        return new Felix(new HashMap<>());
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ValueAxis<?> createValueAxis() {
        return new NumberAxis();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BoundingBox createBoundingBox() {
        return new BoundingBox(0.0d, 0.0d, 0.0d, 0.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HTMLEditor createHTMLEditor() {
        return new HTMLEditor();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BorderStroke createBorderStroke(BorderStrokeStyle style,
            CornerRadii radii, BorderWidths widths) {
        return new BorderStroke(Color.BLACK, style, radii, widths);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PauseTransition createPauseTransition() {
        return new PauseTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PrintColor createPrintColor() {
        return PrintColor.COLOR;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Menu createMenu() {
        return new Menu();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FloatProperty createFloatProperty() {
        return new SimpleFloatProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ParallelTransition createParallelTransition() {
        return new ParallelTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TickMark createTickMark() {
        return new TickMark();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyJavaBeanObjectPropertyBuilder createReadOnlyJavaBeanObjectPropertyBuilder() {
        return new ReadOnlyJavaBeanObjectPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextFieldTreeTableCell<?, ?> createTextFieldTreeTableCell() {
        return new TextFieldTreeTableCell<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Text createText() {
        return new Text();
    }

//    @Lazy
//    @Bean
//    @Override @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public StringPropertyBase createStringPropertyBase() {
//        return new StringPropertyBase();
//    }
    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SceneAntialiasing createSceneAntialiasing() {
        return SceneAntialiasing.DISABLED;
    }

//    @Lazy
//    @Bean
//    @Override @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public SubScene createSubScene() {
//        return new SubSceneBuilder().;
//    }
    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Clipboard createClipboard() {
        return Clipboard.getSystemClipboard();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public LocalTimeStringConverter createLocalTimeStringConverter() {
        return new LocalTimeStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ColorPicker createColorPicker() {
        return new ColorPicker();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeItem createTreeItem() {
        return new TreeItem();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ColumnConstraints createColumnConstraints() {
        return new ColumnConstraints();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Glow createGlow() {
        return new Glow();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CheckMenuItem createCheckMenuItem() {
        return new CheckMenuItem();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BackgroundRepeat createBackgroundRepeat() {
        return BackgroundRepeat.NO_REPEAT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public LongStringConverter createLongStringConverter() {
        return new LongStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StageStyle createStageStyle() {
        return StageStyle.DECORATED;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CheckBox createCheckBox() {
        return new CheckBox();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleLongProperty createSimpleLongProperty() {
        return new SimpleLongProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PixelFormat<?> createPixelFormat() {
        return PixelFormat.getIntArgbInstance();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ImageView createImageView() {
        return new ImageView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ButtonType createButtonType() {
        return ButtonType.CANCEL;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ImageCursor createImageCursor() {
        return new ImageCursor();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TriangleMesh createTriangleMesh() {
        return new TriangleMesh();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CheckBoxListCell<?> createCheckBoxListCell() {
        return new CheckBoxListCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BlendMode createBlendMode() {
        return BlendMode.MULTIPLY;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleSetProperty createSimpleSetProperty() {
        return new SimpleSetProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleStringProperty createSimpleStringProperty() {
        return new SimpleStringProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public WebEngine createWebEngine() {
        return new WebEngine();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FloatStringConverter createFloatStringConverter() {
        return new FloatStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DateStringConverter createDateStringConverter() {
        return new DateStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyJavaBeanStringPropertyBuilder createReadOnlyJavaBeanStringPropertyBuilder() {
        return new ReadOnlyJavaBeanStringPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Modality createModality() {
        return Modality.NONE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public VBox createVBox() {
        return new VBox();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public LocalDateTimeStringConverter createLocalDateTimeStringConverter() {
        return new LocalDateTimeStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ScrollBar createScrollBar() {
        return new ScrollBar();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Ellipse createEllipse() {
        return new Ellipse();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Shadow createShadow() {
        return new Shadow();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ObservableIntegerArray createObservableIntegerArray() {
        return FXCollections.observableIntegerArray();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Insets createInsets() {
        return new Insets(0.0d, 0.0d, 0.0d, 0.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public NumberAxis createNumberAxis() {
        return new NumberAxis();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyStringWrapper createReadOnlyStringWrapper() {
        return new ReadOnlyStringWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MenuBar createMenuBar() {
        return new MenuBar();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MenuButton createMenuButton() {
        return new MenuButton();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyJavaBeanLongPropertyBuilder createReadOnlyJavaBeanLongPropertyBuilder() {
        return new ReadOnlyJavaBeanLongPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StringProperty createStringProperty() {
        return new SimpleStringProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ComboBoxListCell<?> createComboBoxListCell() {
        return new ComboBoxListCell<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SwingNode createSwingNode() {
        return new SwingNode();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Lighting createLighting() {
        return new Lighting();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ScaleTransition createScaleTransition() {
        return new ScaleTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Scale createScale() {
        return new Scale();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Dialog<?> createDialog() {
        return new Dialog<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleObjectProperty createSimpleObjectProperty() {
        return new SimpleObjectProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BorderWidths createBorderWidths() {
        return BorderWidths.DEFAULT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Paper createPaper() {
        return Paper.A4;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeView createTreeView() {
        return new TreeView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ObservableMap<?, ?> createObservableMap() {
        return FXCollections.observableHashMap();
    }

    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ObservableSet<?> createObservableSet() {
        return FXCollections.observableSet(new HashSet<>());
    }

    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ObservableArray<?> createObservableArray() {
        return FXCollections.observableIntegerArray();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MeshView createMeshView() {
        return new MeshView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SVGPath createSVGPath() {
        return new SVGPath();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextFormatter createTextFormatter() {
        return new TextFormatter(TextFormatter.IDENTITY_STRING_CONVERTER);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public LineTo createLineTo() {
        return new LineTo();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CurrencyStringConverter createCurrencyStringConverter() {
        return new CurrencyStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SplitPane createSplitPane() {
        return new SplitPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CornerRadiiConverter createCornerRadiiConverter() {
        return CornerRadiiConverter.getInstance();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public PrinterJob createPrinterJob(Printer printer) {
        return PrinterJob.createPrinterJob(printer);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CubicCurve createCubicCurve() {
        return new CubicCurve();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BigIntegerStringConverter createBigIntegerStringConverter() {
        return new BigIntegerStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Stage createStage() {
        return new Stage();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaBeanStringPropertyBuilder createJavaBeanStringPropertyBuilder() {
        return new JavaBeanStringPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CheckBoxTreeTableCell createCheckBoxTreeTableCell() {
        return new CheckBoxTreeTableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public Background createBackground(BackgroundFill fill) {
        return new Background(fill);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ComboBox createComboBox() {
        return new ComboBox();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Mesh createMesh() {
        return new TriangleMesh();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FloatMap createFloatMap() {
        return new FloatMap();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public KeyCodeCombination createKeyCodeCombination() {
        return (KeyCodeCombination) KeyCodeCombination.NO_MATCH;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyIntegerWrapper createReadOnlyIntegerWrapper() {
        return new ReadOnlyIntegerWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Arc createArc() {
        return new Arc();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Pos createPos() {
        return Pos.BASELINE_LEFT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public VPos createVPos() {
        return VPos.BASELINE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Bloom createBloom() {
        return new Bloom();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyDoubleWrapper createReadOnlyDoubleWrapper() {
        return new ReadOnlyDoubleWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Group createGroup() {
        return new Group();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BorderPane createBorderPane() {
        return new BorderPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StyleConverter createStyleConverter() {
        return new StyleConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SplitMenuButton createSplitMenuButton() {
        return new SplitMenuButton();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Spinner createSpinner() {
        return new Spinner();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TransferMode createTransferMode() {
        return TransferMode.COPY;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public KeyCombination createKeyCombination() {
        return KeyCombination.NO_MATCH;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ChoiceBox createChoiceBox() {
        return new ChoiceBox();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TranslateTransition createTranslateTransition() {
        return new TranslateTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public QuadCurveTo createQuadCurveTo() {
        return new QuadCurveTo();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Interpolator createInterpolator() {
        return Interpolator.LINEAR;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public KeyCode createKeyCode() {
        return KeyCode.SPACE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyLongWrapper createReadOnlyLongWrapper() {
        return new ReadOnlyLongWrapper();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public AnchorPane createAnchorPane() {
        return new AnchorPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Window createWindow() {
        return new Stage();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ShortStringConverter createShortStringConverter() {
        return new ShortStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyJavaBeanDoublePropertyBuilder createReadOnlyJavaBeanDoublePropertyBuilder() {
        return new ReadOnlyJavaBeanDoublePropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BooleanProperty createBooleanProperty() {
        return new SimpleBooleanProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public InputMethodHighlight createInputMethodHighlight() {
        return InputMethodHighlight.SELECTED_RAW;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public OverrunStyle createOverrunStyle() {
        return OverrunStyle.ELLIPSIS;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Duration createDuration() {
        return new Duration(0.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SequentialTransition createSequentialTransition() {
        return new SequentialTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextAlignment createTextAlignment() {
        return TextAlignment.LEFT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HorizontalDirection createHorizontalDirection() {
        return HorizontalDirection.LEFT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FillTransition createFillTransition() {
        return new FillTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Label createLabel() {
        return new Label();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MotionBlur createMotionBlur() {
        return new MotionBlur();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public LocalDateStringConverter createLocalDateStringConverter() {
        return new LocalDateStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public QuadCurve createQuadCurve() {
        return new QuadCurve();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FontSmoothingType createFontSmoothingType() {
        return FontSmoothingType.GRAY;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaBeanBooleanPropertyBuilder createJavaBeanBooleanPropertyBuilder() {
        return new JavaBeanBooleanPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Polygon createPolygon() {
        return new Polygon();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public BackgroundFill createBackgroundFill(CornerRadii radii, Insets insets) {
        return new BackgroundFill(Color.WHITE, radii, insets);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Canvas createCanvas() {
        return new Canvas();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ChoiceBoxTreeTableCell createChoiceBoxTreeTableCell() {
        return new ChoiceBoxTreeTableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Region createRegion() {
        return new Region();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public Border createBorder(BorderStroke stroke) {
        return new Border(stroke);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Slider createSlider() {
        return new Slider();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleDoubleProperty createSimpleDoubleProperty() {
        return new SimpleDoubleProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public ScatterChart createScatterChart(Axis axis, Axis axis1) {
        return new ScatterChart(axis, axis1);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ContextMenu createContextMenu() {
        return new ContextMenu();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PerspectiveCamera createPerspectiveCamera() {
        return new PerspectiveCamera();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public AlertType createAlertType() {
        return AlertType.NONE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BooleanStringConverter createBooleanStringConverter() {
        return new BooleanStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Box createBox() {
        return new Box();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TableCell createTableCell() {
        return new TableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SnapshotParameters createSnapshotParameters() {
        return new SnapshotParameters();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public BubbleChart createBubbleChart(Axis axis, Axis axis1) {
        return new BubbleChart(axis, axis1);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CheckBoxTableCell createCheckBoxTableCell() {
        return new CheckBoxTableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TabPane createTabPane() {
        return new TabPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public InnerShadow createInnerShadow() {
        return new InnerShadow();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Cell<?> createCell() {
        return new Cell<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Dimension2D createDimension2D() {
        return new Dimension2D(1.0d, 1.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ColorAdjust createColorAdjust() {
        return new ColorAdjust();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MenuItem createMenuItem() {
        return new MenuItem();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SpinnerValueFactory createSpinnerValueFactory() {
        return new DoubleSpinnerValueFactory(0.0d, 1.0d);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ComboBoxTreeTableCell<?, ?> createComboBoxTreeTableCell() {
        return new ComboBoxTreeTableCell<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CategoryAxis createCategoryAxis() {
        return new CategoryAxis();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StyleOrigin createStyleOrigin() {
        return StyleOrigin.INLINE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Alert createAlert() {
        return new Alert(Alert.AlertType.NONE);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SetProperty<?> createSetProperty() {
        return new SimpleSetProperty<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public LineChart createLineChart(Axis axis, Axis axis1) {
        return new LineChart(axis, axis1);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleIntegerProperty createSimpleIntegerProperty() {
        return new SimpleIntegerProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SepiaTone createSepiaTone() {
        return new SepiaTone();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public RowConstraints createRowConstraints() {
        return new RowConstraints();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CheckBoxTreeCell<?> createCheckBoxTreeCell() {
        return new CheckBoxTreeCell<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyStringProperty createReadOnlyStringProperty() {
        return new SimpleStringProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyJavaBeanFloatPropertyBuilder createReadOnlyJavaBeanFloatPropertyBuilder() {
        return new ReadOnlyJavaBeanFloatPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Translate createTranslate() {
        return new Translate();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StrokeTransition createStrokeTransition() {
        return new StrokeTransition();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyJavaBeanIntegerPropertyBuilder createReadOnlyJavaBeanIntegerPropertyBuilder() {
        return new ReadOnlyJavaBeanIntegerPropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BlurType createBlurType() {
        return BlurType.GAUSSIAN;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PaperSource createPaperSource() {
        return PaperSource.MAIN;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleFloatProperty createSimpleFloatProperty() {
        return new SimpleFloatProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TableColumn createTableColumn() {
        return new TableColumn();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ContentDisplay createContentDisplay() {
        return ContentDisplay.CENTER;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BackgroundSize createBackgroundSize() {
        return BackgroundSize.DEFAULT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public LongProperty createLongProperty() {
        return new SimpleLongProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ButtonBar createButtonBar() {
        return new ButtonBar();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DepthTest createDepthTest() {
        return DepthTest.INHERIT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Rotate createRotate() {
        return new Rotate();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ListCell createListCell() {
        return new ListCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JavaBeanDoublePropertyBuilder createJavaBeanDoublePropertyBuilder() {
        return new JavaBeanDoublePropertyBuilder();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public RadioMenuItem createRadioMenuItem() {
        return new RadioMenuItem();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public WritablePixelFormat<?> createWritablePixelFormat() {
        return PixelFormat.getIntArgbInstance();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextBoundsType createTextBoundsType() {
        return TextBoundsType.LOGICAL;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ChoiceDialog createChoiceDialog() {
        return new ChoiceDialog();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FillRule createFillRule() {
        return FillRule.EVEN_ODD;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StrokeLineJoin createStrokeLineJoin() {
        return StrokeLineJoin.ROUND;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextFieldTreeCell createTextFieldTreeCell() {
        return new TextFieldTreeCell();
    }

//    @Lazy
//    @Bean
//    @Override @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public JobSettings createJobSettings(Printer printer) {
//        return new JobSettings(printer);
//    }
    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CacheHint createCacheHint() {
        return CacheHint.DEFAULT;
    }

//    @Lazy
//    @Bean
//    @Override @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    public TableFocusModel createTableFocusModel() {
//        return new TableFocusModel();
//    }
    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BackgroundPosition createBackgroundPosition() {
        return BackgroundPosition.DEFAULT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyIntegerProperty createReadOnlyIntegerProperty() {
        return new SimpleIntegerProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Autowired
    public StackedAreaChart createStackedAreaChart(Axis axis, Axis axis1) {
        return new StackedAreaChart(axis, axis1);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Accordion createAccordion() {
        return new Accordion();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Tab createTab() {
        return new Tab();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DrawMode createDrawMode() {
        return DrawMode.FILL;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BorderStrokeStyle createBorderStrokeStyle() {
        return BorderStrokeStyle.SOLID;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Circle createCircle() {
        return new Circle();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DirectoryChooser createDirectoryChooser() {
        return new DirectoryChooser();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextInputDialog createTextInputDialog() {
        return new TextInputDialog();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ListProperty<?> createListProperty() {
        return new SimpleListProperty<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ProgressBarTreeTableCell createProgressBarTreeTableCell() {
        return new ProgressBarTreeTableCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ArcTo createArcTo() {
        return new ArcTo();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Printer createPrinter() {
        return Printer.getDefaultPrinter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MediaView createMediaView() {
        return new MediaView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Pagination createPagination() {
        return new Pagination();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TextField createTextField() {
        return new TextField();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HLineTo createHLineTo() {
        return new HLineTo();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PhongMaterial createPhongMaterial() {
        return new PhongMaterial();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TreeTableRow createTreeTableRow() {
        return new TreeTableRow();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public StackPane createStackPane() {
        return new StackPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ComboBoxTableCell<?, ?> createComboBoxTableCell() {
        return new ComboBoxTableCell<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyMapProperty createReadOnlyMapProperty() {
        return new SimpleMapProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TableView createTableView() {
        return new TableView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DoubleStringConverter createDoubleStringConverter() {
        return new DoubleStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ReadOnlyFloatProperty createReadOnlyFloatProperty() {
        return new SimpleFloatProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CharacterStringConverter createCharacterStringConverter() {
        return new CharacterStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Priority createPriority() {
        return Priority.SOMETIMES;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public NodeOrientation createNodeOrientation() {
        return NodeOrientation.INHERIT;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Pane createPane() {
        return new Pane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DisplacementMap createDisplacementMap() {
        return new DisplacementMap();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DefaultStringConverter createDefaultStringConverter() {
        return new DefaultStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public PopupControl createPopupControl() {
        return new PopupControl();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public AmbientLight createAmbientLight() {
        return new AmbientLight();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SimpleBooleanProperty createSimpleBooleanProperty() {
        return new SimpleBooleanProperty();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Color createColor() {
        return Color.WHITE;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Screen createScreen() {
        return Screen.getPrimary();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Affine createAffine() {
        return new Affine();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public BoxBlur createBoxBlur() {
        return new BoxBlur();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public FXMLLoader createFXMLLoader() {
        return new FXMLLoader();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public NumberStringConverter createNumberStringConverter() {
        return new NumberStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public WebView createWebView() {
        return new WebView();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TitledPane createTitledPane() {
        return new TitledPane();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Blend createBlend() {
        return new Blend();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CustomMenuItem createCustomMenuItem() {
        return new CustomMenuItem();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SeparatorMenuItem createSeparatorMenuItem() {
        return new SeparatorMenuItem();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CubicCurveTo createCubicCurveTo() {
        return new CubicCurveTo();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ByteStringConverter createByteStringConverter() {
        return new ByteStringConverter();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public WritableImage createWritableImage() {
        return new WritableImage(1, 1);
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public MoveTo createMoveTo() {
        return new MoveTo();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ObservableList<?> createObservableList() {
        return FXCollections.observableArrayList();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public ChoiceBoxListCell createChoiceBoxListCell() {
        return new ChoiceBoxListCell();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public VertexFormat createVertexFormat() {
        return VertexFormat.POINT_NORMAL_TEXCOORD;
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public EqualizerBand createEqualizerBand() {
        return new EqualizerBand();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public XYChart.Series<?, ?> createXYChartSeries() {
        return new XYChart.Series<>();
    }

    @Lazy
    @Bean
    @Override
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TabPane.TabClosingPolicy createTabPaneTabClosingPolicy() {
        return TabPane.TabClosingPolicy.UNAVAILABLE;
    }

}
