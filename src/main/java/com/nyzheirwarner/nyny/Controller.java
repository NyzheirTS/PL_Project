package com.nyzheirwarner.nyny;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import ShowList.*;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

// TO GET TO RUN AGAIN ADD implements Initializable to controller class.
public class Controller extends SqlDatabaseConnect implements Initializable{
    // all variables needed for want to watch table.
    public TableView<wantToWatch> wantToWatchTable = new TableView<>();
    public TableColumn<wantToWatch, Integer> tabelNumber_W = new TableColumn<>();
    public TableColumn<wantToWatch, String> showName_W = new TableColumn<>();
    public TableColumn<wantToWatch, String> showType_W = new TableColumn<>();
    public TableColumn<wantToWatch, Integer> numberEpisodes_W = new TableColumn<>();
    public TableColumn<wantToWatch, String> genre_W = new TableColumn<>();
    public AnchorPane pane;
    public Button HomeButton;
    public Button CalenderButton;
    public Label Text;
    public Button ShowButton;
    public Tab allShows;
    public Tab wantToWatch;
    @FXML
    public AnchorPane watchListPane;
    @FXML
    public MenuItem wantToWatchButton;
    public TabPane Tabs;
    public Button cancelListButton_W;
    public Button addToListButton_W;
    public TextField numberOfEpisodes_W;
    public TextField showNameTXTField_W;
    public TextField numberOfEpisodesField;
    public TextField showNameTXTField;
    public Button cancelListButton;
    public Button addToListButton;
    public ChoiceBox<String> showTypeChoiceBOX = new ChoiceBox<>();
    public ChoiceBox<Integer> scoreChoiceBox = new ChoiceBox<>();
    public ChoiceBox<String> showTypeChoiceBOX_W = new ChoiceBox<>();
    public TableView<Shows> allShowsTable = new TableView<>();
    public TableColumn<Shows, Integer> tableNumber = new TableColumn<>();
    public TableColumn<Shows, String> showName = new TableColumn<>();
    public TableColumn<Shows, Integer> showScore = new TableColumn<>();
    public TableColumn<Shows, String> showType = new TableColumn<>();
    public TableColumn<Shows, Integer> numberEpisodes = new TableColumn<>();
    @FXML
    public TextField filterTxtField = new TextField();
    public TextField genreTxtBox_W;
    public Button financeBroSwitch;
    private String[] showTypeChoice = {"Movie","TV","Anime"};
    private String[] showTypeChoice_w = {"Movie","TV","Anime"};
    private Integer[] showScoreChoice = {1,2,3,4,5,6,7,8,9,10};
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private WebView webView;
    @FXML
    private TextField textField;
    private WebEngine engine = new WebEngine();
    private String HomePage;

    public Controller() throws SQLException {
    }

