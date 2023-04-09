package eu.codeacademy.theoryReaped.shop;

import eu.codeacademy.theoryReaped.shop.myException.Insufficient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private String orderNr;
    private HashMap<String, Integer> orderedProducts;
    private Type type;

    public static List<Order> filterOrderByType(List<Order> orderList, Type type) {
        List<Order> orderListByType = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getType().equals(type)) {
                orderListByType.add(order);
            }
        }

        return orderListByType;
    }

    public void makeOrder(Shop shop, Type type, HashMap<String, Integer> hashMap) {

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String barcode = entry.getKey();
            int countOfProduct = hashMap.get(barcode);
            for (int i = 0; i < shop.getProducts().size(); i++) {
                if (barcode.equals(shop.getProducts().get(i).getBarcode())) {
                    if (type.equals(Type.PURCHASE)) {
                        try {
                            shop.getProducts().get(i).addRemainder(countOfProduct);
                        } catch (Insufficient e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        try {
                            shop.getProducts().get(i).removeRemainder(countOfProduct);
                        } catch (Insufficient e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("orderNr='" + orderNr + "'")
                .add("orderedProducts=" + orderedProducts)
                .add("type=" + type)
                .toString();
    }
}
