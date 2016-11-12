package com.robbomb.pegs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by robbie on 10/31/16.
 */
public class Solver {

    Deque<String> moveStack = new ArrayDeque<>();

    public void solve(PegTree pegTree) {

        PegNode node = pegTree.getRoot();
        boolean hadMove = false;


        while (node != null) {
            // skip empty nodes
            if (!node.isPegged()) {
                node = pegTree.getNextNode(node);
                continue;
            }

            // check for skips in every direction
            PegNode n1 = node.getA();
            if (n1 != null && n1.getA() != null && n1.isPegged() && !n1.getA().isPegged()) {
                moveStack.addLast("Jump A route wth " + node.toString());
                node.setPegged(false);
                n1.setPegged(false);
                n1.getA().setPegged(true);
                solve(pegTree);
                moveStack.removeLast();
                node.setPegged(true);
                n1.setPegged(true);
                n1.getA().setPegged(false);
            }

            n1 = node.getB();
            if (n1 != null && n1.getB() != null && n1.isPegged() && !n1.getB().isPegged()) {
                moveStack.addLast("Jump B route wth " + node.toString());
                node.setPegged(false);
                n1.setPegged(false);
                n1.getB().setPegged(true);
                solve(pegTree);
                moveStack.removeLast();
                node.setPegged(true);
                n1.setPegged(true);
                n1.getB().setPegged(false);
            }

            n1 = node.getC();
            if (n1 != null && n1.getC() != null && n1.isPegged() && !n1.getC().isPegged()) {
                moveStack.addLast("Jump C route wth " + node.toString());
                node.setPegged(false);
                n1.setPegged(false);
                n1.getC().setPegged(true);
                solve(pegTree);
                moveStack.removeLast();
                node.setPegged(true);
                n1.setPegged(true);
                n1.getC().setPegged(false);
            }

            n1 = node.getD();
            if (n1 != null && n1.getD() != null && n1.isPegged() && !n1.getD().isPegged()) {
                moveStack.addLast("Jump D route wth " + node.toString());
                node.setPegged(false);
                n1.setPegged(false);
                n1.getD().setPegged(true);
                solve(pegTree);
                moveStack.removeLast();
                node.setPegged(true);
                n1.setPegged(true);
                n1.getD().setPegged(false);
            }

            n1 = node.getE();
            if (n1 != null && n1.getE() != null && n1.isPegged() && !n1.getE().isPegged()) {
                moveStack.addLast("Jump E route wth " + node.toString());
                node.setPegged(false);
                n1.setPegged(false);
                n1.getE().setPegged(true);
                solve(pegTree);
                moveStack.removeLast();
                node.setPegged(true);
                n1.setPegged(true);
                n1.getE().setPegged(false);
            }

            n1 = node.getF();
            if (n1 != null && n1.getF() != null && n1.isPegged() && !n1.getF().isPegged()) {
                moveStack.addLast("Jump F route wth " + node.toString());
                node.setPegged(false);
                n1.setPegged(false);
                n1.getF().setPegged(true);
                solve(pegTree);
                moveStack.removeLast();
                node.setPegged(true);
                n1.setPegged(true);
                n1.getF().setPegged(false);
            }

            node = pegTree.getNextNode(node);
        }
        if (!hadMove) {
            if (pegTree.countLeftPegs() == 1) {
                System.out.println(" *pathway completed, pegs left: " + pegTree.countLeftPegs());
                System.out.println("*** MOVES ***");
                for (String s : moveStack) {

                    System.out.println(s);

                }
                System.out.println();
            }

        }
    }
}
