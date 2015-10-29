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

    private static void insertItem(SQLiteDatabase db, String category, String sub_category_1, String sub_category_2, String product, double price, int stock, int image, String details, double rating) {
        ContentValues freshieValues = new ContentValues();
        freshieValues.put("CATEGORY", category);
        freshieValues.put("SUB_CATEGORY_1", sub_category_1);
        freshieValues.put("SUB_CATEGORY_2", sub_category_2);
        freshieValues.put("PRODUCT", product);
        freshieValues.put("PRICE", price);
        freshieValues.put("STOCK", stock);
        freshieValues.put("IMAGE", image);
        freshieValues.put("DETAIL", details);
        freshieValues.put("RATING", rating);
        db.insert("FRESHIE", null, freshieValues);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 0) {
            db.execSQL("CREATE TABLE FRESHIE ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "CATEGORY TEXT, "
                    + "SUB_CATEGORY_1 TEXT, "
                    + "SUB_CATEGORY_2 TEXT, "
                    + "PRODUCT TEXT, "
                    + "PRICE REAL, "
                    + "STOCK INTEGER, "
                    + "IMAGE INTEGER, "
                    + "DETAIL TEXT, "
                    + "RATING REAL);");
            insertItem(db, "Fresh Food", "Fresh Fruit", "Berries", "Strawberry", 100.00, 10,
                    R.drawable.strawberry, "Juicy and Delicious", 4.5);
        }
    }
}
