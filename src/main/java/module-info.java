module tasks6_4 {
    requires javafx.controls;
    requires javafx.fxml;
    opens tasks6_4.controller to javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens tasks6_4 to javafx.fxml;
    exports tasks6_4;
}