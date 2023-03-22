package br.com.contractworked.entites;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Contract {
    private Date date; 
    private double valueHour; 
    private int worksHour; 

    DateFormat f = DateFormat.getInstance();

    public Contract(){}

    public Contract(String date, double valueHour, int worksHour) throws ParseException{
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
