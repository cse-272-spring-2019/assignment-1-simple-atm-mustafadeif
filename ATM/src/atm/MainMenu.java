package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainMenu {
    
    Stage stage;
    Logic logic;
    Scene scene;
    Login login;
    Transaction trans;
    
    public MainMenu(Stage stage){
        this.stage = stage;
    }

    public void prepareScene() {
        logic = new Logic();
        Button trans1 = new Button("Transaction");
        Button next = new Button("Next");
        Button prev = new Button("Previous");
        Button current = new Button("Current balance");
        Label label = new Label();
        GridPane grid = new GridPane();
        grid.add(label,1,2);
        grid.add(trans1,0,0);
        grid.add(current,2,0);
        grid.add(next,1,1);
        grid.add(prev,0,1);
        current.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                double y = logic.Balance;
                label.setText("" + y);
            }
        });        
        prev.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) 
            {
                if(logic.ptr==0||logic.count-logic.ptr>5)
                {
                    label.setText("Sorry can't do that command");
                }
                else
                {
                    label.setText(logic.prev());
                }
            }
        });        
        next.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) 
            {
                if(logic.ptr>=logic.count||logic.count-logic.ptr>6)
                {
                    label.setText("Sorry can't do that command");
                }
                else
                {
                    label.setText(logic.next());
                }
            }
        });
        trans1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(trans.getScene());
            }
        });     
        scene = new Scene(grid,500,250);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setTrans(Transaction trans) {
        this.trans = trans;
    }
    

    public void setAtmLogic(Logic logic) {
        this.logic = logic;
    }
    
    
}
   
