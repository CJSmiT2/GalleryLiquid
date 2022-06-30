package ua.org.smit.gallerytlx.album;

import java.util.List;
import java.util.Optional;
import ua.org.smit.gallerytlx.hibarnate.PhotomodelsDAO;
import ua.org.smit.gallerytlx.user.photomodel.PhotomodelInfo;

public class Photomodels {

    private final int albumId;

    private final PhotomodelsDAO dao = new PhotomodelsDAO(PhotomodelInfo.class);

    public Photomodels(int albumId) {
        this.albumId = albumId;
    }

    public List<PhotomodelInfo> getList() {
        return dao.findByAlbumId(albumId);
    }

    //TMP
    public void write(String alias, String nickName) {
        PhotomodelInfo model = new PhotomodelInfo();

        Optional<PhotomodelInfo> option = dao.findByAlias(alias);
        if (option.isPresent()) {
            model = option.get();
        } else {
            model.setAlias(alias);
            model.setNickName(nickName);
            model = dao.create(model);
        }

        model.getAlbumsIds().add(albumId);
        dao.update(model);
    }
}
