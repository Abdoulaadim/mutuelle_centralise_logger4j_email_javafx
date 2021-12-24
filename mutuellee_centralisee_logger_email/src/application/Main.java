package application;
	


import org.apache.log4j.Logger;

//import com.mysql.jdbc.log.Log;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
     static  Logger log = Logger.getLogger(Main.class.getName());
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show(); 
			log.info("Application a ete demarrer");
		      
		} catch(Exception e) {
			 e.printStackTrace();
			 log.debug(e);
			 

		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
