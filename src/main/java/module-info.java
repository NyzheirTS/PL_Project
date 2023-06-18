module com.nyzheirwarner.nyny {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires annotations;
    requires java.prefs;
    requires java.net.http;
    requires com.calendarfx.view;
    requires org.slf4j;


    opens com.nyzheirwarner.nyny to javafx.fxml;
    exports com.nyzheirwarner.nyny;
}