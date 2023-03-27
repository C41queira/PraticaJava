package br.com.taxcalculation.entites;

//Extendendo a classe person pois se se trata de uma subclasse, herdando todos os metodos e variaveis necessárias 
public class Individual extends TaxPayer {


    private Double healthExpenditure; 
 
    public Individual() {
    }

    public Individual(String name, Double annualIncome, Double healthExpenditure) {
        super(name, annualIncome);
        this.healthExpenditure = healthExpenditure;
    }

    public Double getHealthExpenditure() {
        return healthExpenditure;
    }

    public void setHealthExpenditure(Double healthExpenditure) {
        this.healthExpenditure = healthExpenditure;
    }
    

    //Sobrescrevendo o metodo taxcalculation, para implementar os calculos desejados na classe PhysicalPerson
    @Override
    public Double taxcalculation() {
        //Realizando um if para rendas anuais menores que 20000
        if (annualIncome < 20000.00) {
            tax = (annualIncome * 15/100);//Calculo do imposto sendo 15% da renda anual 
        }else/*Realizando um else para rendas anuais maiores do que 20000*/{
            tax = (annualIncome *25/100);//Calculo do imposto sendo 25% da renda anual  
        }

        //Realizando um if ver se houve gastos com saúde neste mês 
        if (healthExpenditure > 0) {
            tax -= (healthExpenditure * 50/100);//retirando 50% dos gastos de saúde dos impostos 
        }

        return tax;//Retornando a taxa calculada  
    }

   
}
