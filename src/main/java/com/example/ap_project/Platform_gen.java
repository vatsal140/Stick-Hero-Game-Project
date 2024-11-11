    package com.example.ap_project;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

    public class Platform_gen{
@FXML
public StackPane paneGO;
private  boolean CheatStart_cherry;
    private  boolean CheatStart_score;

private String cheat_cherry="cherry";
private String cheat_score="Score";
@FXML
public Button reviveButton;

@FXML
public Button MainmenuButton;


@FXML
public  Rectangle p1;
@FXML
public  Rectangle p2;
public characterfalls c = new characterfalls();

@FXML
public  Rectangle stick;
@FXML
public ImageView cherry;

@FXML
public Label score;

@FXML
public Label high_score;

@FXML
public Label cherries;

@FXML
public ImageView ichigo;

private boolean cherry_collected=false;


private boolean spaceReleaseCount=true;
private boolean Stick_stop=true;
    private boolean rotate_called=false;
private static Cherries cherry_details;

    public Cherries getCherry_details() {
        return cherry_details;
    }

    private final Random random = new Random();

    public Platform_gen() {
    }


    public void collectCherryLogic(){
        if(!cherry_collected){
        if(ichigo.getTranslateX()+26> cherry_details.getX_coordinate()& ichigo.getTranslateX()<(cherry_details.getX_coordinate()+11)&ichigo.getRotate()==180) {
//            this.cherries.setText( (cherries.getText())+1);
            HelloApplication.game.getSave().setCherries(HelloApplication.game.getSave().getCherries() + 1);
            cherry.setTranslateX(1000);
cherry_collected=true;

        }
        }
if(ichigo.getRotate()==180){        fallLogicFlipped();}


    }
  static   TranslateTransition transition_ichigo;



    Timeline timeline;
public void move(){

transition_ichigo= new TranslateTransition(Duration.seconds(3), ichigo);

    transition_ichigo.setToX(stick.getHeight()+p1.getWidth()-ichigo.getFitWidth());

        transition_ichigo.play();
     timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
       collectCherryLogic();

    }));
    timeline.setCycleCount(Timeline.INDEFINITE); // Run indefinitely
    timeline.play();

    transition_ichigo.setOnFinished((event) -> {
        fallLogic();
if(ichigo.getRotate()!=180& fallLogic()==1){
    next_level();
}
        timeline.stop();

    });


}

public void saveFile() throws IOException {
    ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("Save"));
    output.writeObject(HelloApplication.game.getSave());
    output.close();
}

///CHEAT CODE
        private static Stack<String> stack = new Stack<>();
        private static Map<Character, String> flyweightMap = new HashMap<>();

        public static boolean detectCherry(String inputChar,String spell) {
            String flyweightChar = getFlyweight(inputChar.charAt(0));

            stack.push(flyweightChar);

//            System.out.println(stack.toString());
            if (stack.size() >= spell.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < spell.length(); i++) {
                    sb.append(stack.get(stack.size() - spell.length() + i));
                }
                String lastSixChars = sb.toString();

                return lastSixChars.equals(spell);
            }

            return false;
        }

        private static String getFlyweight(char c) {
            if (!flyweightMap.containsKey(c)) {
                flyweightMap.put(c, String.valueOf(c));
            }
            return flyweightMap.get(c);
        }


        private static Stack<String> stack2 = new Stack<>();
        private static Map<Character, String> flyweightMap2 = new HashMap<>();

        public static boolean detectScore(String inputChar,String spell) {
            String flyweightChar = getFlyweight2(inputChar.charAt(0));

            stack2.push(flyweightChar);

            if (stack2.size() >= spell.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < spell.length(); i++) {
                    sb.append(stack2.get(stack2.size() - spell.length() + i));
                }
                String lastSixChars = sb.toString();

                return lastSixChars.equals(spell);
            }

            return false;
        }

        private static String getFlyweight2(char c) {
            if (!flyweightMap.containsKey(c)) {
                flyweightMap.put(c, String.valueOf(c));
            }
            return flyweightMap.get(c);
        }





        @FXML
