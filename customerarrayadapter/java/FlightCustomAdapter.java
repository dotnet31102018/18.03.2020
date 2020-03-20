package hello.itay.com.demo5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Itay kan on 3/20/2020.
 */

public class FlightCustomAdapter extends ArrayAdapter<Flight> {

    private Context _context;
    private int _resource_layout;
    private ArrayList<Flight> _objects;

    public FlightCustomAdapter(@NonNull Context context, int resource_layout, ArrayList<Flight> objects) {
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
                    _resource_layout,
                    parent, false);
        }
        TextView idtv = result.findViewById(R.id.idtxt);
        idtv.setText(_objects.get(position).Id);
        TextView comptv = result.findViewById(R.id.comptxt);
        comptv.setText(_objects.get(position).Company);
        TextView ortv = result.findViewById(R.id.origtxt);
        ortv.setText(_objects.get(position).Origin);

        ImageView imgv = result.findViewById(R.id.img);
        imgv.setImageResource(_objects.get(position).ImageResourceId);

        result.setOnClickListener(new FlightDeleteListener(this, position, _context, _objects));

        return result;
    }
}