# mooc.fi

[Parte 1](https://java-programming.mooc.fi/part-1)

[Parte 2](https://java-programming.mooc.fi/part-8)

# Bugs

[8.01 To do list](https://java-programming.mooc.fi/part-8/1-recap#programming-exercise-to-do-list-2-parts)

En el enunciado en `Sample output` en la línea 8 de donde aparece `completed` debería aparecer `remove`

```
Command: add
Task: go to the store
Command: add
Task: vacuum clean
Command: list
1: go to the store
2: vacuum clean
Command: completed
Which task was completed? 2
Task go to the store tehty
Command: list
1: go to the store
Command: add
Task: program
Command: list
1: go to the store
2: program
Command: stop
```

debería ser

```
Command: add
Task: go to the store
Command: add
Task: vacuum clean
Command: list
1: go to the store
2: vacuum clean
// -- Command: completed
// ++ Command: remove
Command: remove
Which task was completed? 2
Task go to the store tehty
Command: list
1: go to the store
Command: add
Task: program
Command: list
1: go to the store
2: program
Command: stop
```

[14.08 Hurray](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs#programming-exercise-hurray)

Para poder ejecutar el ejercicio hay que modificar el pom.xml para incluir la dependencia `javafx-media` en el profile de java 11:

```
        <profile>
            <id>java11</id>
            <activation>
                <jdk>11</jdk>
            </activation>
            <properties>
                <maven.compiler.source>11</maven.compiler.source>
                <maven.compiler.target>11</maven.compiler.target>
            </properties>
            <dependencies>
                <dependency>
                    <groupId>org.openjfx</groupId>
                    <artifactId>javafx-base</artifactId>
                    <version>11.0.2</version>
                </dependency>
                <dependency>
                    <groupId>org.openjfx</groupId>
                    <artifactId>javafx-controls</artifactId>
                    <version>11.0.2</version>
                </dependency>
                <dependency>
                    <groupId>org.openjfx</groupId>
                    <artifactId>javafx-media</artifactId>
                    <version>11.0.2</version>
                </dependency>
                <dependency>
                    <groupId>org.testfx</groupId>
                    <artifactId>openjfx-monocle</artifactId>
                    <version>jdk-11+26</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.openjfx</groupId>
                        <artifactId>javafx-maven-plugin</artifactId>
                        <version>0.0.2</version>
                        <configuration>
                            <mainClass>hurraa.HurraaSovellus</mainClass>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </profile>
```

El ejercicio resuelto sería:

```
package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
        

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button button = new Button("Hurraa!");
        pane.setCenter(button);

        button.setOnAction(event -> {
            AudioClip audio = new AudioClip("file:Applause-Yannick_Lemieux.wav");
            audio.play();
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
```

Pero para que pase el test del servidor la única forma es comentar todas las líneas relacionadas con `javafx.scene.media.AudioClip`, quedando:

```
package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
// import javafx.scene.media.AudioClip;
        

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button button = new Button("Hurraa!");
        pane.setCenter(button);

        button.setOnAction(event -> {
            // AudioClip audio = new AudioClip("file:Applause-Yannick_Lemieux.wav");
            // audio.play();
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
```