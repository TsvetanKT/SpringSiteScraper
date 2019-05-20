package tsvetankt.sitescraper.model;

import org.springframework.stereotype.Component;
import Application.SiteScraper;

@Component
public class SiteScraperFactory {

    private SiteScraper siteScraper;

    public SiteScraper getInstance() {

        if (siteScraper == null) {
            siteScraper = new SiteScraper();
        }

        return siteScraper;
    }
}
