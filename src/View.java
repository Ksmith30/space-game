import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class View extends JFrame implements ActionListener {
    private static int width = 1000;
    private static int height = 700;

    private class MyPanel extends JPanel {
        Controller controller;


        MyPanel(Controller c) {
            controller = c;
            JLabel instructions = new JLabel("To start the game press 's'");
            instructions.setForeground(Color.WHITE);
            this.add(instructions);
        }

        public void paintComponent(Graphics g) {
            controller.update(g);
            revalidate();
            getContentPane().setBackground(Color.BLACK);
        }
    }

    public View(Controller c)throws Exception{
        setTitle("My Game");
        setSize(width, height);
        getContentPane().add(new MyPanel(c));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(c);
    }

    public void actionPerformed(ActionEvent evt) {
        repaint();
    }
}

