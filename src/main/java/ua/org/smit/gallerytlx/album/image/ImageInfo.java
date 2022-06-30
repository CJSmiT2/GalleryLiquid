package ua.org.smit.gallerytlx.album.image;

import java.sql.Timestamp;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import ua.org.smit.gallerytlx.album.AlbumInfo;
import ua.org.smit.gallerytlx.hibarnate.AlbumInfoDAO;

@Entity
public class ImageInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int albumId;

    @Column(unique = true)
    private int alias;

    private Timestamp created;

    private int hits;

    private int likes;

    private int timeCounter;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "tag_imageinfo",
//            joinColumns = {
//                @JoinColumn(name = "imagesinfos_id")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "tag_id")}
//    )
//    private List<Tag> tags = new ArrayList<>();
    @Transient
    private AlbumInfo albumInfo;
    @Transient
    private final AlbumInfoDAO albumInfoDAO = new AlbumInfoDAO(AlbumInfo.class);

    public ImageInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getAlias() {
        return alias;
    }

    public void setAlias(int alias) {
        this.alias = alias;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public void setTimeCounter(int timeCounter) {
        this.timeCounter = timeCounter;
    }

    public Optional<AlbumInfo> getAlbumInfo() {
        return Optional.of(albumInfo);
    }

    public void setAlbumInfo(AlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
    }

    public void setAlbumInfo() {
        this.albumInfo = albumInfoDAO.findOne(albumId);
    }
    
    public int getTimeViewsMins(){
        int seconds = timeCounter * 5;
        return (seconds / 60); 
    }
    
    public int getHitsInthousands(){
        return hits / 1000;
    }

}
