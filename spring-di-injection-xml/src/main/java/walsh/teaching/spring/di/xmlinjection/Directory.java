package walsh.teaching.spring.di.xmlinjection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory {
    private List<File> files;
    private FileLister lister;

    public Directory() {
        files = new ArrayList<>();
    }

    public FileLister getLister() {
        return lister;
    }

    public void setLister(FileLister lister) {
        this.lister = lister;
    }

    public void addFiles(File... files) {
        this.files.addAll(Arrays.asList(files));
    }


    public void listFiles() {
        ////java 8 features: method reference
        files.forEach(lister::list);

        //jdk 8 foreach expression
        //files.forEach((file) -> lister.list(file));
    }
}
