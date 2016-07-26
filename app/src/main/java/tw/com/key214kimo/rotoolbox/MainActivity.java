package tw.com.key214kimo.rotoolbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        Intent it = new Intent(MainActivity.this, Occupation1.class);//Main2Activity為指定的位置
        startActivityForResult(it, 99);//設定兩個值
    }
    public void click2(View v)
    {
        Intent it = new Intent(MainActivity.this, Numerical.class);//Main2Activity為指定的位置
        startActivityForResult(it, 99);//設定兩個值
    }
    public void click3(View v)
    {
        Intent it = new Intent(MainActivity.this, skill.class);//Main2Activity為指定的位置
        startActivityForResult(it, 99);//設定兩個值
    }
    public void click4(View v)
    {
        Intent it = new Intent(MainActivity.this, Timer.class);//Main2Activity為指定的位置
        startActivityForResult(it, 99);//設定兩個值
    }
    public void click5(View v)
    {
        Intent it = new Intent(MainActivity.this, Link.class);//Main2Activity為指定的位置
        startActivityForResult(it, 99);//設定兩個值
    }
}
