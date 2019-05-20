package tsvetankt.sitescraper;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tsvetankt.sitescraper.dao.entity.QueryHistory;
import tsvetankt.sitescraper.dao.repository.IQueryHistoryRepository;

@Component
public class DataInitializer {

  private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
  
  @Autowired
  IQueryHistoryRepository queryHistoryRepository;

  public void initData() {

    try {
      QueryHistory history = new QueryHistory();
      history.setIteration(1);
      history.setQuery("special");
      history.setStrategy("Google Images");
      List<String> urList = new ArrayList<>();
      urList.add("https://pbs.twimg.com/profile_images/443395572783800322/nXTuit5o.jpeg");
      urList.add("https://www.nps.gov/articles/images/Image-w-cred-cap_-1200w-_-Brown-Bear-page_-brown-bear-in-fog_2_1.jpg");
      history.setUrList(urList);
      queryHistoryRepository.save(history);
      
    } catch (final Exception ex) {
      logger.error("Exception while inserting the mock data {}", ex);
    }

  }
}
