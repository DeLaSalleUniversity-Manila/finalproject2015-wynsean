package wynsean.freshie;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wyndell on 20/10/2015.
 */
public class FreshieDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "freshie"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    FreshieDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

//    private static void insertItem(SQLiteDatabase db, String category, String sub_category_1, String sub_category_2, String product, double price, int stock, int image, String details, double rating) {
//        ContentValues freshieValues = new ContentValues();
//        freshieValues.put("CATEGORY", category);
//        freshieValues.put("SUB_CATEGORY_1", sub_category_1);
//        freshieValues.put("SUB_CATEGORY_2", sub_category_2);
//        freshieValues.put("PRODUCT", product);
//        freshieValues.put("PRICE", price);
//        freshieValues.put("STOCK", stock); // temporarily used as quantity bought by user
//        freshieValues.put("IMAGE", image);
//        freshieValues.put("DETAIL", details);
//        freshieValues.put("RATING", rating);
//        db.insert("FRESHIE", null, freshieValues);
//    }
//
//    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if (oldVersion == 0) {
//            db.execSQL("CREATE TABLE FRESHIE ("
//                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
//                    + "CATEGORY TEXT, "
//                    + "SUB_CATEGORY_1 TEXT, "
//                    + "SUB_CATEGORY_2 TEXT, "
//                    + "PRODUCT TEXT, "
//                    + "PRICE REAL, "
//                    + "STOCK INTEGER, "
//                    + "IMAGE INTEGER, "
//                    + "DETAIL TEXT, "
//                    + "RATING REAL);");
//            insertItem(db, "Fresh Food", "Fresh Fruit", "Berries", "Strawberry", 100.00, 10,
//                    R.drawable.strawberry, "Juicy and Delicious", 4.5);
//        }
//    }

    private static void insertItem(SQLiteDatabase db, String name, int image, int price, int quantity) {
        ContentValues freshieValues = new ContentValues();
        freshieValues.put("NAME", name);
        freshieValues.put("IMAGE", image);
        freshieValues.put("PRICE", price);
        freshieValues.put("QUANTITY", quantity);
        db.insert("FRESHIE", null, freshieValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 0) {
            db.execSQL("CREATE TABLE FRESHIE ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "IMAGE INTEGER, "
                    + "PRICE INTEGER, "
                    + "QUANTITY INTEGER);");

            insertItem(db, "Strawberry", R.drawable.strawberry, 100, 0);
            insertItem(db, "Apple", R.drawable.apple, 30, 0);
            insertItem(db, "Banana", R.drawable.banana, 20, 0);
            insertItem(db, "Broccoli", R.drawable.broccoli, 40, 0);
            insertItem(db, "Tomato", R.drawable.tomato, 30, 0);
            insertItem(db, "Potato", R.drawable.potato, 10, 0);
            insertItem(db, "Chicken", R.drawable.strawberry, 120, 0);
            insertItem(db, "Duck", R.drawable.strawberry, 300, 0);
            insertItem(db, "Turkey", R.drawable.strawberry, 400, 0);

            insertItem(db, "Corned Beef", R.drawable.cornedbeef, 60, 0);
            insertItem(db, "Sardines", R.drawable.cannedsardines, 10, 0);
            insertItem(db, "Tuna", R.drawable.cannedtuna, 20, 0);
            insertItem(db, "Skyflakes", R.drawable.skyflakes, 30, 0);
            insertItem(db, "Oreos", R.drawable.oreo, 100, 0);
            insertItem(db, "Fita", R.drawable.fita, 25, 0);
            insertItem(db, "Cadburry", R.drawable.cadbury, 150, 0);
            insertItem(db, "Hershey's", R.drawable.hersheys, 160, 0);
            insertItem(db, "M&M's", R.drawable.mm, 140, 0);

            insertItem(db, "Steak", R.drawable.steak, 300, 0);
            insertItem(db, "Chicken", R.drawable.chicken, 210, 0);
            insertItem(db, "Pork", R.drawable.pork, 250, 0);
            insertItem(db, "Bangus", R.drawable.bangus, 100, 0);
            insertItem(db, "Salmon", R.drawable.salmon, 350, 0);
            insertItem(db, "Tuna", R.drawable.tuna, 300, 0);
            insertItem(db, "Magnolia", R.drawable.magnoliaicecream, 100, 0);
            insertItem(db, "Magnum", R.drawable.magnumicecream, 170, 0);
            insertItem(db, "Nestle", R.drawable.nestleicecream, 120, 0);

            insertItem(db, "Coca-Cola", R.drawable.coke, 45, 0);
            insertItem(db, "Pepsi", R.drawable.pepsi, 25, 0);
            insertItem(db, "Rootbeer", R.drawable.rootbeer, 25, 0);
            insertItem(db, "C2 Iced Tea", R.drawable.c2, 30, 0);
            insertItem(db, "Orange Juice", R.drawable.orangejuice, 60, 0);
            insertItem(db, "Grape Juice", R.drawable.grapejuice, 75, 0);
            insertItem(db, "Absolute Bottled Water", R.drawable.absolutewater, 20, 0);
            insertItem(db, "Summit", R.drawable.summitwater, 20, 0);
            insertItem(db, "Nature Spring", R.drawable.naturespringwater, 15, 0);
        }
    }
}
