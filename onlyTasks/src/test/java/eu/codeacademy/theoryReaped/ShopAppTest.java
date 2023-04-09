package eu.codeacademy.theoryReaped;

import eu.codeacademy.theoryReaped.shop.Order;
import eu.codeacademy.theoryReaped.shop.Product;
import eu.codeacademy.theoryReaped.shop.Shop;
import eu.codeacademy.theoryReaped.shop.Type;
import eu.codeacademy.theoryReaped.shop.myException.Insufficient;
import org.junit.jupiter.api.Test;

import java.util.*;

import static eu.codeacademy.theoryReaped.shop.Type.*;
import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ShopAppTest {
    private final String PRODUCT_FIRST_FILE = "E:\\java\\Study\\JavaAdvance\\onlyTasks\\src\\main\\java\\eu\\codeacademy\\theoryReaped\\files\\products1.txt";
    private final String PRODUCT_SECOND_FILE = "onlyTasks\\src\\main\\java\\eu\\codeacademy\\theoryReaped\\products2.txt";
    private HashMap<String, Integer> orderedProducts;
    private List<Order> testOrderList;
    private List<Shop> shops;

    private Order myOrder = new Order("4", returnMap(), PURCHASE);

    private List<Product> testListOfProducts = Product.importProducts(PRODUCT_FIRST_FILE);

    private Shop lidl = new Shop("LIDL", "Romainiai 45", testListOfProducts);


    public HashMap<String, Integer> returnMap() {
        orderedProducts = new HashMap<>();
        orderedProducts.put("06669844723", 2);
        orderedProducts.put("07886659844", 6);
        orderedProducts.put("06998454541", 50);
        orderedProducts.put("0984451274", 17);
        orderedProducts.put("96665644256", 12);

        return orderedProducts;
    }

    public List<Order> returnOrderList() {
        testOrderList = new ArrayList<>(Arrays.asList(
                new Order("1", returnMap(), Type.PURCHASE),
                new Order("2", returnMap(), SALE),
                new Order("3", returnMap(), PURCHASE)));

        return testOrderList;
    }

    private List<Shop> returnShopList() {
        shops = new ArrayList<>();
        shops.add(new Shop("Maxima", "K456", this.testListOfProducts));
        shops.add(new Shop("IKI", "R56", this.testListOfProducts));
        shops.add(new Shop("Rimi", "T1456", this.testListOfProducts));
        shops.add(new Shop("Aibe", "QK456", this.testListOfProducts));


        return shops;
    }

    @Test
    void fillListOfProductsFromFile() {


        System.out.println(testListOfProducts);
        assertEquals(testListOfProducts.get(0).getBarcode(), "07886659844");
        assertEquals(testListOfProducts.get(1).getName(), "Suris");
        assertEquals(testListOfProducts.get(1).getPrice(), 6.85);
    }

    @Test
    void shopBalanceCount() {
        List<Product> testListOfProducts = Product.importProducts(PRODUCT_FIRST_FILE);
        Shop shop = new Shop("MegaShop", "Kaunas", testListOfProducts);
        double result = shop.shopBalance(testListOfProducts);

        System.out.println(result);
        assertEquals(result, 226.54999999999998);
    }

    @Test
    void getListOrderByType() {
        List<Order> orderList = Order.filterOrderByType(returnOrderList(), PURCHASE);
//        System.out.println(orderList);
        assertEquals(orderList.size(), 2);
    }

    @Test
    void sortShops() {
        List<Shop> sortedShops = Shop.sortByName(returnShopList());
//        System.out.println(sortedShops);

        assertEquals("Aibe", sortedShops.get(0).getName());
        assertEquals("IKI", sortedShops.get(1).getName());

    }

    @Test
    void buyTenOfProduct() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("07886659844", 10);

        myOrder.makeOrder(lidl, PURCHASE, map);
        int result = lidl.getProducts().get(0).getRemainder();


    }

    @Test
    void sellMoreThatHaveShop() throws Insufficient {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("07886659844", 10);

        int result = lidl.getProducts().get(0).getRemainder();


            myOrder.makeOrder(lidl, SALE, map);


//        assertEquals(16, result);

    }
}
