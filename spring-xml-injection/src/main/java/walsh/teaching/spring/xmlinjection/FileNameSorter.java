package walsh.teaching.spring.xmlinjection;

import java.util.List;

public class FileNameSorter implements FileSorter {

    @Override
    public List<File> sort(List<File> files) {
        files.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return files;
    }
}
