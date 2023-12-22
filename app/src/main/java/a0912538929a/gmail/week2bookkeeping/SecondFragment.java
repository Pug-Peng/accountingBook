package a0912538929a.gmail.week2bookkeeping;

import static java.util.Calendar.MINUTE;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FourthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    //設定日期的格式
    SimpleDateFormat df = new SimpleDateFormat("hh a", Locale.US);
    //設定時間顯示的格式

    Calendar c;



    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FourthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        uninit(rootView);
        return rootView;
    }

    private void uninit(View rootView) {
        btsave = rootView.findViewById(R.id.button3);

        theDate = rootView.findViewById(R.id.textView6);
        theTime = rootView.findViewById(R.id.textView7);
    }

    private void varInit(){
        c = Calendar.getInstance();

        theDate.setText(df2.format(c.getTime()));
        theTime.setText(df.format(c.getTime()));
    }



    final String TAG = this.getClass().getSimpleName();
    static int count = 0;
    TextView theDate, theTime;
    Button btsave;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        View bb = view.findViewById(R.id.b);
        theDate = bb.findViewById(R.id.textView6);
        theTime = bb.findViewById(R.id.textView7);

        btsave = bb.findViewById(R.id.button3);
    }

    @Override
    public void onStart() {
        super.onStart();

        varInit();
        setListener();
        Log.d(TAG, "enter onStart(), #" + count);
    }

    private void setListener() {
        theDate.setOnClickListener(this);
        theTime.setOnClickListener(this);

        btsave.setOnClickListener(this);
    }

    @Override
    public void onStop() {
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
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button3:
                //帳務資料儲存

                //返回主畫面
                getActivity().finish();
                break;
            case R.id.textView6:
                //設定日期
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        c.set(Calendar.YEAR, year);
                        c.set(Calendar.MONTH, month);
                        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        theDate.setText(df2.format(c.getTime()));
                    }
                }, c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

                break;
            case  R.id.textView7:
                //設定時間
                new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(MINUTE, minute);
                        theTime.setText(df.format(c.getTime()));
                    }
                }, c.get(Calendar.HOUR_OF_DAY), c.get(MINUTE), true
                ).show();

                break;
        }

    }


//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.button3:
//                //帳務資料儲存
//
//                //返回主畫面
//                Tab.this.finish();
//                break;
//        }
//
//    }



}
