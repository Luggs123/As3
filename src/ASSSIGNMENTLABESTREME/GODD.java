package ASSSIGNMENTLABESTREME;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GODD extends Application {
	private PathTransition pathTransition;
	private SequentialTransition sequentialTransition = new SequentialTransition();
	
	public void init(Stage stage) {
		stage.setTitle("Lab Animation");
		Group root = new Group();
		final Scene scene = new Scene(root, 800, 600);

		// Animation A.
		Circle animationA = new Circle(50, 50, 40);
		animationA.setFill(Color.DARKBLUE);
		Path path = PathBuilder.create()
				.elements(
						new MoveTo(50, 50),
						new LineTo(700, 50),
						new LineTo(700, 400),
						new LineTo(50, 400),
						new LineTo(50, 50))
						.build();
		
		pathTransition = PathTransitionBuilder.create()
				.duration(Duration.seconds(6))
				.path(path)
				.node(animationA)
				.build();
		
		root.getChildren().add(path);
		root.getChildren().addAll(animationA);
		
		// Animation B.
		Ellipse ellipses = new Ellipse(300, 300, 40, 60);
		ellipses.setFill(Color.DARKRED);
		
		FadeTransition fadeTransition = new FadeTransition(Duration.millis(1500), ellipses);
		fadeTransition.setCycleCount(0);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.5);
		
		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1500), ellipses);
		scaleTransition.setCycleCount(0);
		scaleTransition.setFromX(1);
		scaleTransition.setFromY(1);
		scaleTransition.setToX(2);
		scaleTransition.setToY(2);
		
		RotateTransition rotateTransition = new RotateTransition(Duration.millis(1500), ellipses);
		rotateTransition.setByAngle(90);
		rotateTransition.setCycleCount(0);
		
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1500), ellipses);
		translateTransition.setByY(-100);
		translateTransition.setCycleCount(0);
		
		sequentialTransition.getChildren().addAll(fadeTransition, scaleTransition, rotateTransition, translateTransition);
		root.getChildren().add(ellipses);
		
		stage.setScene(scene);
		stage.show();
	}
	
	private void play() {
		pathTransition.play();
		sequentialTransition.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
		play();
	}
}
