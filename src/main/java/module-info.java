module com.nyzheirwarner.nyny {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires annotations;
    requires java.prefs;
    requires java.net.http;
            
                            
    opens com.nyzheirwarner.nyny to javafx.fxml;
    exports com.nyzheirwarner.nyny;
}