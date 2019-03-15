package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Transaction {
    
    Stage stage;
    Logic logic;
    Scene scene;
    MainMenu menu;
    
    public Transaction(Stage stage){
        this.stage = stage;
    }
    public void prepareScene() {
        logic = new Logic();
        Label amount = new Label("Amount ");
        Label label = new Label();
        Button with = new Button("Withdraw");
        Button dep = new Button("Deposit");
        Button back = new Button("Back");
        TextField text = new TextField();
        GridPane grid = new GridPane();
        grid.add(amount, 0, 0);
        grid.add(label, 1, 2);
        grid.add(text, 1, 0);
        grid.add(with, 1, 1);
        grid.add(dep,0,1);
        grid.add(back,0,2);
        back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(menu.getScene());
            }
        });
        dep.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String value = text.getText();
                double value2 = Double.parseDouble(value);
                logic.deposite(value2);
                label.setText("Transaction successful");
            }
        });        
        with.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String value = text.getText();
                double value2 = Double.parseDouble(value);
                if(value2>Logic.Balance)
                {
                    label.setText("You don't have enough money for that transaction");
                }
                else
                {
                    logic.withdraw(value2);
                    label.setText("Transaction successful");
                }                
                
            }
        });
        
        scene = new Scene(grid,450,300);
    }

    public Scene getScene() {
        return scene;
    }

    public void setAtmLogic(Logic logic) {
        this.logic = logic;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setMainMenu(MainMenu menu) {
        this.menu = menu;
    }
    
}

