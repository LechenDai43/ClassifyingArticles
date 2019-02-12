package miningdata;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LeLe
 */
public class KeyWord implements Comparable<KeyWord>{
    String key;
    int[][] type = new int[3][3];
    
    public KeyWord(String word){
        key = word;
        type[0][0] = 0;
        type[1][0] = 0;
        type[2][0] = 0;
        type[0][1] = 0;
        type[1][1] = 0;
        type[2][1] = 0;
        type[0][2] = 0;
        type[1][2] = 0;
        type[2][2] = 0;              
    }

    @Override
    public int compareTo(KeyWord o) {
        return this.key.compareTo(o.key);
    }
}
