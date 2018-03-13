package jp.techacademy.kenzou.nakase.aisatsuapp;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView textView= (TextView) findViewById(R.id.textView);
                        if (hourOfDay >= 2 && hourOfDay <= 9) {
                            textView.setText("おはよう、" + "時刻は" + hourOfDay + "時" + String.format("%02d", minute) + "分です。");
                        } else if (hourOfDay >= 10 && hourOfDay <= 17) {
                            textView.setText("こんにちは、" + "時刻は" + hourOfDay + "時" + String.format("%02d", minute) + "分です。");
                        } else if (hourOfDay <= 24 || hourOfDay == 1) {
                            textView.setText("こんばんは、" + "時刻は" + hourOfDay + "時" + String.format("%02d", minute) + "分です。");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }


}
