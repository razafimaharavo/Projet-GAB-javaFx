module com.example.projet_atm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.logging;

    opens com.example.projet_atm to javafx.fxml;
    exports com.example.projet_atm;
}