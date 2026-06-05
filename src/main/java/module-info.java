module conversormain.conversor {
    requires javafx.controls;
    requires javafx.fxml;


    opens conversormain.conversor to javafx.fxml;
    exports conversormain.conversor;
}