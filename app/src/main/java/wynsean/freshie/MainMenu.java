package wynsean.freshie;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;


public class MainMenu extends AppCompatActivity {

    public void onClickHelpButton(View v){
        Intent i = new Intent(this, HelpActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        GridView gridView = (GridView)findViewById(R.id.gridviewCategories);
        gridView.setAdapter(new MyAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(getApplicationContext(), FreshFoodActivity.class);
                    startActivity(i);
                } else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(), FoodCupboardActivity.class);
                    startActivity(i);
                } else if (position == 2) {
                    Intent i = new Intent(getApplicationContext(), FrozenFoodActivity.class);
                    startActivity(i);
                } else if (position == 3) {
                    Intent i = new Intent(getApplicationContext(), DrinksActivity.class);
                    startActivity(i);
                } else if (position == 4) {
                    Intent i = new Intent(getApplicationContext(), HealthandBeautyActivity.class);
                    startActivity(i);
                } else if (position == 5) {
                    Intent i = new Intent(getApplicationContext(), HouseholdActivity.class);
                    startActivity(i);
                }
            }
        });


    }
}
