package br.com.hotelstay.model.exception;

public class DateException extends Exception {
    private static final long serialVersionUID = 1L; 
    
    //Exception criada para problemas de datas que não podem ocorrer
    public DateException(String mg){
        super(mg);
    }
}
