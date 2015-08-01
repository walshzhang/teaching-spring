package walsh.teaching.spring.di.xmlinjection;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class DirectoryTest {

    @Test
    public void testListFiles() {
        File file1 = mock(File.class);
        File file2 = mock(File.class);
        FileLister lister = mock(FileLister.class);

        Directory directory = new Directory();
        directory.setLister(lister);
        directory.listFiles();
        verify(lister, never()).list(any(File.class));

        directory.addFiles(file1, file2);
        directory.listFiles();

        verify(lister, times(1)).list(file1);
        verify(lister, times(1)).list(file2);
    }

}
