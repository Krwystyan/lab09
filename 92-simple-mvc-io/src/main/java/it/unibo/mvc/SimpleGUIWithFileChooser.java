package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Integer;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser{

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser(){
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField tArea = new JTextField(controller.getFilePath());
        final JButton browserButton = new JButton("Browser..");
        final JPanel innerCanvas =  new JPanel();
        final JButton savButton = new JButton("Save");
        innerCanvas.setLayout(new BorderLayout());
        innerCanvas.add(tArea, BorderLayout.CENTER);
        innerCanvas.add(browserButton, BorderLayout.LINE_END);
        canvas.add(innerCanvas, BorderLayout.NORTH);
        canvas.add(savButton, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browserButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent e){
                try {
                    final JFileChooser chooser = new JFileChooser();
                    int val = chooser.showSaveDialog(innerCanvas);
                    if(val == JFileChooser.APPROVE_OPTION){
                        controller.setFile(chooser.getSelectedFile());
                        tArea.setText(controller.getFilePath());
                    }
                    else if(val != JFileChooser.CANCEL_OPTION){
                        JOptionPane.showMessageDialog(browserButton, innerCanvas, "An error as occured", val);
                    }
                } finally {
                    canvas.validate();
                    innerCanvas.validate();
                }
            }
            
        });

        savButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try{
                    controller.writeAString(tArea.getText());
                } catch (NullPointerException | FileNotFoundException nullPointerException) {
                    JOptionPane.showMessageDialog(frame, nullPointerException, "Error", JOptionPane.ERROR_MESSAGE);
                    nullPointerException.printStackTrace();
                }
                
            }
        });

    }

    private void display() {
        
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        new SimpleGUIWithFileChooser().display();
    }

}
