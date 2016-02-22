package com.nov.hotel.main;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.util.ResourceBundle;

public class StartFrame extends JFrame{

    public void init() {
        JFrame frame = new JFrame("JavaFX in Swing");
        final JFXPanel panel = new JFXPanel();
        frame.add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(panel);
            }
        });
    }

    private static Scene createScene(){
        Group root = new Group();
        Scene scene = new Scene(root, Color.YELLOW);
        Button button = new Button("Hello World!");
        button.setLayoutX(50);
        button.setLayoutY(50);
        root.getChildren().add(button);

        return scene;
    }

    private static void initFX(JFXPanel panel) {
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

