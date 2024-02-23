package classes;

import interfaces.ParticipantLottery;

public class ToysCar extends AbstractToys implements ParticipantLottery {
    private int weight;

    public ToysCar(String name, int quant) {
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
