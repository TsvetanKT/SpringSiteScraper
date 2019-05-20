package tsvetankt.sitescraper.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(final CorsRegistry registry) {

    registry.addMapping("/**").allowedOrigins("http://localhost:8080")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD").allowCredentials(true);
  }
}
