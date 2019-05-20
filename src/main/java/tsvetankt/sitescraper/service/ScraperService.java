package tsvetankt.sitescraper.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsvetankt.sitescraper.dao.entity.QueryHistory;
import tsvetankt.sitescraper.dao.repository.IQueryHistoryRepository;
import Application.SiteScraper;

@Service
public class ScraperService {

    // TODO load from properties file
    private boolean USE_QUERY_HISTORY = true;

    @Autowired
    IQueryHistoryRepository queryHistoryRepository;

    public List<String> getIteration(String query, String strategy, int iteration) {

        if (USE_QUERY_HISTORY) {
            List<String> loaded = laodFromHistory(query, strategy, iteration);
            if (loaded != null) {
                return loaded;
            }
        }

        SiteScraper scraper = new SiteScraper();
        List<String> urls = scraper.getIteration(strategy, query, iteration);

        if (USE_QUERY_HISTORY) {
            saveToHistory(query, strategy, iteration, urls);
        }

        return urls;
    }

    public List<String> getActiveStrategies() {
        SiteScraper scraper = new SiteScraper();
        return scraper.getImplementedSources();
    }

    private List<String> laodFromHistory(String query, String strategy, int iteration) {
        QueryHistory history = queryHistoryRepository
                .findQueryHistoryByQueryStrategyAndIteration(query, strategy, iteration);

        if (history == null || history.getQuery() == null || history.getQuery().isEmpty()) {
            return null;
        }

        return history.getUrList();
    }

    private void saveToHistory(String query, String strategy, int iteration, List<String> urls) {
        QueryHistory history = new QueryHistory();
        history.setIteration(iteration);
        history.setStrategy(strategy);
        history.setQuery(query);
        history.setUrList(urls);
        queryHistoryRepository.saveAndFlush(history);
    }
}
