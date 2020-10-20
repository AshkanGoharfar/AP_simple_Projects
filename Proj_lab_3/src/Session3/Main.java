package Session3;

import Session3.music_organizer.MusicCollection;
import Session3.music_organizer.MusicObj;
import Session3.clock_display.ClockDisplay;

public class Main {
    public static void main(String[] args) {
        // write your code here
        
        // Test Clock Display Object
        ClockDisplay clock = new ClockDisplay(0,0,0);
        clock.timeTick();
        clock.timeTick();
        clock.timeTick();
        clock.timeTick();
        clock.setTime(1,2,3);

        // test Music Collection Object
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        MusicCollection rap = new MusicCollection();


        MusicObj eminem = new MusicObj("Beautiful", "Eminem", "2003");
        MusicObj fiftyCent = new MusicObj("Candy Shop", "50cent", "2001");
        MusicObj drDre = new MusicObj("Still D.R.E", "Dr. Dre", "1999");

        rap.addFile(eminem);
        rap.addFile(fiftyCent);
        rap.removeFile(1);
        rap.addFile(drDre);
        rap.startPlaying(0);
        rap.listAllFiles();
    }
}

