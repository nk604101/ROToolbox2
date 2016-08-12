package tw.com.key214kimo.rotoolbox;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Numerical extends AppCompatActivity {
    Spinner spinner;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;

    //
    String str[],ID;
    float para1[];
    int HandUsed[];


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        ROASlist list = new ROASlist(Numerical.this);

        ArrayList<ROASlist> MList=list.DataList();
        SubMenu[] menuList= new SubMenu[10];
        Log.d("T0812",""+MList.get(1).SID);

        for(int i=0;i<11;i++)
        {
            //Log.d("T0812-menu","[i:for1]:"+i);
            for (int j=0; j<MList.size();j++)
            {
                //Log.d("T0812-menu","[j:for2]:"+j+",[size]"+MList.size());
                int Sid=Integer.parseInt(MList.get(j).SID);
                if((Sid/1000000)==i+1)
                {
                    menuList[i] = menu.addSubMenu(0, i, Menu.NONE, MList.get(j).ID);
                    //Log.d("T0812-menu","["+i+"]:"+menuList[i]);
                    break;
                    //menu.setGroupCheckable(1, true, true);
                }
            }
        }


        for(int i=0; i<10;i++)
        {
            int GupID=i+1;
            int itemID=0;
            for(int j=0; j<MList.size();j++)
            {
                int Sid=Integer.parseInt(MList.get(j).SID);

                if ((Sid / 1000000) == i+1)
                {
                    if(((Sid%1000000)/10000)==1 && ((Sid%10000)/100)==1)
                    {
                        menuList[i].add(500, 500, Menu.NONE,"2-1職業");
                        //menuList[itemID].

                    }
                    if(((Sid%1000000)/10000)==2 && ((Sid%10000)/100)==1)
                    {
                        menuList[i].add(500, 500, Menu.NONE,"2-2職業");

                    }
                    menuList[i].add(i+10, itemID, Menu.NONE, MList.get(j).ID);
                    //menuList[i].setGroupCheckable(GupID, true, true);
                    itemID++;
                }
                menuList[i].setGroupEnabled(500,false);
            }
            //menuList[i].setGroupCheckable(GupID, true, true);
        }

        /*
        SubMenu menu1 = menu.addSubMenu(0, 0, Menu.NONE, "初學者");
        SubMenu menu2 = menu.addSubMenu(0, 1, Menu.NONE, "劍　士");
        SubMenu menu3 = menu.addSubMenu(0, 2, Menu.NONE, "魔法師");
        SubMenu menu4 = menu.addSubMenu(0, 3, Menu.NONE, "商　人");
        SubMenu menu5 = menu.addSubMenu(0, 4, Menu.NONE, "盜　賊");
        SubMenu menu6 = menu.addSubMenu(0, 5, Menu.NONE, "服　事");
        SubMenu menu7 = menu.addSubMenu(0, 6, Menu.NONE, "弓箭手");
        SubMenu menu8 = menu.addSubMenu(0, 7, Menu.NONE, "跆拳家");
        SubMenu menu9 = menu.addSubMenu(0, 8, Menu.NONE, "忍　者");
        SubMenu menu10 = menu.addSubMenu(0, 9, Menu.NONE, "神槍手");

        menu1.add(1, 0, Menu.NONE, "超級初學者");
        menu1.add(1, 1, Menu.NONE, "超級初學者等級突破");
        menu1.setGroupCheckable(1, true, true);

        menu2.add(2, 0, Menu.NONE, "2-1職業");
        menu2.add(2, 1, Menu.NONE, "騎　士");
        menu2.add(2, 2, Menu.NONE, "騎士領主");
        menu2.add(2, 3, Menu.NONE, "盧恩騎士");
        menu2.add(2, 4, Menu.NONE, "2-2職業");
        menu2.add(2, 5, Menu.NONE, "十字軍");
        menu2.add(2, 6, Menu.NONE, "聖殿十字軍");
        menu2.add(2, 7, Menu.NONE, "皇家禁衛隊");
        menu2.setGroupCheckable(2, true, true);

        menu3.add(3, 0, Menu.NONE, "2-1職業");
        menu3.add(3, 1, Menu.NONE, "巫　師");
        menu3.add(3, 2, Menu.NONE, "超魔導師");
        menu3.add(3, 3, Menu.NONE, "咒術士");
        menu3.add(3, 4, Menu.NONE, "2-2職業");
        menu3.add(3, 5, Menu.NONE, "賢　者");
        menu3.add(3, 6, Menu.NONE, "智　者");
        menu3.add(3, 7, Menu.NONE, "妖術師");
        menu3.setGroupCheckable(3, true, true);

        menu4.add(4, 0, Menu.NONE, "2-1職業");
        menu4.add(4, 1, Menu.NONE, "鐵　匠");
        menu4.add(4, 2, Menu.NONE, "神工匠");
        menu4.add(4, 3, Menu.NONE, "機械工匠");
        menu4.add(4, 4, Menu.NONE, "2-2職業");
        menu4.add(4, 5, Menu.NONE, "鍊金術師");
        menu4.add(4, 6, Menu.NONE, "創造者");
        menu4.add(4, 7, Menu.NONE, "基因學者");
        menu4.setGroupCheckable(4, true, true);

        menu5.add(5, 0, Menu.NONE, "2-1職業");
        menu5.add(5, 1, Menu.NONE, "刺　客");
        menu5.add(5, 2, Menu.NONE, "十字刺客");
        menu5.add(5, 3, Menu.NONE, "十字斬首者");
        menu5.add(5, 4, Menu.NONE, "2-2職業");
        menu5.add(5, 5, Menu.NONE, "流　氓");
        menu5.add(5, 6, Menu.NONE, "神行太保");
        menu5.add(5, 7, Menu.NONE, "魅影追蹤者");
        menu5.setGroupCheckable(5, true, true);

        menu6.add(6, 0, Menu.NONE, "2-1職業");
        menu6.add(6, 1, Menu.NONE, "祭　司");
        menu6.add(6, 2, Menu.NONE, "神　官");
        menu6.add(6, 3, Menu.NONE, "大主教");
        menu6.add(6, 4, Menu.NONE, "2-2職業");
        menu6.add(6, 5, Menu.NONE, "武道家");
        menu6.add(6, 6, Menu.NONE, "武術宗師");
        menu6.add(6, 7, Menu.NONE, "修　羅");
        menu6.setGroupCheckable(6, true, true);

        menu7.add(7, 0, Menu.NONE, "2-1職業");
        menu7.add(7, 1, Menu.NONE, "獵　人");
        menu7.add(7, 2, Menu.NONE, "神射手");
        menu7.add(7, 3, Menu.NONE, "遊　俠");
        menu7.add(7, 4, Menu.NONE, "2-2職業");
        menu7.add(7, 5, Menu.NONE, "舞孃(女)");
        menu7.add(7, 6, Menu.NONE, "冷豔舞姬(女)");
        menu7.add(7, 7, Menu.NONE, "浪跡舞者(女)");
        menu7.add(7, 8, Menu.NONE, "吟遊詩人(男)");
        menu7.add(7, 9, Menu.NONE, "搞笑藝人(男)");
        menu7.add(7, 10, Menu.NONE, "宮廷樂師(男)");
        menu7.setGroupCheckable(7, true, true);

        menu8.add(8, 0, Menu.NONE, "拳　聖");
        menu8.add(8, 1, Menu.NONE, "悟靈士");
        menu8.setGroupCheckable(8, true, true);

        menu9.add(9, 0, Menu.NONE, "影狼(男)");
        menu9.add(9, 1, Menu.NONE, "朧(女)");
        menu9.setGroupCheckable(9, true, true);

        menu10.add(10, 0, Menu.NONE, "反叛者");
        menu10.setGroupCheckable(10, true, true);
        */
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical);


        String str[] = new String[130];
        for (int i = 0; i < str.length; i++) {
            str[i] = "" + (i + 1);
        }
        spinner = (Spinner) findViewById(R.id.str);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                str);
        spinner.setAdapter(adapter);
