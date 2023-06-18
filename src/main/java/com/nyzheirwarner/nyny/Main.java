package com.nyzheirwarner.nyny;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.prefs.Preferences;



public class Main extends Application  {

    private static final double DEFAULT_WIDTH = 800;
    private static final double DEFAULT_HEIGHT = 600;

    public Main() throws IOException, InterruptedException {
        // TODO document why this constructor is empty
    }

    @Override
    //the primary stage that you see when you first load up the application
    public void start(Stage primeStage) throws IOException {
        Preferences preferences;
        preferences = Preferences.userRoot().node(this.getClass().getName());

        double savedWidth = preferences.getDouble("windowWidth",DEFAULT_WIDTH);
        double savedHeight = preferences.getDouble("WindowHeight",DEFAULT_HEIGHT);

        primeStage.setWidth(savedWidth);
        primeStage.setHeight(savedHeight);

        primeStage.setOnCloseRequest((WindowEvent e)->{
            preferences.putDouble("windowWidth",primeStage.getWidth());
            preferences.putDouble("WindowHeight", primeStage.getHeight());
        });

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main_JFX.fxml")));

        Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //need to try and implement spotify web api prob need to make small site on local machine to run.
        Random ran = new Random();
        int ran_IC = ran.nextInt(6);

        HashMap<Integer,String> iconDict = new HashMap<>();
        iconDict.put(0,"C:\\Users\\eshas\\IdeaProjects\\PL_Project\\src\\main\\resources\\com\\nyzheirwarner\\nyny\\Images\\Screenshot 2023-05-08 224137.png");
        iconDict.put(1,"C:\\Users\\eshas\\IdeaProjects\\PL_Project\\src\\main\\resources\\com\\nyzheirwarner\\nyny\\Images\\Screenshot 2023-04-16 192235.png");
        iconDict.put(2,"C:\\Users\\eshas\\IdeaProjects\\PL_Project\\src\\main\\resources\\com\\nyzheirwarner\\nyny\\Images\\WDRY0779.JPG");
        iconDict.put(3,"C:\\Users\\eshas\\IdeaProjects\\PL_Project\\src\\main\\resources\\com\\nyzheirwarner\\nyny\\Images\\image 2222.png");
        iconDict.put(4,"C:\\Users\\eshas\\IdeaProjects\\PL_Project\\src\\main\\resources\\com\\nyzheirwarner\\nyny\\Images\\image.jpg");
        iconDict.put(5,"C:\\Users\\eshas\\IdeaProjects\\PL_Project\\src\\main\\resources\\com\\nyzheirwarner\\nyny\\Images\\1_The-Weeknd.jpg");

        primeStage.setTitle("Personal Planner");
        primeStage.setScene(scene);
        primeStage.getIcons().add(new Image(iconDict.get(ran_IC)));
        primeStage.show();

    }
    public static void main(String[] args) throws IOException, InterruptedException {
        launch();
        /*
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://openai80.p.rapidapi.com/images/generations"))
                .header("content-type", "application/json")
                .header("X-RapidAPI-Key", "b3f35b28bbmsh1acce0fb8f4ba5ep1f1092jsn8fab6a61e3e5")
                .header("X-RapidAPI-Host", "openai80.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\r\n    \"prompt\": \"Nyzheir Warner \",\r\n    \"n\": 2,\r\n    \"size\": \"1024x1024\"\r\n}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
         */
    }
}