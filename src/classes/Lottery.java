package classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Lottery extends AbstractLottery {
    private int countPrizes;
    private List<AbstractToys> winnigs;
    private List<AbstractToys> prizes;
    private Random random;
    private ArrayList<AbstractToys> setPrizes;

    public Lottery() {
        super();
        prizes = new ArrayList<>();
        winnigs = new ArrayList<>();
        countPrizes = prizes.size();
        random = new Random();
        setPrizes = getSetPrizes();
    }

    public ArrayList<AbstractToys> getSetPrizes() {
        ArrayList<AbstractToys> res = new ArrayList<>();
        for (int i = 0; i < prizes.size(); i++) {
            if (!res.contains(prizes.get(i))) {
                res.add(prizes.get(i));
            }
        }
        return res;
    }

    @Override
    public void start() {
        while (countPrizes != 0) {
            int index = random.nextInt(0, countPrizes);
            winnigs.add(prizes.get(index));
            prizes.remove(index);
            countPrizes--;
            System.out.println("Выигрыш: " + winnigs.get(winnigs.size() - 1));
        }
        System.out.println("Все призы разыгранны, поздравляем!\n");
        finishLottery();
    }

    @Override
    public void finishLottery() {
        giveAwayPrize();
        recordInFile();
    }

    private void giveAwayPrize() {
        System.out.println("Выдача призов");
        System.out.println(winnigs.size());
        for (int i = 0; i < winnigs.size(); i++) {
            System.out.println("Приз: " + winnigs.get(i) + " выдан");
        }
    }

    private void recordInFile() {
        try {
            FileWriter writer = new FileWriter("src/lottery.txt", true);
            Map<String, Integer> count = countOccurrences();
            StringBuilder builder = new StringBuilder();
            String str = "";
            writer.write("Разыгранны следующие призы: \n");

            for (int i = 0; i < setPrizes.size(); i++) {
                str = String.format("%s - %d шт\n", setPrizes.get(i).getName(), count.get(setPrizes.get(i)));
                builder.append(str);
            }
            builder.append("====================================\n\n");
            writer.append(builder.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Integer> countOccurrences() {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < winnigs.size(); i++) {
            res.put(winnigs.get(i).getName(), Collections.frequency(winnigs, winnigs.get(i)));
        }
        return res;
    }

    public void addPrize(AbstractToys prize) {
        prizes.add(prize);
    }

    public void addAllPrizes(ArrayList<AbstractToys> list) {
        prizes.addAll(list);
        countPrizes = prizes.size();
        setPrizes = getSetPrizes();
    }
}
