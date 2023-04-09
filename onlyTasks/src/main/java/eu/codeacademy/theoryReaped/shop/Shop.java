package eu.codeacademy.theoryReaped.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
public class Shop implements Comparable<Shop> {
    private String name;
    private String address;
    private List<Product> products;

    public double shopBalance(List<Product> products){
        //price * remainder
        double result = 0;
        for (int i = 0; i < products.size(); i++) {
            double productPrice = products.get(i).getPrice() * products.get(i).getRemainder();
            result += productPrice;
        }
        return result;
    }

    public static List<Shop> sortByName(List<Shop> shops){
        List<Shop> sortedShopListByName = new ArrayList<>();
        Collections.sort(shops);
        sortedShopListByName.addAll(shops);
        return  sortedShopListByName;
    }

    public int compareTo(@NotNull Shop o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shop.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("address='" + address + "'")
                .add("products=" + products)
                .toString();
    }
}
