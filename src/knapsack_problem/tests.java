package knapsack_problem;

import knapsack_problem.knapsack.Knapsack;
import knapsack_problem.provision.Provision;
import knapsack_problem.provision.ProvisionCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class tests {

    /* Provision Class tests */

    Provision test_p;

    @Test
    @DisplayName("Test provision creation.")
    void testDefaultProvision() {
        test_p = new Provision();

        Assertions.assertFalse(test_p == null);
    }

    @Test
    @DisplayName("Test setting provision weight. (edge case)")
    void testProvisionWeight() {
        test_p = new Provision();
        test_p.setWeight(20);

        Assertions.assertEquals(20, test_p.getWeight());
    }

    @Test
    @DisplayName("Test setting provision profit. (happy path)")
    void testProvisionProfit() {
        test_p = new Provision();
        test_p.setProfit(20);

        Assertions.assertEquals(20, test_p.getProfit());
    }

    @Test
    @DisplayName("Test parameterized provision creation. (happy path)")
    void testParameterizedProvision() {
        test_p = new Provision(5, 20);

        Assertions.assertTrue(test_p.getProfit() == 5 && test_p.getWeight() == 20);
    }

    @Test
    @DisplayName("Tests the toString() method for the Provision class")
    void testToString() {
        test_p = new Provision(5, 20);
        String test_value = "{5, 20}";

        Assertions.assertTrue(test_value.equals(test_p.toString()));
    }

    /* --------------------------------------------------------------------------*/

    /* ProvisionCollection Class tests */

    ProvisionCollection test_pc;

    @Test
    @DisplayName("Manual test to ensure provision generation is occurring as expected with default constructor.")
    void testDefaultProvisionGeneration() {
        test_pc = new ProvisionCollection();
        test_pc.setSize(10);
        test_pc.fill();

        System.out.println("default");
        System.out.println(test_pc.toString());
    }

    @Test
    @DisplayName("Manual test to ensure provision generation is occurring as expected with parameterized constructor.")
    void testParameterizedProvisionGeneration() {
        test_pc = new ProvisionCollection(5);
        test_pc.fill();

        System.out.println("parameterized");
        System.out.println(test_pc.toString());
    }

    /* --------------------------------------------------------------------------*/

    /* Knapsack Class tests */

    Knapsack test_k;

    @Test
    @DisplayName("Test default knapsack constructor.")
    void testDefaultKnapsack() {
        test_k = new Knapsack();

        Assertions.assertFalse(test_k == null);
    }

    @Test
    @DisplayName("Test parameterized knapsack constructor.")
    void testParameterizedKnapsack() {
        test_k = new Knapsack(15);

        Assertions.assertTrue(test_k != null && test_k.getCapacity() == 15);
    }

    @Test
    @DisplayName("Manual test for seeContents() formatting.")
    void testSeeContents() {
        test_pc = new ProvisionCollection();
        test_pc.setSize(10);
        test_pc.fill();

        test_k = new Knapsack(10);
        for(int i = 0; i < test_k.getCapacity(); i++) {
            test_k.addItem(test_pc.provisions.get(i), 1);
        }

        System.out.println(test_pc.toString());
        System.out.println(test_k.seeContents());
    }

    @Test
    @DisplayName("Test item creation and addition to contents.")
    void testItemCreation() {
        test_k = new Knapsack(15);
        test_p = new Provision(1, 1);

        test_k.addItem(test_p, 1);

        Assertions.assertTrue(test_k.seeContents().equals("{  {1.0, 1.0}  }"));
    }

    @Test
    @DisplayName("Tests getTotalProfit().")
    void testTotalProfit() {
        test_k = new Knapsack(10);
        test_p = new Provision(1, 1);

        for(int i = 0; i < test_k.getCapacity(); i++) {
            test_k.addItem(test_p, 1);
        }

        Assertions.assertEquals(10, test_k.getTotalProfit());
    }

    @Test
    @DisplayName("Tests getTotalWeight().")
    void testTotalWeight() {
        test_k = new Knapsack(10);
        test_p = new Provision(1, 1);

        for(int i = 0; i < test_k.getCapacity(); i++) {
            test_k.addItem(test_p, 1);
        }

        Assertions.assertEquals(10, test_k.getTotalWeight());
    }
}
