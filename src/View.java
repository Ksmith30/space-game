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
        JLabel numberOfPoints;

        MyPanel(Controller c) {
            controller = c;
            JLabel instructions = new JLabel("To start the game press 's'");
            instructions.setForeground(Color.WHITE);
            this.add(instructions);
            numberOfPoints = new JLabel("Points: " + 0);
            numberOfPoints.setForeground(Color.WHITE);
            this.add(numberOfPoints);
        }

        public void paintComponent(Graphics g) {
            controller.update(g);
            revalidate();
            this.setBackground(Color.BLACK);
        }

        public void setNumberOfPoints(int points) {
            numberOfPoints.setText("Points: " + points);
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

}

