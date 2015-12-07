package wynsean.freshie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class FoodCupboardPurchaseActivity extends AppCompatActivity {

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


        int groupposition = (Integer) getIntent().getExtras().get(GROUPPOSITION);
        int childposition = (Integer) getIntent().getExtras().get(CHILDPOSITION);

        if (groupposition == 0 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Corned Beef");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.cornedbeef);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("60.00");
        }

        else if (groupposition == 0 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Sardines");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.cannedsardines);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("10.00");
        }

        else if (groupposition == 0 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Tuna");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.cannedtuna);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("20.00");
        }

        else if (groupposition == 1 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Skyflakes");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.skyflakes);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("30.00");
        }

        else if (groupposition == 1 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Oreos");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.oreo);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("100.00");
        }

        else if (groupposition == 1 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Fita");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.fita);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("25.00");
        }

        else if (groupposition == 2 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Cadburry");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.cadbury);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("150.00");
        }

        else if (groupposition == 2 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Hershey's");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.hersheys);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("160.00");
        }

        else if (groupposition == 2 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("M&M's");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.mm);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("140.00");
        }

    }

    public void onClickCancel(View view) {
        this.finish();
    }

    public void onClickAdd(View view) {

        TextView textViewName = (TextView) findViewById(R.id.textViewPurchaseName);
        String name = textViewName.getText().toString();

        EditText textViewQuantity = (EditText) findViewById(R.id.editTextTotalQuantity);
        int quantity = Integer.parseInt(textViewQuantity.getText().toString());

        TextView textViewprice = (TextView) findViewById(R.id.TextViewPurchaseAmount);
        String stramount = textViewprice.getText().toString();
        double amount = Double.parseDouble(stramount);
        int totalamount = (int) amount * quantity;

        ReceiptData.addProduct(name);
        ReceiptData.addQuantity(Integer.toString(quantity) + " pcs");
        ReceiptData.addPrice("P" + Integer.toString(totalamount) + ".00");
        ReceiptData.addTOTAL(totalamount);
        Toast toast = Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT);
        toast.show();
        this.finish();
    }
}

