/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miningdata;

/**
 *
 * @author LeLe
 */
class ScaleWord {
    String key;
    double[] fen = new double[3];
    
    public ScaleWord(String a, double b, double c, double d){
        key = a;
        fen[0] = b;
        fen[1] = c;
        fen[2] = d;
    }
}
