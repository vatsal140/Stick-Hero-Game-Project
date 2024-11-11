# Stick-Hero-Game-Project

Engineered a precise Java-based PC adaptation of the popular "Stick Hero" game.
Designed and implemented core game mechanics, integrating custom features that enhanced the UX.
Employed OOP methodologies to instantiate game objects and orchestrate their interactions through encapsulation, inheritance, and polymorphism.

ReadMe file:

Game Features:

    -> Sound - Game contains background music and sound when the character falls
    -> Character flips- Mouse click flips the character , implemented on a keyframe
    -> Cherry collection - Cherries are generated to be collected by getting upside down (Sometimes there might be a mismatch between the pooling rate of detection and the coordinates of our character )
    -> Menu - Two differernt scenes implemented using FXML which can be interswitched as per the context 
    -> Block Generation - Different width blocks are generated
    -> Block Transition - Blocks transit on set of the next level
    -> Stick Generation - Hold keyboard character 'A' to generate stick , release it to make the stick fall , we have used rotate transition for this function 
    -> Character falls when stick arches over or lands short of the block, or when the character collides upside down with the block
    -> The character translates untile it falls
    -> 5 cherries can help the character revive, an option that appears after character falls
    -> Saving the Game - CAPSLOCK can help the game save
    -> Saved game can be opened back in Load section on main screen
    -> High Score - Highest score by user is displayed on screen
    -> Current Score - Always displayed, when the game progresses
    -> Current cherry count - Displayed as a Label on the Play and game over screen.
    -> Various graphical elements are included like BG Image, Character image,cherry image, Rectangles etc 
Implemented Logic:

    -> Design Patterns:
        -> Singleton is used for single character instance generation 
        -> Flyweight is helping for cheat  detection as the rate of input pooling is very high 

    -> Threading:
        -> used to put the songs on a thread to efficiently control songs with the javafx thread.
    
    -> JUnit:
        -> We have used JUnit testing to see if both the the threads are initialized, and also both the music pieces that are used are initialized it it
        -> We have also tested if in the game file, high score is null, or if game is saved
        -> {To run the JUnit testing, run the HelloApplicationTest class separately by clicking on the play button which is located on the left of the class name   }
        -> The tests pass as thought
    
    -> Error handling:
        ->For various functions to catch null pointers/ IO errors throughout the code
	
-> All the required resources like images,fxml,music etc can be found in the Resources folder 
-> Copyrights have been respected 		
BONUS:

-> Cheat codes(can be entered at any time inside the play game screen) -    When a user types SCORE, their score increases by count of 10 
    When a user types CHERRY, their cherries increases by count of 10
-> Multithreading used as mentioned above.
Navigation:

-> Main screen initiates-> Play or Load -> PLAY CONTROL -> game over -> Revive(LOOPS PLAY CONTROL ) | MAIN MENU ( LOOPS Play or Load ) 
-> Caps/Cheats works at any point in the game without using any specific pause screen 
Note: While implementing threading and junit we found some incompatibility between javafx thread and our custom threads also the same goes for the junit as it must continously call the fxml loader files therefore we have tried to implement only those concepts which were covered as part of the course

Please ADD THE REQUIRED IMPORTS/Junits to the class path before running the code
