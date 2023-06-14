package com.nyzheirwarner.nyny;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SqlDatabaseConnect {
    public Connection DatabaseLink;
    static String dataBaseURL = "jdbc:mysql://localhost:3306/showlistdatabase";
    static String dataBaseUsername = "root";
    static String dataBasePassword = "SunCrisp1741#21";

/*
    public void loadDatabase() {
        try{
            Connection connection = DriverManager.getConnection(dataBaseURL, dataBaseUsername, dataBasePassword);
            System.out.println("Connected to the database");

            String query = "SELECT * FROM showlistdatabase.mylist_table";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id =  resultSet.getInt("id");
                String name = resultSet.getString("show_name");
                String type = resultSet.getString("show_type");
                Integer score = resultSet.getInt("show_score");
                Integer episodes = resultSet.getInt("number_episodes");
                //showList.add(new Shows(id, name, type, score, episodes));
                Shows show = new Shows(id, name, type, score, episodes);
                allShowsTable.getItems().clear();
                allShowsTable.getItems().add(show);
                System.out.println(id +" " + name + " "+ type + " "+ score + " " + episodes);
            }
            System.out.println("Table Loaded");


            connection.close();
            System.out.println("Disconnected from the database");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

    public void dataEntry(String name, String type, Integer score, Integer episodes) {
        try {
            Connection connection = DriverManager.getConnection(dataBaseURL, dataBaseUsername,dataBasePassword);

            String sql = "INSERT INTO mylist_table (show_name, show_type, show_score, number_episodes) VALUES(?, ?, ?, ?)";
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, name);
            statment.setString(2, type);
            statment.setInt(3,score);
            statment.setInt(4, episodes);

            int rowInserted = statment.executeUpdate();
            if(rowInserted > 0) {
                System.out.println("Data Inserted Successfully");
            }
            else{
                System.out.println("Data Insertion Failed.");
            }

            statment.close();
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void dataEntry_W(String name_w, String type_w, Integer episodes_w, String genre_w)  {
        try{
            Connection connection = DriverManager.getConnection(dataBaseURL, dataBaseUsername,dataBasePassword);
            String sql = "INSERT INTO wtw_table (name, type, number_episodes_w, genre) VALUES(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name_w);
            statement.setString(2, type_w);
            statement.setInt(3,episodes_w);
            statement.setString(4, genre_w);

            int rowInserted = statement.executeUpdate();
            if(rowInserted > 0) {
                System.out.println("Data Inserted Successfully");
            }
            else{
                System.out.println("Data Insertion Failed.");
            }

            statement.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
