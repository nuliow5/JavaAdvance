package eu.codeacademy.theoryReaped;

import eu.codeacademy.theoryReaped.shop.Product;

import java.util.List;

public class ShopAppMain {
    public static void main(String[] args) {
        final String PRODUCT_FIRST_FILE = "E:\\java\\Study\\JavaAdvance\\onlyTasks\\src\\main\\java\\eu\\codeacademy\\theoryReaped\\files\\products1.txt";


        System.out.println("test==================");

        List<Product> tempList = Product.importProducts(PRODUCT_FIRST_FILE);
        for (int i = 0; i <tempList.size() ; i++) {
            System.out.println(tempList.get(i));
        }
//        System.out.println(tempList);
        System.out.println("test==================");

    }
}
