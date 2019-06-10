package my.notebook.app;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotebookApp extends JFrame implements NotebookContext {
    private ArrayList<Note> notes;
    private NoteEntryPanel noteEntryPanel;
    private NoteListPanel noteListPanel;
    private CardLayout layout;

    public NotebookApp() {
        super("Notebook");

        notes = new ArrayList<>();

        layout = new CardLayout();
        setLayout(layout);

        noteListPanel = new NoteListPanel(this, notes);
        noteEntryPanel = new NoteEntryPanel(this, new Note());
        add(noteListPanel, "NoteListPanel");
        add(noteEntryPanel, "NoteEntryPanel");

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(quitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(NotebookApp.this, "Open not yet implemented.");
            }
        });

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(NotebookApp.this, "Save not yet implemented.");
            }
        });

        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void switchToNoteList() {
        layout.show(this.getContentPane(), "NoteListPanel");
    }

    @Override
    public void switchToNoteEntry(Note note) {
        noteEntryPanel.editNote(note);
        layout.show(this.getContentPane(), "NoteEntryPanel");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotebookApp();
            }
        });
    }
}
