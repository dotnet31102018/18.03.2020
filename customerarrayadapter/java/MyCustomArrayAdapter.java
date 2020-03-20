package hello.itay.com.demo5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Itay kan on 3/20/2020.
 */

public class MyCustomArrayAdapter extends ArrayAdapter<String> {

    private Context _context;
    private int _resource_layout;
    private ArrayList<String> _objects;

    public MyCustomArrayAdapter(@NonNull Context context, int resource_layout, ArrayList<String> objects) {
        super(context, resource_layout, objects);

        _context = context;
        _resource_layout = resource_layout;
        _objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // take this -- convertView
        View result = convertView;

        // option 1 - view is null
        // option 2 - view is already inflated ( no data guarantee )
        if (result == null)
        {
            result = LayoutInflater.from(_context).inflate(
                    position % 2 == 0 ? _resource_layout : R.layout.my_layout_item_yellow,
                    parent, false);
        }
        TextView tv = result.findViewById(android.R.id.text1);
        tv.setText(_objects.get(position));

        return result;
    }
}
