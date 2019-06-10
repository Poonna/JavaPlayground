import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicApp extends JFrame {
    public BasicApp() {
        super("Basic GUI Demo");

        add(new PageA());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BasicApp();
            }
        });
    }
}
