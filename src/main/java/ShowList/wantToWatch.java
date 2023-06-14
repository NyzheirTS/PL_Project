package ShowList;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class wantToWatch {
    SimpleIntegerProperty id_w;
    SimpleStringProperty name_w;
    SimpleStringProperty type_w;
    SimpleIntegerProperty episodes_w;
    SimpleStringProperty genre_w;


    public wantToWatch(Integer id_w, String name_w, String type_w, Integer episodes_w, String genre_w) {
        this.id_w = new SimpleIntegerProperty(id_w);
        this.name_w = new SimpleStringProperty(name_w);
        this.type_w = new SimpleStringProperty(type_w);
        this.episodes_w = new SimpleIntegerProperty(episodes_w);
        this.genre_w = new SimpleStringProperty(genre_w);
    }

    public int getId_w() {
        return id_w.get();
    }

    public SimpleIntegerProperty id_wProperty() {
        return id_w;
    }

    public void setId_w(int id_w) {
        this.id_w.set(id_w);
    }

    public String getName_w() {
        return name_w.get();
    }

    public SimpleStringProperty name_wProperty() {
        return name_w;
    }

    public void setName_w(String name_w) {
        this.name_w.set(name_w);
    }

    public String getType_w() {
        return type_w.get();
    }

    public SimpleStringProperty type_wProperty() {
        return type_w;
    }

    public void setType_w(String type_w) {
        this.type_w.set(type_w);
    }

    public int getEpisodes_w() {
        return episodes_w.get();
    }

    public SimpleIntegerProperty episodes_wProperty() {
        return episodes_w;
    }

    public void setEpisodes_w(int episodes_w) {
        this.episodes_w.set(episodes_w);
    }

    public String getGenre_w() {
        return genre_w.get();
    }

    public SimpleStringProperty genre_wProperty() {
        return genre_w;
    }

    public void setGenre_w(String genre_w) {
        this.genre_w.set(genre_w);
    }

}
