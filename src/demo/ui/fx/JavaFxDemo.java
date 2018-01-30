package demo.ui.fx;

import java.io.IOException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
	
public class JavaFxDemo extends Application {
	
	@FXML
	private JFXPasswordField passwordField;
	@FXML
	private JFXTextField usernameField;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("DemoFxUi.fxml"));
		} catch (IOException e) {
			System.err.println(e.getMessage());;
		}
        
        Scene scene = new Scene(root, 300, 275);
    
        primaryStage.setTitle("JavaFx Demo Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    protected void handleLoginButtonAction(ActionEvent event) {
        System.out.println("Username: " + usernameField.getText());
        System.out.println("Password: " + passwordField.getText());
    }
    
}