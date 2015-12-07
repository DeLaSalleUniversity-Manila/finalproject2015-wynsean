package wynsean.freshie;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class DrinksPurchaseActivity extends AppCompatActivity {

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
            name.setText("Coca-Cola");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.coke);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("45.00");
        }

        else if (groupposition == 0 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Pepsi");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.pepsi);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("25.00");
        }

        else if (groupposition == 0 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Rootbeer");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.rootbeer);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("25.00");
        }

        else if (groupposition == 1 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("C2 Iced Tea");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.c2);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("30.00");
        }

        else if (groupposition == 1 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Orange Juice");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.orangejuice);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("60.00");
        }

        else if (groupposition == 1 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Grape Juice");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.grapejuice);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("75.00");
        }

        else if (groupposition == 2 && childposition == 0) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Absolute Bottled Water");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.absolutewater);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("20.00");
        }

        else if (groupposition == 2 && childposition == 1) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Summit");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.summitwater);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("20.00");
        }

        else if (groupposition == 2 && childposition == 2) {
            TextView name = (TextView) findViewById(R.id.textViewPurchaseName);
            name.setText("Nature Spring");

            ImageView photo = (ImageView) findViewById(R.id.imageViewPurchaseWindow);
            photo.setImageResource(R.drawable.naturespringwater);

            TextView price = (TextView) findViewById(R.id.TextViewPurchaseAmount);
            price.setText("15.00");

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

