package tw.com.key214kimo.rotoolbox;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Link extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 0, Menu.NONE, "首頁");
        menu.add(0, 1, Menu.NONE, "職業介紹");
        menu.add(0, 2, Menu.NONE, "數值計算機");
        menu.add(0, 3, Menu.NONE, "技能模擬器");
        menu.add(0, 4, Menu.NONE, "計時器");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == 0) {
            Intent it = new Intent(Link.this, MainActivity.class);
            startActivityForResult(it, 99);
        }

        if (id == 1) {
            Intent it = new Intent(Link.this, Occupation1.class);
            startActivityForResult(it, 99);
        }
        if (id == 2) {
            Intent it = new Intent(Link.this, Numerical.class);
            startActivityForResult(it, 99);
        }

        if (id == 3) {
            Intent it = new Intent(Link.this, skill.class);
            startActivityForResult(it, 99);
        }
        if (id == 4) {
            Intent it = new Intent(Link.this, Timer.class);
            startActivityForResult(it, 99);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
    }
    public void click1 (View v)
    {
        Uri uri = Uri.parse("http://ro.gnjoy.com.tw/notice/notice_list.aspx");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    public void click2 (View v)
    {
        Uri uri = Uri.parse("http://forum.gamer.com.tw/B.php?bsn=04212&subbsn=0");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

}
