package ua.org.smit.gallerytlx.importdata;

import ua.org.smit.gallerytlx.album.AlbumInfo;
import ua.org.smit.gallerytlx.album.image.ImageInfo;
import ua.org.smit.gallerytlx.hibarnate.AlbumInfoDAO;
import ua.org.smit.gallerytlx.hibarnate.ImageInfoDAO;

public class ImportData {

    private AlbumInfoDAO albumDAO = new AlbumInfoDAO(AlbumInfo.class);
    private ImageInfoDAO imageDAO = new ImageInfoDAO(ImageInfo.class);

    public void write(Album albumImport) {
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setAlias(albumImport.alias);
        albumInfo.setTitle(albumImport.title);
        albumInfo.setPosterImageId(albumImport.posterAlias);
        albumInfo.setCreated(albumImport.created);
        albumInfo.setUpdated(albumImport.updated);
        albumInfo.setImagesCount(albumImport.images.size());

        AlbumInfo savedAlbum = albumDAO.create(albumInfo);
        int albumId = savedAlbum.getAlbumId();

        for (Image image : albumImport.images) {
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setAlbumId(albumId);
            imageInfo.setAlias(image.id);
            imageInfo.setCreated(image.created);
            imageInfo.setHits(image.hits);
            imageInfo.setLikes(image.likes);
            imageInfo.setTimeCounter(image.timeCounter);

            imageDAO.create(imageInfo);
        }
    }
}
