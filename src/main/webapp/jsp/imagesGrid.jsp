<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>${selectedStrategy} search for ${searchText}</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link href="https://fonts.googleapis.com/css?family=Droid+Sans:400,700" rel="stylesheet">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.8.1/baguetteBox.min.css">
		
		<link href="/css/customImageGrid.css" rel="stylesheet">
        <script src="/js/custom.js" type="text/javascript"> </script>
        <script type="text/javascript">
	        function isSearchQueryExists() {
	        	var theVar = "${searchText}";
	        	
	        	if (theVar) {
	        		return true;;
	        	} 
	        	
	        	return false;
	        }
	            
	        function callNextIteration() {
	        	$contentLoadTriggered = true;
	        	
	        	if (!isSearchQueryExists()) {
	        		return;
	        	}
	        	
	            var requestParams =
	            {
	            		query:$('#search').val(), 
	            		/* strategy:$('#strategy option:selected').text().trim(), */ 
	            		strategy:"${selectedStrategy}", 
	            		iteration: getIteration()
	        	};
	            $.get("/api/getImagesData", requestParams, function(data){
	            	console.log("dataa " + data);
	            	
	            	var innerHtml = "";
	            	for (const url of data) {
	            		innerHtml+="<div class=\"col-sm-3 col-md-2\">" + 
	            				"<a class=\"lightbox\" href=\"" + url + "\">" +
	                    "<img class=\"grid-image\" src=\"" + url + "\"></a></div>";
	            	}
	                $("#content-wrapper").append(innerHtml);
	                $contentLoadTriggered = false;
	                baguetteBox.run('.tz-gallery');
	            });
	            
	            console.log(requestParams);
	        }
        </script>
        
    </head>
    <body>
	
	<div class="navbar text-center">
		<form:form  modelAttribute="QueryObject" class="form-inline" method="POST" action="/">
			<div class="form-group">
		      <form:input type="text" id="search" class="form-control" path="searchText" autocomplete="off" value="${searchText}" style="width:600px;" />
		    </div>
			<div class="form-group">
		      <form:select class="form-control" id="strategy" path="strategy"  style="width:auto;">
	      			 <form:option value="${selectedStrategy}" />
                     <form:options items="${listOfStrategies}"></form:options>
				</form:select>
		    </div>
			<input type="submit" class="btn btn-default" value="Submit">
		</form:form>
	</div>
	
	<div class="container gallery-container">
    
    <div class="tz-gallery">

        <div id="content-wrapper" class="row image-table">
        </div>

    </div>

</div>

<script>
    baguetteBox.run('.tz-gallery');
</script>

</body>
</html>