package br.com.taxcalculation.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.taxcalculation.entites.Company;
import br.com.taxcalculation.entites.TaxPayer;
import br.com.taxcalculation.entites.Individual;

public class Progam {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);//Criando um scanner para armazenar dados a partir do terminal 

        List<TaxPayer> taxPayers = new ArrayList<>();//Criando uma lista para armazenar todas as persons 
        TaxPayer payer; //Criando o Tax payer a ser armazenado na lista

        Double soma = 0.0; //Variavel feita para calcular a soma de todos os impostos

        System.out.print("Enter the number of tax payers: ");//Descobrindo a quantidade de pagadores de imposto  
        int n = scan.nextInt();//Alocando a quantidade de pagadores de imposto  

        //Realizar o mesmo processo para todos os pagadores de imposto (entanto i < n)
        for(int i = 0; i < n; i++){
            System.out.print("Individual or company (i/c)? ");//Descobrindo se é individual ou companhia
            char pay = scan.next().charAt(0); 
            switch (pay) {
                case 'i':
                    System.out.print("Name: ");
                    String nameI = scan.next();//Armazenando o nome do individuo  
                    System.out.print("Anual income: ");
                    Double incomeI = scan.nextDouble(); //Armazenando o ganho anual do individuo  
                    System.out.print("Health expenditures: ");
                    Double health = scan.nextDouble(); //Armazenando o gasto anual em saúde do individuo   
                    payer = new Individual(nameI, incomeI, health);//Criando um Tax Payer Individual
                    taxPayers.add(payer); //Adicionando ele a lista de tax payers   
                    break;
                case 'c':
                    System.out.print("Name: ");
                    String nameC = scan.next();//Armazenando o nome da companhia   
                    System.out.print("Anual income: ");
                    Double incomeC = scan.nextDouble(); //Armazenando o ganho anual da companhia 
                    System.out.print("Number of employees: ");
                    int employess = scan.nextInt(); //Armazenando o numero de funcionarios da companhia  
                    payer = new Company(nameC, incomeC, employess);//Criando um Tax Payer Company
                    taxPayers.add(payer); //Adicionando ele a lista de tax payers
                    break;  
                default:
                    break;
            }
        }

        scan.close();

        //Reaçizar a soma de todos os impostos 
        for (TaxPayer taxPayer : taxPayers) {
            soma += taxPayer.taxcalculation(); 
        }

        System.out.println("\nTAXES PAID:");
        for (TaxPayer taxPayer : taxPayers) {
            System.out.printf("%s: $ %.2f\n", taxPayer.getName(), taxPayer.getTax());
        }

        System.out.println("\nTOTAL TAXES:" + soma);
    }
}
