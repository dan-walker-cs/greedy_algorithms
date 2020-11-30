package knapsack_problem.provision;

import java.util.ArrayList;
import java.util.Random;


// This class acts as the list of candidate objects for inclusion within the knapsack
// These objects, called Provisions, are generated with random values, up to an arbitrary max
public class ProvisionCollection {
    public ArrayList<Provision> provisions = new ArrayList<Provision>();
    private int size;

    public ProvisionCollection() {

    }

    public ProvisionCollection(int num_provisions) {
        this.size = num_provisions;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    private Provision generateProvision() {
        Random number_generator = new Random();
        Provision new_provision = new Provision();

        new_provision.setProfit(number_generator.nextInt(Provision.MAX_PROFIT) + 1);
        new_provision.setWeight(number_generator.nextInt(Provision.MAX_WEIGHT) + 1);

        return new_provision;
    }

    private void addProvision() {
        provisions.add(generateProvision());
    }

    public Provision getProvision(int index) {
        return provisions.get(index);
    }

    public void fill() {
        for(int i = 0; i < size; i++) {
            addProvision();
        }
    }

    public String toString() {
        String template = "Current available provisions: (index: {profit, weight})\n";
        for(int i = 0; i < size; i++) {
            template += i + ": " + provisions.get(i).toString() + "\n";
        }
        return template;
    }
}
