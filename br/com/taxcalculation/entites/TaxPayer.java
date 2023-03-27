package br.com.taxcalculation.entites;

//Criação da classe person de com abstract pois ela é uma classe mais generica, sem especificações 
public abstract class TaxPayer {

    private String name;
    protected Double annualIncome; 
    protected Double tax;
    
    public TaxPayer() {
    }

    public TaxPayer(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }  

    //Colocando o calculo de imposto em abstract pois cada subclasse vai ter um metodo diferente para se clacular o imposto
    public abstract Double taxcalculation();
}
