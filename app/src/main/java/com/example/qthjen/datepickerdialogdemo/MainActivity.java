package com.example.qthjen.datepickerdialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseDate();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseTime();
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void ChooseDate() {

        final Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                /** i = year, i1 = month, i2 = date **/
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                et.setText(simpleDateFormat.format(calendar.getTime()));
            }
        } , year, month , date);
        datePickerDialog.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void ChooseTime() {

        final Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR);
        int phut = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {

                /** i = gio, i1 = phut **/
                calendar.set(0,0,0,i,i1);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
                tv.setText(simpleDateFormat1.format(calendar.getTime()));

            }
        } , gio, phut, true); // true là bật định dạng 24 giờ
        timePickerDialog.show();

    }

}
