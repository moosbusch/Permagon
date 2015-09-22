package io.github.moosbusch.permagon.configuration;

import java.awt.Rectangle;
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

public interface JavaFXBeanConfiguration {

    public JFXPanel createJFXPanel();

    public Shear createShear();

    public TimeStringConverter createTimeStringConverter();

    public TreeTableCell createTreeTableCell();

//    public Stop createStop();

    public ChoiceBoxTableCell createChoiceBoxTableCell();

    public JavaBeanIntegerPropertyBuilder createJavaBeanIntegerPropertyBuilder();

    public Sphere createSphere();

    public JavaBeanLongPropertyBuilder createJavaBeanLongPropertyBuilder();

    public Button createButton();

    public DropShadow createDropShadow();

    public Popup createPopup();

    public Paper createPaper();

    public PaperSource createPaperSource();

    public DataFormat createDataFormat();

    public TextFlow createTextFlow();

    public Orientation createOrientation();

    public Line createLine();

//    public LinearGradient createLinearGradient();
    public TreeCell createTreeCell();

//    public MatrixType createMatrixType();

    public ReadOnlyObjectWrapper createReadOnlyObjectWrapper();

    public ColorInput createColorInput();

    public HBox createHBox();

    public ClipboardContent createClipboardContent();

//    public AudioEqualizer createAudioEqualizer();
    public Font createFont();

    public ReadOnlySetWrapper createReadOnlySetWrapper();

    public PasswordField createPasswordField();

    public ProgressBar createProgressBar();

    public JavaFXBuilderFactory createJavaFXBuilderFactory();

    public Path createPath();

//    public WebHistory createWebHistory();
    public IntegerProperty createIntegerProperty();

    public ToggleButton createToggleButton();

    public ReadOnlyJavaBeanBooleanPropertyBuilder createReadOnlyJavaBeanBooleanPropertyBuilder();

    public Rectangle2D createRectangle2D();

    public ChoiceBoxTreeCell createChoiceBoxTreeCell();

    public ProgressBarTableCell createProgressBarTableCell();

    public VerticalDirection createVerticalDirection();

    public Timeline createTimeline();

    public ToolBar createToolBar();

    public CornerRadii createCornerRadii();

    public PercentageStringConverter createPercentageStringConverter();

    public Separator createSeparator();

    public Hyperlink createHyperlink();

    public ComboBoxTreeCell<?> createComboBoxTreeCell();

    public TextArea createTextArea();

    public VLineTo createVLineTo();

    public CullFace createCullFace();

    public StrokeType createStrokeType();

    public ReadOnlyObjectProperty createReadOnlyObjectProperty();

    public ListView createListView();

    public ReadOnlyFloatWrapper createReadOnlyFloatWrapper();

    public Point2D createPoint2D();

    public Light createLight();

    public ReadOnlyListProperty createReadOnlyListProperty();

    public TextFieldListCell createTextFieldListCell();

    public PageOrientation createPageOrientation();

    public GaussianBlur createGaussianBlur();

    public ReadOnlyBooleanWrapper createReadOnlyBooleanWrapper();

    public CheckBoxTreeItem createCheckBoxTreeItem();

    public Tooltip createTooltip();

    public JSException createJSException();

    public RadioButton createRadioButton();

//    public Scene createScene();
    public DialogPane createDialogPane();

    public ClosePath createClosePath();

    public DateTimeStringConverter createDateTimeStringConverter();

    public Point3D createPoint3D();

    public PerspectiveTransform createPerspectiveTransform();

    public Polyline createPolyline();

    public PointLight createPointLight();

    public SelectionMode createSelectionMode();

    public IntegerStringConverter createIntegerStringConverter();

    public FontWeight createFontWeight();

    public HPos createHPos();

    public PieChart createPieChart();

    public ImageInput createImageInput();

    public ProgressIndicator createProgressIndicator();

    public FontPosture createFontPosture();

    public ReadOnlyListWrapper createReadOnlyListWrapper();

    public ReadOnlyMapWrapper createReadOnlyMapWrapper();

    public FadeTransition createFadeTransition();

    public IndexedCell createIndexedCell();

    public Cylinder createCylinder();

    public SimpleMapProperty<?, ?> createSimpleMapProperty();

    public ReadOnlySetProperty<?> createReadOnlySetProperty();

    public RotateTransition createRotateTransition();

    public ToggleGroup createToggleGroup();

    public DoubleProperty createDoubleProperty();

    public DateCell createDateCell();

    public SimpleListProperty<?> createSimpleListProperty();

    public PrintSides createPrintSides();

    public TilePane createTilePane();

