package br.com.olympiadativides.application;

import br.com.olympiadativides.entites.Olympiad;

public class UI {
    
    public static void printScorecard(Olympiad olympiad){

        for(int l = 0; l < olympiad.getScorecard().length; l++){
            System.out.print(olympiad.getParticipants().get(l).getName() + " ");//Coloca os nomes dos participantes nas linhas
            for(int c = 0; c < olympiad.getScorecard()[l].length; c++){
                System.out.print(olympiad.getScorecard()[l][c] + " ");//Pega todas as informações da tabela de pontuação
            }
            System.out.println(); 
        }

        System.out.print("Rounds:");

        for(int i = 0; i < olympiad.getRounds(); i++){
            System.out.print(" " + (i+1) + " ");
        }

        System.out.print("Total points");
    }
}
