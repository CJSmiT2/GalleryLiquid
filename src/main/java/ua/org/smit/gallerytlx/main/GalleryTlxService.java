package ua.org.smit.gallerytlx.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ua.org.smit.gallerytlx.album.Album;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ua.org.smit.commontlx.filesystem.FolderCms;
import ua.org.smit.gallerytlx.GalleryTLX;
import ua.org.smit.gallerytlx.album.AlbumInfo;
import ua.org.smit.gallerytlx.album.image.ImageInfo;
import ua.org.smit.gallerytlx.hibarnate.AlbumInfoDAO;
import ua.org.smit.gallerytlx.hibarnate.HibernateUtil;
import ua.org.smit.gallerytlx.hibarnate.ImageInfoDAO;
import ua.org.smit.gallerytlx.hibarnate.PhotomodelsDAO;
import ua.org.smit.gallerytlx.hibarnate.TagDAO;
import ua.org.smit.gallerytlx.tag.Tag;
import ua.org.smit.gallerytlx.user.photomodel.Photomodel;
import ua.org.smit.gallerytlx.user.photomodel.PhotomodelInfo;

@Service
public class GalleryTlxService implements GalleryTLX {

    static Logger log = Logger.getLogger(GalleryTlxService.class);

    private final AlbumInfoDAO albumInfoDAO = new AlbumInfoDAO(AlbumInfo.class);
    private final PhotomodelsDAO photomodelsDAO = new PhotomodelsDAO(PhotomodelInfo.class);
    private final ImageInfoDAO imageInfoDAO = new ImageInfoDAO(ImageInfo.class);
    private final TagDAO tagDAO = new TagDAO(Tag.class);

    private final FolderCms galleryFolder;

    public GalleryTlxService(FolderCms gallery, SessionFactory sessionFactory) {
        this.galleryFolder = gallery;
        HibernateUtil.setSessionFactory(sessionFactory);
    }

    @Override
    public Album getAlbum(String alias) {
        log.info("Get album: " + alias);
        return new Album(galleryFolder, alias);
    }

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = new ArrayList<>();
        for (AlbumInfo albumInfo : this.albumInfoDAO.findAll()) {
            albums.add(getAlbum(albumInfo.getAlias()));
        }
        return albums;
    }

    @Override
    public List<Album> getAlbumsByAliases(List<String> aliases) {
        List<Album> albums = new ArrayList<>();
        for (String alias : aliases) {
            albums.add(getAlbum(alias));
        }
        return albums;
    }

    @Override
    public List<Integer> getAlbumsIds() {
        return albumInfoDAO.getAllIds();
    }

    @Override
    public List<String> getAllAlbumAliases() {
        return albumInfoDAO.getAllAliases();
    }

    @Override
    public List<PhotomodelInfo> getAllPhotomodelsInfos() {
        return this.photomodelsDAO.getAllWithAlbumsIds();
    }

    @Override
    public List<ImageInfo> getImages(List<Integer> aliases) {
        List<ImageInfo> images = imageInfoDAO.getImagesByAliases(aliases);

        for (ImageInfo image : images) {
            image.setAlbumInfo();
        }

        return images;
    }

    @Override
    public Photomodel getPhotomodel(String alias) {
        log.info("Get photomodel: '" + alias + "'");
        return new Photomodel(alias);
    }

    @Override
    public List<AlbumInfo> getAlbumsByIds(List<Integer> albumsIds) {
        return this.albumInfoDAO.getByIds(albumsIds);
    }

    @Override
    public Tag createTag(String name) {
        log.info("Create tag by name '" + name + "'");
        Tag tag = new Tag();
        tag.setName(name);
        return tagDAO.create(tag);
    }

    @Override
    public List<ImageInfo> getImagesByAliases(List<Integer> aliases) {
        return this.imageInfoDAO.getImagesByAliases(aliases);
    }

    @Override
    public Tag getTag(int id) {
        return tagDAO.findOne(id);
    }

    @Override
    public List<Tag> getAllTags() {
        return this.tagDAO.findAll();
    }

    @Override
    public Optional<Tag> getTagByName(String name) {
        Optional<Tag> tag = this.tagDAO.findByName(name);
        if (!tag.isPresent()) {
            return Optional.empty();
        }
        tag.get().setAlbumsInfos();
        return tag;
    }

}
