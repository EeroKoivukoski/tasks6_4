package tasks6_4.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
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
        // Initialization logic if needed
    }

    @FXML
    private void addNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);

            // Update ListView
            notesList.getItems().add(note);

            // Clear input fields
            titleField.clear();
            contentArea.clear();
        }
    }
}
