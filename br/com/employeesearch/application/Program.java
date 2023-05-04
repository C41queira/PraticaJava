package br.com.employeesearch.application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.employeesearch.entite.Employee;

public class Program {

    /*Fazer um programa para ler os dados (nome, email e salário)
    de funcionários a partir de um arquivo em formato .csv.
    
    Em seguida mostrar, em ordem alfabética, o email dos
    funcionários cujo salário seja superior a um dado valor
    fornecido pelo usuário.

    Mostrar também a soma dos salários dos funcionários cujo
    nome começa com a letra 'M'. */

    public static void main(String[] args) {

        File file = new File("C:\\Users\\berti\\Desktop\\PraticaExercicios\\br\\com\\employeesearch\\employees.txt");
        Scanner scan = null;
        Scanner scanSystem = null;
        List<Employee> listEmployees = new ArrayList<>(); 
        
        try {
            scan = new Scanner(file); 
            while (scan.hasNextLine()) {
                String[] informations = scan.nextLine().split(","); 
                String name = informations[0]; 
                String email = informations[1]; 
                Double salary = Double.parseDouble(informations[2]); 
                Employee employee = new Employee(name, email, salary); 
                listEmployees.add(employee);                
            }

            scanSystem = new Scanner(System.in);

            System.out.println("Finding employees by salary \nEnter the Salary: ");
            Double salaryNeed = scanSystem.nextDouble(); 

            //Cria uma nova lista filtrada com os criterios desejados 
            List<Employee> salaryEmployees = listEmployees.stream()/*Transforma em stream*/
            .filter(p -> p.getSalary() >= salaryNeed)/*Filtra a stream a partir dos criterios entre parenteses*/
            .collect(Collectors.toList())/*Tranforma a stream novamente para List*/;

            //Organiza a lista em ordem alfabéticapor meio de compareTo 
            salaryEmployees.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
            //Imprime todos os elementos da lista
            System.out.printf("\nEmail of people whose salary is more than $ %.2f\n", salaryNeed);
            salaryEmployees.forEach(p -> System.out.println(p.getEmail()));

            Double soma = listEmployees.stream().filter(p -> p.getName().charAt(0) == 'M')
            .map(x -> x.getSalary()).reduce(0.0, (x, y) -> x + y); 

            System.out.println("\nSum of salary of people whose name starts with 'M': " + soma);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage()); 
        } finally {
            scan.close();
        }
    }
}
