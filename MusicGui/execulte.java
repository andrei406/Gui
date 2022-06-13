import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
public void initUI(){
    //Setting songName Label to center
    songName = new jLabel("", SwingConstants.CENTER);

    //Creating button for selecting a song
    select = new JButton("Select");

    //Creating Pannels
    playerPanel = new JPane1(); //Music Selection Panel
    controlPanel = new JPane1(); //Control Selection Panel

    //Creating icons for buttons
    iconPlay = new ImageICon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/play-button.png");
    iconPause = new ImageICon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/pause-button.png");
    iconResume = new ImageIcon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/resume-button.png");
    iconSto = new ImageICon("/home/Andrei/Outros/Estudos de Programação/Desenvolvimento de Software/Gui/MusicGui/lib/music-player-java-code/DataFlair-Mp3MusicPlayer/music-player-icons/sto-button.pnj");

    //Creating image buttons
    play = new JButton(iconPlay);
    pause = new JButton(iconPause);
    resume = new JButton(inconResume);



    //Setting Layout of playerpanel
    playerPanel.setLayout(new GridLayout(1, 4));
    
    //Addings comonentes in Controlpanel
    playerPanel.add(select);
    playerPanel.add(pause);
    playerPanel.add(resume);
    playerPanel.add(stop);

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
    frame.Resizable(true;);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



}