import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Window extends Application {
	boolean update = true;
	public static void main(String[] args){
		try {
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox box = new VBox(0);
		
		animatedCanvas water = new animatedCanvas(256,256,0.96);
		animatedCanvas water2 = new animatedCanvas(128,128,0.95);
		water.drawData();

		new AnimationTimer() {
			@Override
			public void handle(long now) {
				water.drawData();
				water.drawData();
			}
		}.start();

		water.widthProperty().bind(primaryStage.widthProperty());
		water.heightProperty().bind(primaryStage.heightProperty().divide(1));
		water2.widthProperty().bind(primaryStage.widthProperty());
		water2.heightProperty().bind(primaryStage.heightProperty().divide(2));
		box.getChildren().add(water);
		//box.getChildren().add(water2);
		
		primaryStage.setScene(new Scene(box));
		primaryStage.setWidth(100);
		primaryStage.setHeight(100);
		primaryStage.setResizable(true);
		primaryStage.show();

	}
}
