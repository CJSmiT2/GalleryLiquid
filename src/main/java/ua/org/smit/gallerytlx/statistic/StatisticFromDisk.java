//package ua.org.smit.gallerytlx.statistic;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
//import java.io.IOException;
//import org.apache.log4j.Logger;
//import ua.org.smit.commontlx.filesystem.FolderCms;
//import ua.org.smit.commontlx.filesystem.TxtFile;
//
//public class StatisticFromDisk {
//
//    private static final Logger log =  Logger.getLogger(StatisticFromDisk.class);
//
//    private final String alias;
//    private AlbumData statisticData = new AlbumData();
//
//    private static final ObjectMapper MAPER = new ObjectMapper();
//
//    public StatisticFromDisk(String alias) {
//        this.alias = alias;
//    }
//
//    public void readFromDisk() {
//        FolderCms jsonFolder = new FolderCms(STATISTIC_PATH);
//        File file = new File(jsonFolder + File.separator + alias + ".json");
//        if (file.exists()) {
//            try {
//                statisticData = MAPER.readValue(file, AlbumData.class);
//            } catch (IOException ex) {
//                log.warn("Cant load file: {}" + file);
//            }
//        }
//    }
//
//    public void writeToDisk() {
//        FolderCms jsonFolder = new FolderCms(STATISTIC_PATH);
//        File file = new File(jsonFolder + File.separator + alias + ".json");
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            MAPER.writeValue(file, statisticData);
//        } catch (IOException ex) {
//            log.warn("Cant write file: {}" + file);
//        }
//    }
//
//    public void initOldStatistic() {
//        FolderCms album = new FolderCms(OLD_STATISTIC_PATH + File.separator + alias);
//        TxtFile hits = new TxtFile(album + File.separator + "hits.txt");
//        TxtFile likes = new TxtFile(album + File.separator + "likes.txt");
//        TxtFile timeView = new TxtFile(album + File.separator + "time_view.txt");
//        statisticData.setHitsGuest(hits.readFirstInteger());
//        statisticData.setLikesGuest(likes.readFirstInteger());
//        statisticData.setTimeViewGuest(timeView.readFirstLong());
//
//        for (FolderCms imageFolder : album.getFoldersCms()) {
//            ImageData imageData = new ImageData();
//            imageData.setId(Integer.valueOf(imageFolder.getName()));
//            TxtFile hitsImg = new TxtFile(imageFolder + File.separator + "hits.txt");
//            TxtFile likesImg = new TxtFile(imageFolder + File.separator + "likes.txt");
//            TxtFile timeViewImg = new TxtFile(imageFolder + File.separator + "time_view.txt");
//            imageData.setHitsGuest(hitsImg.readFirstInteger());
//            imageData.setLikesGuest(likesImg.readFirstInteger());
//            imageData.setTimeViewGuest(timeViewImg.readFirstLong());
//            statisticData.getImages().add(imageData);
//        }
//    }
//
//}
