package wynsean.freshie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class FrozenFoodDataProvider {

    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> FreshFoodDetails = new LinkedHashMap<String, List<String>>();

        List<String> FreshFruitList = new ArrayList<>();
        FreshFruitList.add("Steak");
        FreshFruitList.add("Chicken");
        FreshFruitList.add("Pork");

        List<String> FreshVegetableList = new ArrayList<>();
        FreshVegetableList.add("Bangus");
        FreshVegetableList.add("Salmon");
        FreshVegetableList.add("Tuna");

        List<String> FreshMeatList = new ArrayList<>();
        FreshMeatList.add("Magnolia");
        FreshMeatList.add("Magnum");
        FreshMeatList.add("Nestle");

        FreshFoodDetails.put("Frozen Meat and Poultry", FreshFruitList);
        FreshFoodDetails.put("Frozen Fish and Seafood", FreshVegetableList);
        FreshFoodDetails.put("Ice Cream and Frozen Yoghurt", FreshMeatList);

        return FreshFoodDetails;

    }

}
