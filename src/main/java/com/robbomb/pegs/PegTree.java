package com.robbomb.pegs;

/**
 * Created by robbie on 10/31/16.
 */
public class PegTree {

    private PegNode root;
    private int level = 1;
    private int pegs = 1;

    private PegNode lastNode;

    public PegTree() {
        root = new PegNode();
        lastNode = root;
    }



    public void addNode() {
        // count pegs in row above
        PegNode p = new PegNode();
        pegs++;
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
        if (node.getD() != null) return getNextNode(node.getD());
        if (node.getB() != null) return getNextNode(node.getB());
        return node;
    }

    protected static int getFactorial(int x) {
        if (x == 1) return 1;
        return x + getFactorial(x-1);
    }

}
