package wynsean.freshie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class DataProvider {

    public static LinkedHashMap<String, List<String>> getInfo() {

        LinkedHashMap<String, List<String>> FreshFruitDetails = new LinkedHashMap<String, List<String>>();

        List<String> AppleList = new ArrayList<>();
        AppleList.add("Fuji Apple");
        AppleList.add("Washington Apple");
        AppleList.add("Green Apple");

        List<String> AvocadoList = new ArrayList<>();
        AvocadoList.add("Item 1");
        AvocadoList.add("Item 2");
        AvocadoList.add("Item 3");

        List<String> BananaList = new ArrayList<>();
        BananaList.add("Item 1");
        BananaList.add("Item 2");
        BananaList.add("Item 3");

        List<String> BerryList = new ArrayList<>();
        BerryList.add("Acai Berry");
        BerryList.add("Blackberry");
        BerryList.add("Blueberry");
        BerryList.add("Cherry");
        BerryList.add("Goji Berry");
        BerryList.add("Strawberry");
        BerryList.add("Raspberry");

        FreshFruitDetails.put("Apples", AppleList);
        FreshFruitDetails.put("Avocados", AvocadoList);
        FreshFruitDetails.put("Banana", BananaList);
        FreshFruitDetails.put("Berries", BerryList);

        return FreshFruitDetails;

    }

}