    public void homeSceneSwitch(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main_JFX.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        HomeButton.setUnderline(false);

    }
    public void calenderSceneSwitch(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("usrCalenderFXML/usrCalender.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ShowListSwitchScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ShowListFXML/showList.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void financeBroSwitch(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FinanceHubFXML/financeBro.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addEntrySwitch(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShowListFXML/addEntryPopUp.fxml"));
        root = fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("Add Entry");
        stage.setScene(new Scene(root));
        stage.show();

    }
    public void confirmEntry(ActionEvent event) {

        String show_name = showNameTXTField.getText();
        String show_type = showTypeChoiceBOX.getValue();
        Integer show_score = scoreChoiceBox.getValue();
        Integer number_episodes = Integer.parseInt(numberOfEpisodesField.getText());

        dataEntry(show_name,show_type,show_score,number_episodes);


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void confirmEntry_W(ActionEvent event) {

        String show_name_w = showNameTXTField_W.getText();
        String show_type_w = showTypeChoiceBOX_W.getValue();
        Integer show_episodes_w = Integer.parseInt(numberOfEpisodes_W.getText());
        String show_genre_w = genreTxtBox_W.getText();

        dataEntry_W(show_name_w, show_type_w, show_episodes_w, show_genre_w);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void cancelEntry(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    //initializer method that handles things that do not have a node connection such as the choice boxes or anything that need to be initialized before the program starts
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //sets the choices to the choice boxes int the program.
        showTypeChoiceBOX.getItems().addAll(showTypeChoice);
        scoreChoiceBox.getItems().addAll(showScoreChoice);
        showTypeChoiceBOX_W.getItems().addAll(showTypeChoice_w);

        //used load the showlist database and tableview.
        addColum();
        DB_CONNECT();
        DB_CONNECT_W();



        //webView Start/
        /*
        engine = webView.getEngine();
        HomePage = "google.com";
        textField.setText(HomePage);
        engine.load("https://"+ textField.getText());
         */

        //method to filter table by input in a txtfield
        FilteredList<Shows> filterData = new FilteredList<>(data, b -> true);
        FilteredList<wantToWatch> filterData_W = new FilteredList<>(data_W, f -> true);
        filterTxtField.textProperty().addListener((observable, oldValue, newValue) -> {
            //uses a predicate to determine compare input and determine whether true or false. b
            filterData.setPredicate(Shows -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                //cast toLower for easy comparison
                String lowerCaseFilter = newValue.toLowerCase();
                if (Shows.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // filter match to name
                }
                else if(Shows.getType().toLowerCase().contains(lowerCaseFilter)){
                    return true; // filter match to type
                }
                else if(String.valueOf(Shows.getScore()).contains(lowerCaseFilter)) {
                    return true; // filter match to score
                }
                else
                    return false;
            });
            filterData_W.setPredicate(wantToWatch -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                //cast toLower for easy comparison
                String lowerCaseFilter_w = newValue.toLowerCase();
                if (wantToWatch.getName_w().toLowerCase().contains(lowerCaseFilter_w)) {
                    return true; // filter match to name
                }
                else if(wantToWatch.getType_w().toLowerCase().contains(lowerCaseFilter_w)){
                    return true; // filter match to type
                }
                else if(wantToWatch.getGenre_w().toLowerCase().contains(lowerCaseFilter_w)) {
                    return true; // filter match to genre
                }
                else
                    return false;
            });
        });
        // new sorted list base upon inputed txt field.
        SortedList<Shows> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(allShowsTable.comparatorProperty());
        allShowsTable.setItems(sortedData);

        SortedList<wantToWatch> sortedData_W = new SortedList<>(filterData_W);
        sortedData_W.comparatorProperty().bind(wantToWatchTable.comparatorProperty());
        wantToWatchTable.setItems(sortedData_W);
    }
    public void addColum(){
        tableNumber.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        showName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        showScore.setCellValueFactory(cellData -> cellData.getValue().scoreProperty().asObject());
        showType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        numberEpisodes.setCellValueFactory(cellData -> cellData.getValue().episodesProperty().asObject());

        tabelNumber_W.setCellValueFactory((cellData -> cellData.getValue().id_wProperty().asObject()));
        showName_W.setCellValueFactory(cellData -> cellData.getValue().name_wProperty());
        showType_W.setCellValueFactory(cellData -> cellData.getValue().type_wProperty());
        numberEpisodes_W.setCellValueFactory(cellData -> cellData.getValue().episodes_wProperty().asObject());
        genre_W.setCellValueFactory(cellData -> cellData.getValue().genre_wProperty());
    }
    ObservableList<Shows> data = FXCollections.observableArrayList();
    ObservableList<wantToWatch> data_W = FXCollections.observableArrayList();
    public Shows DB_CONNECT(){

        try {
            Connection connection = DriverManager.getConnection(dataBaseURL,dataBaseUsername, dataBasePassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM showlistdatabase.mylist_table");

            while(resultSet.next()){
                Integer id =  resultSet.getInt("id");
                String name = resultSet.getString("show_name");
                String type = resultSet.getString("show_type");
                Integer score = resultSet.getInt("show_score");
                Integer episodes = resultSet.getInt("number_episodes");
                data.add(new Shows(id, name, type, score, episodes));
            }

            allShowsTable.setItems(data);
            allShowsTable.refresh();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public wantToWatch DB_CONNECT_W(){
        try {
            Connection connection_w = DriverManager.getConnection(dataBaseURL, dataBaseUsername, dataBasePassword);
            Statement statement_w = connection_w.createStatement();
            ResultSet resultSet_w = statement_w.executeQuery("SELECT * FROM showlistdatabase.wtw_table");

            while(resultSet_w.next()){
                Integer id =  resultSet_w.getInt("id");
                String name = resultSet_w.getString("name");
                String type = resultSet_w.getString("type");
                Integer episodes = resultSet_w.getInt("number_episodes_w");
                String genre = resultSet_w.getString("genre");
                data_W.add(new wantToWatch(id, name, type, episodes, genre));
            }
            wantToWatchTable.setItems(data_W);
            wantToWatchTable.refresh();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}