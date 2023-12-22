package a0912538929a.gmail.week2bookkeeping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = this.getClass().getSimpleName();
    static int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count++;

        Log.d(TAG, "enter onCreate(), #" + count);
    }


    @Override
    protected void onStart() {
        super.onStart();
       // findViewById(android.R.id.content).setOnClickListener(this);
        Log.d(TAG, "enter onStart(), #" + count);

        Message msg = myHandler.obtainMessage();

        myHandler.sendMessageDelayed(msg, 500);
    }


    @Override
    protected void onStop() {
        Log.d(TAG, "enter onStop(), #" + count);
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG, "enter onDestroy(), #" + count);
        count--;
        super.onDestroy();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d(TAG, "enter onRestart(), #" + count);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "enter onPause(), #" + count);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "enter onResume(), #" + count);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case android.R.id.content:
                startActivity(new Intent(this, bookkeeping.class));

                overridePendingTransition(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);

                MainActivity.this.finish();
                break;


        }

    }


    //-----------------------------------------------------
    private Handler myHandler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(Message msg){
            startActivity(new Intent(MainActivity.this, bookkeeping.class));

            overridePendingTransition(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
            MainActivity.this.finish();
        }
    };
}


