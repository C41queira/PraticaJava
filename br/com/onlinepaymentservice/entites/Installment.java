package br.com.onlinepaymentservice.entites;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Installment {
    
    private LocalDate dueDate;
    private Double amount;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("#.00");

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    } 
    
    @Override
    public String toString() {
        return dtf.format(dueDate) + " - " + df.format(amount); 
    }
}
