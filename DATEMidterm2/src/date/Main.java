package date;

import java.io.IOException;

import javafx.application.Application;
import date.view.DateController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private Stage stage; //sets layout
	private AnchorPane dView;

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		this.stage.setTitle("The Date");
		showDateView();
	}

	public void showDateView() { //loads and shows the scene
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/DateView.fxml"));
			dView = (AnchorPane) loader.load();

			Scene scene = new Scene(dView);
			stage.setScene(scene);
			DateController controls = loader.getController();
			controls.setMain(this);
			
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
