package tw.com.key214kimo.rotoolbox;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Hsinwei on 2016/8/10.
 */
public class ROASlist {
    String ID;          //職業
    String SID;         //分類ID aabbccdd aa:職業群 bb:職業轉職階級 cc:職業階級 dd:性別
    String Shield;      //盾
    String Empty;       //空手
    String Knife;       //短劍
    String Sword;       //劍
    String THSword;     //雙手劍
    String Spear;       //槍
    String THSpear;     //雙手槍
    String Axe;         //斧
    String THAxe;       //雙手斧
    String Staff;       //杖
    String THStaff;     //雙手杖
    String Blunt;       //鈍器
    String Bow;         //弓
    String Katar;       //拳刃
    String Book;        //書
    String Fist;        //拳套
    String Musical;     //樂器
    String Whip;        //鞭
    String Shuriken;    //手裡劍
    String Pistol;      //手槍
    String Rifle;       //來福槍
    String Shutgun;     //霧彈槍(散彈)
    String Greengun;    //格林槍
    String Grenadegun;  //榴彈槍
    String MorPT,MorHP; //進階職業獎勵值


    private Context context;
    private String str;

    public ROASlist(Context context)
    {
        this.context=context;
    }

    public ArrayList<ROASlist> DataList()
    {
        InputStream is = null;
        is = context.getResources().openRawResource(R.raw.rodata_attsp);
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try {
            while ((length = is.read(buffer)) != -1)
                result.write(buffer, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            str = result.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        // TypeToken<ArrayList<?>>(){} 取出 ArrayList<?>這個 Type
        ArrayList<ROASlist> glist = gson.fromJson(str,new TypeToken<ArrayList<ROASlist>>(){}.getType());

        return glist;
    }

    public ROASlist SeacrhList(String ID)
    {

        ArrayList<ROASlist> glist = DataList();

        for(int i=0;i<glist.size();i++)
        {
            if(glist.get(i).ID.equals(ID)) {
                Log.d("T0809-Gson", glist.get(i).ID + ",空手:" + glist.get(i).Empty);

                return glist.get(i);
            }
        }
        return null;
    }
    public ArrayList<ShowIDListArray> ShowList(ROASlist IDList)
    {
        ArrayList<ShowIDListArray> List = new ArrayList<>();

        //ShowIDListArray s = new ShowIDListArray();
        if (!IDList.Empty.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "空手";
            s.speed = IDList.Empty;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.Knife.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "短劍";
            s.speed = IDList.Knife;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.Sword.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "劍";
            s.speed = IDList.Sword;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.THSword.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "雙手劍";
            s.speed = IDList.THSword;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Spear.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "槍";
            s.speed = IDList.Spear;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.THSpear.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "雙手槍";
            s.speed = IDList.THSpear;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Axe.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "斧";
            s.speed = IDList.Axe;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.THAxe.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "雙手斧";
            s.speed = IDList.THAxe;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Staff.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "杖";
            s.speed = IDList.Staff;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.THStaff.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "雙手杖";
            s.speed = IDList.THStaff;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Blunt.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "鈍器";
            s.speed = IDList.Blunt;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.Bow.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "弓";
            s.speed = IDList.Bow;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Katar.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "拳刃";
            s.speed = IDList.Katar;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Book.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "書";
            s.speed = IDList.Book;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.Fist.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "拳套";
            s.speed = IDList.Fist;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.Musical.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "樂器";
            s.speed = IDList.Musical;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.Whip.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "鞭";
            s.speed = IDList.Whip;
            s.HandUsed=1;
            List.add(s);
        }
        if (!IDList.Shuriken.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "手裡劍";
            s.speed = IDList.Shuriken;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Pistol.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "手槍";
            s.speed = IDList.Pistol;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Rifle.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "來福槍";
            s.speed = IDList.Rifle;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Shutgun.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "散彈槍";
            s.speed = IDList.Shutgun;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Greengun.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "格林槍";
            s.speed = IDList.Greengun;
            s.HandUsed=2;
            List.add(s);
        }
        if (!IDList.Grenadegun.equals("0.00"))
        {
            ShowIDListArray s = new ShowIDListArray();
            s.Weapon = "榴彈槍";
            s.speed = IDList.Grenadegun;
            s.HandUsed=2;
            List.add(s);
        }
        //Log.d("T0809-size",""+List.size());
        return List;
    }
}

