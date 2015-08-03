package walsh.teaching.spring.xmlinjection;

public class FileListers {
    public static FileLister getNameFileLister() {
        return file -> System.out.println(file.getName());
    }

    public static FileLister getDetailedFileLister() {
        return file -> System.out.printf("%s\t%f\n", file.getName(), file.getLength());
    }
}
