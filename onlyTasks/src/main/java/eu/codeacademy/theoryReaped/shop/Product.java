package eu.codeacademy.theoryReaped.shop;

import eu.codeacademy.theoryReaped.shop.myException.Insufficient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Product {


    private String name;
    private double price;
    private String barcode;
    private Integer remainder;

    public Product(String name, double price, String barcode, Integer remainder) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.remainder = remainder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }

    public void addRemainder(int desiredQuantity) throws Insufficient {
        if (desiredQuantity > 0){
            this.remainder += desiredQuantity;
        } else {
            throw new Insufficient("We dont have so much this categero producrs", desiredQuantity);
        }

    }

    public void removeRemainder(int desiredQuantity) throws Insufficient {
        if (desiredQuantity <= this.remainder){
            this.remainder -= desiredQuantity;
        } else {
            throw new Insufficient("We dont have so much this categero producrs", desiredQuantity);
        }

    }

    public static List<Product> importProducts(String filePath) {
        List<Product> productList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] splitToArray = line.split(", ");
                productList.add(new Product(
                        splitToArray[0],
                        Double.parseDouble(splitToArray[1]),
                        splitToArray[2],
                        Integer.parseInt(splitToArray[3].trim())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("barcode='" + barcode + "'")
                .add("remainder=" + remainder)
                .toString();
    }
}
