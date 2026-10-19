module com.leonardoso.conteo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.leonardoso.conteo to javafx.fxml;
    exports com.leonardoso.conteo;
}
