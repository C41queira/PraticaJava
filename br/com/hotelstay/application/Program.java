package br.com.hotelstay.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;

import br.com.hotelstay.model.entite.Reservation;

public class Program {
    public static void main(String[] args) {
        /*Exception
         * Criação da reserva:
         *  - A data de checkOut não pode ser antes da de checkIn
         *  - A data de checkIn e checkOut não podem ser no mesmo dia 
         * 
         * Update da reserva: 
         *  - A data de checkOut não pode ser antes da de checkIn
         *  - A data de checkIn e checkOut não podem ser no mesmo dia
         *  - A nova data de checkIn e checkOut so podem ser realizadas antes da primeira data de checkIn     
        */

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

        String checkIn = "12/08/2019";
        String checkOut = "19/08/2019";  

        String checkInUp = "10/08/2019";
        String checkOutUp = "19/08/2019";

        try {
            Reservation r1 = new Reservation("Maria", 5600, sdf.parse(checkIn), sdf.parse(checkOut)); 
            System.out.println(r1.toString());
            
            r1.updateReserve(sdf.parse(checkInUp), sdf.parse(checkOutUp));
        } catch (DataFormatException e) {
            System.out.println(e.getMessage()); 
        } catch (ParseException e) {
            System.out.println(e.getMessage()); 
        }

       

    }
}
