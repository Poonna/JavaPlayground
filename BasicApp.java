import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class BasicApp extends JFrame {
    private CardLayout layout;
    private PageA pageA;
    private PageB pageB;

    public BasicApp() {
        super("Basic GUI Demo");

        layout = new CardLayout();
        setLayout(layout);
        pageA = new PageA(this);
        pageB = new PageB(this);
        add(pageA, "PageA");
        add(pageB, "PageB");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void switchToPageA() {
        layout.show(this.getContentPane(), "PageA");
    }

    public void switchToPageB(String text) {
        pageB.setData(text);
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
