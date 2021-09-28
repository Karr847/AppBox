package simple3dbox;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Simple3DBoxApp extends Application {
    public Parent createContent() throws Exception {
        //Box.
        Box testBox = new Box (5, 5, 5);
        testBox.setMaterial (new PhongMaterial (Color.RED));
        testBox.setDrawMode (DrawMode.LINE);
        //create and position camera.
        PerspectiveCamera camera = new PerspectiveCamera (true);
        camera.getTransforms ( ).addAll (
                new Rotate (-20, Rotate.Y_AXIS),
                new Rotate (-20, Rotate.X_AXIS),
                new Rotate (0, 0, -15));
        //Build the scene graph
        Group root = new Group ( );
        root.getChildren ( ).add (camera);
        root.getChildren ( ).add (testBox);
        //Use SubScene.
        SubScene subScene = new SubScene (root, 300, 300);
        subScene.setFill (Color.ALICEBLUE);
        subScene.setCamera (camera);
        Group group = new Group ( );
        group.getChildren ( ).add (subScene);
        return group;


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable (false);
        Scene scene = new Scene (createContent ( ));
        primaryStage.setScene (scene);
        primaryStage.show ( );
    }

    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch ( );
    }

}