package ShipBattleGame;

import javafx.scene.Parent;

import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
//klasa planszy
public class Area extends Parent {
    private VBox rows = new VBox();//rzędy
    private boolean rival = false;//przeciwnik
    public int ship  = 5;//ilość statków

    //plansza
    public Area(boolean rival, EventHandler<? super MouseEvent> handler){
        this.rival = rival;
        //tworzymy rzędy
        for(int y = 0; y<15; y++){
            HBox row = new HBox();
            for(int x = 0;x<15;x++)//tworzymy komórki
            {
                Cell c = new Cell(x,y,this);
                c.setOnMouseClicked(handler);
                row.getChildren().add(c);
            }
            rows.getChildren().add(row);//dodajemy rzędy do listy rzędów
        }
        getChildren().add(rows);//dodajemy rzędy do Parents

    }

    //metoda do rozkładania statków statków
    public boolean placeShip(Ships ships, int x,int y){
        //czy możemy nadal rozkładać statki
        if(palacingShips(ships,x,y)){
            int length = ships.size;//rozmiar statku
            boolean vertical = ships.vertical;//położenie

            if(vertical){
                for(int i =y; i<y+length;i++) {
                    Cell cell = getCell(x, i);
                    cell.ships = ships;
                    //jeśli nie przeciwnik nadajemy kolory
                    if (!rival) {
                        cell.setFill(Color.BROWN);
                        cell.setStroke(Color.BROWN);
                    }
                }
            }
                    else {
                    for(int i =x; i<x+length;i++){
                        Cell cell = getCell(i,y);
                        cell.ships = ships;
                        if(!rival){
                            cell.setFill(Color.BROWN);
                            cell.setStroke(Color.BROWN);
                        }
                }
            }
            return true;//jeśli możemy postawić statek
        }
        return false;//jeśli nie możemy postawić statku
    }

    public Cell getCell(int x, int y){
        return (Cell)((HBox)rows.getChildren().get(y)).getChildren().get(x);
    }

    private Cell[] getNeighbors(int x, int y){
        Point2D[] points = new Point2D[]{
            new Point2D(x-1,y),
            new Point2D(x+1,y),
            new Point2D(x,y-1),
            new Point2D(x,y+1)
        };

        List<Cell> neighbors = new ArrayList<Cell>();

        for(Point2D p : points){
            if(isValidPoint(p)){
                neighbors.add(getCell((int)p.getX(),(int)p.getY()));
            }
        }
        return neighbors.toArray(new Cell[0]);
    }

    private boolean palacingShips(Ships ships, int x, int y){
        int length = ships.size;
        boolean vertical = ships.vertical;

        if(vertical){
            for(int i = y;i<y+length;i++){
                if(!isValidPoint(x, i))
                    return false;

                Cell cell = getCell(x, i);
                if(cell.ships !=null)
                    return false;

                for(Cell neighbor : getNeighbors(x, i )){
                    if(!isValidPoint(x, i))
                        return false;
                    if(neighbor.ships !=null)
                        return false;
                }
            }
        }
        else{
            for(int i= x;i<x+length;i++){
                if(!isValidPoint(i, y))
                    return false;

                Cell cell = getCell(i, y);
                if(cell.ships !=null)
                    return false;

                for(Cell neighbor : getNeighbors(i, y )){
                    if(!isValidPoint(i, y))
                        return false;
                    if(neighbor.ships !=null)
                        return false;
                }
            }
         }
         return true;
    }

    private boolean isValidPoint(Point2D point){
        return isValidPoint(point.getX(),point.getY());
    }
    //przeciążenie metodi isValidPoint
    private boolean isValidPoint(double x, double y){
        return x >=0 && x < 15 && y >=0 && y < 15;
    }

    // klasa komórki
public class Cell extends Rectangle {

        public int x,y; //pozycja komórki na planszy
        public Ships ships = null;//jeśli na komórce nie leży statek
        public boolean Shoted = false;//czy komórka była trafiona

        private Area area;//plansza

        public Cell(int x, int y, Area area){
            super (20,20);//wielokść komórki
            this.x = x;//położenie
            this.y = y;//położenie
            this.area = area;
            setFill(Color.DARKBLUE);
            setStroke(Color.BLUE);

        }
        //metoda strzał
        public boolean shoot(){

            Shoted = true;//jeśli komórka trafiona
            setFill(Color.BLACK);

            if(ships != null)// jeśli na komórce leży statek
            {
                ships.hit();//metda trafienie
                setFill(Color.RED);
                if (!ships.StillAlive())//metoda czy "żyje"
                {
                    area.ship--;//redukujemy liczbę statków na planszy
                }
                return true;//statek trafiony
            }
            return false;//statek nie trafiony
        }
}
}
