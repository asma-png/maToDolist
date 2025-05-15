package com.example.toodoolist;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class HelloController {
    @FXML private TextField inputField;
    @FXML private ListView<String> taskListView;

    private final ManageItem manageItem = new ManageItem();

    @FXML
    public void initialize() {
        updateList();
    }

    @FXML
    private void addTask() {
        String task = inputField.getText().trim();
        if (task.isEmpty()) {
            showError("Please enter a Task");
            return;
        }
        manageItem.addTask(task);
        inputField.clear();
        updateList();
    }

    @FXML
    private void removeTask() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex == -1) {
            showError("Please select a task to delete.");
            return;
        }
        manageItem.removeTask(selectedIndex);
        updateList();
    }

    @FXML
    private void editTask() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        String newText = inputField.getText().trim();

        if (selectedIndex == -1) {
            showError("Please select a task to edit.");
            return;
        }
        if (newText.isEmpty()) {
            showError("Please enter the new text.");
            return;
        }

        manageItem.editTask(selectedIndex, newText);
        inputField.clear();
        updateList();
    }

    private void updateList() {
        taskListView.setItems(FXCollections.observableArrayList(manageItem.getTasks()));
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }
}
