package br.com.olympiadativides.service;

import java.util.Random;

import br.com.olympiadativides.entites.Olympiad;

public class UpdateOlympiad {
    
    public static void update(Olympiad olympiad){
        Random random = new Random(); 
       
        //Preencher todos os valores das tabelas 
        for(int l = 0; l < olympiad.getScorecard().length; l++)/*Percorre todas as linhas*/{ 
            int somaTotal = 0; //Utilizado para armazenar os valores para a soma de todos os rounds 
            for(int c = 0; c < olympiad.getScorecard()[l].length; c++)/*Percorre todas as colunas*/{
                if (c == olympiad.getScorecard()[l].length - 1) /*Começar o processo de soma assim que chegar na ultima coluna*/{
                    for(int i = 0; i < olympiad.getScorecard()[l].length-1; i++)/*Percorre todas as colunas da linha atual*/{  
                        somaTotal += olympiad.getScorecard()[l][i];//Vai acumulando todos os valores da linha
                        olympiad.getScorecard()[l][c] = somaTotal;//Coloca a soma de todos os valores na ultima coluna  
                    }
                }else{
                    olympiad.getScorecard()[l][c] = random.nextInt(51);//Atribui um valor aleatorio para cada cedula
                }
            }
        }
       
    }
}
