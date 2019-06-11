import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class BasicApp extends JFrame {
    private CardLayout layout;

    public BasicApp() {
        super("Basic GUI Demo");

        layout = new CardLayout();
        setLayout(layout);
        PageA pageA = new PageA(this);
        PageB pageB = new PageB(this);
        add(pageA, "PageA");
        add(pageB, "PageB");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void switchToPageA() {
        layout.show(this.getContentPane(), "PageA");
    }

    public void switchToPageB() {
        layout.show(this.getContentPane(), "PageB");
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
