package ua.org.smit.gallerytlx.hibarnate;

import java.util.List;
import org.hibernate.query.Query;
import ua.org.smit.gallerytlx.album.image.ImageInfo;

public class ImageInfoDAO extends AbstractHibernateDAO< ImageInfo> {

    public ImageInfoDAO(Class<ImageInfo> aClass) {
        setClazz(aClass);
    }

    public List<ImageInfo> getImagesByAlbum(int albumId) {
        this.openCurrentSession();
        String hql = "from " + clazz.getName() + " E where E.albumId = :albumId order by E.id";
        Query query = currentSession.createQuery(hql);
        query.setParameter("albumId", albumId);
        List<ImageInfo> items = query.list();
        this.closeCurrentSession();
        return items;
    }

    public ImageInfo getImage(int albumId, int alias) {
        this.openCurrentSession();
        String hql = "from " + clazz.getName() + " E where E.albumId = :albumId and E.alias = :alias";
        Query query = currentSession.createQuery(hql);
        query.setParameter("albumId", albumId);
        query.setParameter("alias", alias);
        query.setMaxResults(1);
        ImageInfo item = (ImageInfo) query.getSingleResult();
        this.closeCurrentSession();
        return item;
    }

    public List<ImageInfo> getImagesByAliases(List<Integer> aliases) {
        this.openCurrentSession();
        String hql = "from " + clazz.getName() + " E where E.alias in (:aliases)";
        Query query = currentSession.createQuery(hql);
        query.setParameterList("aliases", aliases);
        List<ImageInfo> items = query.list();
        this.closeCurrentSession();
        return items;
    }

}
