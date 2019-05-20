package tsvetankt.sitescraper.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tsvetankt.sitescraper.dao.entity.QueryHistory;
import tsvetankt.sitescraper.dao.repository.IQueryHistoryRepository;
import tsvetankt.sitescraper.service.ScraperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Site Scraper REST API")
@RequestMapping("/api")
public class ScraperRestController {

    @Autowired
    ScraperService scraperService;

    @Autowired
    IQueryHistoryRepository queryHistoryRepository;

    @ApiOperation(value = "Get Images URLs", response = Iterable.class)
    @RequestMapping(value = "/getImagesData", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<?> getImagesData(@RequestParam String query,
            @RequestParam String strategy, @RequestParam int iteration) {
        return ResponseEntity.ok(scraperService.getIteration(query, strategy, iteration));
    }

    @ApiOperation(value = "Get active scraping strategies", response = Iterable.class)
    @RequestMapping(value = "/getActiveStrategies", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<?> getActiveStrategies() {
        return ResponseEntity.ok(scraperService.getActiveStrategies());
    }

    @ApiOperation(value = "Get all the saved History", response = Iterable.class)
    @GetMapping(value = "/getQueryHistory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getQueryHistory() {
        List<QueryHistory> queryHistory = queryHistoryRepository.findAll();
        return new ResponseEntity<>(queryHistory, HttpStatus.OK);
    }

    @ApiOperation(value = "Get some saved History", response = Iterable.class)
    @GetMapping(value = "/getSomeQueryHistory", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSomeQueryHistory(@RequestParam String query,
            @RequestParam String strategy, @RequestParam int iteration) {

        QueryHistory queryHistory = queryHistoryRepository
                .findQueryHistoryByQueryStrategyAndIteration(query, strategy, iteration);
        return new ResponseEntity<>(queryHistory, HttpStatus.OK);
    }

}
