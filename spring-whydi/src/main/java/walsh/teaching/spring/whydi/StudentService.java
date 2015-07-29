package walsh.teaching.spring.whydi;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = new FileBasedStudentDao("students.txt");
    }
}
