package controller;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import dao.UserDao;
import factory.UserDaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import methode.MethodeAlert;
import model.User;
import javafx.scene.control.PasswordField;

public class RegisterUserController {
	
    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button Register;

    @FXML
    private Button login;
    
    static  Logger logger = Logger.getLogger(LoginController.class.getName());

    @FXML
    void login(ActionEvent event) {
    	try {
   		 Parent root =  FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
	         Scene  scene = new Scene(root);
	         Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
            page.setScene(scene);
            page.show();
            logger.info("Return � la page login");
		} catch(Exception e) {
			e.printStackTrace();
			logger.debug(e);
		}
    }

    @FXML
    void register(ActionEvent event) {
    	
    	User user=new User(firstname.getText(), lastname.getText(), email.getText(), BCrypt.hashpw(password.getText(), BCrypt.gensalt()));
    	UserDao userDAO=UserDaoFactory.getUserDAO("jdbc");
    	//call insert method by passing user object
    	int i= userDAO.inscription(user);
    	if (i==1) {
    		MethodeAlert methodeAlert =new MethodeAlert();
    		methodeAlert.afficherAlert("Information Dialog", "A �t� ajouter avec succ�s");
    		login(event);
            logger.info("A ete ajouter avec succee");

    		
		} else {
			MethodeAlert methodeAlert =new MethodeAlert();
    		methodeAlert.afficherAlert("Information Dialog", "Erreur d'ajout ");
    		logger.debug("Erreur d'ajout ");
		}
    }

}
