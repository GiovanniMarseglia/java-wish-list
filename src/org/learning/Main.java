package org.learning;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        ArrayList<String> gift = new ArrayList<>();
        File file = new File("./resources/text.txt");
        try (Scanner scannerReader = new Scanner(file)){

            while (scannerReader.hasNextLine()){
                String line = scannerReader.nextLine();
                gift.add(line);
            }

        } catch (FileNotFoundException e){
            System.out.println("Impossibile leggere nel file");
        }



        while (flag){
            System.out.println("Scrivere y per aggiungere l'elemento altrimente n se vuoi smeettere di inserire elementi");
            String response = scanner.nextLine();
            if(response.equals("y")){
                System.out.println("Inserisci il nome del regalo");
                String element = scanner.nextLine();
                gift.add(element);

                if (gift.size()==1){
                    System.out.println("Nella lista c'è un regalo");
                }else{
                    System.out.println("Nella lista ci sono " + gift.size() + " regali");
                }
            }else if(response.equals("n")){
                flag=false;
            }else{
                System.out.println("hai inserito un parametro non valido...riprova");
            }
        }



        try (FileWriter fileWriter = new FileWriter(file)){
            for (String element : gift){
                fileWriter.write(element + "\n");
            }
        }catch (IOException e){
            System.out.println("Impossibile accedere al file");
        }

        Collections.sort(gift);
        System.out.println(gift);
    }
}
