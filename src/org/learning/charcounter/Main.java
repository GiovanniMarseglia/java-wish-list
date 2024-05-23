package org.learning.charcounter;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word=scanner.nextLine();

        HashMap<Character,Integer> list = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);

            if(list.containsKey(c)){
                list.put(c,list.get(c)+1);
            }else{
                list.put(c,1);
            }
        }

        for (Character element : list.keySet()){
            System.out.println(element + ":" + list.get(element));
        }
    }
}
