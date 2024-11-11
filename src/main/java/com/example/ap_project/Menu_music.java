package com.example.ap_project;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Menu_music {

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    MediaPlayer mediaPlayer;



    public void stop() {
        mediaPlayer.stop();
    }

    public void Mediaplayer()  {
        String s = "src/main/resources/com/example/ap_project/home11.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }


}
