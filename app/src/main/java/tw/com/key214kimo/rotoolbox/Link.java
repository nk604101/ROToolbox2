package tw.com.key214kimo.rotoolbox;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Link extends AppCompatActivity {

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
