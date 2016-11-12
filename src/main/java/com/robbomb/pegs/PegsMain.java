package com.robbomb.pegs;

/**
 * Created by robbie on 10/31/16.
 */
public class PegsMain {

    public static void main(String[] args) {

        // Build PegTree data structure
        try {
            PegTree pegTree = new PegTree(5);
            // set initial missing pin
            pegTree.getPeg(1).setPegged(false);

            Solver solver = new Solver();
            solver.iterateSolutions(pegTree);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
