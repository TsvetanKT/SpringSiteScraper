package tsvetankt.sitescraper.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tsvetankt.sitescraper.dao.entity.QueryHistory;

@Repository
public interface IQueryHistoryRepository extends JpaRepository<QueryHistory, Long> {

    @Query("SELECT q FROM QueryHistory q WHERE q.query = ?1 AND q.strategy = ?2 AND q.iteration = ?3")
    QueryHistory findQueryHistoryByQueryStrategyAndIteration(String query, String strategy,
            int iteration);
}
