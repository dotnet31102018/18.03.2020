package hello.itay.com.demo5;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Itay kan on 3/20/2020.
 */

public class FlightDeleteListener implements View.OnClickListener {

    private FlightCustomAdapter _adapter;
    private Context _context;
    private int _position;
    private ArrayList<Flight> _flights;

    FlightDeleteListener(FlightCustomAdapter adapter, int position, Context context, ArrayList<Flight> flights)
    {
        _adapter = adapter;
        _position = position;
        _context = context;
        _flights = flights;
    }

    @Override
    public void onClick(View view) {

        AlertDialog.Builder b = new AlertDialog.Builder(_context);

        b.setTitle("Delete '" + _flights.get(_position) + "'");

        b.setMessage("Are you sure you want to delete?");

        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                _adapter.remove(_flights.get(_position));
                Toast.makeText(_context, "Deleted", Toast.LENGTH_LONG).show();
            }
        });
        b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Toast.makeText(_context, "Ok, forget about it", Toast.LENGTH_LONG).show();

            }
        });

        //_adapter.remove(_adapter.getItem(_position));

        AlertDialog alert = b.create();
        alert.show();
    }
}
