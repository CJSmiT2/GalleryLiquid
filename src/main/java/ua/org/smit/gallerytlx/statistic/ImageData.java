package ua.org.smit.gallerytlx.statistic;

import java.sql.Timestamp;

public class ImageData {

    private int id;

    private Timestamp created = new Timestamp(System.currentTimeMillis());
    private Timestamp updated = new Timestamp(System.currentTimeMillis());
    private int hitsGuest = 0;
    private int likesGuest = 0;
    private long timeViewGuest = 0;
    private int hitsAuthorized = 0;
    private int likesAuthorized = 0;
    private long timeViewAuthorized = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ImageData{" + "id=" + id + ", created=" + created + ", updated=" + updated + ", hitsGuest=" + hitsGuest + ", likesGuest=" + likesGuest + ", timeViewGuest=" + timeViewGuest + ", hitsAuthorized=" + hitsAuthorized + ", likesAuthorized=" + likesAuthorized + ", timeViewAuthorized=" + timeViewAuthorized + '}';
    }

}