    public PathTransition createPathTransition();

    public TextFieldTableCell createTextFieldTableCell();

    public StrokeLineCap createStrokeLineCap();

    public FlowPane createFlowPane();

    public ObjectProperty createObjectProperty();

    public GridPane createGridPane();

    public Reflection createReflection();

    public JavaBeanFloatPropertyBuilder createJavaBeanFloatPropertyBuilder();

    public IndexRange createIndexRange();

    public ReadOnlyLongProperty createReadOnlyLongProperty();

    public TreeTableColumn createTreeTableColumn();

    public ScrollPane createScrollPane();

    public TableRow createTableRow();

    public DatePicker createDatePicker();

    public TreeSortMode createTreeSortMode();

    public CycleMethod createCycleMethod();

    public ParallelCamera createParallelCamera();

    public PrintQuality createPrintQuality();

    public StackedBarChart createStackedBarChart(Axis axis, Axis axis1);

    public JavaBeanObjectPropertyBuilder createJavaBeanObjectPropertyBuilder();

    public TreeTableView createTreeTableView();

//    public PrinterAttributes createPrinterAttributes();

    public Side createSide();

    public BigDecimalStringConverter createBigDecimalStringConverter();

    public Felix createFelix();

    public BoundingBox createBoundingBox();

    public HTMLEditor createHTMLEditor();

    public BorderStroke createBorderStroke(BorderStrokeStyle style,
            CornerRadii radii, BorderWidths widths);

    public ValueAxis<?> createValueAxis();

    public PauseTransition createPauseTransition();

    public PrintColor createPrintColor();

    public Menu createMenu();

    public FloatProperty createFloatProperty();

    public ParallelTransition createParallelTransition();

    public TickMark createTickMark();

    public ReadOnlyJavaBeanObjectPropertyBuilder createReadOnlyJavaBeanObjectPropertyBuilder();

//    public HostServices createHostServices();

    public TextFieldTreeTableCell<?, ?> createTextFieldTreeTableCell();

    public Text createText();

    public SceneAntialiasing createSceneAntialiasing();

//    public SubScene createSubScene();

    public Clipboard createClipboard();

    public LocalTimeStringConverter createLocalTimeStringConverter();

    public ColorPicker createColorPicker();

    public TreeItem createTreeItem();

    public ColumnConstraints createColumnConstraints();

    public Glow createGlow();

    public CheckMenuItem createCheckMenuItem();

    public BackgroundRepeat createBackgroundRepeat();

    public LongStringConverter createLongStringConverter();

    public StageStyle createStageStyle();

    public CheckBox createCheckBox();

    public SimpleLongProperty createSimpleLongProperty();

//    public SelectionModel createSelectionModel();

    public PixelFormat<?> createPixelFormat();

    public ImageView createImageView();

    public ButtonType createButtonType();

//    public TableSelectionModel createTableSelectionModel();

    public ImageCursor createImageCursor();

    public TriangleMesh createTriangleMesh();

    public CheckBoxListCell<?> createCheckBoxListCell();

    public BlendMode createBlendMode();

    public SimpleSetProperty<?> createSimpleSetProperty();

//    public PropertyValueFactory createPropertyValueFactory();

    public SimpleStringProperty createSimpleStringProperty();

    public WebEngine createWebEngine();

    public FloatStringConverter createFloatStringConverter();

    public DateStringConverter createDateStringConverter();

    public ReadOnlyJavaBeanStringPropertyBuilder createReadOnlyJavaBeanStringPropertyBuilder();

//    public AudioTrack createAudioTrack();

    public Modality createModality();

    public VBox createVBox();

    public LocalDateTimeStringConverter createLocalDateTimeStringConverter();

    public ScrollBar createScrollBar();

    public Ellipse createEllipse();

    public Insets createInsets();

    public NumberAxis createNumberAxis();

    public ReadOnlyStringWrapper createReadOnlyStringWrapper();

//    public PopupWindow createPopupWindow();

    public MenuBar createMenuBar();

    public MenuButton createMenuButton();

    public ReadOnlyJavaBeanLongPropertyBuilder createReadOnlyJavaBeanLongPropertyBuilder();

    public StringProperty createStringProperty();

    public ComboBoxListCell<?> createComboBoxListCell();

//    public FormatStringConverter createFormatStringConverter();

    public SwingNode createSwingNode();

    public Lighting createLighting();

    public ScaleTransition createScaleTransition();

//    public PopupFeatures createPopupFeatures();

    public Scale createScale();

    public Dialog<?> createDialog();

    public SimpleObjectProperty createSimpleObjectProperty();

    public BorderWidths createBorderWidths();

