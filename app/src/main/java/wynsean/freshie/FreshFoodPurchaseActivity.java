package wynsean.freshie;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class FreshFoodPurchaseActivity extends AppCompatActivity {

    public static final String GROUPPOSITION = "groupposition";
    public static final String CHILDPOSITION = "childposition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));

        //Create a cursor
//        try {
//            SQLiteOpenHelper freshieDatabaseHelper = new FreshieDatabaseHelper(this);
//            SQLiteDatabase db = freshieDatabaseHelper.getReadableDatabase();
//            Cursor cursor = db.query("FRESHIE",
//                    new String[]{"CATEGORY", "SUB_CATEGORY_1", "SUB_CATEGORY_2", "PRODUCT", "PRICE", "STOCK", "IMAGE", "DETAIL", "RATING"}, null,
//                    null, null, null, null);
//
//            //Move to the first record in the Cursor
//            if (cursor.moveToFirst()) {
//                //Get the drink details from the cursor
//                String nameText = cursor.getString(3);
//                int photoId = cursor.getInt(6);
//                //Populate the drink name
//                TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
//                name.setText(nameText);
//
//                //Populate the drink image
//                ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
//                photo.setImageResource(photoId);
//            }
//            cursor.close();
//            db.close();
//        } catch (SQLiteException e) {
//            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
//        }


        int groupposition = (Integer) getIntent().getExtras().get(GROUPPOSITION);
        int childposition = (Integer) getIntent().getExtras().get(CHILDPOSITION);

        if (groupposition == 0 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Strawberry");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.strawberry);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("100.00");
        } else if (groupposition == 0 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Apple");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.apple);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("30.00");
        } else if (groupposition == 0 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Banana");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.banana);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("20.00");
        } else if (groupposition == 1 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Broccoli");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.broccoli);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("40.00");
        } else if (groupposition == 1 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Tomato");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.tomato);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("30.00");
        } else if (groupposition == 1 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Potato");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.potato);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("10.00");
        } else if (groupposition == 2 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Chicken");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.chicken);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("120.00");
        } else if (groupposition == 2 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Duck");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.duck);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("300.00");
        } else if (groupposition == 2 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Turkey");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.turkey);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("400.00");
        }

    }

    public void onClickCancel(View view) {
        this.finish();
    }

    public void onClickAdd(View view) {
//        TextView textViewName = (TextView) findViewById(R.id.textViewPurchaseName);
//        String name = (String) textViewName.getText();
//
//        TextView textViewQuantity = (TextView) findViewById(R.id.TextViewPurchaseWindowQuantity);
//        int quantity = Integer.parseInt((String) textViewQuantity.getText());
//
//        SQLiteOpenHelper freshieDatabaseHelper = new FreshieDatabaseHelper(this);
//        SQLiteDatabase db = freshieDatabaseHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(name, quantity);
//        db.close(); // Closing database connection


        TextView textViewName = (TextView) findViewById(R.id.textViewPurchaseName);
        String name = textViewName.getText().toString();

        EditText textViewQuantity = (EditText) findViewById(R.id.editTextTotalQuantity);
        int quantity = Integer.parseInt(textViewQuantity.getText().toString());

        TextView textViewprice = (TextView) findViewById(R.id.TextViewPurchaseAmount);
        String stramount = textViewprice.getText().toString();
        double amount = Double.parseDouble(stramount);
        int totalamount = (int) amount * quantity;

//        ReceiptData receipt = new ReceiptData();
        ReceiptData.addProduct(name);
        ReceiptData.addQuantity(Integer.toString(quantity) + " pcs");
        ReceiptData.addPrice("P" + Integer.toString(totalamount) + ".00");
        ReceiptData.addTOTAL(totalamount);
//        int size = ReceiptData.getList().size();
//        String strsize = Integer.toString(size);
        Toast toast = Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT);
        toast.show();
        this.finish();
    }

}
