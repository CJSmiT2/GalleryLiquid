package ua.org.smit.gallerytlx.importdata;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Album {

    public int albumId;
    public String alias;
    public String title;
    public int posterAlias;
    public Timestamp created;
    public Timestamp updated;

    public List<Image> images = new ArrayList<>();

    @Override
    public String toString() {
        return "Album{" + "albumId=" + albumId + ", alias=" + alias + ", title=" + title + ", posterAlias=" + posterAlias + ", created=" + created + ", updated=" + updated + ", images=" + images + '}';
    }
}
