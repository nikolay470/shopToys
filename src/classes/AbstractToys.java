package classes;

public abstract class AbstractToys {
    private int id;
    private String name;
    private int quant;
    private static int count = 1;

    public AbstractToys(String name, int quant) {
        this.id = getCount();
        this.name = name;
        this.quant = quant;
    }

    public static int getCount() {
        return count++;
    }

    public String getName() {
        return name;
    }

    public int getQuant() {
        return quant;
    }

    public void changeQuant(int quantChange) {
        int newQuant = quantChange + quant;
        if (newQuant >= 0 && newQuant <= 100) {
            this.quant = newQuant;
        } else if (newQuant < 0){
            this.quant = 0;
        } else {
            this.quant = 100;
        }
    }

    public int getId() {
        return this.id;
    }
}
