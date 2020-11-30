package knapsack_problem.knapsack;

import knapsack_problem.provision.Provision;
import knapsack_problem.provision.ProvisionCollection;

import java.util.*;

// This class pulls the elements of the algorithm together and represents its runtime state
public class KnapsackImpl {
    Knapsack knapsack;
    ProvisionCollection pc;
    ArrayList<Double> inclusionMetrics;
    HashMap<Double,Integer> inclusionMap;
    double currentWeight = 0;

    public KnapsackImpl(int k_size, int pc_size) {
        this.knapsack = new Knapsack(k_size);

        this.pc = new ProvisionCollection(pc_size);
        pc.fill();
        System.out.println(pc.toString());

        this.generateInclusionMetrics();
        this.generateInclusionOrder();

        this.fillKnapsack();
    }

    // calculates the profit/weight of each item in the provision collection
    // hashmap is used to preserve pairs when sorted
    private void generateInclusionMetrics() {
        double metric_value;
        this.inclusionMetrics = new ArrayList<Double>();
        this.inclusionMap = new HashMap<Double, Integer>();

        for(int i = 0; i < pc.getSize(); i++) {
            metric_value = ((double) pc.getProvision(i).getProfit()) / ((double) pc.getProvision(i).getWeight());
            inclusionMetrics.add(metric_value);
            inclusionMap.put(metric_value, i);
        }
    }

    // inclusion process is faster with a descending value list
    private void generateInclusionOrder() {
        Collections.sort(inclusionMetrics, Collections.reverseOrder());
    }

    private void fillKnapsack() {
        // these are here to avoid spaghetti method chain
        double next_highest_metric;
        int target_provision_index;
        Provision target_provision;

        int i = 0;
        while(currentWeight <= knapsack.getCapacity()) {
            next_highest_metric = inclusionMetrics.get(i);
            target_provision_index = inclusionMap.get(next_highest_metric);
            target_provision = pc.getProvision(target_provision_index);

            // for the final case where we potentially cannot fit the entire stock of the provision in the knapsack
            if(target_provision.getWeight() + currentWeight > knapsack.getCapacity()) {
                double weight_left = knapsack.getCapacity() - currentWeight;
                double target_amount = weight_left / (double)target_provision.getWeight();

                knapsack.addItem(target_provision,target_amount);
            } else {
                knapsack.addItem(target_provision, 1);
            }
            i++;
            currentWeight += target_provision.getWeight();
        }
    }

    public double getTotalProfit() {
        return knapsack.getTotalProfit();
    }
}
