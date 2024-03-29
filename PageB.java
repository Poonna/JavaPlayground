import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class PageB extends JPanel {
    private BasicApp app;
    private String text;

    public PageB(BasicApp app) {
        this.app = app;

        JButton backButton = new JButton("Back");
        JButton showButton = new JButton("Show");

        add(backButton);
        add(showButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PageB.this.app.switchToPageA();
            }
        });

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, text);
            }
        });
    }

    void setData(String text) {
        this.text = text;
    }
}
