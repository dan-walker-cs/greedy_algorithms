package knapsack_problem.provision;

// This class is the blueprint for an object to potentially be included within the knapsack
public class Provision {
    // arbitrarily selected bounds
    final static int MAX_PROFIT = 49;
    final static int MAX_WEIGHT = 19;

    private int profit;
    private int weight;

    public Provision() {

    }

    public Provision(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getProfit() {
        return profit;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "{" + profit + ", " + weight + "}";
    }
}