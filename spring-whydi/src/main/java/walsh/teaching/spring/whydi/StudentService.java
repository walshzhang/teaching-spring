package walsh.teaching.spring.whydi;

import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao dao) {
        this.studentDao = dao;
    }

    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }
}
