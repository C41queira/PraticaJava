package br.com.tagproduct.entites;

public class ImportedProduct extends Product{
    
    private Double customFee;

    public ImportedProduct() {
    }

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public Double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(Double customFee) {
        this.customFee = customFee;
    }
    
    @Override
    public final String priceTag(){
        StringBuilder sb = new StringBuilder(); 
        sb.append(name + "\n");
        sb.append("$ " + (price + customFee));
        sb.append(" (Custom Fee: " + customFee + ")");   
        return sb.toString(); 
    }
}
