import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class tehcode extends Application {
	private final Timeline timeline = new Timeline();
	private final Timeline timeline2 = new Timeline();

	private void init(Stage primaryStage) {
		Group root = new Group();
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root, 800, 900));
		
		ImageView imageTest = createMovingImage(Interpolator.LINEAR);
		// interpolator
		root.getChildren().addAll(imageTest); // add circle1 to root
	}

	private ImageView createMovingImage(Interpolator interpolator) {
		Image imageJorge = new Image("Jorge.png");
		ImageView icon = new ImageView(imageJorge);
		icon.setX(45);
		icon.setY(45);
		icon.preserveRatioProperty();
		
		// set the timeline for moving the circle
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline2.setCycleCount(Timeline.INDEFINITE);
		timeline2.setAutoReverse(true);
		
		// keyValue for verticle translation of circle to target position
		KeyValue keyValueX = new KeyValue(icon.translateXProperty(), 20, interpolator);
		KeyValue keyValueY = new KeyValue(icon.translateYProperty(), 20, interpolator);
		KeyValue keyValueX2 = new KeyValue(icon.translateXProperty(), -20, interpolator);
		KeyValue keyValueY2 = new KeyValue(icon.translateYProperty(), -20, interpolator);
		
		// create a keyFrame with duration= 4s
		KeyFrame keyFrame = new KeyFrame(Duration.millis(10), keyValueX, keyValueY, keyValueX2, keyValueY2);
		
		KeyValue keySizeH = new KeyValue(icon.fitHeightProperty(), 600, interpolator);
		KeyValue keySizeV = new KeyValue(icon.fitWidthProperty(), 720, interpolator);
		KeyFrame keyFrame2 = new KeyFrame(Duration.millis(100), keySizeH, keySizeV);

		// add the keyframe to the timeline
		timeline.getKeyFrames().add(keyFrame);
		timeline2.getKeyFrames().add(keyFrame2);
		return icon;
	}

	public void play() {
		timeline.play();
		timeline2.play();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
		play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
