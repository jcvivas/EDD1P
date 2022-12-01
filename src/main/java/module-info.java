module com.grupo02.videogamestore {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.desktop;

    opens com.grupo02.videogamestore to javafx.fxml;
    exports com.grupo02.videogamestore;
}
