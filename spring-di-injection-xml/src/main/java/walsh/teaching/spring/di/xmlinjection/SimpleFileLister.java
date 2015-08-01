package walsh.teaching.spring.di.xmlinjection;

public class SimpleFileLister implements FileLister {
    @Override
    public void list(File file) {
        System.out.println(file.getName());
    }
}
