package walsh.teaching.spring.di.xmlinjection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DirectoryIntegrationTest {
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testListFiles() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:beans.xml");
        Directory directory = applicationContext.getBean("directory", Directory.class);
        File virusFile = applicationContext.getBean("virusFile", File.class);
        directory.addFiles(virusFile);
        directory.listFiles();

        FileLister lister = directory.getLister();
        assertThat(outContent.toString(), equalTo("virus" + System.lineSeparator()));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }
}
