package br.com.contractworked.entites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract {
    private Date date; 
    private double valueHour; 
    private int worksHour; 

    //Implementada para formatar a data do contrato 
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    public Contract(){}

    //Construtor instanciado para já implementar todas as variaveis 
    public Contract(String date, double valueHour, int worksHour) throws ParseException{
        //Converte a String do construtor para uma data certa no contrato 
        this.date = f.parse(date);

        this.valueHour = valueHour;
        this.worksHour = worksHour;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setValueHour(double valueHour) {
        this.valueHour = valueHour;
    }
    public double getValueHour() {
        return valueHour;
    }

    public void setWorksHour(int worksHour) {
        this.worksHour = worksHour;
    }
    public int getWorksHour() {
        return worksHour;
    }

    public Double totaValue(){
        return valueHour * worksHour; 
    }
    
}
