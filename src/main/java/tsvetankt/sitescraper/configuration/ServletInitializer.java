package tsvetankt.sitescraper.configuration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tsvetankt.sitescraper.SiteScraperApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SiteScraperApplication.class);
    }
}
