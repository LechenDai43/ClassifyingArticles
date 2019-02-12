/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miningdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author LeLe
 */
public class MiningData {

    

    /**
     * @param args the command line arguments
     */
    
     
    
     public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<KeyWord> lists = new ArrayList<KeyWord>();
        ArrayList<ScaleWord> scales = new ArrayList<ScaleWord>();
        File m1 = new File(".\\politics\\p1.txt");
        File m2 = new File(".\\politics\\p2.txt");
        File m3 = new File(".\\politics\\p3.txt");
        File b1 = new File(".\\busniess\\p1.txt");
        File b2 = new File(".\\busniess\\p2.txt");
        File b3 = new File(".\\busniess\\p3.txt");
        File t1 = new File(".\\travel\\p1.txt");
        File t2 = new File(".\\travel\\p2.txt");
        File t3 = new File(".\\travel\\p3.txt");
        
        processFile(m1,1,1,lists);
        processFile(m2,1,2,lists);
        processFile(m3,1,3,lists);
        processFile(b1,2,1,lists);
        processFile(b2,2,2,lists);
        processFile(b3,2,3,lists);
        processFile(t1,3,1,lists);
        processFile(t2,3,2,lists);
        processFile(t3,3,3,lists);
        
        Collections.sort(lists);
        
        
        for(int i = 0; i < lists.size(); i ++){
            scales.add(processKey(lists.get(i)));
        }
        
                
        File t01 = new File(".\\politics\\o1.txt");
        File t02 = new File(".\\politics\\o2.txt");
        File t03 = new File(".\\politics\\o3.txt");
        File t04 = new File(".\\politics\\o4.txt");
        File t05 = new File(".\\politics\\o5.txt");
        File t06 = new File(".\\busniess\\o1.txt");
        File t07 = new File(".\\busniess\\o2.txt");
        File t08 = new File(".\\busniess\\o3.txt");
        File t09 = new File(".\\busniess\\o4.txt");
        File t10 = new File(".\\busniess\\o5.txt");        
        File t11 = new File(".\\travel\\o1.txt");
        File t12 = new File(".\\travel\\o2.txt");
        File t13 = new File(".\\travel\\o3.txt");
        File t14 = new File(".\\travel\\o4.txt");
        File t15 = new File(".\\travel\\o5.txt");
        
