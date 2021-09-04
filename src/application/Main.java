package application;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
        Button anotherButton = new Button();
        simpleButton.setPrefWidth(100);
        simpleButton.setPrefHeight(20);

        anotherButton.setPrefWidth(100);
        anotherButton.setPrefHeight(20);


        simpleButton.setText("Next");
        anotherButton.setText("Data");

        HBox hbox1 = new HBox(simpleButton, anotherButton);
        hbox1.setSpacing(10);


        hbox1.setAlignment(Pos.CENTER);


        BorderPane simplePane = new BorderPane();// It is used in order to set it at the center
        simplePane.setCenter(hbox1);

        simpleButton.setOnAction(actionEvent -> {
            stage.close();
            stage.setScene(borderScene(stage));
            stage.show();
        });
        anotherButton.setOnAction(actionEvent -> {
            stage.close();
            stage.setScene(accountScene(stage));
            stage.show();
        });

        return new Scene(simplePane);
    }
    public Scene borderScene(Stage stage){// Displays the borders: home, close, add, sub
        Button addButton = new Button("Add"); addButton.setPrefHeight(stage.getHeight());// Adjusting the width on add
        Button subButton = new Button("Sub"); subButton.setPrefHeight(stage.getHeight());// and sub button
        Button closeButton = new Button("Close"); closeButton.setPrefWidth(stage.getWidth()/2);// Adjusting the height on the close and
        Button resetButton = new Button("Reset"); resetButton.setPrefWidth(stage.getWidth()/2);// reset button adjacent to each other
        Button homeButton = new Button("Home"); homeButton.setPrefWidth(stage.getWidth());// home button

        HBox hbox = new HBox(closeButton, resetButton);

        BorderPane borderPane = new BorderPane(); //Adjusting the position of the various buttons
        borderPane.setBottom(hbox);// at the bottom
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

        resetButton.setOnAction(actionEvent -> {
            int ret = Integer.parseInt(label.getText());
            label.setText("0");

        });

        return new Scene(borderPane);
    }

    public Scene accountScene(Stage stage){// entering to the next scene to enter any text

        Label label = new Label();
        label.setText("Enter any text: ");

        TextField inputText = new TextField();// text to be inputed

        Button btn = new Button("Display");

        Label label1 = new Label();// text to be displayed

        HBox side = new HBox(label, inputText, btn, label1);

        BorderPane borderPane1 = new BorderPane();
        borderPane1.setCenter(side);

        btn.setOnAction(actionEvent -> {
            label1.setText(inputText.getText());
        });

        return new Scene(borderPane1);
    }
}