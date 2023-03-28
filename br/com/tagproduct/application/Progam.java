package br.com.tagproduct.application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.tagproduct.entites.ImportedProduct;
import br.com.tagproduct.entites.Product;
import br.com.tagproduct.entites.UsedProduct;

public class Progam {
    public static void main(String[] args) throws ParseException {
        
        Scanner s = new Scanner(System.in); 
        List<Product> products = new ArrayList<>(); 

        System.out.println("Quantos produtos armazenados tem? ");//Perguntando no terminal quanto produtos teram na lista products

        int n = s.nextInt();//Utilizando Scanner para armazenar a quantidade de produtos em uma variavel
        
        //Utilizando um repetidor para criar todos os produtos a partir do numero colocado em n
        for(int x = 1; x <= n; x++) {   
            Product p;//Criando o produto que sera salvo  

            System.out.println("O produto é Comum, Usado ou Importado? (c/u/i)");//Perguntando no terminal qual o tipo do produto 

            String resposta = s.next();//Utilizando Scanner para armazenar a quantidade de produtos em uma variavel
            
            //Para cada resposta, o switch ira jogar a execução correspondente a ela
            switch (resposta) {
                case "c":
                    System.out.println("Name: ");
                    String name = s.next();
                    System.out.println("Price: ");
                    Double price = s.nextDouble();
                    p = new Product(name, price); 
                    products.add(p);
                    break;
                case "u":
                    System.out.println("Name: ");
                    String nameU = s.next();
                    System.out.println("Price: ");
                    Double priceU = s.nextDouble();
                    System.out.println("Data de Fabricacao (DD/MM/YYYY): ");
                    String date = s.next();
                    p = new UsedProduct(nameU, priceU, date); 
                    products.add(p);
                    break;
                case "i":
                    System.out.println("Name: ");
                    String nameI = s.next();
                    System.out.println("Price: ");
                    Double priceI = s.nextDouble();
                    System.out.println("Valor do Frete: ");
                    Double fee = s.nextDouble();
                    p = new ImportedProduct(nameI, priceI, fee); 
                    products.add(p);
                    break;
                default:
                    System.out.println("Tipo do produto não encontrado");
                    break;
            }

        }

        s.close();

        for (Product product : products) {
           System.out.println(product.priceTag()); 
        }
    }
}
