package knapsack_problem.knapsack;

import knapsack_problem.provision.Provision;

import java.util.ArrayList;

// This class represents the state of the knapsack
public class Knapsack {
    private ArrayList<Item> contents = new ArrayList<Item>();
    private int capacity;
    private double totalProfit = 0;

    public Knapsack() {

    }

    public Knapsack(int capacity) {
        this.capacity = capacity;
    }

    // Provisions within the knapsack
    private class Item {
        double profit;
        double weight;

        Item(double profit, double weight) {
            this.profit = profit;
            this. weight = weight;
        }

        double getProfit() {
            return profit;
        }

        void setProfit(double profit) {
            this.profit = profit;
        }

        double getWeight() {
            return weight;
        }

        void setWeight(double weight) {
            this.weight = weight;
        }

        public String toString() {
            return "{" + profit + ", " + weight + "}";
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    // amountIncluded is 0 <= amountIncluded <= 1 for the percentage of the total item quantity
    public void addItem(Provision p, double amountIncluded) {
        Item new_item = new Item(p.getProfit() * amountIncluded, p.getWeight() * amountIncluded);
        contents.add(new_item);

        this.totalProfit += new_item.getProfit();
    }

    public String seeContents() {
        String template = "{  ";
        for(int i = 0; i < contents.size(); i++) {
            template += contents.get(i).toString() + ", ";
        }
        // get rid of the trailing comma and whitespace
        template = template.substring(0, template.length()-2);

        template += "  }";
        return template;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public String toString() {
        return null;
    }
}