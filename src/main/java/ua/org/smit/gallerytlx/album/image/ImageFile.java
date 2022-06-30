package ua.org.smit.gallerytlx.album.image;

import java.io.File;
import ua.org.smit.commontlx.filesystem.FileCms;

public class ImageFile extends FileCms {

    private final int id;

    public ImageFile(File file, int id) {
        super(file);

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public enum Extension {
        JPEG, JPG, jpeg, jpg;
    }

}
