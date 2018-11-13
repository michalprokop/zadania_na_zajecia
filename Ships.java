package ShipBattleGame;

import javafx.scene.Parent;
//klasa statek
public class Ships extends Parent  {
    public int size;//rozmiar
    public boolean vertical = true;//kierunek ułożenia
    private int durability;//wytrzymałość


    public Ships(int size, boolean vertical){
    this.size=size;
    this.vertical=vertical;
     durability = size;
    }
    //metoda trafienie
    public void hit(){
        durability--;
    }
    //metoda sprawdająca czy statek "żyje"
    public boolean StillAlive(){
        return durability>0;
    }
}
