package ua.org.smit.gallerytlx.album.image;

import java.util.List;
import ua.org.smit.gallerytlx.hibarnate.ImageInfoDAO;

public class Images {

    private int albumId;

    private final ImageInfoDAO dao = new ImageInfoDAO(ImageInfo.class);

    public Images(int albumId) {
        this.albumId = albumId;
    }

    public ImageInfo getByAlias(int alias) {
        return dao.getImage(albumId, alias);
    }

    public List<ImageInfo> getAllByAlbum() {
        return dao.getImagesByAlbum(albumId);
    }

}
