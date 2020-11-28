package knapsack_problem.provision;

public class Provision {
    // arbitrarily selected bounds
    final static int MAX_PROFIT = 50;
    final static int MAX_WEIGHT = 20;

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