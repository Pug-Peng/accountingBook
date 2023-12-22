package a0912538929a.gmail.week2bookkeeping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class bookkeeping extends AppCompatActivity implements View.OnClickListener{

    final String TAG = this.getClass().getSimpleName();
    static int count = 0;
    TextView theDate, theTime;
    Button btsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_constraintlayout);

        uiInit();
        count ++;
        Log.d(TAG, "enter onCreate(), #" + count);

    }

    private void uiInit() {
        theDate = findViewById(R.id.textView6);
        theTime = findViewById(R.id.textView7);

        btsave = findViewById(R.id.button3);

    }

    @Override
    protected void onStart() {
        super.onStart();

        varInit();
        setListener();
        Log.d(TAG, "enter onStart(), #" + count);
    }

    private void varInit() {
    }

    private void setListener() {

        theDate.setOnClickListener(this);
        theTime.setOnClickListener(this);

        btsave.setOnClickListener(this);

    }

    @Override
    protected void onStop() {
        Log.d(TAG, "enter onStop(), #" + count);
        releaseListener();
        super.onStop();
    }

    private void releaseListener() {
        theDate.setOnClickListener(null);
        theTime.setOnClickListener(null);
        btsave.setOnClickListener(null);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "enter onDestroy(), #" + count);
        count --;
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
        switch (view.getId()){
            case R.id.button3:
                //帳務資料儲存

                //返回主畫面
                bookkeeping.this.finish();
                break;
        }

    }
    private Handler myHandler = new Handler(Looper.getMainLooper()){

//        @Override
//        public void handleMessage(Message msg){
//            startActivity(new Intent(bookkeeping.this, FirstFragment.class));
//
//            overridePendingTransition(android.R.anim.slide_in_left,
//                    android.R.anim.slide_out_right);
//            bookkeeping.this.finish();
//        }
    };
};