public void stick_grow(KeyEvent event)   {

    if(event.getCode()==KeyCode.C){
        CheatStart_cherry=true;

    }
    if(event.getCode()==KeyCode.S){
        CheatStart_score=true;
    }


            if(detectScore(event.getCode().toString(),"SCORE")){
                System.out.println("CHEAT DETECTED");
                HelloApplication.game.getSave().setScore(HelloApplication.game.getSave().getScore()+10);
                score.setText(String.valueOf( HelloApplication.game.getSave().getScore()));
                if(HelloApplication.game.getHighscore()<HelloApplication.game.getSave().getScore()){
                    HelloApplication.game.setHighscore(HelloApplication.game.getSave().getScore());
                    high_score.setText(String.valueOf(HelloApplication.game.getHighscore()));
                }

            }


        if(detectCherry(event.getCode().toString(),"CHERRY")){
            System.out.println("CHEAT DETECTED");
            HelloApplication.game.getSave().setCherries(HelloApplication.game.getSave().getCherries()+10);
            cherries.setText(String.valueOf( HelloApplication.game.getSave().getCherries()));

    }


//    System.out.println(event.getCode());
    if(event.getCode()==KeyCode.CAPS){
        System.out.println("Game saved");
        HelloApplication.game.setSave(new Save( new Level((int) p1.getTranslateX(), (int) p1.getWidth(), (int) p2.getTranslateX(), (int) p2.getWidth(),getCherry_details()),HelloApplication.game.getSave().getScore(),HelloApplication.game.getSave().getCherries()));
                HelloApplication.game.getSave().setHighscore(HelloApplication.game.getHighscore());
        try {
            saveFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    if (event.getCode() == KeyCode.A & Stick_stop) {

            stick.setHeight(stick.getHeight()+ 10);

    }

}
@FXML
public void init_keyaction(){

    cherry_collected=false ;
    Stick_stop=true;
    spaceReleaseCount=true;
    rotate_called=false;

    HelloApplication.Play.setOnKeyPressed(this::stick_grow);
        HelloApplication.Play.setOnKeyReleased(this::stickStopOnKeyRelease);
        HelloApplication.Play.setOnMouseClicked(this::flip);
    }
public void stickStopOnKeyRelease(KeyEvent event){
    System.out.println(event.getCode().toString());
    if(event.getCode()==KeyCode.A & spaceReleaseCount){
        Stick_stop=false;
        spaceReleaseCount=false;


            rotate();}

}

public void rotate(){

        if(!rotate_called) {

//            double width = stick.getWidth();
//            stick.setWidth(stick.getHeight());
//            stick.setHeight(width);

            Rotate rotate = new Rotate(0, 0, stick.getHeight()); // Angle, pivotX, pivotY
            stick.getTransforms().add(rotate);

            // Create a Timeline to animate the rotation
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(rotate.angleProperty(), 90))
            );

            timeline.setCycleCount(1); // Rotate only once
            timeline.setOnFinished(e -> move());
            timeline.play();

        }




}

