package ua.org.smit.gallerytlx.statistic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

class AlbumData {

    private Timestamp created = new Timestamp(System.currentTimeMillis());
    private Timestamp updated = new Timestamp(System.currentTimeMillis());
    private int hitsGuest = 0;
    private int likesGuest = 0;
    private long timeViewGuest = 0;
    private int hitsAuthorized = 0;
    private int likesAuthorized = 0;
    private long timeViewAuthorized = 0;

    private final List<ImageData> images = new ArrayList<>();

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

    public int getHitsGuest() {
        return hitsGuest;
    }

    public void setHitsGuest(int hitsGuest) {
        this.hitsGuest = hitsGuest;
    }

    public int getLikesGuest() {
        return likesGuest;
    }

    public void setLikesGuest(int likesGuest) {
        this.likesGuest = likesGuest;
    }

    public long getTimeViewGuest() {
        return timeViewGuest;
    }

    public void setTimeViewGuest(long timeViewGuest) {
        this.timeViewGuest = timeViewGuest;
    }

    public int getHitsAuthorized() {
        return hitsAuthorized;
    }

    public void setHitsAuthorized(int hitsAuthorized) {
        this.hitsAuthorized = hitsAuthorized;
    }

    public int getLikesAuthorized() {
        return likesAuthorized;
    }

    public void setLikesAuthorized(int likesAuthorized) {
        this.likesAuthorized = likesAuthorized;
    }

    public long getTimeViewAuthorized() {
        return timeViewAuthorized;
    }

    public void setTimeViewAuthorized(long timeViewAuthorized) {
        this.timeViewAuthorized = timeViewAuthorized;
    }

    public List<ImageData> getImages() {
        return images;
    }

}
