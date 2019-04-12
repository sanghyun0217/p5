package application;

import static javafx.application.Platform.exit;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	private ComboBox comboBox;
	private Label greetingLabel;
	private BorderPane root;
	private TextField textField;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Define BorderPane
			root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			root.setStyle("-fx-background-color: lightgray");
			VBox vBox = new VBox();// creating a vertical box for top
			// Define Label

			Label greetingLabel = new Label("Hello World!");
			Label label1 = new Label("CS400 My First JavaFX");
			greetingLabel.setStyle("-fx-font-size: 30px");// style
			vBox.getChildren().add(label1);
			vBox.getChildren().add(greetingLabel);
			root.setTop(vBox); // set the box at top

			// Define comboBox on the Left
			ObservableList<String> options = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
			comboBox = new ComboBox(options);
			root.setLeft(comboBox);

			// Define imageview on the Center
			Image img = new Image("sanghyunlee.png");
			ImageView imageView = new ImageView();
			imageView.setImage(img);
			root.setCenter(imageView);

			// Define button on the bottom
			Button button = new Button("Done");
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					exit();
				}
			});
			root.setBottom(button);

			// Define TextField on the Right
			VBox rightbox = new VBox();// creating another vertical box
			Label label2 = new Label("what's your name?");
			Label label3 = new Label("where are you from?");
			TextField tf = new TextField();
			TextField tf1 = new TextField();
			rightbox.getChildren().add(label2);
			rightbox.getChildren().add(tf);
			rightbox.getChildren().add(label3);
			rightbox.getChildren().add(tf1);

			root.setRight(rightbox);
			primaryStage.setScene(scene);
			primaryStage.setWidth(600);
			primaryStage.setHeight(400);
			primaryStage.setTitle("Sanghyun's First JavaFX program");
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}