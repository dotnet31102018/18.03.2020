package hello.itay.com.demo5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mobileArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("1", "El AL", "ISRAEL", R.drawable.elal));
        flights.add(new Flight("2", "AIR FRANCE", "FRANCE", R.drawable.airf));
        flights.add(new Flight("4", "SWISS", "JAMEIKA", R.drawable.swiss));

        final ArrayAdapter adapter = new FlightCustomAdapter(this, R.layout.flight_item_layout, flights);

        ListView lv = findViewById(R.id.mobileList);
        lv.setAdapter(adapter);


    }
}
