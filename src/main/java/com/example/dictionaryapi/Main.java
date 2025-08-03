/*
*Name: Tavisha Prajapat
* studentId:200554770
* */
package com.example.dictionaryapi;

import javafx.application.Application; // Importing the Application class from JavaFX library
import javafx.event.ActionEvent; // Importing the ActionEvent class from JavaFX library
import javafx.fxml.FXML; // Importing the FXML annotation from JavaFX library
/*
 *Name: Tavisha Prajapat
 * studentId:200554770
 * */
import javafx.fxml.FXMLLoader; // Importing the FXMLLoader class from JavaFX library
import javafx.scene.Node; // Importing the Node class from JavaFX library
import javafx.scene.Scene; // Importing the Scene class from JavaFX library
import javafx.scene.image.Image; // Importing the Image class from JavaFX library
import javafx.stage.Stage; // Importing the Stage class from JavaFX library

import java.io.IOException; // Importing the IOException class from Java's IO library

public class Main extends Application { // Defining a class named Main which extends Application
    @Override
    public void start(Stage stage) throws IOException {// Overriding the start method of Application class
        // Creating an instance of FXMLLoader to load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        // Adding an icon to the stage
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/dictionaryapi/dictionary.png")));
        // Creating a new scene with the loaded FXML file
        Scene scene = new Scene(fxmlLoader.load(), 698, 494);
        // Setting the title of the stage
        stage.setTitle("Dictionary!");
        // Setting the scene to the stage
        stage.setScene(scene);
        // Displaying the stage
        stage.show();
    }
    @FXML
    public void opendictionary(ActionEvent actionEvent) throws IOException {
        // Creating an instance of FXMLLoader to load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        // Creating a new scene with the loaded FXML file
        Scene scene = new Scene(fxmlLoader.load(), 974, 560);
        // Getting the current stage from the action event
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        // Setting the title of the stage
        stage.setTitle("Dictionary!");
        // Adding an icon to the stage
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/example/dictionaryapi/dictionary.png")));
        // Setting the scene to the stage
        stage.setScene(scene);
        // Displaying the stage
        stage.show();
    }
    // Main method to launch the application
    public static void main(String[] args) {
        launch();
    }
}