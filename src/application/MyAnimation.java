package application;

import java.util.Random;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyAnimation extends Application {
	@Override
	public void start(Stage stage) {
		stage.setTitle("Fading Demo");
		final Scene scene = new Scene(new Group(), 600, 450);
		scene.setFill(Color.BLACK);              
		Rectangle rectFade = new Rectangle(100, 150, 100, 100);  //coordinates (x, y), width, and height
		//  Rectangle rectFade = new Rectangle(100, 100);         //width and size
		rectFade.setX(10);                       //set top-left corner x coordinate of property X
		rectFade.setY(250);                      //set top-left corner y coordinate
		rectFade.setArcHeight(20);
		rectFade.setArcWidth(20);        
//		String.valueOf(rectFade.getFill().addListener(new ChangeListener<String>() {
//			public void changed(ObservableValue ov,String old_val, String new_val) {                    
//				switch (new Random().nextInt(5)) {
//				case 0: rectFade.setFill(Color.ORANGE); break;
//				case 1: rectFade.setFill(Color.RED); break;
//				case 2: rectFade.setFill(Color.WHITE); break;
//				case 3: rectFade.setFill(Color.GREEN); break;
//				case 4: rectFade.setFill(Color.BLUE); break;
//				}
//			}  
//		});

		FadeTransition ft = new FadeTransition(Duration.millis(20), rectFade);
		ft.setFromValue(1.0);
		ft.setToValue(0.3);                         //if 0, fully transparent
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), rectFade);
		rotateTransition.setDelay(Duration.millis(2000));  //delay for 2 sec
		rotateTransition.setFromAngle(0f);
		rotateTransition.setToAngle(90f);
		rotateTransition.setCycleCount(0);
		rectFade.setFill(Color.RED);
		rotateTransition.play();
		((Group)scene.getRoot()).getChildren().addAll(rectFade); //error message if cast operator missing
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
