package br.com.contractworked.application;

import java.text.ParseException;
import br.com.contractworked.entites.Contract;
import br.com.contractworked.entites.Worker;
import br.com.contractworked.enums.WorkerLevel;

public class App{
    public static void main(String[] args) throws ParseException {
       Worker paulo = new Worker("Paulo Jorge", 1200.00, WorkerLevel.JUNIOR);

       Contract c1 = new Contract("12/09/2022", 30, 15);
    }
}