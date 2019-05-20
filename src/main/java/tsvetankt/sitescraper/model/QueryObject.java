package tsvetankt.sitescraper.model;

import org.springframework.stereotype.Component;

@Component
public class QueryObject {

    private String searchText;
    private String strategy;
    private int iteration;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }


}
