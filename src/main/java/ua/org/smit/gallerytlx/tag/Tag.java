package ua.org.smit.gallerytlx.tag;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import org.apache.log4j.Logger;
import ua.org.smit.gallerytlx.album.AlbumInfo;
import ua.org.smit.gallerytlx.album.image.ImageInfo;
import ua.org.smit.gallerytlx.hibarnate.AlbumInfoDAO;
import ua.org.smit.gallerytlx.hibarnate.ImageInfoDAO;
import ua.org.smit.gallerytlx.hibarnate.TagDAO;

@Entity
public class Tag {

    @Transient
    static Logger log = Logger.getLogger(Tag.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<ImageInfo> imagesInfos = new ArrayList<>();

    @Transient
    private final ImageInfoDAO imageInfoDAO = new ImageInfoDAO(ImageInfo.class);
    @Transient
    private final TagDAO tagDAO = new TagDAO(Tag.class);
    @Transient
    private final AlbumInfoDAO albumInfoDAO = new AlbumInfoDAO(AlbumInfo.class);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageInfo> getImagesInfos() {
        return imagesInfos;
    }

    public void setImagesInfos(List<ImageInfo> imagesInfos) {
        this.imagesInfos = imagesInfos;
    }

    public void addImageInfo(List<ImageInfo> imageInfo) {
        this.imagesInfos.addAll(imageInfo);
        this.tagDAO.update(this);
    }

    public void setAlbumsInfos() {
        for (ImageInfo image : imagesInfos) {
            image.setAlbumInfo(albumInfoDAO.findOne(image.getAlbumId()));
        }
    }

}
