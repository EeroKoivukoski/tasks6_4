package tasks6_4.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import tasks6_4.model.Note;
import tasks6_4.model.Notebook;

public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private Button addButton;

    @FXML
    private ListView<Note> notesList;

    private final Notebook notebook = new Notebook();

    @FXML
    private void initialize() {
        // Add a context menu for editing/deleting
        ContextMenu contextMenu = new ContextMenu();

        MenuItem editItem = new MenuItem("Edit");
        editItem.setOnAction(_ -> editSelectedNote());

        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(_ -> deleteSelectedNote());

        contextMenu.getItems().addAll(editItem, deleteItem);
        notesList.setContextMenu(contextMenu);
    }

    @FXML
    private void addNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);
            notesList.getItems().add(note);

            titleField.clear();
            contentArea.clear();
        }
    }

    private void editSelectedNote() {
        Note selected = notesList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            // Pre-fill fields with existing data
            titleField.setText(selected.getTitle());
            contentArea.setText(selected.getContent());

            // Remove old note so when "Add" is clicked it gets replaced
            notesList.getItems().remove(selected);
            notebook.getNotes().remove(selected);
        }
    }

    private void deleteSelectedNote() {
        Note selected = notesList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            notesList.getItems().remove(selected);
            notebook.getNotes().remove(selected);
        }
    }

}