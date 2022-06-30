package ua.org.smit.gallerytlx.album;

import java.io.File;
import ua.org.smit.commontlx.filesystem.FolderCms;
import ua.org.smit.gallerytlx.album.image.ImageFile;

public class QualityFolder extends FolderCms {

    public QualityFolder(FolderCms folder, Quality quality) {
        super(folder + File.separator + quality.name());
    }

    public ImageFile get(int id) {
        File file = null;

        for (ImageFile.Extension ext : ImageFile.Extension.values()) {
            file = new File(this + File.separator + id + "." + ext);
            if (file.exists()) {
                break;
            }
        }

        return new ImageFile(file, id);
    }

}
