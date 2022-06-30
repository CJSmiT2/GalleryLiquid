package ua.org.smit.gallerytlx.album.image;

import java.sql.Timestamp;

public class ImageInfoDTO {

    private String albumAlias;
    private int imageId;
    private Timestamp created;
    private Timestamp updated;
    private int hits;
    private int likes;

    public String getAlbumAlias() {
        return albumAlias;
    }

    public void setAlbumAlias(String albumAlias) {
        this.albumAlias = albumAlias;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
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

    @Override
    public String toString() {
        return "ImageInfoDTO{" + "albumAlias=" + albumAlias + ", imageId=" + imageId + ", created=" + created + ", updated=" + updated + ", hits=" + hits + ", likes=" + likes + '}';
    }

}
