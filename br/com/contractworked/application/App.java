package br.com.contractworked.application;

import java.text.ParseException;
import br.com.contractworked.entites.Contract;
import br.com.contractworked.entites.Worker;
import br.com.contractworked.enums.Department;
import br.com.contractworked.enums.WorkerLevel;

public class App{
    public static void main(String[] args) throws ParseException {
        
        //Cria um trabalhador 
        Worker paulo = new Worker("Paulo Jorge", 1200.00, WorkerLevel.JUNIOR, Department.BACK_END);

        //Criação dos contratos 
        Contract c1 = new Contract("12/09/2022", 30, 15);
        Contract c2 = new Contract("25/09/2022", 80, 8);
        Contract c3 = new Contract("5/06/2022", 40, 20);

        //Adição dos contratos ao trabalhador 
        paulo.addContract(c1);
        paulo.addContract(c2);
        paulo.addContract(c3);

        System.out.println(paulo.income(9, 2022));
    }
}