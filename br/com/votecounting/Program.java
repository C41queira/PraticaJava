package br.com.votecounting;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
    
    public static void main(String[] args) {
        File file = new File("C:\\Users\\berti\\Desktop\\PraticaExercicios\\br\\com\\votecounting\\votes.txt");
        Scanner scan = null; 
        Map<String, Integer> voters = new TreeMap<>(); 

        try {
            scan = new Scanner(file); 
            while (scan.hasNextLine()) {
                String[] counting = scan.nextLine().split(","); 
                String name = counting[0];
                Integer votes = Integer.parseInt(counting[1]); 
                if (voters.containsKey(counting[0])) {
                    int votesSoFar = voters.get(counting[0]);
                    voters.put(name, votesSoFar + votes); 
                }else{
                    voters.put(name, votes);
                }
            }

            System.out.println(voters.toString());

            System.out.println();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            if (scan != null ) {
                scan.close();
            }
        }
    }
}
