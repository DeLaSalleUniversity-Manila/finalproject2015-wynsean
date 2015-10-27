package wynsean.freshie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class FreshFruitActivity extends AppCompatActivity {

    LinkedHashMap<String, List<String>> FreshFruit_category;
    List<String> FreshFruit_list;
    ExpandableListView Exp_list;
    FreshFruitAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh_fruit);

        Exp_list = (ExpandableListView) findViewById(R.id.expandableListViewFreshFruit);
        FreshFruit_category = DataProvider.getInfo();
        FreshFruit_list = new ArrayList<>(FreshFruit_category.keySet());
        adapter = new FreshFruitAdapter(this, FreshFruit_category, FreshFruit_list);
        Exp_list.setAdapter(adapter);

        Exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (groupPosition == 3 && childPosition == 5) {
                    startActivity(new Intent(getBaseContext(), StrawberryActivity.class));
                }

                return false;
            }
        });
    }

}
