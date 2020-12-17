package Session9;
import Session9.gui.CFrame;
import javax.swing.*;

/**
 * A class to drive program.
 *
 * @author Mohammadreza Shahrestani
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        CFrame frame = new CFrame(" All notes");
        frame.setVisible(true);
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}