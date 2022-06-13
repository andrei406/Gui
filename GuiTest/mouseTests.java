package GuiTest;
import java.awt.*;
import javax.swing.*;
import org.w3c.dom.events.Event;


import java.awt.event.*;
public class mouseTests {
    //Define MouseListener
    public static void main(String args[]){
        Runnable runner = new Runnable(){
            public void run(){
                JFrame frame = new JFrame("Mouse Clicks");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton button = new JButton("Click here");
            
            ActionListener actionListener = new ActionListener(){
                public void actionPerformed(ActionEvent actionEvent){
                    System.out.println("Detected mouse");
                }
            };
            
        MouseListener mouseListener = new MouseAdapter(){
            public void mousePressed(MouseEvent mouseEvent){
                int modifiers = mouseEvent.getModifiers();
                Object frame;
                if ((frame.modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON2_MASK){
                    System.out.println("Middle button pressed");
                }
            }
            public void mouseReleased(MouseEvent mouseEvent){
                    if (SwingUtilities.isMiddleMouseButton(mouseEvent)){
                        System.out.println("Middle button released");
                    }
            };
            button.addActionListener(actionListener);
            button.addActionListener(mouseListener);e.add(button,BorderLayout.SOUTH);
            frame.setSize(300,300);
            frame.setVisible(true);
            }
    };
    EventQueue.invokeLater(runner);
    }
}

