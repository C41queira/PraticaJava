package br.com.onlinepaymentservice.services;

public class PaypalService implements OnlinePaymentService {

    @Override
    public Double paymentFee(Double amount) {
        
        Double value = 0.0; 

        value = (amount*0.02);
        
        return value; 
        
    }

    @Override
    public Double interest(Double amount, Integer months) {
        /* amount + amount*0.01*months */
        Double value = 0.0; 

        value = (amount*0.01*months);
        
        return value; 
    }
    
}
