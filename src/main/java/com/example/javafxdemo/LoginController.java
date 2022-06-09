package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController {

    public TextField userName;
    public PasswordField passWord;

    public void loginButtonClicked() throws IOException {
        String userNameText = userName.getText();
        String passWordText = passWord.getText();

        if("admin".equals(userNameText) && "admin".equals(passWordText)){
            openMainWindow();
        } else {
            alertLoginFail();
        }

    }

    private void alertLoginFail() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("用户或者密码不正确!");
        alert.showAndWait();
    }

    private void openMainWindow() throws IOException {
        Stage mainStage = new Stage();
        mainStage.setScene(new Scene(JavaFxDemoApplication.loadFxml("/view/main.fxml").load()));
        mainStage.show();
        Window window = userName.getScene().getWindow();
        if(window instanceof Stage){
            ((Stage) window).close();
        }


    }
}
