package walsh.teaching.spring.xmlinjection;

import com.google.common.base.Joiner;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class DirectoryIntegrationTest {
    private static ApplicationContext applicationContext;
    private static File file1;
    private static File file2;

    private ByteArrayOutputStream outContent;

    @BeforeClass
    public static void setUpEnv() {
        applicationContext = new ClassPathXmlApplicationContext("beans-test.xml");

        file1 = new File();
        file1.setName("file1");
        file1.setLength(10f);

        file2 = applicationContext.getBean("file2", File.class);
    }

    @AfterClass
    public static void tearDownEnv() {
        applicationContext = null;
    }

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
//        System.setOut(null);
    }

    @Test
    public void testListFilesWithNameSorterAndNameLister() {
        prepareDirectoryThenListFiles("nameSortedAndSimpleListeddirectory");
        String expectedOutput = Joiner.on(System.lineSeparator()).join("file1", "file2", "");
        assertThat(outContent.toString(), equalTo(expectedOutput));
    }

    @Test
    public void testListFilesWithNameSorterAndDetailedLister() {
        prepareDirectoryThenListFiles("nameSortedAndDetailedListeddirectory");
        String expectedOutput = "file1\t10.000000\nfile2\t20.000000\n";
        assertThat(outContent.toString(), equalTo(expectedOutput));
    }

    private void prepareDirectoryThenListFiles(String bean) {
        Directory directory = applicationContext.
                getBean(bean, Directory.class);
        directory.addFile(file2, file1);
        directory.listFiles();
    }

}
