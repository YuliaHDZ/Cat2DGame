module com.example.twodgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.twodgame to javafx.fxml;
    exports com.example.twodgame;
}