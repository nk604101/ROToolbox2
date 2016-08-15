package tw.com.key214kimo.rotoolbox;


import android.location.LocationListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.Toast;

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
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Numerical extends AppCompatActivity {
    final int MAX_Para_Level=130;
    final int MAX_Level=175;
    boolean checkShowList;

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
    int LV;
    int MorPoint;
    TextView tv16;
    //Spinner spinner1;   //buff type1
    Spinner spinner2;
    //Spinner spinner3;
    Spinner spLV;

    //
    CheckBox cb;       //裝備盾牌
    Spinner sp;        //武器選項
    Spinner sp1;       //buff type1
    CheckBox cb3;      //buff type2-1
    CheckBox cb4;      //buff type2_2
    String str[],ID;    //str 可裝備武器列表 ID職業名
    float para1[];  //可裝備武器攻速
    int HandUsed[]; //武器手持類型 1單手 2雙手
    TextView tvASPD;
    TextView borATK,borDEF,borMDEF,stCRI,stFLEE,stFDodge,stHIT,stCastTime;
    TextView borMATK;

    EditText edSTR,edAGI,edVIT,edINT,edDEX,edLUK;

    DecimalFormat df;

    EditText edType3,edType2_3;

    float type1,type2_1,type2_2,type2_3,shd,WAsp;
    float type3;


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

        df = new DecimalFormat("#.##"); //設定顯示小數點第二位

        cb = (CheckBox)findViewById(R.id.checkBox);
        sp1 = (Spinner)findViewById(R.id.spinner1);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);

        spLV = (Spinner) findViewById(R.id.lv);
        spinnerStr = (Spinner) findViewById(R.id.str);
        spinnerAgi = (Spinner) findViewById(R.id.agi);
        spinnerVit = (Spinner) findViewById(R.id.vit);
        spinnerIn = (Spinner) findViewById(R.id.in);
        spinnerDex = (Spinner) findViewById(R.id.dex);
        spinnerLuk = (Spinner) findViewById(R.id.luk);

        tvASPD=(TextView)findViewById(R.id.stASPD);
        edType2_3=(EditText)findViewById(R.id.edType23);
        edType3=(EditText)findViewById(R.id.edType3);
        sp1 = (Spinner) findViewById(R.id.spinner1);

        borATK=(TextView)findViewById(R.id.stBofATK);
        borMATK=(TextView)findViewById(R.id.stBorMATK);
        borDEF=(TextView)findViewById(R.id.stBorDEF);
        borMDEF=(TextView)findViewById(R.id.stBofMDEF);
        stCRI=(TextView)findViewById(R.id.stCRI);
        stHIT=(TextView)findViewById(R.id.stHIT);
        stFLEE=(TextView)findViewById(R.id.stFLEE);
        stFDodge=(TextView)findViewById(R.id.stFDodge);
        stCastTime=(TextView)findViewById(R.id.stCastTime);

        edSTR=(EditText)findViewById(R.id.edSTR);
        edAGI=(EditText)findViewById(R.id.edAGI);
        edVIT =(EditText)findViewById(R.id.edVIT);
        edINT=(EditText)findViewById(R.id.edINT);
        edDEX=(EditText)findViewById(R.id.edDEX);
        edLUK=(EditText)findViewById(R.id.edLUK);


        checkShowList=false;

        ResetPara();//reset表單
        ResetLV();

        //   /******************************************************/
        String Basic_Level[] = new String[MAX_Level];
        for (int i = 0; i < Basic_Level.length; i++) {
            Basic_Level[i] = "" + (i + 1);
        }

        ArrayAdapter<String> adapterlv = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Basic_Level);
        spLV.setAdapter(adapterlv);
        spLV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LV=position+1;
                ParaValue();
                StateShow();
                AttSpeed();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        String Para_Max[] = new String[MAX_Para_Level];
        for (int i = 0; i < Para_Max.length; i++) {
            Para_Max[i] = "" + (i + 1);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Para_Max);
        spinnerStr.setAdapter(adapter);
        spinnerStr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StrPos = position+1;
                Log.d("T0814-A","Str:"+StrPos);
                ParaValue();
                AttSpeed();
                StateShow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
/******************************************************/

        ArrayAdapter<String> adapteragi = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Para_Max);
        spinnerAgi.setAdapter(adapteragi);
        spinnerAgi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AgiPos = position+1;
                Log.d("T0814-A","Agi:"+AgiPos);
                ParaValue();
                AttSpeed();
                StateShow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
/******************************************************/

        ArrayAdapter<String> adapteragivit = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Para_Max);
        spinnerVit.setAdapter(adapteragivit);
        spinnerVit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                VitPos = position+1;
                Log.d("T0814-A","Vit:"+VitPos);
                ParaValue();
                AttSpeed();
                StateShow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
