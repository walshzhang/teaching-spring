package walsh.teaching.spring.whydi;

import java.util.List;

public interface StudentDao {
    List<Student> findByName(String name);
}
