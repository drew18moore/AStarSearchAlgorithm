import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Window extends JFrame implements ActionListener {
    final int SCREEN_SIZE = 750;
    int numRows;
    int numColumns;
    int[] startingTile;
    int[] goalTile;
    Node[][] nodes;
    JPanel[][] tiles;
    JPanel gridPanel;
    JMenuBar menuBar;
    JMenu addNodeMenu;
    JMenuItem addStart;
    JMenuItem addGoal;
    JOptionPane addStartDialog;
    JOptionPane addGoalDialog;


    public Window(int numRows, int numCols) {
        this.numRows = numRows;
        this.numColumns = numCols;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_SIZE, SCREEN_SIZE);
        setLocationRelativeTo(null);
        setTitle("A* Pathfinding Algorithm");
        setResizable(true);
        setLayout(new BorderLayout());

        // Create a menu bar
        menuBar = new JMenuBar();
        addNodeMenu = new JMenu("Add Nodes");
        addStart = new JMenuItem("Add Start Node");
        addGoal = new JMenuItem("Add Goal Node");
        addStartDialog = new JOptionPane();
        addStart.addActionListener(this);
        addGoal.addActionListener(this);
        addNodeMenu.add(addStart);
        addNodeMenu.add(addGoal);
        menuBar.add(addNodeMenu);
        setJMenuBar(menuBar);


        createGrid(this.numRows, this.numColumns);
        //aStarAlgorithm(startingTile, goalTile);
        setVisible(true);
    }

    // Generates grid with random unpathable tiles
    private void createGrid(int numRows, int numCols) {
        Random r = new Random();
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(numRows, numCols));
        nodes = new Node[numRows][numCols];
        tiles = new JPanel[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createLineBorder(Color.black));

                // each tile has a 10% chance of being unpathable
                if (r.nextInt(10) == 0) {
                    nodes[i][j] = new Node(i, j, 1, Color.darkGray);
                    panel.setBackground(Color.darkGray);
                } else {
                    nodes[i][j] = new Node(i, j, 0, Color.white);
                    panel.setBackground(Color.white);
                }
                tiles[i][j] = panel;
                gridPanel.add(panel);
            }
        }
        add(gridPanel);
    }

    private void aStarAlgorithm(int[] start, int[] goal) {
        LinkedList<Node> openList = new LinkedList<>();
        LinkedList<Node> closedList = new LinkedList<>();
        boolean foundGoal = false;
        openList.add(nodes[start[1]][start[0]]);
        while (!foundGoal || !openList.isEmpty()) {
            System.out.println(openList.get(0));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addStart) {
            while (true) {
                String str = JOptionPane.showInputDialog("Input coordinates for the starting point (x,y)");
                startingTile = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();

                if ((startingTile[0] > 0 && startingTile[0] <= numColumns) && (startingTile[1] > 0 && startingTile[1] <= numRows)) {
                    tiles[startingTile[1] - 1][startingTile[0] - 1].setBackground(Color.green);
                    break;
                }
            }
        }
        if (e.getSource() == addGoal) {
            while (true) {
                String str = JOptionPane.showInputDialog("Input coordinates for the goal point (x,y");
                goalTile = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();

                if ((goalTile[0] > 0 && goalTile[0] <= numColumns) && (goalTile[1] > 0 && goalTile[1] <= numRows)) {
                    tiles[goalTile[1] - 1][goalTile[0] - 1].setBackground(Color.red);
                    break;
                }
            }
        }
    }
}
