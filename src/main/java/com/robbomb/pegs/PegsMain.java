package com.robbomb.pegs;

/**
 * Created by robbie on 10/31/16.
 */
public class PegsMain {

    public static void main(String[] args) {
        // Build PegTree data structure
        PegTree pegTree = new PegTree(5);

        // set initial missing pin
        pegTree.getRoot().setPegged(false);


        Solver solver = new Solver();
        solver.solve(pegTree);


    }
}
