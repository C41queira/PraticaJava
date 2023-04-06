package br.com.onlinepaymentservice.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.onlinepaymentservice.entites.Contract;
import br.com.onlinepaymentservice.entites.Installment;
import br.com.onlinepaymentservice.services.ContractService;
import br.com.onlinepaymentservice.services.PaypalService;

public class Program{
    /*
        Uma empresa deseja automatizar o processamento de seus contratos. O processamento de
    um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no
    número de meses desejado.
        A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.
    Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa
    por pagamento. Por enquanto, o serviço contratado pela empresa é o do Paypal, que aplica
    juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
        Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
    e valor total do contrato). Em seguida, o programa deve ler o número de meses para
    parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
    sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
    meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.
    */


    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in); 
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Coloque as informações do contrato");
        
        System.out.print("Numero do contrato: ");
        int id = scan.nextInt();
        
        System.out.print("Data do contrato(dd/MM/yyyy): ");
        String s = scan.next();

        System.out.print("Valor do Contrato: ");
        Double d = scan.nextDouble();
        
        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = scan.nextInt();

        Contract ct1 = new Contract(id, LocalDate.parse(s, dtf), d,new PaypalService());
        
        ContractService.processContract(ct1, parcelas);

        System.out.println("\nContrato:\n" + ct1);

        System.out.println("\nParcelas: ");
        for (Installment installment : ct1.getInstallments()) {
            System.out.println(installment);
        }

        scan.close();
    }
}
    