package tsvetankt.sitescraper.dao.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QueryHistory {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String query;
    private String strategy;
    private int iteration;

    // There may be urls with more than 900 chars
    @Column(length = 900)
    @ElementCollection(targetClass = String.class)
    private List<String> urList;

    public QueryHistory() {
        this.urList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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

    public List<String> getUrList() {
        return urList;
    }

    public void setUrList(List<String> urList) {
        this.urList = urList;
    }
}
