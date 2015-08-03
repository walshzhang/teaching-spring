package walsh.teaching.spring.xmlinjection;

public class DetailedFileLister implements FileLister {
    @Override
    public void list(File file) {
        System.out.printf("%s\t%f\n", file.getName(), file.getLength());
    }
}