/******************************************************/
        String agi[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            agi[i] = "" + (i + 1);
        }
        spinner = (Spinner) findViewById(R.id.agi);
        ArrayAdapter<String> adapteragi = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                agi);
        spinner.setAdapter(adapteragi);
/******************************************************/
        String vit[] = new String[130];
        for (int i = 0; i < vit.length; i++) {
            vit[i] = "" + (i + 1);
        }
        spinner = (Spinner) findViewById(R.id.vit);
        ArrayAdapter<String> adapteragivit = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                vit);
        spinner.setAdapter(adapteragivit);
/******************************************************/
        String In[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            In[i] = "" + (i + 1);
        }
        spinner = (Spinner) findViewById(R.id.in);
        ArrayAdapter<String> adapteragiin = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                In);
        spinner.setAdapter(adapteragiin);
/******************************************************/
        String dex[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            dex[i] = "" + (i + 1);
        }
        spinner = (Spinner) findViewById(R.id.dex);
        ArrayAdapter<String> adapteragidex = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                dex);
        spinner.setAdapter(adapteragidex);

/******************************************************/
        String luk[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            luk[i] = "" + (i + 1);
        }
        spinner = (Spinner) findViewById(R.id.luk);
        ArrayAdapter<String> adapteragiluk = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                luk);
        spinner.setAdapter(adapteragiluk);
