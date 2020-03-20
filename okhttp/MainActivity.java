package hello.itay.com.demo6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextViewResult = findViewById(R.id.text_view_result);

        // create client
        OkHttpClient client = new OkHttpClient();

        // create a request object
        String url = "http://jsonplaceholder.typicode.com/users/1";

        Request request = new Request.Builder().url(url).build(); // Fluent

        // enqueue - add item to the request queue
        // ANR - Application not responding
        client.newCall(request).enqueue(
                new Callback()  // anonymous class
                {
            @Override
            public void onFailure(Call call, final IOException e) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTextViewResult.setText(e.getMessage());
                    }
                });
            }

            // SUCCESS!!!
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) { // HTTP 200+
                    final String myResponse = response.body().string();

                    // Dispathcer.Invoke(...)
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);
                        }
                    });
                }
                else
                {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(response.toString());
                        }
                    });
                }
            }
        });
    }
}

//        String url = "http://10.0.2.2:58882/api/flights";