package wynsean.freshie;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

//        ReceiptData receipt = new ReceiptData();

//        String summary = "";
//
//        for (int i = 0; i < receipt.getList().size(); i++) {
//            summary = summary + receipt.getList().get(i) + "\n";
//        }

//        TextView tvtotalprice = (TextView) findViewById(R.id.TextViewTotalPriceFinal);
//        tvtotalprice.setText("Total Price: " + Integer.toString(ReceiptData.getTOTAL()));
//        setCart();


        TableLayout tablelayout = (TableLayout) findViewById(R.id.TableLayout);

        for(int i=0; i<ReceiptData.getSize(); i++)
        {
            TableRow tR = new TableRow(this);
            tR.setPadding(5, 5, 5, 5);

            LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);

            TextView tV_txt1 = new TextView(this);
            TextView tV_txt2 = new TextView(this);
            TextView tV_txt3 = new TextView(this);


            tV_txt1.setText(ReceiptData.getListProduct(i));
            tV_txt1.setLayoutParams(params);
            tV_txt1.setTextSize(15);

            tV_txt2.setText(ReceiptData.getListQuantity(i));
            tV_txt2.setLayoutParams(params);
//            tV_txt2.setPadding(70, 0, 0, 0);
            tV_txt2.setTextSize(15);

            tV_txt3.setText(ReceiptData.getListPrice(i));
            tV_txt3.setLayoutParams(params);
//            tV_txt3.setPadding(100, 0, 0, 0);
            tV_txt3.setTextSize(15);

            tR.addView(tV_txt1);
            tR.addView(tV_txt2);
            tR.addView(tV_txt3);

            tablelayout.addView(tR);
        }

        TextView tV_txt4 = new TextView(this);
        tV_txt4.setText("Total Amount:\t\tP" + ReceiptData.getTOTAL() + ".00");
        tV_txt4.setPadding(5, 50, 0, 0);
        tV_txt4.setTextSize(15);

        tablelayout.addView(tV_txt4);
    }

//    public void setCart(){
//        String[] items = {"eggs", "chicken", "butter", "strawberry", "bread", "cookies"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cartitems, ReceiptData.getList());
//        ListView list = (ListView) findViewById(R.id.ListViewCart);
//        list.setAdapter(adapter);
//    }
}
