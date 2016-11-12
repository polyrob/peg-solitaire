package com.robbomb.pegs;

/**
 * Created by robbie on 10/31/16.
 */
public class PegTree {

    private final PegNode root;
    private int level = 1;
    private int pegs = 1;

    private PegNode lastNode;


    /**
     * PegTree data structure constructor.
     * The pegs are named such that "1" is the top of the triangle, working the way down from the left. Example for "4"
     * would be a triangle of 10 pins, like bowling pins. The "10" peg would be the bottom right peg in the row of 4.
     * @param size the number of "levels".
     */
    public PegTree(int size) {
        root = new PegNode("1");
        lastNode = root;
        int totalNodes = getFactorial(size);
        for (int i = 1; i < totalNodes; i++) {
            addNode();
        }
    }


    public void addNode() {
        pegs++;
        PegNode p = new PegNode(String.valueOf(pegs));

        if (pegs > getFactorial(level)) {
            level++;
            // get left-most note from lastNode
            PegNode leftMost = getLeftMost(lastNode);
            p.setA(leftMost);
            leftMost.setD(p);
        } else {
            // add as B route to last
            lastNode.setB(p);
            p.setE(lastNode);

            // f parent
            PegNode fParent = lastNode.getA();
            p.setF(fParent);
            fParent.setC(p);

            // a parent
            if (fParent.getB() != null) {
                p.setA(fParent.getB());
                fParent.getB().setD(p);
            }


        }
        lastNode = p;
    }

    public PegNode getLeftMost(PegNode node) {
        if (node.getE() == null) return node;
        return getLeftMost(node.getE());
    }


    public PegNode getNextNode(PegNode node) {
        if (node.getB() != null) return node.getB();
        return getLeftMost(node).getD();
    }

    protected static int getFactorial(int x) {
        if (x == 1) return 1;
        return x + getFactorial(x-1);
    }


    public PegNode getRoot() {
        return root;
    }

    public int countLeftPegs() {
        PegNode p = root;
        int count = 0;
        while (p != null) {
            if (p.isPegged()) count++;
            p = getNextNode(p);
        }
        return count;
    }

}
