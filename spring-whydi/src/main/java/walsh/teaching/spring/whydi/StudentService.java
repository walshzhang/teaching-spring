package walsh.teaching.spring.whydi;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = new FileBasedStudentDao("students.txt");
    }

    public List<Student> findByName(String name) {
        return studentDao.findByNames(name);
    }
}
