package ejercicio04;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {

    private String extension;

    public Filter(String extension) {
        this.extension=extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }
}
