package wynsean.freshie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class DrinksDataProvider {

    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> FreshFoodDetails = new LinkedHashMap<String, List<String>>();

        List<String> FreshFruitList = new ArrayList<>();
        FreshFruitList.add("Coca-Cola");
        FreshFruitList.add("Pepsi");
        FreshFruitList.add("Rootbeer");

        List<String> FreshVegetableList = new ArrayList<>();
        FreshVegetableList.add("C2 Iced Tea");
        FreshVegetableList.add("Orange Juice");
        FreshVegetableList.add("Grape Juice");

        List<String> FreshMeatList = new ArrayList<>();
        FreshMeatList.add("Absolute");
        FreshMeatList.add("Summit");
        FreshMeatList.add("Nature Spring");

        FreshFoodDetails.put("Fizzy Drinks and Cola", FreshFruitList);
        FreshFoodDetails.put("Juices and Smoothies", FreshVegetableList);
        FreshFoodDetails.put("Bottled Water", FreshMeatList);

        return FreshFoodDetails;

    }

}
