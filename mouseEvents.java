import java.awt.*;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

//import org.w3c.dom.events.MouseEvent;

//import java.awt.*;
//qimport java.awt.event.*;
public class mouseEvents extends selectableButton {
    //Define MouseListener
    MouseListener mouseListener = new MouseAdapter(){
        public void mousePressed(MouseEvent mouseEvent){
            int modifiers = mouseEvent.getModifiers();
            if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON2_MASK){
                System.out.println("Middle button pressed");
            }
            public void mouseReleased(MouseEvent mouseEvent){
                if (SwingUtilities.isMiddleMouseButton(mouseEvent)){
                    System.out.println("Middle button released");
                }
            };
            
        } 
      
    }
}

