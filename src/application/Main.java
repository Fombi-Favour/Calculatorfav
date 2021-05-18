package application;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Setting Button");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setScene(simpleScene(stage));
        stage.show();
    }

    public Scene simpleScene(Stage stage){// Creating a button in the first scene to be placed at the center
        Button simpleButton = new Button();
        simpleButton.setPrefWidth(100);
        simpleButton.setPrefHeight(20);
        simpleButton.setText("Next");

        simpleButton.setAlignment(Pos.CENTER);

        BorderPane simplePane = new BorderPane();// It is used in order to set it at the center
        simplePane.setCenter(simpleButton);

        simpleButton.setOnAction(actionEvent -> {
            stage.close();
            stage.setScene(borderScene(stage));
            stage.show();
        });

        return new Scene(simplePane);
    }
    public Scene borderScene(Stage stage){// Displays the borders: home, close, add, sub
        Button addButton = new Button("Add"); addButton.setPrefHeight(stage.getHeight());// Adjusting the width on add
        Button subButton = new Button("Sub"); subButton.setPrefHeight(stage.getHeight());// and sub button
        Button closeButton = new Button("Close"); closeButton.setPrefWidth(stage.getWidth());// Adjusting the height on the close and
        Button homeButton = new Button("Home"); homeButton.setPrefWidth(stage.getWidth());// home button

        BorderPane borderPane = new BorderPane(); //Adjusting the position of the various buttons
        borderPane.setBottom(closeButton);// at the bottom
        borderPane.setLeft(addButton);// on the left
        borderPane.setRight(subButton);// on the right
        borderPane.setTop(homeButton);// at the top

        Label label = new Label("0");// creating a label at the center
        borderPane.setCenter(label);

        addButton.setOnAction(actionEvent -> {// setting an action on every button
            int add = Integer.parseInt(label.getText()) + 1;
            label.setText(String.valueOf(add));
        });

        subButton.setOnAction(actionEvent -> {
            int sub = Integer.parseInt(label.getText()) - 1;
            label.setText(String.valueOf(sub));
        });

        closeButton.setOnAction(actionEvent -> {
            stage.close();
        });

        homeButton.setOnAction(actionEvent -> {
            stage.close();
            stage.setScene(simpleScene(stage));
            stage.show();
        });

        return new Scene(borderPane);
    }
}