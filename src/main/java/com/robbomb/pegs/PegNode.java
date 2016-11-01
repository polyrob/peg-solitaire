package com.robbomb.pegs;

/**
 * Created by robbie on 10/31/16.
 */
public class PegNode {

    private boolean pegged;

    private PegNode a;
    private PegNode b;
    private PegNode c;
    private PegNode d;
    private PegNode e;
    private PegNode f;




    /*          f     a
                 \   /
                  \ /
              e ---o--- b
                  / \
                 /   \
                d     c
     */

    public boolean isPegged() {
        return pegged;
    }

    public void setPegged(boolean pegged) {
        this.pegged = pegged;
    }

    public PegNode getA() {
        return a;
    }

    public void setA(PegNode a) {
        this.a = a;
    }

    public PegNode getB() {
        return b;
    }

    public void setB(PegNode b) {
        this.b = b;
    }

    public PegNode getC() {
        return c;
    }

    public void setC(PegNode c) {
        this.c = c;
    }

    public PegNode getD() {
        return d;
    }

    public void setD(PegNode d) {
        this.d = d;
    }

    public PegNode getE() {
        return e;
    }

    public void setE(PegNode e) {
        this.e = e;
    }

    public PegNode getF() {
        return f;
    }

    public void setF(PegNode f) {
        this.f = f;
    }
}
