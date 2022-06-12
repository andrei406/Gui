package GuiTest;
import javax.swing.*;

import org.w3c.dom.events.Event;

import java.awt.*;
import java.awt.event.*;
public class selectableButton {
    public static void main(String args[]){
        Runnable runner = new Runnable() {
            public void run(){
                // p P
                JFrame frame = new JFrame("Button Sample");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton button = new JButton("Select me");
            
                // Define ActionListener
                ActionListener actionListener = new ActionListener(){
                    public void actionPerformed(ActionEvent actionEvent){
                        System.out.println("I was selected");
                    }
                };
                //Attach listeners
                button.addActionListener(actionListener);
                frame.add(button, BorderLayout.SOUTH);
                frame.setSize(300, 300);
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(runner);
    }
}
