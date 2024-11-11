package com.example.ap_project;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class characterfalls {

  private   MediaPlayer mediaPlayer;
    public void Mediaplayer()  {
        String s = "src/main/resources/com/example/ap_project/home3.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void stopmusic() {
        mediaPlayer.stop();
    }
}