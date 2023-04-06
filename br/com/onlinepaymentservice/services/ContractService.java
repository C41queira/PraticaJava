package br.com.onlinepaymentservice.services;

import java.time.LocalDate;

import br.com.onlinepaymentservice.entites.Contract;
import br.com.onlinepaymentservice.entites.Installment;

public class ContractService {
    
    public static void processContract(Contract contract, Integer months){

        //Pega o mês do contrato 
        LocalDate date = contract.getDate();

        for(int i = 1; i <= months; i++){
            //Adiciona i meses a data do contrato para colocar a data da prestação 
            LocalDate dateInstallment =  date.plusMonths(i);
            
            //Pega o valor total a ser pago e divide pela quantidade de meses
            Double valueAmount = (contract.getTotalValue() / months);
            
            //Adiciona o valor do jusros simples do mês i 
            valueAmount += contract.getOps().interest(valueAmount, i);
            //Adiciona a taxa de pagamento do serviço online
            valueAmount += contract.getOps().paymentFee(valueAmount);
            
            //Cria uma nova prestação 
            Installment installment = new Installment(dateInstallment, valueAmount);

            //Adiciona a prestação criada na lista de prestações do contrato
            contract.getInstallments().add(installment); 
        }
    }
}
