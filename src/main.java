import Application.HelloWorld;
import GUI.UserWindows;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                UserWindows userWindows = new UserWindows();
            }
        });


    }
}
