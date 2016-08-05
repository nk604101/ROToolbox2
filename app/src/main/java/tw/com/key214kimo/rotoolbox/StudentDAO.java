package tw.com.key214kimo.rotoolbox;

import java.util.List;

/**
 * Created by Student on 2016/8/4.
 */
public interface StudentDAO {
    void addStudent(Student s);

    void delStudent(Student s);

    void updateStudent(Student s);

    List getAllStudent();
}
