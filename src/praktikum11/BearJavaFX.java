package praktikum11;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BearJavaFX extends Application {

	public static void main(String[] args) {
        launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Karu");
		Group root = new Group();
		Canvas canvas = new Canvas(400, 400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		draw(gc);
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	private void draw(GraphicsContext gc) {
		gc.setFill(Color.SADDLEBROWN);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(5);
		gc.fillRoundRect(50, 50, 300, 300, 40, 40); // Head.
        gc.fillOval(10, 20, 100, 100); // Left ear.
        gc.fillOval(300, 20, 100, 100); // Right ear.
		gc.strokeLine(100, 300, 300, 300); // Mouth.
		gc.strokeOval(100, 100, 50, 50);
		gc.strokeOval(250, 100, 50, 50);
		gc.setFill(Color.BLACK);
		gc.fillRoundRect(175, 200, 50, 50, 10, 10);
		gc.fillText("See peaks karu olema..", 100, 370);
	}
}