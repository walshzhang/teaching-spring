package walsh.teaching.spring.xmlinjection;

public class FileSorters {
    public static FileSorter getFileNameSorter() {
        return files -> files.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public static FileSorter getFileLengthSorter() {
        return files -> files.sort((o1, o2) -> Float.compare(o1.getLength(), o2.getLength()));
    }
}
