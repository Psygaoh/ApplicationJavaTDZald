import Application.Devinette;
import Application.HelloWorld;
import GUI.UserWindows;

import javax.swing.*;

public class main {
    public static void main(String[] args) {

      //  Devinette devinette = new Devinette();
      //  devinette.comparer();

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                UserWindows userWindows = new UserWindows();
            }
        });


    }
}
