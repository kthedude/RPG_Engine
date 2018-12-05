package UI;

import Base.Battle;
import Base.Characters.Fighter;
import Base.Characters.Goblin;

public class Main {

    public static void main(String[] args){
        Terminal_UI ui = new Terminal_UI();
        ui.start();
    }

    private static void print(String string){
        System.out.println(string);
    }
}
