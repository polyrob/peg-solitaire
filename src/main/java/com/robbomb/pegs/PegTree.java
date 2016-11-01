package com.robbomb.pegs;

/**
 * Created by robbie on 10/31/16.
 */
public class PegTree {

    private final PegNode root;
    private int level = 1;
    private int pegs = 1;

    private PegNode lastNode;

    public PegTree() {
        root = new PegNode("1");
        lastNode = root;
    }

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


    public PegNode getLastNode(PegNode node) {
        if (node.getD() != null) return getLastNode(node.getD());
        if (node.getB() != null) return getLastNode(node.getB());
        return node;
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

    public void printMoves() {
        PegNode node = root;
        System.out.println(" *** Current moves for board. **");
        while (node != null) {
            // skip empty nodes
            if (!node.isPegged()) {
                node = getNextNode(node);
                continue;
            }

            // check for skips in every direction
            if (node.getA() != null && node.getA().getA() != null && node.getA().isPegged() && !node.getA().getA().isPegged()) {
                System.out.println("Jump A route wth " + node.toString());
            }

            if (node.getB() != null && node.getB().getB() != null && node.getB().isPegged() && !node.getB().getB().isPegged()) {
                System.out.println("Jump B route wth " + node.toString());
            }

            if (node.getC() != null && node.getC().getC() != null && node.getC().isPegged() && !node.getC().getC().isPegged()) {
                System.out.println("Jump C route wth " + node.toString());
            }

            if (node.getD() != null && node.getD().getD() != null && node.getD().isPegged() && !node.getD().getD().isPegged()) {
                System.out.println("Jump D route wth " + node.toString());
            }

            if (node.getE() != null && node.getE().getE() != null && node.getE().isPegged() && !node.getE().getE().isPegged()) {
                System.out.println("Jump E route wth " + node.toString());
            }

            if (node.getF() != null && node.getF().getF() != null && node.getF().isPegged() && !node.getF().getF().isPegged()) {
                System.out.println("Jump F route wth " + node.toString());
            }

            node = getNextNode(node);
        }
    }
}
