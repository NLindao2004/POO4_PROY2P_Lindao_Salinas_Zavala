module com.pooespol.proyecto2_heladeria {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pooespol.proyecto2_heladeria to javafx.fxml;
    exports com.pooespol.proyecto2_heladeria;
}
