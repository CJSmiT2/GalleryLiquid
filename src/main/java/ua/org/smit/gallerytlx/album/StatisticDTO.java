package ua.org.smit.gallerytlx.album;

public class StatisticDTO {

    private int imageAlias;
    private int hits;
    private int likes;
    private int timeView;

    public int getImageAlias() {
        return imageAlias;
    }

    public void setImageAlias(int imageAlias) {
        this.imageAlias = imageAlias;
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

    public int getTimeView() {
        return timeView;
    }

    public void setTimeView(int timeView) {
        this.timeView = timeView;
    }

    @Override
    public String toString() {
        return "StatisticDTO{" + "imageAlias=" + imageAlias + ", hits=" + hits + ", likes=" + likes + ", timeView=" + timeView + '}';
    }

}
