package walsh.teaching.spring.whydi;

import java.util.Arrays;
import java.util.List;

public class FileBasedStudentDao implements StudentDao {

    private final String file;

    public FileBasedStudentDao(String file) {
        this.file = file;
    }

    @Override
    public List<Student> findByNames(String name) {
        //return directly with empty list.
        return Arrays.asList(new Student[]{});
    }
}
