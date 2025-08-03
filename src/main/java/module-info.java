

module com.example.dictionaryapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires json.simple;
    opens com.example.dictionaryapi to javafx.fxml;
    exports com.example.dictionaryapi;
}