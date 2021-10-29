import java.awt.*;

public class Node {
    private int row, col, f, g, h, type;
    private Node parent;
    private Color color;

    public Node(int r, int c, int t, Color color) {
        this.row = r;
        this.col = c;
        this.type = t;
        this.parent = null;
        this.color = color;
        //type 0 is traversable, 1 is not
    }

    //mutator methods to set values
    public void setF() {
        this.f = this.g + this.h;
    }

    public void setG(int value) {
        this.g = value;
    }

    public void setH(int value) {
        this.h = value;
    }

    public void setParent(Node n) {
        this.parent = n;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //accessor methods to get values
    public int getF() {
        return f;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public Node getParent() {
        return parent;
    }

    public int getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Color getColor() {
        return color;
    }

    public boolean equals(Object in) {
        //typecast to Node
        Node n = (Node) in;
        return row == n.getRow() && col == n.getCol();
    }

    public String toString() {
        return "Node: " + row + "_" + col;
    }
}
