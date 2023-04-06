package br.com.onlinepaymentservice.entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.onlinepaymentservice.services.OnlinePaymentService;

public class Contract {
    
    private Integer id; 
    private LocalDate date; 
    private Double totalValue;

    private OnlinePaymentService ops; 

    private List<Installment> installments; 
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Contract(Integer id, LocalDate date, Double totalValue, OnlinePaymentService ops) {
        this.id = id;
        this.date = date;
        this.totalValue = totalValue;
        this.ops = ops;
        installments = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public OnlinePaymentService getOps() {
        return ops;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        sb.append("Numero: " + id);
        sb.append("\nData: " + dtf.format(date)); 
        sb.append("\nValor do contrato: " + totalValue);
        return sb.toString(); 
    }
}
