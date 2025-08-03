package com.example.dictionaryapi; // Declaring the package name

import javafx.event.ActionEvent; // Importing the ActionEvent class from JavaFX library
import javafx.fxml.FXML; // Importing the FXML annotation from JavaFX library
import javafx.scene.control.Button; // Importing the Button class from JavaFX library
import javafx.scene.control.TextArea; // Importing the TextArea class from JavaFX library
import javafx.scene.control.TextField; // Importing the TextField class from JavaFX library

import java.io.IOException; // Importing the IOException class from Java's IO library
import java.net.URL; // Importing the URL class from Java's networking library
import java.util.ResourceBundle; // Importing the ResourceBundle class from Java's utility library

public class HelloController {// Defining a class named HelloController
    @FXML
    private TextField searchField;// Declaring a private TextField variable named searchField

    @FXML
    private TextArea resultArea;// Declaring a private TextArea variable named resultArea

    @FXML
    private Button searchButton;// Declaring a private Button variable named searchButton


    // Initializing method called automatically by FXMLLoader
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Initialization code can be added here
// TODO
}
    // Event handler for the searchButton
    @FXML
    private void doSearch(ActionEvent event) throws IOException {
        // Getting the text from the searchField
        String word=searchField.getText();
        // Creating an instance of InternetConnection class
            InternetConnection ic=new InternetConnection();
        // Getting online data for the entered word
           String data= ic.getOnlineData(word);
        // Setting the retrieved data to the resultArea
            resultArea.setText(data);

}
        }