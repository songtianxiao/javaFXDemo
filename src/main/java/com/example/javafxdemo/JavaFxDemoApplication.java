package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaFxDemoApplication extends Application {

    private static ApplicationContext applicationContext;

    public static FXMLLoader loadFxml(String fxmlPath){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(JavaFxDemoApplication.class.getResource(fxmlPath));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader;
    }


    public static void main(String[] args) {
        applicationContext = SpringApplication.run(JavaFxDemoApplication.class, args);
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(loadFxml("/view/login.fxml").load()));
        primaryStage.show();
    }
}
