package tw.com.key214kimo.rotoolbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Timer extends AppCompatActivity {

    Spinner spinner5;
    Spinner spinner6;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 0, Menu.NONE, "首頁");
        menu.add(0, 1, Menu.NONE, "職業介紹");
        menu.add(0, 2, Menu.NONE, "數值計算機");
        menu.add(0, 3, Menu.NONE, "技能模擬器");
        menu.add(0, 4, Menu.NONE, "網站連結");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == 0) {
            Intent it = new Intent(Timer.this, MainActivity.class);
            startActivityForResult(it, 99);
        }

        if (id == 1) {
            Intent it = new Intent(Timer.this, Occupation1.class);
            startActivityForResult(it, 99);
        }
        if (id == 2) {
            Intent it = new Intent(Timer.this, Numerical.class);
            startActivityForResult(it, 99);
        }

        if (id == 3) {
            Intent it = new Intent(Timer.this, skill.class);
            startActivityForResult(it, 99);
        }
        if (id == 4) {
            Intent it = new Intent(Timer.this, Link.class);
            startActivityForResult(it, 99);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        String fruits5[] = {"MVP重生時間", "副本CD時間", "生命體餵食時間", "艾可拉珠 BUFF", "詩人歌唱時間", "對話時間"};
        spinner5 = (Spinner) findViewById(R.id.agi);
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
