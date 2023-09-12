import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectangleMouseEventsApp extends JFrame {
    private int rectangleX = 10;
    private int rectangleY = 10;
    private int rectangleWidth = 300;
    private int rectangleHeight = 200;

    public RectangleMouseEventsApp() {
        setTitle("Прямоугольник и события мыши");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClicked(e);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                handleMouseMoved(e);
            }
        });


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    showWindowSize();
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight);
    }

    private void handleMouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (mouseX >= rectangleX && mouseX <= (rectangleX + rectangleWidth) &&
                    mouseY >= rectangleY && mouseY <= (rectangleY + rectangleHeight)) {
                JOptionPane.showMessageDialog(this, "Точка внутри прямоугольника");
            } else if (mouseX >= rectangleX - 10 && mouseX <= (rectangleX + rectangleWidth + 10) &&
                    mouseY >= rectangleY - 10 && mouseY <= (rectangleY + rectangleHeight + 10)) {
                JOptionPane.showMessageDialog(this, "Точка на границе прямоугольника");
            } else {
                JOptionPane.showMessageDialog(this, "Точка снаружи прямоугольника");
            }

            if (e.isControlDown()) {
                System.exit(0);
            }
        }
    }

    private void handleMouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        setTitle("Координаты мыши: X = " + mouseX + ", Y = " + mouseY);
    }

    private void showWindowSize() {
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        JOptionPane.showMessageDialog(this, "Ширина = " + windowWidth + ", Высота = " + windowHeight);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RectangleMouseEventsApp app = new RectangleMouseEventsApp();
                app.setVisible(true);
            }
        });
    }
}
