import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class PageA extends JPanel {
    public PageA() {
        JLabel label = new JLabel("Click here:");
        JButton button = new JButton("Click!");
        JTextField textField = new JTextField("Nothing here.", 20);

        JPanel topPanel = new JPanel();
        topPanel.add(label);
        topPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Button clicked!");
            }
        });

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(textField, BorderLayout.CENTER);
    }
}
