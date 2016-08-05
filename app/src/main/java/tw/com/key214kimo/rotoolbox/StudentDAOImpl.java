package tw.com.key214kimo.rotoolbox;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 2016/8/5.
 */
public class StudentDAOImpl implements StudentDAO {
    static ArrayList<Student> mylist;
    Context context;

    public StudentDAOImpl(Context context) {
        this.context = context;
        String fName = "student.json";
        File readFile = new File(context.getFilesDir() + File.separator + fName);
        char[] buffer = new char[1];
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        if (readFile.exists()) {
            try {
                fr = new FileReader(readFile);
                while (fr.read(buffer) != -1) {
                    sb.append(new String(buffer));
                }
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String data = sb.toString();
            Gson gson = new Gson();
            mylist = gson.fromJson(data, new TypeToken<ArrayList<Student>>() {
            }.getType());
        } else {
            mylist = new ArrayList<>();
        }

    }

    private void saveList() {
        Gson gson = new Gson();
        String json = gson.toJson(mylist, new TypeToken<ArrayList<Student>>() {
        }.getType());
        String fName = "student.json";
        FileOutputStream fOut = null;

        try {
            fOut = context.openFileOutput(fName, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        try {
            osw.write(json);
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addStudent(Student s) {
        mylist.add(s);
        saveList();
    }

    @Override
    public void delStudent(Student s) {
        mylist.remove(s);
        saveList();
    }

    @Override
    public void updateStudent(Student s) {
        for (Student t : mylist) {
            if (t.name.equals(s.name)) {
                t.addr = s.addr;
                t.tel = s.tel;
            }
        }
        saveList();
    }

    @Override
    public List getAllStudent() {
        return mylist;
    }
}
