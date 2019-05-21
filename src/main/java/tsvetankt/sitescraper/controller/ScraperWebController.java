package tsvetankt.sitescraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tsvetankt.sitescraper.model.SiteScraperFactory;

@Controller
public class ScraperWebController {

    @Autowired
    private SiteScraperFactory scraper;

    @RequestMapping(value = "/")
    public String imagesGrid(Model model) {
        return imagesGrid(null, model);
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String imageGrid(
            Model model,
            @RequestParam(name = "searchText", defaultValue= "") String searchText,
            @RequestParam(name = "strategy", defaultValue= "") String strategy,
            @RequestParam(name = "iteration", defaultValue= "1") Integer iteration) {
       
        System.out.println(String.format("searchText = %s | strategy = %s | iteration = %s",
                searchText, strategy, iteration));
        
        model.addAttribute("listOfStrategies", scraper.getInstance().getImplementedSources());
        model.addAttribute("searchText", searchText);
        model.addAttribute("selectedStrategy", strategy);
        model.addAttribute("iteration", iteration);
        
        return "imagesGrid"; 
    }

    private String imagesGrid(String searchText, Model model) {
        model.addAttribute("listOfStrategies", scraper.getInstance().getImplementedSources());
        model.addAttribute("searchText", searchText);
        return "imagesGrid";
    }
}
