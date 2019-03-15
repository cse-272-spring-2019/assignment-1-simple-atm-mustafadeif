package atm;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM");        
        Login login = new Login(primaryStage);
        MainMenu menu = new MainMenu(primaryStage);
        Transaction trans = new Transaction(primaryStage);        
        login.prepareScene();
        menu.prepareScene();
        trans.prepareScene();        
        login.setMenu(menu);
        menu.setLogin(login);
        menu.setTrans(trans);
        trans.setMainMenu(menu);        
        primaryStage.setScene(login.getScene());
        primaryStage.show();
    }    
    public static void main(String[] args) {
        launch(args);
    }
    
}
