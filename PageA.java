import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PageA extends JPanel {
    private BasicApp app;

    public PageA(BasicApp app) {
        this.app = app;

        JLabel label = new JLabel("Click here:");
        JButton button = new JButton("Click!");
        JTextField textField = new JTextField("Nothing here.", 20);

        JPanel topPanel = new JPanel();
        topPanel.add(label);
        topPanel.add(button);

        String[] columnNames = { "Text", "Length" };
        Object[][] data = {
            { "Hello", Integer.valueOf(5) },
            { "Goodbye", Integer.valueOf(7) }
        };

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.setValueAt(textField.getText(), 0, 0);
                table.setValueAt(textField.getText().length(), 0, 1);
            }
        });
    }
}
