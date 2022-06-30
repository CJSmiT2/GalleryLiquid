package ua.org.smit.gallerytlx.config;

import org.hibernate.SessionFactory;
import ua.org.smit.commontlx.filesystem.FolderCms;

public class ConfigTest {

    public static final String ROOT_DIRECTORY = "D:\\LatexArtV7";

    public static final FolderCms ROOT_FOLDER = new FolderCms(ROOT_DIRECTORY);

    public static SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
            .configure().buildSessionFactory();
}