        processTarget(t01,scales);
        processTarget(t02,scales);
        processTarget(t03,scales);
        processTarget(t04,scales);
        processTarget(t05,scales);
        processTarget(t06,scales);
        processTarget(t07,scales);
        processTarget(t08,scales);
        processTarget(t09,scales);
        processTarget(t10,scales);
        processTarget(t11,scales);
        processTarget(t12,scales);
        processTarget(t13,scales);
        processTarget(t14,scales);
        processTarget(t15,scales);
        
        
    }
     
    private static void processFile(File f, int x, int y, ArrayList<KeyWord> lists) throws FileNotFoundException, IOException {
        x --;
        y --;
        InputStreamReader reader = new InputStreamReader(new FileInputStream(f));  
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        while(line != null){
            line = processString(line);
            StringTokenizer tk = new StringTokenizer(line);
                while(tk.hasMoreTokens()){
                    String tem = tk.nextToken();
                    tem = tem.toLowerCase();
                    if(tem.equals("a")||tem.equals("an") || tem.equals("the")||tem.equals("to") || tem.equals("for")||
                            tem.equals("of") || tem.equals("on") || tem.equals("in") || tem.equals("with") || tem.equals("from") ||
                            tem.equals("after") || tem.equals("before") || tem.equals("above") || tem.equals("below") || tem.equals("withour") || 
                            tem.length() <= 3){
                        
                    }else{
                    boolean has = false;
                    for(int j = 0; j < lists.size(); j ++){
                        if(tem.equals(lists.get(j).key)){
                            lists.get(j).type[x][y] ++;
                            has = true;
                            break;
                        }
                    }
                    if(! has){
                        KeyWord tkw = new KeyWord(tem);
                        tkw.type[x][y] ++;
                        lists.add(tkw);
                    }
                    }
                }
                line = br.readLine();
        }
    }
    
    private static String processString(String a){
        for(int i = 0; i < a.length(); i++){
                char tar = a.charAt(i);
                if( tar < 79 || tar > 122){
                    a = a.substring(0,i) + " " + a.substring(i+1);
                }                
            }
        
    
    return a;
    }

    private static ScaleWord processKey(KeyWord get) {
        ScaleWord theOne;
        boolean c11 = get.type[0][0] > 0;
        boolean c12 = get.type[0][1] > 0;
        boolean c13 = get.type[0][2] > 0;
        boolean c21 = get.type[1][0] > 0;
        boolean c22 = get.type[1][1] > 0;
        boolean c23 = get.type[1][2] > 0;
        boolean c31 = get.type[2][0] > 0;
        boolean c32 = get.type[2][1] > 0;
        boolean c33 = get.type[2][2] > 0;
        double one = get.type[0][0] + get.type[0][1] + get.type[0][2];
        double two = get.type[1][0] + get.type[1][2] + get.type[1][1];
        double three = get.type[2][0] + get.type[2][2] + get.type[2][1];
        double f1 = 1;
        double f2 = 1;
        double f3 = 1;
        if(c11){
            f1 *= 1;
            f2 /= 2;
            f3 /= 2;
        }
        if(c12){
            f1 *= 1;
            f2 /= 2;
            f3 /= 2;
        }
        if(c13){
            f1 *= 1;
            f2 /= 2;
            f3 /= 2;
        }
        if(c21){
            f2 *= 1;
            f1 /= 2;
            f3 /= 2;
        }
        if(c22){
            f2 *= 1;
            f1 /= 2;
            f3 /= 2;
        }
        if(c23){
            f2 *= 1;
            f1 /= 2;
            f3 /= 2;
        }
        if(c31){
            f3 *= 1;
            f1 /= 2;
            f2 /= 2;
        }
        if(c32){
            f3 *= 1;
            f1 /= 2;
            f2 /= 2;
        }
        if(c33){
            f3 *= 1;
            f1 /= 2;
            f2 /= 2;
        }
        one *= f1;
        two *= f2;
        three *= f3;
        if(one == two && one == three){
            one = 0;
            two = 0;
            three = 0;
        }else if(one == two){
            one = 0;
            two = 0;
        }else if(one == three){
            one = 0;
            three = 0;
        }else if(two == three){
            two = 0;
            three = 0;
        }
        theOne = new ScaleWord(get.key,one,two,three);
        return theOne;
    }

    private static void processTarget(File f, ArrayList<ScaleWord> scales) throws FileNotFoundException, IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(f));  
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        double point1 = 0.0;
        double point2 = 0.0;
        double point3 = 0.0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        while(line != null){
            line = processString(line);
            StringTokenizer tk = new StringTokenizer(line);
                while(tk.hasMoreTokens()){
                    String tem = tk.nextToken();
                    tem = tem.toLowerCase();
                    for(int i = 0; i < scales.size(); i ++){
                        if(tem.equals(scales.get(i).key)){
                            point1 += scales.get(i).fen[0];
                            point2 += scales.get(i).fen[1];
                            point3 += scales.get(i).fen[2];
                            if(scales.get(i).fen[0] > 0){
                                num1 ++;
                            }
                            if(scales.get(i).fen[1] > 0){
                                num2 ++;
                            }
                            if(scales.get(i).fen[2] > 0){
                                num3 ++;
                            }
                            break;
                        }
                    }
                }
                line = br.readLine();
        }
        point1 /= num1;
        point2 /= num2;
        point3 /= num3;
        if(point1 == point2 && point2 == point3){
            System.out.println("I am poor to find this article!!");
        }else if(point3 < point1 && point3 < point2){
            if(point1 > point2){
                System.out.println("This is politics article.");
            }else if(point1 < point2){
                System.out.println("This is business article.");
            }else{
                System.out.println("This is business or politics article.");
            }
        }else if(point2 < point1 && point2 < point3){
            if(point1 > point3){
                System.out.println("This is politics article.");
            }else if(point1 < point3){
                System.out.println("This is travel article.");
            }else{
                System.out.println("This is travel or politics article.");
            }
        }else{
            if(point2 > point3){
                System.out.println("This is business article.");
            }else if(point2 < point3){
                System.out.println("This is travel article.");
            }else{
                System.out.println("This is travel or business article.");
            }
        }
    }

}
