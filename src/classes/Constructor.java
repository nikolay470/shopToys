package classes;

import interfaces.ParticipantLottery;

public class Constructor extends AbstractToys implements ParticipantLottery {
    private int weight;
    public Constructor(String name, int quant, int weight) {
        super(name, quant);
    }

    @Override
    public int getWeight() {
        return 0;
    }

    public void setWeight(int weight) throws RuntimeException {
        if (weight > 0 && weight < 100) {
            this.weight = weight;
        } else {
            throw new RuntimeException();
        }
    }
}
