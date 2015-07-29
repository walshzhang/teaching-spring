package walsh.teaching.spring.whydi;

/**
 * show how to use StudentService class.
 */
public class StudentClient {
    public static void main(String[] args) {
        StudentService service = StudentServiceFactory.createFileBasedStudentService("students.txt");
        service.findByName("alice");

        service = StudentServiceFactory.createMemoryBasedStudentService();
        service.findByName("alice");
    }
}