/******************************************************/

        String speed1[] = {"無效果", "瓜拿那糖果10%", "集中藥水10%", "覺醒藥水15%", "菠色藥藥水20%", "毒藥瓶20%(十次刺客/十字斬首者限定)"};
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                speed1);
        spinner1.setAdapter(adapter1);

/******************************************************/
        String fruits2[] = {"Save1:on SaveData", "Save2:on SaveData", "Save3:on SaveData"};
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits2);
        spinner2.setAdapter(adapter2);



        //   /******************************************************/
        String Basic_Level[] = new String[175];
        for (int i = 0; i < Basic_Level.length; i++) {
            Basic_Level[i] = "" + (i + 1);
        }
        spinner4 = (Spinner) findViewById(R.id.lv);
        ArrayAdapter<String> adapterlv = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Basic_Level);
        spinner4.setAdapter(adapterlv);
    }
    protected void onCreate1(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical);

        File f = getCacheDir();
        Log.d("FILE", f.toString());
        String fName = "mydata.txt";
        FileOutputStream fOut = null;
        try {

            fOut = openFileOutput(fName, MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write("She sell sea shells on the sea shore .");
            osw.close();


            File readFile = new File(getFilesDir() + File.separator + fName);
            char[] buffer = new char[1];
            FileReader fr = null;
            StringBuilder sb = new StringBuilder();

            fr = new FileReader(readFile);
            while (fr.read(buffer) != -1) {
                sb.append(new String(buffer));
            }
            fr.close();
            Log.d("FILE", sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void click1(View v) {

        JSONArray array = new JSONArray();
        JSONObject obj;
        try {
            obj = new JSONObject();
            obj.put("name", "vit[i]");
            obj.put("addr", "Taipei");
            obj.put("tel", "123456");
            array.put(obj);
            obj = new JSONObject();
            obj.put("name", "Mary");
            obj.put("addr", "Tainan");
            obj.put("tel", "654321");
            array.put(obj);

            Log.d("JSON", array.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void click2(View v) {

        ArrayList<Student> mylist = new ArrayList();

        EditText ed = (EditText) findViewById(R.id.editText);
        EditText ed2 = (EditText) findViewById(R.id.editText2);
        EditText ed3 = (EditText) findViewById(R.id.editText3);

        String n = ed.getText().toString();
        String a = ed2.getText().toString();
        String p = ed3.getText().toString();


        Student s1 = new Student(12, 22, 15, "[i]", "[i]", "luk[i]", "[i]", "[i]", "[i]");

        mylist.add(s1);

        Gson gson = new Gson();

        String str = gson.toJson(mylist, new TypeToken<ArrayList<Student>>() {
        }.getType());
        Log.d("JSON", str);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.d("T0810-Smenu","Group:"+item.getGroupId());
        //Log.d("T0810-Smenu","Item:"+item.getItemId());
        Log.d("T0810-Smenu","Title:"+item.getTitle());
        //if (item.getGroupId()==500 && item.getItemId()==500)

        //ID="巫師";
        ROASlist list = new ROASlist(Numerical.this);
        ID= item.getTitle().toString();

        list=list.SeacrhList(ID);
        //Log.d("T0809-list", list.ID + ",空手:" + list.Empty);

        TextView tv31 = (TextView)findViewById(R.id.textView31);
        if(item.getGroupId()!=0)
        tv31.setText(ID);
        //tv.setText(ID);

        ArrayList<ShowIDListArray> sid=list.ShowList(list);
        str = new String[sid.size()];
        para1 = new float[sid.size()];
        HandUsed=new int[sid.size()];
        final float shd=Float.parseFloat(list.Shield);
        for(int i=0; i< sid.size();i++)
        {
            //Log.d("T0809-E",sid.get(i).Weapon+":"+sid.get(i).speed);
            str[i]=sid.get(i).Weapon;
            para1[i]=Float.parseFloat(sid.get(i).speed);
            HandUsed[i]=sid.get(i).HandUsed;
            Log.d("T0809-E1",str[i]+":"+para1[i]+":"+HandUsed[i]);
            //sid.get(i).Weapon;
            //sid.get(i).speed;
        }
        Spinner sp1= (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adpt = new ArrayAdapter<String>(Numerical.this,android.R.layout.simple_list_item_1,str);
        sp1.setAdapter(adpt);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CheckBox cb = (CheckBox)findViewById(R.id.checkBox);
                if(HandUsed[i]==2)
                {
                    cb.setEnabled(false);
                    cb.setChecked(false);
                }else {
                    cb.setEnabled(true);
                }

                if(cb.isChecked())
                    Log.d("T0813-shd",""+shd);
                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Log.d("T0813-shd",""+isChecked);
                    }
                });
                //tv42.setText(""+para1[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return super.onOptionsItemSelected(item);
    }
}
