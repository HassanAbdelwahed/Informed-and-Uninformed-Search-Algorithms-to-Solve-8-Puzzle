package com.example.lab1ai;

import com.example.lab1ai.*;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Controller {
    private Stack<State> path = new Stack<>();
    private Stack<State> stepsPath = new Stack<>();
    Alert alert = new Alert(Alert.AlertType.NONE);
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button solveButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button place00;
    @FXML
    private Button place01;
    @FXML
    private Button place02;
    @FXML
    private Button place10;
    @FXML
    private Button place11;
    @FXML
    private Button place12;
    @FXML
    private Button place20;
    @FXML
    private Button place21;
    @FXML
    private Button place22;

    @FXML
    private List<Button> buttons = new ArrayList<>();
    protected int stringToBe[] = new int[9];

    protected int current = 0, steps = 0;

    protected void addButtons() {
        buttons.add(place00);
        buttons.add(place01);
        buttons.add(place02);
        buttons.add(place10);
        buttons.add(place11);
        buttons.add(place12);
        buttons.add(place20);
        buttons.add(place21);
        buttons.add(place22);
    }

    @FXML
    protected void handleClick(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if (buttons.size() == 0) {
            addButtons();
        }
        int i;
        for (i = 0; i < 9; i++) {
            if (buttons.get(i).equals(sourceButton)) {
                break;
            }
        }
        if (current == 0) {
            buttons.get(i).setText(" ");
        } else {
            buttons.get(i).setText(String.valueOf(current));
        }
        buttons.get(i).setDisable(true);
        buttons.get(i).setFocusTraversable(false);
        stringToBe[i] = current;
        current++;
        provideAlgorithms();
    }

    @FXML
    protected void provideAlgorithms() {
        if (current == 9 && comboBox.getItems().isEmpty()) {
            comboBox.setPromptText("Select an algorithm");
            comboBox.getItems().addAll(
                    "BFS",
                    "DFS",
                    "A* (Manhattan)",
                    "A* (Euclidean)"
            );
            solveButton.setDisable(false);
        } else {
            comboBox.setPromptText("Add All Pieces");
        }
    }

    @FXML
    protected void solve(ActionEvent event) {
        String initialState = Arrays.toString(stringToBe).replaceAll("\\[|\\]|,|\\s", "");
        if (CheckSolvable.isSolvable(initialState)) {
            if (comboBox.getValue() == null) {
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setContentText("Please Select algorithm first");
                alert.show();
            } else if (comboBox.getValue() == "BFS") {
                BFS bfs = new BFS();
                bfs.bfs(initialState);
                path = bfs.finalPath;
                next();
            } else if (comboBox.getValue() == "DFS") {
                DFS dfs = new DFS();
                dfs.dfs(initialState);
                path = dfs.finalPath;
                next();
            } else if (comboBox.getValue() == "A* (Manhattan)") {
                AStarManhattan aStarManhattan = new AStarManhattan();
                aStarManhattan.aStarManhattan(initialState);
                path = aStarManhattan.finalPath;
                next();
            } else if (comboBox.getValue() == "A* (Euclidean)") {
                AStarEuclidean aStarEuclidean = new AStarEuclidean();
                aStarEuclidean.AStarEuclidean(initialState);
                path = aStarEuclidean.finalPath;
                next();
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Unsolvable");
            alert.show();
        }
        nextButton.setDisable(false);
    }

    @FXML
    protected void clear() {
        if (buttons.size() == 0) {
            addButtons();
        }
        for (int i = 0; i < 9; i++) {
            buttons.get(i).setText("");
            buttons.get(i).setDisable(false);
            stringToBe[i] = 0;
        }
        current = 0;
        steps = 0;
        comboBox.getItems().clear();
        path = new Stack<>();
        stepsPath = new Stack<>();
        nextButton.setDisable(true);
        provideAlgorithms();
    }

    @FXML
    protected void reset() {
        if (buttons.size() == 0) {
            addButtons();
        }
        for (int i = 0; i < 9; i++) {
            if (stringToBe[i] == 0) {
                buttons.get(i).setText("");
            } else {
                buttons.get(i).setText(String.valueOf(stringToBe[i]));
            }
        }
        steps = 0;
        provideAlgorithms();
    }

    @FXML
    private void next() {
        if(!path.isEmpty()){
            stepsPath.push(path.peek());
            changeValues(path.pop().getBoardState());
        }else{
            nextButton.setDisable(true);
        }
    }

    private void changeValues(String state) {
        for (int i = 0; i < 9; i++) {
            if (state.charAt(i) == '0') {
                buttons.get(i).setText(" ");
            } else {
                buttons.get(i).setText(String.valueOf(state.charAt(i)));
            }
        }
    }
}

