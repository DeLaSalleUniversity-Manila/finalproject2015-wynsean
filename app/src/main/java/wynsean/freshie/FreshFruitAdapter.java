package wynsean.freshie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Wyndell on 09/10/2015.
 */
public class FreshFruitAdapter extends BaseExpandableListAdapter{

    private Context ctx;
    private LinkedHashMap<String, List<String>> FreshFruit_Category;
    private List<String> FreshFruit_List;

    public FreshFruitAdapter(Context ctx, LinkedHashMap<String, List<String>> FreshFruit_Category, List<String> FreshFruit_List) {

        this.ctx = ctx;
        this.FreshFruit_Category = FreshFruit_Category;
        this.FreshFruit_List = FreshFruit_List;
    }

    @Override
    public Object getChild(int parent, int child) {

        return FreshFruit_Category.get(FreshFruit_List.get(parent)).get(child);
    }

    @Override
    public long getChildId(int parent, int child) {

        return child;
    }

    @Override
    public View getChildView(int parent, int child, boolean isLastChild, View convertview, ViewGroup parentview) {

        String child_title = (String) getChild(parent, child);
        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.child_layout, parentview, false);
        }
        TextView child_textview = (TextView) convertview.findViewById(R.id.textViewChild);
        child_textview.setText(child_title);

        return convertview;
    }

    @Override
    public int getChildrenCount(int arg0) {
        return FreshFruit_Category.get(FreshFruit_List.get(arg0)).size();
    }

    @Override
    public Object getGroup(int arg0) {

        return FreshFruit_List.get(arg0);
    }

    @Override
    public int getGroupCount() {

        return FreshFruit_List.size();
    }

    @Override
    public long getGroupId(int arg0) {

        return arg0;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
        String group_title = (String) getGroup(parent);
        if (convertview == null) {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflator.inflate(R.layout.parent_layout, parentview, false);
        }
        TextView parent_textview = (TextView) convertview.findViewById(R.id.textViewParent);
        parent_textview.setText(group_title);
        return convertview;
    }

    @Override
    public boolean hasStableIds() {

        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {

        return true;
    }

}
