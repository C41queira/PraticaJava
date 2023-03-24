package br.com.tagproduct.entites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class UsedProduct extends Product{
    
    private Date manufactureDate;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct() {
    }

    public UsedProduct(String name, Double price, String date) throws ParseException {
        super(name, price);
        this.manufactureDate = sdf.parse(date);
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    
    @Override
    public String priceTag(){
        StringBuilder sb = new StringBuilder(); 
        sb.append(name + " (Used)"+ "\n");
        sb.append("$ " + price);
        sb.append(" (Manufacture Date: " + sdf.format(manufactureDate) +")");   
        return sb.toString(); 
    }
}
