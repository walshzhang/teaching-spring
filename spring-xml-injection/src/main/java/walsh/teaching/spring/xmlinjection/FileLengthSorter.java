package walsh.teaching.spring.xmlinjection;

import java.util.List;

public class FileLengthSorter implements FileSorter {
    @Override
    public List<File> sort(List<File> files) {
        files.sort((o1, o2) -> Float.compare(o1.getLength(), o2.getLength()));
        return files;
    }
}
