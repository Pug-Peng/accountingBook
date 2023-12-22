package a0912538929a.gmail.week2bookkeeping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;

public class cuteDoggo extends AppCompatActivity {

    final String TAG = this.getClass().getSimpleName();

    ImageView iv;
    final int IMAGE_ONE = 10001;
    final int IMAGE_TWO = 10002;
    final int IMAGE_THREE = 10003;

    final int interval = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cute_doggo);

        uiInit();
    }

    private void uiInit() {
        iv = findViewById(R.id.imageView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //SystemClock.sleep(1000000);

        Message msg = myHandler.obtainMessage();
        msg.what = IMAGE_TWO;
        myHandler.sendMessageDelayed(msg, 500);
    }

    @Override
    protected void onStop() {
        myHandler.removeCallbacksAndMessages(null);
        super.onStop();
    }

    public Handler myHandler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case IMAGE_ONE:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_1);
                    Log.d(TAG, "Image_one:"+ SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_TWO;
                    myHandler.sendMessageDelayed(msg,interval);
                    break;
                case IMAGE_TWO:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_2);
                    Log.d(TAG, "Image_two:"+ SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_THREE;
                    myHandler.sendMessageDelayed(msg,interval);
                    break;
                case IMAGE_THREE:
                    iv.setImageResource(R.drawable.ic_dog_rotate_right_3);
                    Log.d(TAG, "Image_three:"+ SystemClock.elapsedRealtime());
                    msg = this.obtainMessage();
                    msg.what = IMAGE_ONE;
                    myHandler.sendMessageDelayed(msg,interval);
                    break;
            }
        }
    };



}