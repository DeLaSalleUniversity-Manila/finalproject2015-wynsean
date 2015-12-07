package wynsean.freshie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class FoodCupboardDataProvider {

    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> FreshFoodDetails = new LinkedHashMap<String, List<String>>();

        List<String> CansList = new ArrayList<>();
        CansList.add("Corned Beef");
        CansList.add("Sardines");
        CansList.add("Tuna");

        List<String> BiscuitsList = new ArrayList<>();
        BiscuitsList.add("Skyflakes");
        BiscuitsList.add("Oreos");
        BiscuitsList.add("Fita");

        List<String> ChocoList = new ArrayList<>();
        ChocoList.add("Cadburry");
        ChocoList.add("Hershey's");
        ChocoList.add("M&Ms");

        FreshFoodDetails.put("Tins, Cans, and Packets", CansList);
        FreshFoodDetails.put("Biscuits", BiscuitsList);
        FreshFoodDetails.put("Chocolate", ChocoList);

        return FreshFoodDetails;

    }

}
