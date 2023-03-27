package br.com.taxcalculation.entites;
//Extendendo a classe person pois se se trata de uma subclasse, herdando todos os metodos e variaveis necessárias 
public class Company extends TaxPayer {

    private int employess; 

    
    public Company() {
    }

    public Company(String name, Double annualIncome, int employess) {
        super(name, annualIncome);
        this.employess = employess;
    }

    public int getEmployess() {
        return employess;
    }

    public void setEmployess(int employess) {
        this.employess = employess;
    }
    
    //Sobrescrevendo o metodo taxcalculation, para implementar os calculos desejados na classe LegalPerson
    @Override
    public Double taxcalculation() {

        //Realizando um if LegalPeron com menos de 10 funcionarios 
        if(employess < 10){
            tax = (annualIncome * 16/100);//Calculo do imposto sendo 16% da renda anual

        }else/*Realizando um if LegalPeron com mais de 10 funcionarios*/{
            tax = (annualIncome * 14/100);//Calculo do imposto sendo 14% da renda anual
        }
        
        return tax;//Retornando a taxa calculada 
    }
 
}
