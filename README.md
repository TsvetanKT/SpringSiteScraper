SiteScraper
=================
Spring Boot MVC project for site scraping

### Features:
*	Scrapes images from Google and Tumblr (for now)
* 	Scrapes with headless browser or api calls
*	Capable to save history searches in DB
*	'Infinite' scroll paging
*	API Documentation with Swagger

### Uses:
* 	Spring Boot 2.1.4
* 	JSP pages with Bootstrap and JQuery
*	API Documentation with Swagger 2.9.2
*	ORM with Hibernate
*	h2 DB
*	[baguetteBox.js](https://feimosi.github.io/baguetteBox.js) lightbox gallery
*	[SiteScraperCore](https://github.com/TsvetanKT/SiteScraperCore) library

### Swagger endpoints
*	UI *http://localhost:8080/swagger-ui.html*
*	API *http://localhost:8080/v2/api-docs*

### Example functionality
*	Search query "*cute kittens*" and strategy selected "*Google Images*" will show the found images in the custom UI
*	Search query "*https://cutest-cats.tumblr.com*" and strategy selected "*Tumblr Blog*" will show the images found in that tumblr blog in the custom UI

### Screenshot:
![Home view](https://raw.githubusercontent.com/TsvetanKT/SpringSiteScraper/master/SpringSiteScraperScreenshot.png "Home view")