package ua.org.smit.gallerytlx.album;

import java.io.File;
import java.util.List;
import java.util.Optional;
import ua.org.smit.gallerytlx.album.image.Images;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import ua.org.smit.commontlx.filesystem.FolderCms;
import ua.org.smit.gallerytlx.album.image.ImageInfo;
import ua.org.smit.gallerytlx.hibarnate.AlbumInfoDAO;

public class Album {

    private static final Logger log = LogManager.getLogger(Album.class);

    private final AlbumInfo info;

    private final Images images;
    private final Photomodels photomodels;

    private final AlbumInfoDAO dao = new AlbumInfoDAO(AlbumInfo.class);

    private final FolderCms selfFolder;
    
    private final ImageListener listener;

    public Album(FolderCms galleryFolder, String alias) {
        log.debug("Init album. Alias = '{}'", alias);

        Optional<AlbumInfo> optional = dao.findByAlias(alias);
        if (!optional.isPresent()) {
            throw new RuntimeException("Cant find album by alias '" + alias + "'");
        }

        info = optional.get();
        images = new Images(info.getAlbumId());
        photomodels = new Photomodels(info.getAlbumId());

        this.selfFolder = new FolderCms(
                galleryFolder + File.separator + info.getAlias());
        
        listener = new ImageListener(images);
    }

    public QualityFolder getByQuality(Quality quality) {
        return new QualityFolder(selfFolder, quality);
    }

    public AlbumInfo getInfo() {
        return info;
    }

    public Images getImages() {
        return images;
    }

    public Photomodels getPhotomodels() {
        return photomodels;
    }

    public void addStatistics(StatisticDTO statistic) {
        info.addStatistic(statistic);
        images.addStatistic(statistic);
        dao.update(info);
    }

    public ImageListener getListener() {
        return listener;
    }
    
    public void updateStatistic(){ // TMP!!!!!
         List<ImageInfo> imagesTMP = this.images.getAllByAlbum();
         for (ImageInfo image : imagesTMP){
             info.setHits(info.getHits() + image.getHits());
             info.setLikes(info.getLikes()+ image.getLikes());
         }
         info.setImagesCount(imagesTMP.size());
         dao.update(info);
    }
    
    

}
