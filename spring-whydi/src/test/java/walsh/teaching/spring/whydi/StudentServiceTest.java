package walsh.teaching.spring.whydi;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class StudentServiceTest {
    @Test
    public void testFindByName() {
        StudentDao dao = Mockito.mock(StudentDao.class);
        StudentService service = new StudentService(dao);
        service.findByName("alice");
        verify(dao, times(1)).findByName("alice");

        when(dao.findByName("alice")).thenReturn(Arrays.asList(new Student[]{}));
        service.findByName("alice");
        assertThat(service.findByName("alice").size(), equalTo(0));
    }
}
