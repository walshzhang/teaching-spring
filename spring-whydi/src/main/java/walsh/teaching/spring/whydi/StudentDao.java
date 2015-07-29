package walsh.teaching.spring.whydi;

import java.util.List;

public interface StudentDao {
    List<Student> findByNames(String name);
}
