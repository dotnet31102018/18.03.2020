package hello.itay.com.demo5;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Itay kan on 3/18/2020.
 */

public class FlightAdapter extends ArrayAdapter<Flight> {

    Context _context;
    int _layout;
    ArrayList<Flight> _objects;

    public FlightAdapter(Context context, int layout, ArrayList<Flight> objects) {
        super(context, layout, objects); // not much meaning ...
        _context = context;
        _layout = layout;
        _objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("=============", "Get view for " + position);

        //return super.getView(position, convertView, parent);

        // position
        // convert view -- current view
        // parent ViewGroup

        View result = convertView;

        // option 1 - view is null
        // option 2 - view is already inflated ( no data guarantee )

        if (result == null)
        {
            Log.d("=======", "Drawing " + position);

            // draw the current view in two options:
            // if is even -- draw using the android layout (white)
            // if is odd -- draw using our layout (colored)
//            result = LayoutInflater.from(_context).inflate(
//                    position % 2 == 0 ? android.R.layout.simple_list_item_1 : R.layout.my_layout_item_yellow,
//                    parent, false);

            result = LayoutInflater.from(_context).inflate(
                    R.layout.flight_item_layout,
                    parent, false);
        }
        TextView tv = result.findViewById(R.id.idtxt);
        tv.setText(_objects.get(position).Id);

        TextView comp = result.findViewById(R.id.comptxt);
        comp.setText(_objects.get(position).Company);

        TextView orig = result.findViewById(R.id.origtxt);
        orig.setText(_objects.get(position).Origin);

        ImageView img = result.findViewById(R.id.img);
        img.setImageResource(_objects.get(position).ImageResourceId);
        //result.setOnClickListener(new DeleteOnClickListener(this, position));

        return result;

    }
}