/******************************************************/

        ArrayAdapter<String> adapteragiin = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Para_Max);
        spinnerIn.setAdapter(adapteragiin);
        spinnerIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                InPos = position+1;
                Log.d("T0814-A","In:"+InPos);
                ParaValue();
                AttSpeed();
                StateShow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/******************************************************/

        ArrayAdapter<String> adapteragidex = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Para_Max);
        spinnerDex.setAdapter(adapteragidex);
        spinnerDex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DexPos = position+1;
                Log.d("T0814-A","Dex:"+DexPos);
                ParaValue();
                AttSpeed();
                StateShow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/******************************************************/

        ArrayAdapter<String> adapteragiluk = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                Para_Max);
        spinnerLuk.setAdapter(adapteragiluk);
        spinnerLuk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LukPos = position+1;
                Log.d("T0814-A","Luk:"+LukPos);
                ParaValue();
                AttSpeed();
                StateShow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


/******************************************************/
        String fruits2[] = {"Save1:on SaveData", "Save2:on SaveData", "Save3:on SaveData"};
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Numerical.this,
                android.R.layout.simple_spinner_dropdown_item,
                fruits2);
        spinner2.setAdapter(adapter2);


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

        //EditText ed = (EditText) findViewById(R.id.editText);
       //EditText ed2 = (EditText) findViewById(R.id.editText2);
        //EditText ed3 = (EditText) findViewById(R.id.editText3);

       // String n = ed.getText().toString();
        //String a = ed2.getText().toString();
        //String p = ed3.getText().toString();


        Student s1 = new Student(12, 22, 15, "[i]", "[i]", "luk[i]", "[i]", "[i]", "[i]");

        mylist.add(s1);

        Gson gson = new Gson();

        String str = gson.toJson(mylist, new TypeToken<ArrayList<Student>>() {
        }.getType());
        Log.d("JSON", str);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        ResetPara();//reset
        ParaValue();
        StateShow();

        //取得職業資料
        ROASlist list = new ROASlist(Numerical.this);
        ID= item.getTitle().toString();

        //將所選的職業名稱丟入取出數值表
        list=list.SeacrhList(ID);
        //Log.d("T0809-list", list.ID + ",空手:" + list.Empty);
        if(item.getGroupId()!=0) {
            //秀出目前職業
            TextView tv31 = (TextView) findViewById(R.id.textView31);
            //
            //if(item.getGroupId()!=0)
            tv31.setText(ID);
            //tv.setText(ID);

            //將可裝備武器資料 放到 Spinner
            ArrayList<ShowIDListArray> sid = list.ShowList(list);
            str = new String[sid.size()];   //決定 顯示數量
            para1 = new float[sid.size()];
            HandUsed = new int[sid.size()];
            MorPoint=Integer.parseInt(list.MorPT);
            //Log.d("T0814-point",list.MorPT);
            //shd=Float.parseFloat(list.Shield);
            final float listShd = Float.parseFloat(list.Shield);
            //將資料放置同一 position
            for (int i = 0; i < sid.size(); i++) {
                str[i] = sid.get(i).Weapon;
                para1[i] = Float.parseFloat(sid.get(i).speed);
                HandUsed[i] = sid.get(i).HandUsed;
                Log.d("T0809-E1", str[i] + ":" + para1[i] + ":" + HandUsed[i]);
            }
            sp = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter<String> adpt = new ArrayAdapter<String>(Numerical.this, android.R.layout.simple_list_item_1, str);
            sp.setAdapter(adpt);

            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    checkShowList = true;

                    ParaValue();
                    StateShow();
                    CheckBox cb = (CheckBox) findViewById(R.id.checkBox);
                    cb.setChecked(false);
                    Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
                    sp1.setSelection(0);
                    CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
                    CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
                    cb3.setChecked(false);
                    cb4.setChecked(false);

                    if (HandUsed[i] == 2) {
                        cb.setEnabled(false);
                        cb.setChecked(false);
                    } else {
                        cb.setEnabled(true);
                    }
                    WAsp = para1[i];
                    AttSpeed();


                    cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            Log.d("T0813-shd", "" + shd);
                            Log.d("T0813-shd", "" + isChecked);
                            if (isChecked) {
                                shd = listShd;
                                AttSpeed();
                            } else {
                                shd = 0;
                                AttSpeed();
                            }
                        }
                    });

                    /******************************************************/

                    String[] speed1 = {"無效果", "瓜拿那糖果10%", "集中藥水10%", "覺醒藥水15%", "菠色藥藥水20%", "毒藥瓶20%(十字刺客/十字斬首者限定)"};
                    String[] speed2 = {"無效果", "瓜拿那糖果10%", "集中藥水10%", "覺醒藥水15%", "菠色藥藥水20%"};
                    ArrayAdapter<String> adapter1;
                    if(ID.equals("十字刺客")||ID.equals("十字斬首者"))
                    adapter1 = new ArrayAdapter<String>(Numerical.this,
                            android.R.layout.simple_spinner_dropdown_item,
                            speed1);
                    else
                        adapter1 = new ArrayAdapter<String>(Numerical.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                speed2);
                    sp1.setAdapter(adapter1);
                    //第一類攻速
                    sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Log.d("T0813-buffS", "" + position);

                                    switch (position)
                                    {
                                        case 0:
                                            type1 = 0;
                                            break;
                                        case 1:
                                        case 2:
                                            type1 = 10f;
                                            break;
                                        case 3:
                                            type1 = 15f;
                                            break;
                                        case 4:
                                        case 5:
                                            type1 = 20f;
                                            break;
                                    }
                            AttSpeed();
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                    cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked)
                                type2_1 = 10f;
                            else
                                type2_1 = 0;

                            AttSpeed();
                        }
                    });


                    cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked)
                                type2_2 = 25f;

                            else
                                type2_2 = 0;

                            AttSpeed();
                        }
                    });
                    edType2_3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                        }
                    });

                    edType3.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                        }
                    });
                    edSTR.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }
                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                            StateShow();
                        }
                    });
                    edAGI.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }
                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                            StateShow();
                        }
                    });
                    edVIT.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }
                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                            StateShow();
                        }
                    });
                    edINT.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }
                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                            StateShow();
                        }
                    });
                    edDEX.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }
                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                            StateShow();
                        }
                    });
                    edLUK.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }
                        @Override
                        public void afterTextChanged(Editable s) {
                            AttSpeed();
                            StateShow();
                        }
                    });

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    //攻速計算
    public void AttSpeed()
    {


        if(edType2_3.getText().toString().trim().equals(""))
        {
            type2_3 = 0;
        }
        else
        {
            type2_3 = Integer.parseInt(edType2_3.getText().toString());
        }

        if(edType3.getText().toString().trim().equals(""))
        {
            type3 = 0;
        }
        else
        {
            type3 = Integer.parseInt(edType3.getText().toString());
        }


        double basic_aspd=WAsp;//基礎攻速
        double potion1=type1;//攻速第一類(取最高)
        double potion2=type2_1+type2_2+type2_3;//攻速第二類(可累加)
        double potion3=type3;//攻速第三類(直接增加)
        float bs_aspd2;
        final float baseA=144;

        if(basic_aspd<baseA)
        {
            bs_aspd2 = 1;
        }
        else
        {
            bs_aspd2 = (float) (1 - ((basic_aspd - baseA) / 50));
        }

        double aspd1=basic_aspd+Math.pow(((AgiPos*1120/111f)+(DexPos*11/60)),0.5f)*bs_aspd2;//攻速1
        double aspd2=200-(200-aspd1)*(1-potion1/100f);//攻速2
        double aspd3=195-(195-aspd2)*(1-potion2/100f)+potion3-shd;//最終ASPD
        Log.d("T0814-Attspd","1:"+aspd1);
        Log.d("T0814-Attspd","2:"+aspd2);
        Log.d("T0814-Attspd","3:"+aspd3);

        String totalASPD=df.format(aspd3);
        if(checkShowList)
        tvASPD.setText(totalASPD+"       ");
    }
    public void StateShow()
    {
        int totalSTR,totalAGI,totalVIT,totalINT,totalDEX,totalLUK;
        if(edSTR.getText().toString().trim().equals(""))
            totalSTR=StrPos+0;
        else
            totalSTR=StrPos+Integer.parseInt(edSTR.getText().toString());

        if(edAGI.getText().toString().trim().equals(""))
            totalAGI=AgiPos+0;
        else
            totalAGI=AgiPos+Integer.parseInt(edAGI.getText().toString());

        if(edVIT.getText().toString().trim().equals(""))
            totalVIT=VitPos+0;
        else
            totalVIT=VitPos+Integer.parseInt(edVIT.getText().toString());

        if(edINT.getText().toString().trim().equals(""))
            totalINT=InPos+0;
        else
            totalINT=InPos+Integer.parseInt(edINT.getText().toString());

        if(edDEX.getText().toString().trim().equals(""))
            totalDEX=DexPos+0;
        else
            totalDEX=DexPos+Integer.parseInt(edDEX.getText().toString());

        if(edLUK.getText().toString().trim().equals(""))
            totalLUK=LukPos+0;
        else
            totalLUK=LukPos+Integer.parseInt(edLUK.getText().toString());

        double atk1=totalSTR+totalLUK*0.3+LV/4f+totalDEX/5f;    //前ATK
        double matk1=(LV/4f)+(totalINT*1.5)+(totalDEX/5f)+(totalLUK*0.3);    //前MATK(素質MATK)
        double hit=175+totalDEX+(totalLUK*0.3)+LV;    //命中
        double flee=100+totalAGI+totalLUK/5f+LV;   //迴避率
        double complete_flee=1+ totalLUK/10f; //完全迴避率
        double aria=(1-(totalDEX+totalINT/2f)/265f); //數值變動詠唱
        double cri=totalLUK*0.3+1;   //CRI暴擊率
        double def1=(LV+totalVIT)/2f+(totalAGI/5f);//前def
        double mdef1=totalINT+(LV/4f)+(totalVIT/5f)+(totalDEX/5f);//前mdef

        if(checkShowList) {
            borATK.setText(df.format(atk1) + "       ");
            borMATK.setText(df.format(matk1) + "       ");
            stHIT.setText(df.format(hit) + "       ");
            stCRI.setText(df.format(cri) + "       ");
            stCastTime.setText(df.format(aria) + "       ");
            stFDodge.setText(df.format(complete_flee) + "       ");
            stFLEE.setText(df.format(flee) + "       ");
            borDEF.setText(df.format(def1) + "       ");
            borMDEF.setText(df.format(mdef1) + "       ");
        }
        double hp_coefficient=0.7;//HP係數
        double hp_magnification=5;//HP倍率
    }

    //技能點計算
    public void ParaValue()
    {
        int sum=0;
        int point;
        point=SkillPoint(LV)+MorPoint;

        sum=point-UsePoint(StrPos)-UsePoint(AgiPos)-UsePoint(VitPos)-
                UsePoint(InPos)-UsePoint(DexPos)-UsePoint(LukPos);
        //Log.d("T0814-A","sum:"+sum);
        tv16=(TextView)findViewById(R.id.textView16);
        tv16.setText(""+sum);
    }

    public void ResetPara()
    {
        cb.setChecked(false);
        sp1.setSelection(0);
        cb3.setChecked(false);
        cb4.setChecked(false);

        shd=0;
        type1=1;
        type2_1=0;
        type2_2=0;
        type2_3=0;
        type3=0;
    }
    public void ResetLV()
    {
        spLV.setSelection(0);
        spinnerStr.setSelection(0);
        spinnerAgi.setSelection(0);
        spinnerVit.setSelection(0);
        spinnerIn.setSelection(0);
        spinnerDex.setSelection(0);
        spinnerLuk.setSelection(0);
        LV=1;
        StrPos=1;
        AgiPos=1;
        VitPos=1;
        InPos=1;
        DexPos=1;
        LukPos=1;
        MorPoint=0;
    }
    //
    public int SkillPoint (int LV)
    {
        int point=45;
        int LVMax=175;

        if(LV<=100) {
            for (int i = 1; i <= LV; i++) {
                point = point + 3 + (i - 1) / 5;
            }

        }else  if(LV>=101 && LV <=150)
        {
            for (int i = 1; i <= 100; i++) {
                point = point + 3 + (i - 1) / 5;
            }
            for (int i=1 ;i<=LV-100;i++)
            {
                point = point + 23 + (i - 1) / 10;
            }
        }else if(LV>=151 && LV<=LVMax)
        {
            for (int i = 1; i <= 100; i++) {
                point = point + 3 + (i - 1) / 5;
            }
            for (int i=1 ;i<=150-100;i++)
            {
                point = point + 23 + (i - 1) / 10;
            }
            for (int i=1 ;i<=LV-150;i++)
            {
                point = point + 28 + (i - 1) / 7;
            }
        }

        return point;
    }
    public int UsePoint(int paraUsed)
    {
        int pointUsed=0;
        int paraUsedMax=130;
        //int paraUsed1=99;
        if(paraUsed<=100) {
            for (int i = 2; i <= paraUsed; i++) {
                pointUsed = pointUsed +(2 + (i-2) / 10);
                Log.d("T0814-para","para1"+pointUsed);
            }

        }else  if(paraUsed>=101 && paraUsed<=paraUsedMax)
        {
            for (int i = 2; i <= 100; i++) {
                pointUsed = pointUsed +(2 + (i-2) / 10);
                Log.d("T0814-para","para2"+pointUsed);
            }
            for (int i=1 ;i<=paraUsed-100;i++)
            {
                pointUsed = pointUsed + (16 + (i-1)/5*4);
                Log.d("T0814-para","para3"+pointUsed);
            }
        }
        return pointUsed;
    }
}
