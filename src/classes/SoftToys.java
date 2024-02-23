package classes;

import interfaces.ParticipantLottery;

import javax.swing.*;

public class SoftToys extends AbstractToys implements ParticipantLottery {
    private int weight;

    public SoftToys(String name, int quant) {
        super(name, quant);
    }

    @Override
    public void setWeight(int weight) {
        if (weight > 0 && weight < 100) {
            this.weight = weight;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public int getWeight() {
        return 0;
    }
}
