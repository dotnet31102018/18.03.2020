package hello.itay.com.demo5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;


/**
 * Created by Itay kan on 3/18/2020.
 */

public class DeleteOnClickListener implements View.OnClickListener{

    private MyArrayAdapter _adapter;
    private int _position;

    public DeleteOnClickListener(MyArrayAdapter adapter, int position)
    {
        _adapter = adapter;
        _position = position;
    }

    @Override
    public void onClick(View view) {

        AlertDialog.Builder b = new AlertDialog.Builder(_adapter._context);

        b.setTitle("Delete '" + _adapter._objects.get(_position) + "'");
        b.setMessage("Are you sure you want to delete?");
        b.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                _adapter.remove(_adapter._objects.get(_position));
                Toast.makeText(_adapter._context, "Deleted", Toast.LENGTH_LONG).show();
            }
        });
        b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(_adapter._context, "Ok, forget about it", Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });

        AlertDialog alert = b.create();
        alert.show();

    }
}