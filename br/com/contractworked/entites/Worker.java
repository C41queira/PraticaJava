package br.com.contractworked.entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.contractworked.enums.WorkerLevel;

public class Worker {
    
    private String name;
    private double baseSalary; 
    private WorkerLevel workerLevel; 

    private List<Contract> contracts; 

    public Worker(){}

    public Worker(String name, double baseSalary, WorkerLevel workerLevel){
        this.name = name;
        this.baseSalary = baseSalary;
        this.workerLevel = workerLevel;
        contracts = new ArrayList<>();  
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setWorkerLevel(WorkerLevel workerLevel) {
        this.workerLevel = workerLevel;
    }
    public WorkerLevel getWorkerLevel() {
        return workerLevel;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
    public List<Contract> getContracts() {
        return contracts;
    }

    public void addContract(Contract contract){
        contracts.add(contract); 
    }

    public void removeContract(Contract contract){
        contracts.remove(contract); 
    }

    public Double income(int month, int year){
        double totalSalary = baseSalary;
        Calendar cal = Calendar.getInstance(); 
        for (Contract contract : contracts) {
            cal.setTime(contract.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1+ cal.get(Calendar.MONTH);
            
            if (c_month == month && c_year == year) {
                totalSalary += contract.totaValue(); 
            }
        }

        return totalSalary; 
    }
}