    public TreeView createTreeView();

    public ObservableMap<?, ?> createObservableMap();

    public ObservableIntegerArray createObservableIntegerArray();

    public MeshView createMeshView();

    public SVGPath createSVGPath();

    public TextFormatter createTextFormatter();

    public LineTo createLineTo();

    public CurrencyStringConverter createCurrencyStringConverter();

    public SplitPane createSplitPane();

    public CornerRadiiConverter createCornerRadiiConverter();

    public PrinterJob createPrinterJob(Printer printer);

    public CubicCurve createCubicCurve();

    public BigIntegerStringConverter createBigIntegerStringConverter();

    public BarChart createBarChart(Axis axis, Axis axis1);

    public Stage createStage();

    public JavaBeanStringPropertyBuilder createJavaBeanStringPropertyBuilder();

    public CheckBoxTreeTableCell createCheckBoxTreeTableCell();

    public Background createBackground(BackgroundFill fill);

    public ComboBox createComboBox();

    public Mesh createMesh();

    public FloatMap createFloatMap();

    public KeyCodeCombination createKeyCodeCombination();

//    public MultipleSelectionModel createMultipleSelectionModel();

    public ReadOnlyIntegerWrapper createReadOnlyIntegerWrapper();

    public Arc createArc();

    public Pos createPos();

    public VPos createVPos();

    public Bloom createBloom();

    public ReadOnlyDoubleWrapper createReadOnlyDoubleWrapper();

    public Group createGroup();

    public BorderPane createBorderPane();

    public StyleConverter createStyleConverter();

    public SplitMenuButton createSplitMenuButton();

    public Spinner createSpinner();

//    public AccessibleRole createAccessibleRole();

    public TransferMode createTransferMode();

    public KeyCombination createKeyCombination();

    public ChoiceBox createChoiceBox();

    public TranslateTransition createTranslateTransition();

    public QuadCurveTo createQuadCurveTo();

    public Interpolator createInterpolator();

    public KeyCode createKeyCode();

//    public FXCanvas createFXCanvas();
    public ReadOnlyLongWrapper createReadOnlyLongWrapper();

    public AnchorPane createAnchorPane();

    public Window createWindow();

    public ShortStringConverter createShortStringConverter();

    public ReadOnlyJavaBeanDoublePropertyBuilder createReadOnlyJavaBeanDoublePropertyBuilder();

    public BooleanProperty createBooleanProperty();

    public InputMethodHighlight createInputMethodHighlight();

    public OverrunStyle createOverrunStyle();

    public Duration createDuration();

    public SequentialTransition createSequentialTransition();

    public TextAlignment createTextAlignment();

    public HorizontalDirection createHorizontalDirection();

//    public MediaPlayer createMediaPlayer();

//    public SingleSelectionModel createSingleSelectionModel();

    public FillTransition createFillTransition();

    public Label createLabel();

    public MotionBlur createMotionBlur();

    public LocalDateStringConverter createLocalDateStringConverter();

    public QuadCurve createQuadCurve();

    public FontSmoothingType createFontSmoothingType();

    public FileChooser createFileChooser();

    public JavaBeanBooleanPropertyBuilder createJavaBeanBooleanPropertyBuilder();

    public Polygon createPolygon();

    public BackgroundFill createBackgroundFill(CornerRadii radii, Insets insets);

    public Canvas createCanvas();

    public ChoiceBoxTreeTableCell createChoiceBoxTreeTableCell();

    public Region createRegion();

    public Border createBorder(BorderStroke stroke);

    public Slider createSlider();

    public SimpleDoubleProperty createSimpleDoubleProperty();

    public ScatterChart createScatterChart(Axis axis, Axis axis1);

    public Shadow createShadow();

    public ContextMenu createContextMenu();

    public PerspectiveCamera createPerspectiveCamera();

    public AlertType createAlertType();

    public BooleanStringConverter createBooleanStringConverter();

    public Box createBox();

    public TableCell createTableCell();

    public SnapshotParameters createSnapshotParameters();

    public BubbleChart createBubbleChart(Axis axis, Axis axis1);

    public CheckBoxTableCell createCheckBoxTableCell();

    public TabPane createTabPane();

    public TabPane.TabClosingPolicy createTabPaneTabClosingPolicy();

    public InnerShadow createInnerShadow();

    public Cell<?> createCell();

    public Dimension2D createDimension2D();

    public ColorAdjust createColorAdjust();

    public MenuItem createMenuItem();

    public SpinnerValueFactory createSpinnerValueFactory();

    public ComboBoxTreeTableCell<?, ?> createComboBoxTreeTableCell();

