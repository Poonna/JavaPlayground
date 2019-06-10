package my.notebook.app;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NoteListPanel extends JPanel {
    private ArrayList<Note> notes;
    private NotebookContext appContext;

    public NoteListPanel(NotebookContext appContext, ArrayList<Note> notes) {
        this.appContext = appContext;
        this.notes = notes;

        JTable noteList = new JTable(new AbstractTableModel() {
            String[] columnNames = { "Date", "Subject" };
            public String getColumnName(int col) {
                return columnNames[col];
            }
            public int getColumnCount() { return 2; }
            public int getRowCount() { return notes.size(); }
            public Object getValueAt(int row, int col) {
                Note note = notes.get(row);
                if (col == 0) { return note.getDate(); }
                else if (col == 1) { return note.getSubject(); }
                else throw new IllegalArgumentException("Unknown column");
            }
        });
        noteList.setFillsViewportHeight(true);
        noteList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(noteList);

        JButton newButton = new JButton("New");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Note newNote = new Note();
                notes.add(newNote);
                appContext.switchToNoteEntry(newNote);
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (noteList.getSelectedRow() >= 0) {
                    appContext.switchToNoteEntry(notes.get(noteList.getSelectedRow()));
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(newButton);
        bottomPanel.add(editButton);

        setLayout(new BorderLayout());
        add(new JLabel("Note List", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
