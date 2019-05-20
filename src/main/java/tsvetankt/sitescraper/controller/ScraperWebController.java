package tsvetankt.sitescraper.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tsvetankt.sitescraper.model.QueryObject;
import tsvetankt.sitescraper.model.SiteScraperFactory;

@Controller
public class ScraperWebController {

    @Autowired
    private SiteScraperFactory scraper;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String images(@Valid @ModelAttribute("QueryObject") QueryObject queryObj,
            BindingResult result, Model model) {
        return imagesGrid(queryObj.getSearchText(), model);
    }

    @RequestMapping(value = "/")
    public String imagesGrid(Model model) {
        return imagesGrid(null, model);
    }

    private String imagesGrid(String searchText, Model model) {
        QueryObject temp = (QueryObject) model.asMap().get("QueryObject");
        QueryObject object = temp == null ? new QueryObject() : temp;
        System.out.println("Images endpoint - text " + searchText);
        model.addAttribute("listOfStrategies", scraper.getInstance().getImplementedSources());
        model.addAttribute("QueryObject", object);
        model.addAttribute("searchText", searchText);
        model.addAttribute("selectedStrategy", object.getStrategy());
        return "imagesGrid";
    }
}
