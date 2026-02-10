import java.util.List;

public interface SiteDAOInterface {
    Site getSiteBySiteno(int siteno);

    List<Site> getAllSites();

    void updateSite(Site site);
}
