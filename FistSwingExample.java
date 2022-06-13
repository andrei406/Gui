import javax.swing.*;
public class FistSwingExample{
    public static void main(String[] args){
        JFrame f = new JFrame();
        JButton b = new JButton("Ok, you have did it");
        b.setBounds(130, 100, 300, 40);  // x asis y asis width heigh
        f.add(b);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
}