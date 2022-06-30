package ua.org.smit.gallerytlx.user.photomodel;

import java.util.List;
import java.util.Optional;
import ua.org.smit.gallerytlx.album.AlbumInfo;
import ua.org.smit.gallerytlx.hibarnate.AlbumInfoDAO;
import ua.org.smit.gallerytlx.hibarnate.PhotomodelsDAO;

public class Photomodel {

    private final PhotomodelsDAO photomodelDao = new PhotomodelsDAO(PhotomodelInfo.class);
    private final AlbumInfoDAO albumInfoDAO = new AlbumInfoDAO(AlbumInfo.class);

    private final PhotomodelInfo info;

    public Photomodel(String alias) {
        Optional<PhotomodelInfo> optional = photomodelDao.findByAlias(alias);
        if (!optional.isPresent()) {
            throw new RuntimeException("Cant find photomodel by alias '" + alias + "'");
        }
        info = optional.get();
    }

    public PhotomodelInfo getInfo() {
        return info;
    }

    public List<AlbumInfo> getAlbums() {
        return this.albumInfoDAO.getByIds(info.getAlbumsIds());
    }

}
