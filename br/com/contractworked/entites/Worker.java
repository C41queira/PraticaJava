package br.com.contractworked.entites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.contractworked.enums.Department;
import br.com.contractworked.enums.WorkerLevel;

public class Worker {
    
    private String name;
    private double baseSalary; 
    private WorkerLevel workerLevel; 

    private List<Contract> contracts; 
    private Department department; 

    public Worker(){}

    //Construtor paar já instanciar as variaveis desejadas num trabalhador
    public Worker(String name, double baseSalary, WorkerLevel workerLevel, Department department){
        this.name = name;
        this.baseSalary = baseSalary;
        this.workerLevel = workerLevel;
        this.department = department; 
        contracts = new ArrayList<>();  
    }

    //Setagem do nome
    public void setName(String name) {
        this.name = name;
    }
    //Pega do nome 
    public String getName() {
        return name;
    }

    //Setagem da base salarial
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    //Pega da base salarial
    public double getBaseSalary() {
        return baseSalary;
    }

    //Setagem do cargo do trabalhador
    public void setWorkerLevel(WorkerLevel workerLevel) {
        this.workerLevel = workerLevel;
    }
    //Pega do cargo do trabalhador
    public WorkerLevel getWorkerLevel() {
        return workerLevel;
    }

    //Setagem da lista de contratos 
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
    //Pega dos contratos 
    public List<Contract> getContracts() {
        return contracts;
    }

    //Metodo de adição de contrato para um trabalhador
    public void addContract(Contract contract){
        contracts.add(contract); 
    }

    //metodo para remoção de contrato para um trabalhador
    public void removeContract(Contract contract){
        contracts.remove(contract); 
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public Department getDepartment() {
        return department;
    }

    //Metodo de calculo de ganho total do trabalhador, salario base + ganhos dos contratos
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
