module com.menu.menu {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.menu.menu to javafx.fxml;
    exports com.menu.menu;
}