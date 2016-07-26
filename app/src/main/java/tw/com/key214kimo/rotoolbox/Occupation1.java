package tw.com.key214kimo.rotoolbox;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class Occupation1 extends AppCompatActivity {
    Spinner spinner;
    Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupation1);

        String fruits[] = {"初學者", "劍　士", "魔法師", "服　事", "盜　賊", "商　人", "弓箭手", "跆拳家", "忍　者", "神槍手"};
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Occupation1.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits);
        spinner.setAdapter(adapter);

        String fruits2[] = {"騎　士", "騎士領主", "盧恩騎士"};
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Occupation1.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits2);
        spinner2.setAdapter(adapter2);
}
}
