package MusicGui;
import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.lang.reflect.Method;
//

public void initUI(){
    //Setting songName Label to center
    songName = new JLabel("Rythbox", SwingConstants.CENTER);

    //Creating button for selecting a song
    select = new JButton("Select");

    //Creating Pannels
    playerPanel = new JPanel(); //Music Selection Panel            
    controlPanel = new JPanel(); //Control Selection Panel

    //Creating icons for buttons
    iconPlay = new ImageIcon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/play-button.png");
    iconPause = new ImageIcon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/pause-button.png");            iconResume = new ImageIcon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/resume-button.png");
    iconStop = new ImageIcon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/stop-button.pnj");

    //Creating image buttons
    play = new JButton(iconPlay);
    pause = new JButton(iconPause);
    resume = new JButton(iconResume);



    //Setting Layout of playerpanel
    playerPanel.setLayout(new GridLayout(1, 4));
            
    //Addings comonentes in Controlpanel
    controlPanel.add(select);
    controlPanel.add(pause);
    controlPanel.add(resume);
    controlPanel.add(stop);

    //Setting button Background color
    play.setBackground(Color.RED);
    stop.setBackground(Color.RED);
    resume.setBackground(Color.RED);
    pause.setBackground(Color.RED);

    //Intialing the frame
    frame = new JFrame();

    //Seting Frame's Tittle
    frame.setTittle("Rhytm internal");

    //Adding panels in Frame
    frame.add(playerPanel, BorderLayout.NORTH);
    frame.add(controlPanel, BorderLayout.SOUTH);

    //setting Frame background color
    frame.setBackground(Color.BLUE);
    frame.setSize(400, 200);
    frame.setVisible(true);
    frame.Resizable(true);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void addActionEvents(){
        
    //registering actions listener to buttons
    select.addActionListener(this);
    play.addActionListener(this);
    pause.addActionListener(this);
    resume.addActionListener(this);
    stop.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e){
    if (e.getSource().equals(select)){
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("/home/andrei/Music"));
        fileChooser.setDialogTitle("Where stay your music?");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 Files", "mp3"));
        if (fileChooser.showOpenD(select) == JFileChooser.APPROVE_OPTION){
            myFile = fileChooser.getSelectedFile();
            fileName = fileChooser.getSelectedFile().getName();
            filePath = fileChooser.getSelectedFile().getPath();
            songName.setText("Music Selected" + filename);
        }

    }
    if (e.getSource().equals(play)){
        //starting play thread
        if (filename != null){
            playThread.start();
            songName.setText("Now playing: " + filename);

        }else{
            songName.setText("Not file was selected!");
        }

    }
    if (e.getSource().equals(pause)){
        //code for pause button
        if (player != null && filename != null){
            try{
                pauseLength = FileInputStream.available();
                player.close();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }
    if (e.getSource().equals(resume)){
        //Starting resume thread
        if (filename != null){
            resumeThread.start();

        }else{
            songName.setText("No filse was selected!");
        }
    }
    if (e.getSource().equals(stop)){
        //code for sto button
        if (player != null){
            player.close();
            songName.setText("");
        }
    }
}   
//p P
Runnable runnablePlay = new Runnable() {
    @Override
    public void run(){
        try{
            //code for resume button
            fileInputStream = new FileInputStream(myFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            player = new Player(bufferedInputStream);
            fileInputStream.ski(totalLength = pauseLength);
            player.play();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
};
public static void main(String args[]) {
    MusicPlayer mp = new MusicPlayer();
            
}
}