    public CategoryAxis createCategoryAxis();

    public StyleOrigin createStyleOrigin();

    public Alert createAlert();

    public SetProperty<?> createSetProperty();

    public LineChart createLineChart(Axis axis, Axis axis1);

    public SimpleIntegerProperty createSimpleIntegerProperty();

    public SepiaTone createSepiaTone();

    public Rectangle createRectangle();

    public RowConstraints createRowConstraints();

    public CheckBoxTreeCell<?> createCheckBoxTreeCell();

    public ReadOnlyStringProperty createReadOnlyStringProperty();

    public ReadOnlyJavaBeanFloatPropertyBuilder createReadOnlyJavaBeanFloatPropertyBuilder();

    public Translate createTranslate();

    public StrokeTransition createStrokeTransition();

    public ReadOnlyJavaBeanIntegerPropertyBuilder createReadOnlyJavaBeanIntegerPropertyBuilder();

    public BlurType createBlurType();

    public SimpleFloatProperty createSimpleFloatProperty();

    public TableColumn createTableColumn();

    public ContentDisplay createContentDisplay();

    public BackgroundSize createBackgroundSize();

    public LongProperty createLongProperty();

    public ButtonBar createButtonBar();

    public DepthTest createDepthTest();

    public Rotate createRotate();

    public ListCell<?> createListCell();

    public JavaBeanDoublePropertyBuilder createJavaBeanDoublePropertyBuilder();

    public RadioMenuItem createRadioMenuItem();

    public WritablePixelFormat<?> createWritablePixelFormat();

    public TextBoundsType createTextBoundsType();

    public ChoiceDialog createChoiceDialog();

    public FillRule createFillRule();

    public StrokeLineJoin createStrokeLineJoin();

    public TextFieldTreeCell createTextFieldTreeCell();

//    public JobSettings createJobSettings(Printer printer);
    public CacheHint createCacheHint();

//    public TableFocusModel createTableFocusModel();
    public BackgroundPosition createBackgroundPosition();

    public ReadOnlyIntegerProperty createReadOnlyIntegerProperty();

    public StackedAreaChart createStackedAreaChart(Axis axis, Axis axis1);

    public Accordion createAccordion();

    public Tab createTab();

    public DrawMode createDrawMode();

    public BorderStrokeStyle createBorderStrokeStyle();

    public Circle createCircle();

    public DirectoryChooser createDirectoryChooser();

    public TextInputDialog createTextInputDialog();

    public ListProperty<?> createListProperty();

    public ProgressBarTreeTableCell createProgressBarTreeTableCell();

    public ArcTo createArcTo();

    public Printer createPrinter();

    public MediaView createMediaView();

    public Pagination createPagination();

    public TextField createTextField();

    public HLineTo createHLineTo();

    public PhongMaterial createPhongMaterial();

    public TreeTableRow createTreeTableRow();

    public StackPane createStackPane();

    public ComboBoxTableCell<?, ?> createComboBoxTableCell();

    public ReadOnlyMapProperty createReadOnlyMapProperty();

    public TableView createTableView();

    public DoubleStringConverter createDoubleStringConverter();

    public ReadOnlyFloatProperty createReadOnlyFloatProperty();

    public CharacterStringConverter createCharacterStringConverter();

    public Priority createPriority();

//    public Media createMedia();

    public NodeOrientation createNodeOrientation();

    public Pane createPane();

    public DisplacementMap createDisplacementMap();

    public DefaultStringConverter createDefaultStringConverter();

    public PopupControl createPopupControl();

    public AmbientLight createAmbientLight();

    public SimpleBooleanProperty createSimpleBooleanProperty();

    public Color createColor();

    public Screen createScreen();

    public Affine createAffine();

    public BoxBlur createBoxBlur();

    public FXMLLoader createFXMLLoader();

    public NumberStringConverter createNumberStringConverter();

    public WebView createWebView();

    public TitledPane createTitledPane();

    public Blend createBlend();

    public CustomMenuItem createCustomMenuItem();

    public SeparatorMenuItem createSeparatorMenuItem();

    public CubicCurveTo createCubicCurveTo();

    public ByteStringConverter createByteStringConverter();

    public WritableImage createWritableImage();

    public MoveTo createMoveTo();

    public ObservableList<?> createObservableList();

    public ObservableSet<?> createObservableSet();

    public ObservableArray<?> createObservableArray();

    public ChoiceBoxListCell createChoiceBoxListCell();

    public VertexFormat createVertexFormat();

    public EqualizerBand createEqualizerBand();

    public XYChart.Series<?, ?> createXYChartSeries();

}
