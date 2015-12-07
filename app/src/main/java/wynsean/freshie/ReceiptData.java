package wynsean.freshie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wyndell on 10/11/2015.
 */
public class ReceiptData {
//    public static ArrayList<String> list;
//
//    public ReceiptData() {
//        list = new ArrayList<>();
//    }
//
//    public static ArrayList<String> getList() {
//        return list;
//    }
//
//    public void add(String item) {
//        list.add(item);
//    }

    private static int TOTAL;

    private static List<String> listProduct = new ArrayList<>();
    private static List<String> listQuantity = new ArrayList<>();
    private static List<String> listPrice = new ArrayList<>();


    public static String getListProduct(int i) {
        return listProduct.get(i);
    }

    public static String getListQuantity(int i) {
        return listQuantity.get(i);
    }

    public static String getListPrice(int i) {
        return listPrice.get(i);
    }

    public static void addProduct(String item) {
        listProduct.add(item);
    }

    public static void addQuantity(String item) {
        listQuantity.add(item);
    }

    public static void addPrice(String item) {
        listPrice.add(item);
    }


    public static int getSize() {
        return listProduct.size();
    }



    public static int getTOTAL() {
        return TOTAL;
    }

    public static void addTOTAL(int price) {
        TOTAL = TOTAL + price;
    }

//    public static void addTOTAL(int price) {
//        TOTAL[counter] = price;
//        counter++;
//    }
//
//    public static int getTOTAL() {
//        int totalprice = 0;
//        for (int i = 0; i < counter+1; i++) {
//            totalprice = totalprice + TOTAL[i];
//        }
//        return totalprice;
//    }
}
