package tw.com.key214kimo.rotoolbox;


import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.SubMenu;



public class Occupation1 extends AppCompatActivity {
    @Override
    public boolean  onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        SubMenu menu1=menu.addSubMenu(0,0,Menu.NONE,"初學者");
        SubMenu menu2=menu.addSubMenu(0,1,Menu.NONE,"劍　士");
        SubMenu menu3=menu.addSubMenu(0,2,Menu.NONE,"魔法師");
        SubMenu menu4 = menu.addSubMenu(0, 3, Menu.NONE, "商　人");
        SubMenu menu5 = menu.addSubMenu(0, 4, Menu.NONE, "盜　賊");
        SubMenu menu6 = menu.addSubMenu(0, 5, Menu.NONE, "服　事");
        SubMenu menu7 = menu.addSubMenu(0, 6, Menu.NONE, "弓箭手");
        SubMenu menu8=menu.addSubMenu(0,7,Menu.NONE,"跆拳家");
        SubMenu menu9=menu.addSubMenu(0,8,Menu.NONE,"忍　者");
        SubMenu menu10 = menu.addSubMenu(0, 9, Menu.NONE, "神槍手");

        menu1.add(1,0,Menu.NONE,"超級初學者");
        menu1.add(1,1,Menu.NONE,"超級初學者等級突破");
        menu1.setGroupCheckable(1,true,true);

        menu2.add(2,0,Menu.NONE,"2-1職業");
        menu2.add(2,1,Menu.NONE,"騎　士");
        menu2.add(2,2,Menu.NONE,"騎士領主");
        menu2.add(2,3,Menu.NONE,"盧恩騎士");
        menu2.add(2,4,Menu.NONE,"2-2職業");
        menu2.add(2,5,Menu.NONE,"十字軍");
        menu2.add(2,6,Menu.NONE,"聖殿十字軍");
        menu2.add(2,7,Menu.NONE,"皇家禁衛隊");
        menu2.setGroupCheckable(2,true,true);

        menu3.add(3,0,Menu.NONE,"2-1職業");
        menu3.add(3,1,Menu.NONE,"巫　師");
        menu3.add(3,2,Menu.NONE,"超魔導師");
        menu3.add(3,3,Menu.NONE,"咒術士");
        menu3.add(3,4,Menu.NONE,"2-2職業");
        menu3.add(3,5,Menu.NONE,"賢　者");
        menu3.add(3,6,Menu.NONE,"智　者");
        menu3.add(3,7,Menu.NONE,"妖術師");
        menu3.setGroupCheckable(3,true,true);

        menu4.add(4,0,Menu.NONE,"2-1職業");
        menu4.add(4, 1, Menu.NONE, "鐵　匠");
        menu4.add(4, 2, Menu.NONE, "神工匠");
        menu4.add(4, 3, Menu.NONE, "機械工匠");
        menu4.add(4,4,Menu.NONE,"2-2職業");
        menu4.add(4, 5, Menu.NONE, "鍊金術師");
        menu4.add(4, 6, Menu.NONE, "創造者");
        menu4.add(4, 7, Menu.NONE, "基因學者");
        menu4.setGroupCheckable(4,true,true);

        menu5.add(5,0,Menu.NONE,"2-1職業");
        menu5.add(5,1,Menu.NONE,"刺　客");
        menu5.add(5,2,Menu.NONE,"十字刺客");
        menu5.add(5,3,Menu.NONE,"十字斬首者");
        menu5.add(5,4,Menu.NONE,"2-2職業");
        menu5.add(5,5,Menu.NONE,"流　氓");
        menu5.add(5,6,Menu.NONE,"神行太保");
        menu5.add(5,7,Menu.NONE,"魅影追蹤者");
        menu5.setGroupCheckable(5,true,true);

        menu6.add(6,0,Menu.NONE,"2-1職業");
        menu6.add(6, 1, Menu.NONE, "祭　司");
        menu6.add(6, 2, Menu.NONE, "神　官");
        menu6.add(6, 3, Menu.NONE, "大主教");
        menu6.add(6,4,Menu.NONE,"2-2職業");
        menu6.add(6, 5, Menu.NONE, "武道家");
        menu6.add(6, 6, Menu.NONE, "武術宗師");
        menu6.add(6, 7, Menu.NONE, "修　羅");
        menu6.setGroupCheckable(6,true,true);

        menu7.add(7,0,Menu.NONE,"2-1職業");
        menu7.add(7,1,Menu.NONE,"獵　人");
        menu7.add(7,2,Menu.NONE,"神射手");
        menu7.add(7,3,Menu.NONE,"遊　俠");
        menu7.add(7,4,Menu.NONE,"2-2職業");
        menu7.add(7, 5, Menu.NONE, "舞孃(女)");
        menu7.add(7, 6, Menu.NONE, "冷豔舞姬(女)");
        menu7.add(7, 7, Menu.NONE, "浪跡舞者(女)");
        menu7.add(7, 8, Menu.NONE, "吟遊詩人(男)");
        menu7.add(7, 9, Menu.NONE, "搞笑藝人(男)");
        menu7.add(7, 10, Menu.NONE, "宮廷樂師(男)");
        menu7.setGroupCheckable(7,true,true);

        menu8.add(8,0,Menu.NONE,"拳　聖");
        menu8.add(8,1,Menu.NONE,"悟靈士");
        menu8.setGroupCheckable(8,true,true);

        menu9.add(9,0,Menu.NONE,"影狼(男)");
        menu9.add(9,1,Menu.NONE,"朧(女)");
        menu9.setGroupCheckable(9,true,true);

        menu10.add(10,0,Menu.NONE,"反叛者");
        menu10.setGroupCheckable(10,true,true);
        return true;
    }

}
