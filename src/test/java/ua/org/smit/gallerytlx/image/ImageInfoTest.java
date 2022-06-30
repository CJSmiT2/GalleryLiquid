//package ua.org.smit.gallerytlx.image;
//
//import org.junit.jupiter.api.AfterAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import ua.org.smit.gallerytlx.album.image.ImageInfo;
//import ua.org.smit.gallerytlx.hibarnate.HibernateUtil;
//import ua.org.smit.gallerytlx.hibarnate.ImageInfoDAO;
//import ua.org.smit.gallerytlx.hibarnate.TagDAO;
//import ua.org.smit.gallerytlx.tag.Tag;
//
//public class ImageInfoTest {
//
//    @BeforeAll
//    public static void initHibernate() {
//        HibernateUtil.buildSessionFactory();
//    }
//
//    @Test
//    public void tryAddTagToImage() {
//        TagDAO tagDAO = new TagDAO(Tag.class);
//        ImageInfoDAO imageDao = new ImageInfoDAO(ImageInfo.class);
//
//        ImageInfo image = new ImageInfo();
//        image = imageDao.create(image);
//
//        Tag tag1 = new Tag();
//        tag1.setName("test_tag_3");
//        tag1.getImagesInfos().add(image);
//        tag1 = tagDAO.create(tag1);
//
//        Tag tag2 = new Tag();
//        tag2.setName("test_tag_4");
//        tag2.getImagesInfos().add(image);
//        tag2 = tagDAO.create(tag2);
//
//        ImageInfo image2 = imageDao.findOne(image.getId());
//        assertEquals(2, image2.getTags().size());
//    }
//
//    @AfterAll
//    public static void closeHibernateSession() {
//        HibernateUtil.close();
//    }
//}
