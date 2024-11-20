package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new SimpleController();

    /**
     * Build a very simple GUI for the program.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField tField = new JTextField();
        canvas.add(tField, BorderLayout.NORTH);
        final JTextArea tArea = new JTextArea();
        canvas.add(tArea, BorderLayout.CENTER);
        final JPanel innerCanvas = new JPanel();
        innerCanvas.setLayout(new BoxLayout(innerCanvas, BoxLayout.X_AXIS));
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show History");
        innerCanvas.add(printButton);
        innerCanvas.add(historyButton);
        canvas.add(innerCanvas, BorderLayout.PAGE_END);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                Objects.requireNonNull(tField.getText());
                controller.setNextString(tField.getText());
                controller.printCurrentString();
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                String fullHistory = " ";
                for (final String x : controller.getHistory()) {
                    fullHistory = fullHistory.concat(x + "\n");
                }
                tArea.setText(fullHistory);
                canvas.validate();
                innerCanvas.validate();
            } 
        });
    }

    /**
     * Start the program and set the size by picking data from system settings.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Is the main of application.
     * @param args the passed args for the main.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
