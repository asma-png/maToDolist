module com.example.toodoolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;

    opens com.example.toodoolist to javafx.fxml;
    exports com.example.toodoolist;
}