import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class View extends JFrame implements ActionListener {
    private static int width = 1000;
    private static int height = 700;
    private MyPanel myPanel;

    public class MyPanel extends JPanel {
        Controller controller;
        JLabel start;
        JLabel numberOfPoints;
        JLabel pause;

        MyPanel(Controller c) {
            controller = c;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            start = new JLabel("To start the game press SPACE.                             " +
                    "OBJECTIVE: Capture all 20 stars.");
            start.setForeground(Color.WHITE);
            start.setAlignmentX(CENTER_ALIGNMENT);
            this.add(start);
            this.add(Box.createRigidArea(new Dimension(0, 350)));

            pause = new JLabel("-- PAUSED --");
            pause.setForeground(Color.WHITE);
            pause.setAlignmentX(CENTER_ALIGNMENT);
            this.add(pause);
            pause.setVisible(false);
            this.add(Box.createRigidArea(new Dimension(0, 290)));

            numberOfPoints = new JLabel("Points: " + 0 + "         " +
                    "|  ↑ - Up  |  ← - Left  |  ↓ - Down  |  → - Right  |  p - PAUSE  |  r - RESUME  |  Restart - SPACE");
            numberOfPoints.setForeground(Color.WHITE);
            numberOfPoints.setAlignmentX(CENTER_ALIGNMENT);
            this.add(numberOfPoints);

        }

        public void paintComponent(Graphics g) {
            controller.update(g);
            revalidate();
            this.setBackground(Color.BLACK);
        }

        public void setNumberOfPoints(int points) {
            numberOfPoints.setText("Points: " + points + "         " +
                    "|  ↑ - Up  |  ← - Left  |  ↓ - Down  |  → - Right  |  p - PAUSE  |  r - RESUME  |  Restart - SPACE");
        }

        public void setPause(boolean visible) {
            pause.setVisible(visible);
            pause.setText("-- PAUSED --");
        }

        public void setStart(boolean visible) {
            start.setVisible(visible);
        }

        public void assertWin() {
            pause.setText("-- YOU WIN!! --");
            pause.setVisible(true);
            pause.setForeground(Color.RED);
        }
    }

    public View(Controller c)throws Exception{
        myPanel = new MyPanel(c);
        setTitle("My Game");
        setSize(width, height);
        getContentPane().add(myPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(c);
    }

    public void actionPerformed(ActionEvent evt) {
        repaint();
    }

    public void setNumberOfPoints(int points) {
        myPanel.setNumberOfPoints(points);
    }

    public void setPause(boolean visible) {
        myPanel.setPause(visible);
    }

    public void setStart(boolean visible) {
        myPanel.setStart(visible);
    }

    public void assertWin() {
        myPanel.assertWin();
    }

}

