import classes.*;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<AbstractToys> listToys = new ArrayList<>();
        int countPrizes = 10;
        for (int i = 0; i < countPrizes; i++) {
            if (i < 3) {
                listToys.add(new Copter("copter" + i, 5));
            } else if (i >=3 && i < 6) {
                listToys.add(new Constructor("constructor" + i, 4));
            } else if (i >= 6 && i < 8) {
                listToys.add(new Doll("doll" + i, 3));
            } else if (i >= 8 && i < 10) {
                listToys.add(new SoftToys("softToys" + i, 2));
            } else {
                listToys.add(new Locomotive("locomotive" + i, 1));
            }
        }

        Lottery lottery = new Lottery();
        lottery.addAllPrizes(listToys);
        lottery.start();
    }
}
