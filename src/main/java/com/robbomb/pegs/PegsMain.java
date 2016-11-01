package com.robbomb.pegs;

/**
 * Created by robbie on 10/31/16.
 */
public class PegsMain {

    public static void main(String[] args) {
        PegTree pegTree = new PegTree();

        for (int i = 0; i < 14; i++) {
            pegTree.addNode();
        }

        System.out.println(pegTree);
    }
}
