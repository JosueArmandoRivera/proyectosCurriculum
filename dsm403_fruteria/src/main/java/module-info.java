module org.utl.dsm403_fruteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.utl.dsm403_fruteria to javafx.fxml;
    exports org.utl.dsm403_fruteria;
}