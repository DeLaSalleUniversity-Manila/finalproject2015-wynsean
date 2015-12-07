package wynsean.freshie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class FreshFoodDataProvider {

    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> FreshFoodDetails = new LinkedHashMap<String, List<String>>();

        List<String> FreshFruitList = new ArrayList<>();
        FreshFruitList.add("Strawberry");
        FreshFruitList.add("Apple");
        FreshFruitList.add("Banana");

        List<String> FreshVegetableList = new ArrayList<>();
        FreshVegetableList.add("Broccoli");
        FreshVegetableList.add("Tomato");
        FreshVegetableList.add("Potato");

        List<String> FreshMeatList = new ArrayList<>();
        FreshMeatList.add("Chicken");
        FreshMeatList.add("Duck");
        FreshMeatList.add("Turkey");

        FreshFoodDetails.put("Fresh Fruit", FreshFruitList);
        FreshFoodDetails.put("Fresh Vegetable", FreshVegetableList);
        FreshFoodDetails.put("Fresh Meat", FreshMeatList);

        return FreshFoodDetails;

    }

}
