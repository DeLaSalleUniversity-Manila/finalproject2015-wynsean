/**
 * Created by Wyndell on 07/10/2015.
 */
package wynsean.freshie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wynsean.freshie.R;

/**
 * Created by Wyndell on 07/10/2015.
 */
public final class MyAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item("Fresh Food",       R.drawable.freshfoodpic));
        mItems.add(new Item("Food Cupboard",   R.drawable.foodcupboardpic));
        mItems.add(new Item("Frozen Food", R.drawable.frozenfoodpic));
        mItems.add(new Item("Drinks",      R.drawable.drinkspic));
//        mItems.add(new Item("Health and Beauty",     R.drawable.healthandbeautypic));
//        mItems.add(new Item("Household",      R.drawable.householdpic));
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.gridview_item, viewGroup, false);
            v.setTag(R.id.grid_picture, v.findViewById(R.id.grid_picture));
            v.setTag(R.id.grid_text, v.findViewById(R.id.grid_text));
        }

        picture = (ImageView) v.getTag(R.id.grid_picture);
        name = (TextView) v.getTag(R.id.grid_text);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}