package tw.com.key214kimo.rotoolbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class skill extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 0, Menu.NONE, "首頁");
        menu.add(0, 1, Menu.NONE, "職業介紹");
        menu.add(0, 2, Menu.NONE, "數值計算機");
        menu.add(0, 3, Menu.NONE, "計時器");
        menu.add(0, 4, Menu.NONE, "網站連結");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == 0) {
            Intent it = new Intent(skill.this, MainActivity.class);
            startActivityForResult(it, 99);
        }

        if (id == 1) {
            Intent it = new Intent(skill.this, Occupation1.class);
            startActivityForResult(it, 99);
        }
        if (id == 2) {
            Intent it = new Intent(skill.this, Numerical.class);
            startActivityForResult(it, 99);
        }

        if (id == 3) {
            Intent it = new Intent(skill.this, Timer.class);
            startActivityForResult(it, 99);
        }
        if (id == 4) {
            Intent it = new Intent(skill.this, Link.class);
            startActivityForResult(it, 99);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
    }
}
