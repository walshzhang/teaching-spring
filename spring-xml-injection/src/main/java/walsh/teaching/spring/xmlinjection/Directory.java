package walsh.teaching.spring.xmlinjection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory {
    private FileSorter sorter;
    private FileLister lister;

    private List<File> files;

    public Directory(FileSorter sorter) {
        this.sorter = sorter;
        this.files = new ArrayList<>();
    }

    public void addFile(File... files) {
        Arrays.asList(files).forEach(this.files::add);
    }

    public void setLister(FileLister lister) {
        this.lister = lister;
    }

    public void listFiles() {
        sorter.sort(files);
        files.forEach(lister::list);
    }
}
