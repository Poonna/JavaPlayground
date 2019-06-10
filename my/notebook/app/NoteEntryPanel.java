package my.notebook.app;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NoteEntryPanel extends JPanel {
    private NotebookContext appContext;
    private JTextField subjectEntry;
    private JTextField dateEntry;
    private JTextArea noteEntry;
    private Note currentNote;

    public NoteEntryPanel(NotebookContext appContext, Note newNote) {
        this.appContext = appContext;

        setLayout(new BorderLayout());

        JLabel subjectLabel = new JLabel("Subject");
        JLabel dateLabel = new JLabel("Date");
        JButton okButton = new JButton("OK");

        subjectEntry = new JTextField(40);
        dateEntry = new JTextField(8);

        noteEntry = new JTextArea(10, 60);
        noteEntry.setLineWrap(true);
        noteEntry.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(noteEntry);

        JPanel topPanel = new JPanel();

        topPanel.add(subjectLabel);
        topPanel.add(subjectEntry);
        topPanel.add(dateLabel);
        topPanel.add(dateEntry);
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentNote.setSubject(subjectEntry.getText());
                currentNote.setDate(dateEntry.getText());
                currentNote.setNote(noteEntry.getText());
                appContext.switchToNoteList();
            }
        });

        editNote(newNote);
    }

    public void editNote(Note note) {
        currentNote = note;
        subjectEntry.setText(note.getSubject());
        dateEntry.setText(note.getDate());
        noteEntry.setText(note.getNote());
    }
}
