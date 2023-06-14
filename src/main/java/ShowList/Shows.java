package ShowList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Shows {
    SimpleIntegerProperty id;
    SimpleStringProperty  name;
    SimpleStringProperty  type;
    SimpleIntegerProperty  score;
    SimpleIntegerProperty  episodes;

    public Shows(Integer id, String name, String type, Integer score, Integer episodes){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.score = new SimpleIntegerProperty(score) ;
        this.episodes = new SimpleIntegerProperty(episodes);
    }

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getEpisodes() {
        return episodes.get();
    }

    public SimpleIntegerProperty episodesProperty() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes.set(episodes);
    }
}
