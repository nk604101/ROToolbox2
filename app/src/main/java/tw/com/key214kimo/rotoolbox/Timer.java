package tw.com.key214kimo.rotoolbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Timer extends AppCompatActivity {

    Spinner spinner5;
    Spinner spinner6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        String fruits5[] = {"MVP重生時間", "副本CD時間", "生命體餵食時間", "艾可拉珠 BUFF", "詩人歌唱時間", "對話時間"};
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(Timer.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits5);
        spinner5.setAdapter(adapter5);
        String fruits6[] = {"[M] 獸人英雄", "[M] 蟻后", "[M] 獸人酋長"};
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(Timer.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits6);

        spinner6.setAdapter(adapter6);
    }
}
