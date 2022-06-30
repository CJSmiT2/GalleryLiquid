package ua.org.smit.gallerytlx.importdata;

import java.sql.Timestamp;

public class Image {

    public int id;
    public int albumId;
    public Timestamp created;
    public int hits;
    public int likes;
    public int timeCounter;

    @Override
    public String toString() {
        return "Image{" + "id=" + id + ", albumId=" + albumId + ", created=" + created + ", hits=" + hits + ", likes=" + likes + ", timeCounter=" + timeCounter + '}';
    }

}
