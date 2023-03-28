package br.com.hotelstay.model.entite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;

public class Reservation {
    
    private String holder;
    private Integer roomNumber; 
    private Date checkIn; 
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public Reservation() {
    }
    
    public Reservation(String holder, Integer roomNumber, Date checkIn, Date checkOut) throws DataFormatException {
        this.holder = holder;
        this.roomNumber = roomNumber;

        //Comparativo, caso situação não desejada ocorrer, instanciar um Exception personalizado com a mensagem indicada 
        if (!checkOut.after(checkIn)/*Analisa de a data de checkOut não é posterior a data de checkIn*/) {
            //Instancia um exception personalizado
            throw new DataFormatException("Data de check_out deve ser posterior a data de check_in");
         }  else {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
         }
        
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public long duration(){
        //Checkin.getTime e checkOut.getTime estão em milisegundos em formato Long
        //Peguei a diferença deles para saber a duração da estadia e armazenei na variavel diff  
        long diff = checkOut.getTime() - checkIn.getTime();
        
        //Como long diff vais estar em milisegundos, usei TimeUnit para converter milisegundos em dias a partir do valor do diff
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
    }

    //Metodo realizado para atualizar as datas de checkIn e checkOut
    //throws DataFormatException colocado para instanciar caso ocorra uma exception
    public void updateReserve(Date checkIn, Date checkOut) throws DataFormatException{
        System.out.println("Inicio da atualização da reserva");
        //Comparativo, caso situação não desejada ocorrer, instanciar um Exception personalizado com a mensagem indicada 
        if (checkIn.before(this.checkIn)/*Analisa se o checkIn da atualização é anterior ao checkIn já cadastrado*/||checkOut.before(this.checkOut)/* Analisa se o checkOut da atualização é anterior ao checkOut já cadastrado*/) {
            throw new DataFormatException("ERROR - Datas de check_in e/ou check_out anteriores a data de reserva"); 
         } else if (!checkOut.after(checkIn)) {
            throw new DataFormatException("ERROR - Data de check_out deve ser posterior a data de check_in");
         } else {
            System.out.println("Atualização bem sucedida");
            this.checkIn = checkIn;
            this.checkOut = checkOut;
         }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name Holder: " + holder);
        sb.append("\nRoom: " + roomNumber);
        sb.append("\nCheck_In: " + sdf.format(checkIn));
        sb.append(" - Check_Out: " + sdf.format(checkOut));
        sb.append("\n"+ duration() + " Nights");
        return sb.toString(); 
    }
}
