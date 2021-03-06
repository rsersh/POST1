/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {
    private FileReader in;
    private BufferedReader reader;

    private String productsFile;
    private String parsedSpec;
    
    public ProductReader(String productCatalogFile){
        productsFile = productCatalogFile;
    }    
    
    public void init() throws IOException { 
        
        in = new FileReader(productsFile); 
        reader = new BufferedReader(in);
        
        while(hasMoreProducts())
            getNextProduct();
    }
    
    public boolean hasMoreProducts()throws IOException{
        if((parsedSpec = reader.readLine()) != null){
            return false;
        }
        else{
            return true;
        } 
    }
    
    public ProductSpec getNextProduct(){
        //read next line in file
        //then create a ProductSpec instance and return it
        //listOfItems.add(new Item(productSpec));
        String UPC = parsedSpec.substring(0,3);
        String description = parsedSpec.substring(9, 28);
        String sPrice = parsedSpec.substring(34);
        float price = Integer.parseInt(sPrice);
        
        ProductSpec nextProduct = new ProductSpec();
        
        nextProduct.setUPC(UPC);
        nextProduct.setDescription(description);
        nextProduct.setPrice(price);
        
        return nextProduct;
    }
    
}

