package walsh.teaching.spring.whydi;

import java.util.Arrays;

public class StudentServiceFactory {
    public static StudentService createFileBasedStudentService(String file) {
        return new StudentService(new FileBasedStudentDao(file));
    }

    //jdk8 feature: lambda expression
    public static StudentService createMemoryBasedStudentService() {
        return new StudentService((name) -> Arrays.asList(new Student[]{}));
    }
}
