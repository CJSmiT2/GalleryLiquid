package ua.org.smit.gallerytlx;

import ua.org.smit.gallerytlx.album.Album;
import java.util.List;
import java.util.Optional;
import ua.org.smit.gallerytlx.album.AlbumInfo;
import ua.org.smit.gallerytlx.album.image.ImageInfo;
import ua.org.smit.gallerytlx.tag.Tag;
import ua.org.smit.gallerytlx.user.photomodel.Photomodel;
import ua.org.smit.gallerytlx.user.photomodel.PhotomodelInfo;

public interface GalleryTLX {

    Album getAlbum(String alias);

    List<Album> getAllAlbums();

    List<Album> getAlbumsByAliases(List<String> aliases);

    List<AlbumInfo> getAlbumsByIds(List<Integer> albumsIds);

    List<String> getAllAlbumAliases();

    List<Integer> getAlbumsIds();

    List<PhotomodelInfo> getAllPhotomodelsInfos();

    List<ImageInfo> getImages(List<Integer> ids);

    List<ImageInfo> getImagesByAliases(List<Integer> aliases);

    Photomodel getPhotomodel(String alias);

    Tag createTag(String name);

    Tag getTag(int id);

    Optional<Tag> getTagByName(String name);

    List<Tag> getAllTags();

}
