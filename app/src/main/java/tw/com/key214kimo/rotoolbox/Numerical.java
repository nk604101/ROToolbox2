package tw.com.key214kimo.rotoolbox;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Numerical extends AppCompatActivity {

    Spinner spinner3;
    Spinner spinner4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical);

        String fruits[] = {"初學者", "劍　士", "魔法師", "服　事", "盜　賊", "商　人", "弓箭手", "跆拳家", "忍　者", "神槍手"};
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits);
        spinner3.setAdapter(adapter3);
        String fruits2[] = {"騎　士", "騎士領主", "盧恩騎士"};
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits2);

        spinner4.setAdapter(adapter4);
    }
}