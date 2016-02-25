package com.nov.hotel.main;

import com.nov.hotel.gui.windows.AuthorWindow;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.util.ResourceBundle;

public class StartFrame extends JFrame{

    public void init() {
        JFrame frame = new JFrame("LogIn WindowInit");
        final JFXPanel panel = new JFXPanel();

        frame.setLocation(400,200);
        frame.add(panel);
        frame.setSize(400,240);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
 //               initFX(frame, panel);
               AuthorWindow.create(frame, panel);
            }
        });
    }

    private static void initFX(JFrame frame, JFXPanel panel) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(StartFrame.class.getResource("/fxml/author.fxml"));
        loader.setResources(ResourceBundle.getBundle("Locale"));
        try{
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add("/styles/styles.css");
            panel.setScene(scene);
        } catch (Exception e) {

        }

    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                show();
//            }
//        });
//    }

}

