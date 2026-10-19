module com.leonardoso.fabulasgraficasdeesopo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.leonardoso.fabulasgraficasdeesopo to javafx.fxml;
    exports com.leonardoso.fabulasgraficasdeesopo;
}
