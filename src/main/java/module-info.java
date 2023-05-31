module com.nyzheirwarner.nyny {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.nyzheirwarner.nyny to javafx.fxml;
    exports com.nyzheirwarner.nyny;
}