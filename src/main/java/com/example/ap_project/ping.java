package com.example.ap_project;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class ping extends Thread {

    MediaPlayer mediaPlayer;
    public void run()  {
        String s = "src/main/resources/com/example/ap_project/ping.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();

    }

}