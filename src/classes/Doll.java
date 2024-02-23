package classes;

import interfaces.ParticipantLottery;

public class Doll extends AbstractToys implements ParticipantLottery {
    private int weight;
    public Doll(String name, int quant) {
        super(name, quant);
    }

    @Override
    public void setWeight(int weight) throws RuntimeException{
        if (weight > 0 && weight < 100) {
            this.weight = weight;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
