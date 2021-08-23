/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualCB;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author harishsivaram
 */
//public class CodeGeneration {
//    public static String getRandomNumberString() {
//    // It will generate 6 digit random Number.
//    // from 0 to 999999
//        Random rnd = new Random();
//    int number = rnd.nextInt(999999);
//
//    // this will convert any number sequence into 6 character.
//    return String.format("%06d", number);
//}
//    
//}
public class CodeGeneration{
 public static void main(String []args)
     {

        Random r=new Random();
                        HashSet<Integer> set= new HashSet<Integer>();
                        while(set.size()<1)
                        {
                            int ran=r.nextInt(99)+100000;
                            set.add(ran);
                        }
                        int len = 6;
                        String random=String.valueOf(len);
                        for(int  random1:set)
                        {
                            System.out.println(random1);
                            random=Integer.toString(random1);

                        }
     }
}
