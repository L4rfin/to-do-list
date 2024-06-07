package com.example.todolist.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Window;

public class HomeController {
    @FXML
    Button newTask;
    Popup newTaskWindow = new Popup();

    public void printButton(MouseEvent event) {

        VBox body = new VBox();
        body.setStyle("-fx-background-color: #123242");
        HBox column1 = new HBox();
        TextField taskName = new TextField("to do what?");
        MenuButton difficulty = new MenuButton("difficulty",new VBox(),new MenuItem("easy"),new MenuItem("easy"),new MenuItem("easy"),new MenuItem("easy"));
        TextArea taskDescription = new TextArea("task description");
        Label labelName = new Label("task name");
        Label labelDescription = new Label("description");
        HBox centerButton = new HBox();
        Button confirm = new Button("confirm");

        EventHandler<ActionEvent> confirmEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                newTaskWindow.hide();
                System.out.println(taskName.getText());
                System.out.println(taskDescription.getText());
            }
        };

        confirm.setOnAction(confirmEvent);

        column1.getChildren().add(labelName);
        column1.getChildren().add(taskName);
        column1.getChildren().add(difficulty);
        body.getChildren().add(column1);
        body.getChildren().add(labelDescription);
        body.getChildren().add(taskDescription);
        centerButton.getChildren().add(confirm);
        body.getChildren().add(centerButton);
        newTaskWindow.getContent().add(body);

        if (!newTaskWindow.isShowing())
            newTaskWindow.show(( (Node) event.getSource()). getScene().getWindow());
        Window window = (( (Node) event.getSource()). getScene().getWindow());
        double positionX = window.getX();
        double positionY = window.getY();
        if (window.getX()!=positionX|| window.getY()!=positionY){
            newTaskWindow.hide();
        }
    }
    public void popupClose(){

    }

}
