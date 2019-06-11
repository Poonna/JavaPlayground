import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
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

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(textField, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PageA.this.app.switchToPageB(textField.getText());
            }
        });
    }
}
