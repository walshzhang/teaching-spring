package walsh.teaching.spring.di.xmlinjection;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class SimpleFileListerTest {
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testList() {
        File file = mock(File.class);
        when(file.getName()).thenReturn("hello.txt");

        FileLister lister = new SimpleFileLister();
        lister.list(file);
        verify(file, times(1)).getName();

        assertThat(outputStream.toString(), equalTo("hello.txt" + System.lineSeparator()));
    }
}
