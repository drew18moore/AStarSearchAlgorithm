import sun.awt.image.ImageWatched;

import javax.swing.*;
import java.util.LinkedList;

public class AStarAlgorithm {
    int[] startCoordinates = new int[2];
    int[] goalCoordinates = new int[2];
    boolean foundGoal;
    LinkedList<Node> openList;
    LinkedList<Node> closedList;

    Node[][] nodes;
    JPanel[][] tiles;
    Node currentNode;

    public AStarAlgorithm(int[] start, int[] goal, Node[][] nodes, JPanel[][] tiles) {
        this.startCoordinates = start;
        this.goalCoordinates = goal;
        this.foundGoal = false;
        this.nodes = nodes;
        this.tiles = tiles;

        openList = new LinkedList<>();
        closedList = new LinkedList<>();

        openList.add(nodes[startCoordinates[1]][startCoordinates[0]]);
        while (!foundGoal || !openList.isEmpty()) {
            for (int i = 0; i < openList.size(); i++) {
                openList.get(i).setF();
                int temp = i;
                if (openList.get(smallestF).getF() > openList.get(temp).getF())


            }

            openList.remove(nodes[startCoordinates[1]][startCoordinates[0]]);

        }
    }

    private void findG(Node node) {
        int row = node.getRow();
        int col = node.getCol();

        if (row == startCoordinates[1] && col == startCoordinates[0])
           node.setG(0);
        else {
            if (currentNode.getRow())
        }
    }

    private Node smallestFInOpenList(LinkedList<Node> openL) {
        Node smallestF = openL.get(0);
        for (int i = 0; i < openL.size(); i++) {
            openL.
        }
    }
}
