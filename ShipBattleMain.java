package ShipBattleGame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import ShipBattleGame.Area.Cell;

import java.util.Random;


public class ShipBattleMain extends Application {

    private boolean running = false;
    private Area rivalArea, playerArea;
    private int ShipOnArea = 5;
    private boolean  rivalTurn = false;
    private Random random = new Random();

    private Parent createContent(){
        BorderPane root = new BorderPane();
        root.setPrefSize(100,100);
        root.setRight(new Text("controls:" +
                "\nleft click mouse = horizontal" +
                "\nright click mouse = vertical"));


        rivalArea = new Area(true, event ->{
            if(!running)
                return;
            Cell cell = (Cell) event.getSource();
            if(cell.Shoted)
                return;

            rivalTurn = !cell.shoot();

            if(rivalArea.ship==0){
                System.out.println("wygrałeś");

            }
            if(rivalTurn)
                rivalMove();
        });

        playerArea = new Area(false, event-> {
            if(running)
                return;
            Cell cell  = (Cell) event.getSource();
            if (playerArea.placeShip(new Ships(ShipOnArea, event.getButton()==MouseButton.PRIMARY),cell.x, cell.y)) {
                if (--ShipOnArea == 0) {
                    startGame();
                }
            }
        });
        VBox vbox = new VBox(20,rivalArea,playerArea);
        vbox.setAlignment(Pos.CENTER);

        root.setCenter(vbox);
        return root;
    }

    private void rivalMove(){
        while (rivalTurn){
            int x = random.nextInt(15);
            int y = random.nextInt(15);

            Cell cell = playerArea.getCell(x,y);
            if(cell.Shoted)
                continue;
            rivalTurn = cell.shoot();

            if(playerArea.ship == 0){
                System.out.println("przegrałeś");
            }
        }
    }

    private  void startGame(){
        //
        int size = 5;

        while (size>0){
            int x = random.nextInt(15);
            int y = random.nextInt(15);

            if (rivalArea.placeShip(new Ships(size, Math.random()< 0.5),x,y)){
                size--;
            }
        }
        running = true;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(createContent());
        primaryStage.setTitle("SeaBattle");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
