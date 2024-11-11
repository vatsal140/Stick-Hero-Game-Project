package com.example.ap_project;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class Stage_Controller  {

    @FXML
    public  Label highscore;


    @FXML
    public Button Load;
    @FXML
    public Button launch_game;

    @FXML
    public void launch_game(MouseEvent event) throws IOException, InterruptedException {
Load.setText("LOAD");
HelloApplication.game.setSave(new Save(new Level(),0,0));
HelloApplication.controller.high_score.setText(String.valueOf(HelloApplication.game.getHighscore()));
HelloApplication.controller.cherries.setText(String.valueOf(0));
HelloApplication.controller.score.setText(String.valueOf(0));
        HelloApplication.test.stop();
        HelloApplication.p.Mediaplayer();
        String flag = "ss";

        HelloApplication.primary.setScene(HelloApplication.Play);
        HelloApplication.controller.initialize();
        HelloApplication.controller.init_keyaction();
//       HelloApplication. controller.score_update();

    }

    @FXML
        public void load_game(MouseEvent event) {
        HelloApplication.test.stop();
        HelloApplication.p.Mediaplayer();
        String flag = "ss";

        Save save = null;
        try {
            save = HelloApplication.game.getSave();

        } catch (NullPointerException e) {
            Load.setText("NO LOAD FOUND");
            return;
        }
        HelloApplication.controller.init_keyaction();

//        HelloApplication.controller.initialize();
        HelloApplication.controller.generate_level(save);
        HelloApplication.primary.setScene(HelloApplication.Play);


    }
}
