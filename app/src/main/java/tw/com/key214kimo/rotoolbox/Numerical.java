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
    Spinner spinnerStr;
    Spinner spinnerAgi;
    Spinner spinnerVit;
    Spinner spinnerIn;
    Spinner spinnerDex;
    Spinner spinnerLuk;
    int StrPos;
    int AgiPos;
    int VitPos;
    int InPos;
    int DexPos;
    int LukPos;
    TextView tv16;
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
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical);

        StrPos=1;
        AgiPos=1;
        VitPos=1;
        InPos=1;
        DexPos=1;
        LukPos=1;

        String str[] = new String[130];
        for (int i = 0; i < str.length; i++) {
            str[i] = "" + (i + 1);
        }
        spinnerStr = (Spinner) findViewById(R.id.str);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                str);
        spinnerStr.setAdapter(adapter);
        spinnerStr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StrPos = position+1;
                Log.d("T0814-A","Str:"+StrPos);
                ParaValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
/******************************************************/
        String agi[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            agi[i] = "" + (i + 1);
        }
        spinnerAgi = (Spinner) findViewById(R.id.agi);
        ArrayAdapter<String> adapteragi = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                agi);
        spinnerAgi.setAdapter(adapteragi);
        spinnerAgi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AgiPos = position+1;
                Log.d("T0814-A","Agi:"+AgiPos);
                ParaValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
/******************************************************/
        String vit[] = new String[130];
        for (int i = 0; i < vit.length; i++) {
            vit[i] = "" + (i + 1);
        }
        spinnerVit = (Spinner) findViewById(R.id.vit);
        ArrayAdapter<String> adapteragivit = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                vit);
        spinnerVit.setAdapter(adapteragivit);
        spinnerVit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                VitPos = position+1;
                Log.d("T0814-A","Vit:"+VitPos);
                ParaValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
/******************************************************/
        String In[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            In[i] = "" + (i + 1);
        }
        spinnerIn = (Spinner) findViewById(R.id.in);
        ArrayAdapter<String> adapteragiin = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                In);
        spinnerIn.setAdapter(adapteragiin);
        spinnerIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                InPos = position+1;
                Log.d("T0814-A","In:"+InPos);
                ParaValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/******************************************************/
        String dex[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            dex[i] = "" + (i + 1);
        }
        spinnerDex = (Spinner) findViewById(R.id.dex);
        ArrayAdapter<String> adapteragidex = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                dex);
        spinnerDex.setAdapter(adapteragidex);
        spinnerDex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DexPos = position+1;
                Log.d("T0814-A","Dex:"+DexPos);
                ParaValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/******************************************************/
        String luk[] = new String[130];
        for (int i = 0; i < agi.length; i++) {
            luk[i] = "" + (i + 1);
        }
        spinnerLuk = (Spinner) findViewById(R.id.luk);
        ArrayAdapter<String> adapteragiluk = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                luk);
        spinnerLuk.setAdapter(adapteragiluk);
        spinnerLuk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LukPos = position+1;
                Log.d("T0814-A","Luk:"+LukPos);
                ParaValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

        Log.d("T8014-In",spinnerIn.getSelectedItem().toString());
        //取得職業資料
        ROASlist list = new ROASlist(Numerical.this);
        ID= item.getTitle().toString();

        //將所選的職業名稱丟入取出數值表
        list=list.SeacrhList(ID);
        //Log.d("T0809-list", list.ID + ",空手:" + list.Empty);

        //秀出目前職業
        TextView tv31 = (TextView)findViewById(R.id.textView31);
        //
        if(item.getGroupId()!=0)
        tv31.setText(ID);
        //tv.setText(ID);

        //將可裝備武器資料 放到 Spinner
        ArrayList<ShowIDListArray> sid=list.ShowList(list);
        str = new String[sid.size()];   //決定 顯示數量
        para1 = new float[sid.size()];
        HandUsed=new int[sid.size()];
        final float shd=Float.parseFloat(list.Shield);
        //將資料放置同一 position
        for(int i=0; i< sid.size();i++)
        {
            str[i]=sid.get(i).Weapon;
            para1[i]=Float.parseFloat(sid.get(i).speed);
            HandUsed[i]=sid.get(i).HandUsed;
            Log.d("T0809-E1",str[i]+":"+para1[i]+":"+HandUsed[i]);
        }
        final Spinner sp1= (Spinner)findViewById(R.id.spinner);
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


                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Log.d("T0813-shd",""+shd);
                        Log.d("T0813-shd",""+isChecked);
                    }
                });

                Spinner sp1 = (Spinner)findViewById(R.id.spinner1);

                sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Log.d("T0813-buffS",""+position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return super.onOptionsItemSelected(item);
    }
    public void AttSpeed(int WPos,int BuffPos)
    {

    }

    public void ParaValue()
    {
        int sum;
        sum=StrPos+AgiPos+VitPos+InPos+DexPos+LukPos;
        Log.d("T0814-A","sum:"+sum);
        tv16=(TextView)findViewById(R.id.textView16);
        tv16.setText(""+sum);
    }
}