public void fall(int scaleY){
    timeline.stop();
    System.out.println("FALL USED");
    HelloApplication.p.stop();
    c.Mediaplayer();
    c.getMediaPlayer().setStopTime(Duration.seconds(4));

    TranslateTransition transition = new TranslateTransition(Duration.seconds(1), ichigo);
    ichigo.setScaleY(scaleY);
    transition.setToY(300-ichigo.getTranslateY());

    transition.play();
    transition.setOnFinished(event->{
//        HelloApplication.c.getMediaPlayer().stop();
                try {
                          HelloApplication.game.Game_over();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
    );
}


public void fallLogicFlipped(){
    if(ichigo.getTranslateX()+26>=p2.getTranslateX()){
//        timeline.stop();

        transition_ichigo.stop();

        fall(1);
    }

}

public int fallLogic(){
    if(stick.getHeight()<p2.getTranslateX()-125 | stick.getHeight()+125>p2.getTranslateX()+p2.getWidth()){

        fall(-1);

return  0;


    }
    return 1;


}

public void next_level(){
    CheatStart_score=false;

    cherry_collected=false ;
    Stick_stop=true;
    spaceReleaseCount=true;
    rotate_called=false;
    HelloApplication.game.updateScore();
    HelloApplication.game.Next_level();
    score_update();
}

public void score_update(){

        if(HelloApplication.game.getSave().getScore()+1>HelloApplication.game.getHighscore()){
            HelloApplication.game.setHighscore(HelloApplication.game.getSave().getScore()+1);
            HelloApplication.game.getSave().setHighscore(HelloApplication.game.getHighscore());
        }

        HelloApplication.game.getSave().setScore(HelloApplication.game.getSave().getScore()+1);
//    HelloApplication.game.getSave().setScore(HelloApplication.game.getSave().getScore()+1);
    this.score.setText(String.valueOf((HelloApplication.game.getSave().getScore())));
    this.cherries.setText(String.valueOf(HelloApplication.game.getSave().getCherries()));
    this.high_score.setText(String.valueOf(HelloApplication.game.getHighscore()));
    }


@FXML
public void flip(MouseEvent event){
        if(ichigo.getTranslateX()>125&ichigo.getTranslateX()<p2.getTranslateX() ) {
            if (ichigo.getRotate() == 0) {

                ichigo.setScaleX(-1);
                ichigo.setRotate(180);
                ichigo.setTranslateY(ichigo.getTranslateY()  + ichigo.getFitHeight());

            } else {
                ichigo.setScaleX(1);
                ichigo.setRotate(0);
                ichigo.setTranslateY(ichigo.getTranslateY()  - ichigo.getFitHeight());

            }
        }


}

public void transitPillars(int y,int ichigo_coords){
    ichigo.setTranslateY(-261);

    TranslateTransition transition = new TranslateTransition(Duration.seconds(0.4), p1);

    p1.setTranslateX(ichigo_coords);
    p2.setTranslateX(700);
    ichigo.setTranslateX(ichigo_coords);
    transition.setToX(0);



    TranslateTransition transition2 = new TranslateTransition(Duration.seconds(0.4), p2);
    transition2.setToX(y);



    TranslateTransition ichigo_transition = new TranslateTransition(Duration.seconds(0.4), ichigo);
    ichigo_transition.setToX(0);
    ichigo_transition.play();
    transition.play();

    transition2.play();




}

@FXML
public void Revive(MouseEvent event){
if(HelloApplication.game.getSave().getCherries()<5){
    Label reviveFail=new Label();
    reviveFail.setText("Insufficient cherries");
    reviveFail.setTranslateX(-100);
    reviveFail.setTranslateY(-80);
    paneGO.getChildren().add(reviveFail);

}
else {
    HelloApplication.game.setSave(new Save( new Level((int) p1.getTranslateX(), (int) p1.getWidth(), (int) p2.getTranslateX(), (int) p2.getWidth(),getCherry_details()),HelloApplication.game.getSave().getScore(),HelloApplication.game.getSave().getCherries()));
HelloApplication.game.getSave().setCherries (HelloApplication.game.getSave().getCherries()-5);
    generate_level(HelloApplication.game.getSave());
paneGO.setTranslateX(900);
}



}

@FXML
public void Mainmenu(MouseEvent event){

HelloApplication.primary.setScene(HelloApplication.Main_menu);
paneGO.setTranslateX(900);

HelloApplication.test.Mediaplayer();
}



@FXML
public void initialize(){
    CheatStart_cherry=false;
    CheatStart_score=false;

    paneGO.setTranslateX(900);

    ichigo.setScaleX(1);
ichigo.setScaleY(1);


//    ichigo.getTransforms().clear();

    ichigo.setTranslateY(-261);


    stick.getTransforms().clear();




ichigo.setRotate(0);

    int p2_width=random.nextInt(300)+10;
    int p2_translate= (int) (random.nextInt(300)+p1.getWidth()+20);
    transitPillars(p2_translate, (int) ichigo.getTranslateX());

    cherry_details=new Cherries(125, (int) (p2_translate-9));
    cherry.setTranslateX(cherry_details.getX_coordinate());

stick.setWidth(0.4);
stick.setTranslateX(125);
stick.setHeight(0);


//    this.p2=new Rectangle(p1.getWidth(),263,random.nextInt((int) p1.getWidth())+(random.nextInt(300))+10,263);
p2.setWidth(p2_width);
//p2.setTranslateX(p2_translate);
//    p1.setX(100);






}


public void go_PANEL(){
    paneGO.setTranslateX(0);

}




@FXML
public void generate_level(Save save){
    CheatStart_score=false;

    CheatStart_cherry=false;
    ichigo.setScaleX(1);
    ichigo.setScaleY(1);
    cherry_collected=false ;
    Stick_stop=true;
    stick.setWidth(0.4);
    stick.setTranslateX(125);
    stick.setHeight(0);

    spaceReleaseCount=true;
    rotate_called=false;
System.out.println(save.getLevel());
    paneGO.setTranslateX(900);

    ichigo.setScaleX(1);
    ichigo.setScaleY(1);

ichigo.setTranslateX(0);
//    ichigo.getTransforms().clear();

    ichigo.setTranslateY(-261);


    stick.getTransforms().clear();




    ichigo.setRotate(0);
this.high_score.setText(String.valueOf(HelloApplication.game.getHighscore()));
        p2.setWidth(save.getLevel().getP2().getWidth());
p2.setTranslateX(save.getLevel().getP2().getX_coord());
cherry.setTranslateX(save.getLevel().cherry.getX_coordinate());
this.score.setText(String.valueOf(save.getScore()));
this.cherries.setText(String.valueOf(save.getCherries()));
    }






}
