package a0912538929a.gmail.week2bookkeeping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    Activity cDog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cDog = getActivity();
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_first, container, false);

        uinit(rootview);
        return rootview;



}

    final String TAG = this.getClass().getSimpleName();
    final int IMAGE_ONE = 10001;
    final int IMAGE_TWO = 10002;
    final int IMAGE_THREE = 10003;

    final int interval = 200;
    @Override
    public void onStart() {
        super.onStart();
        Message msg = myHandler.obtainMessage();
        msg.what = IMAGE_TWO;
        myHandler.sendMessageDelayed(msg, 500);
    }

    @Override
    public void onStop() {
        myHandler.removeCallbacksAndMessages(null);
        super.onStop();
    }

    ImageView iv;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View dogoView = view.findViewById(R.id.dogo);
        iv = dogoView.findViewById(R.id.imageView);
    }

    public Handler myHandler = new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(@NonNull Message msg) {
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

    private void uinit(View v) {

    }



//    public void onStart(){
//        super.onStart();
//        Intent intent = new Intent(ccDog, );
//
//    }




}

//import androidx.appcompat.app.AppCompatActivity;
//
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.os.Handler;
//        import android.os.Looper;
//        import android.os.Message;
//        import android.os.SystemClock;
//        import android.util.Log;
//        import android.widget.ImageView;
class CDoggo extends AppCompatActivity {




        final String TAG = this.getClass().getSimpleName();

        ImageView iv;
        final int IMAGE_ONE = 10001;
        final int IMAGE_TWO = 10002;
        final int IMAGE_THREE = 10003;

        final int interval = 200;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_first);

            uiInit();
        }

        private void uiInit () {

            View dogoView = findViewById(R.id.dogo);
            iv = dogoView.findViewById(R.id.imageView);
//        iv = findViewById(R.id.imageView);
        }

        @Override
        protected void onStart () {
            super.onStart();

            //SystemClock.sleep(1000000);

            Message msg = myHandler.obtainMessage();
            msg.what = IMAGE_TWO;
            myHandler.sendMessageDelayed(msg, 500);
        }

        @Override
        protected void onStop () {
            myHandler.removeCallbacksAndMessages(null);
            super.onStop();
        }

        public Handler myHandler = new Handler(Looper.getMainLooper()) {

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case IMAGE_ONE:
                        iv.setImageResource(R.drawable.ic_dog_rotate_right_1);
                        Log.d(TAG, "Image_one:" + SystemClock.elapsedRealtime());
                        msg = this.obtainMessage();
                        msg.what = IMAGE_TWO;
                        myHandler.sendMessageDelayed(msg, interval);
                        break;
                    case IMAGE_TWO:
                        iv.setImageResource(R.drawable.ic_dog_rotate_right_2);
                        Log.d(TAG, "Image_two:" + SystemClock.elapsedRealtime());
                        msg = this.obtainMessage();
                        msg.what = IMAGE_THREE;
                        myHandler.sendMessageDelayed(msg, interval);
                        break;
                    case IMAGE_THREE:
                        iv.setImageResource(R.drawable.ic_dog_rotate_right_3);
                        Log.d(TAG, "Image_three:" + SystemClock.elapsedRealtime());
                        msg = this.obtainMessage();
                        msg.what = IMAGE_ONE;
                        myHandler.sendMessageDelayed(msg, interval);
                        break;
                }
            }
        };



}
