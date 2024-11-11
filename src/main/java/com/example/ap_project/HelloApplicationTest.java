package com.example.ap_project;
import org.junit.Before;
import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.*;

public class HelloApplicationTest {




    @Before
    private Save loadSaveFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Save"))) {
            return (Save) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testLoadSaveFile() {
        // Load the Save object from the serialized file
        Save loadedSave = loadSaveFile();

        // Assert that the loaded Save object is not null
        assertNotNull(loadedSave,"Loaded Save object is null");

        // Assert that the Highscore in the loaded Save object is not null
        assertNotNull( loadedSave.getHighscore(),"Highscore is null");

        // Additional assertions can be added based on your requirements
        // For example, you can check if the loaded Highscore matches the expected value
    }






    @Test
    public void testThreadStart() {
        assertNotNull(HelloApplication.t1, "Threadstart should be initialized");
    }

    @Test
    public void testPingInitialization() {
        assertNotNull(HelloApplication.t2, "Ping should be initialized");
    }

    @Test
    public void testmenu_start() {
        assertNotNull(HelloApplication.test, "Menu_music should be initialized");
    }

    @Test
    public void testplaymusic() {
        assertNotNull(HelloApplication.p, "Music should be initialized");
    }


}
