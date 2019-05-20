package tsvetankt.sitescraper;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tsvetankt.sitescraper.DataInitializer;
import tsvetankt.sitescraper.SiteScraperApplication;

@SpringBootApplication
@ComponentScan("tsvetankt.sitescraper")
public class SiteScraperApplication {

    private final Logger logger = LoggerFactory.getLogger(SiteScraperApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SiteScraperApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(final DataInitializer initializer) {
        return new CommandLineRunner() {
            @Override
            public void run(String... arg0) throws Exception {
                logger.info("\n +++++++++ Initializing Data +++++++++ ");
                initializer.initData();
            }
        };
    }

    @Bean
    public TomcatServletWebServerFactory tomcatFactory() {
        return new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
            }
        };
    }
}
