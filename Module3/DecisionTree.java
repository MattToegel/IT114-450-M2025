package Module3;

// Node class representing a decision point in the NPC decision tree
class DecisionNode {
    String question; // Decision point question or condition description
    String action; // Action taken by the NPC at this decision point
    DecisionNode yesBranch; // Subtree if the condition is true
    DecisionNode noBranch; // Subtree if the condition is false

    public DecisionNode(String question, String action) {
        this.question = question;
        this.action = action;
    }

    // Method to traverse the decision tree and simulate NPC actions
    public void traverse() {
        // Display the decision point and the action taken
        System.out.println("Decision: " + question);
        System.out.println("Action: " + action);

        // Simulate NPC decision-making based on a condition (random in this example)
        boolean condition = Math.random() > 0.5; // Simulated condition check

        // Traverse branches based on the simulated condition
        if (condition && yesBranch != null) {
            System.out.println("Condition met: Yes");
            yesBranch.traverse(); // Traverse the yes branch
        } else if (!condition && noBranch != null) {
            System.out.println("Condition met: No");
            noBranch.traverse(); // Traverse the no branch
        }
    }
}

public class DecisionTree {
    public static void main(String[] args) {
        // Creating a decision tree with NPC behavior scenarios
        DecisionNode root = new DecisionNode("Is the NPC's health low?", "Checking health...");

        // Expanding the tree with more behavior nodes
        root.yesBranch = new DecisionNode("Does the NPC have healing items?", "Using a health potion.");
        root.noBranch = new DecisionNode("Is an enemy nearby?", "Scanning for threats.");

        // Adding deeper decision paths
        root.yesBranch.yesBranch = new DecisionNode("Is the NPC in combat?", "Retreating to heal.");
        root.yesBranch.noBranch = new DecisionNode("Can the NPC find cover?", "Taking cover and healing.");

        root.noBranch.yesBranch = new DecisionNode("Is the enemy stronger?", "Retreating to a safe distance.");
        root.noBranch.noBranch = new DecisionNode("Is the NPC's weapon ready?", "Engaging the enemy.");

        // Additional behavior nodes to handle further actions
        root.noBranch.yesBranch.yesBranch = new DecisionNode("Can the NPC call for backup?",
                "Calling for reinforcements.");
        root.noBranch.yesBranch.noBranch = new DecisionNode("Is stealth an option?", "Hiding from the enemy.");

        // Start traversal to simulate NPC behavior based on the decision tree
        root.traverse();
    }
}