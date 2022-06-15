import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.io.*;
//
public void initUI(){
    //Setting songName Label to center
    songName = new jLabel("We're go!", SwingConstants.CENTER);
  
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
    stop = new JButton(iconStop);



    //Setting Layout of playerpanel
    playerPanel.setLayout(new GridLayout(1, 4));
    
    //Addings comonentes in Controlpanel
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
    frame.setSize(600, 250);
    frame.setVisible(true);
    frame.Resizable(true);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void addActionEvents(){
    //registering action listener to buttons
    select.addActionListener(this);
    play.addActionListener(this);
    pause.addActionListener(this);
    resume.addActionListener(this);
    sto.addActionListener(this);
}
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(select)) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("/home/andrei"));
            fileChooser.setDialogTitle("Select Mp3");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));
            if (fileChooser.showOpenDialog(select) == JFileChooser.APPROVE_OPTION) {
                myFile = fileChooser.getSelectedFile();
                filename = fileChooser.getSelectedFile().getName();
                filePath = fileChooser.getSelectedFile().getPath();
                songName.setText("File Selected : " + filename);
            }
        }
        if (e.getSource().equals(play)) {
            //starting play thread
            if (filename != null) {
                playThread.start();
                songName.setText("Now playing : " + filename);
            } else {
                songName.setText("No File was selected!");
            }
        }
        if (e.getSource().equals(pause)) {
            //code for pause button
            if (player != null && filename != null) {
                try {
                    pauseLength = fileInputStream.available();
                    player.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        if (e.getSource().equals(resume)) {
            //starting resume thread
            if (filename != null) {
                resumeThread.start();
            } else {
                songName.setText("No File was selected!");
            }
        }
        if (e.getSource().equals(stop)) {
            //code for stop button
            if (player != null) {
                player.close();
                songName.setText("");
            }

        }

    }

    Runnable runnablePlay = new Runnable() {
        @Override
        public void run() {
            try {
                //code for play button
                fileInputStream = new FileInputStream(myFile);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                totalLength = fileInputStream.available();
                player.play();//starting music
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable runnableResume = new Runnable() {
        @Override
        public void run() {
            try {
                //code for resume button
                fileInputStream = new FileInputStream(myFile);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                fileInputStream.skip(totalLength - pauseLength);
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}