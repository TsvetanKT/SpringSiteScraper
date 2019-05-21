/**
 * Custom JS functions
 */

$(document).ready(function(){
	console.log("document readyy");
	callNextIteration();
    $contentLoadTriggered = false;
    $(window).scroll(function(){ 
       if((window.innerHeight + window.scrollY) >= document.body.offsetHeight)
        {
    	   callNextIteration();
        }
    });
});

function getIteration() {
    if ( typeof getIteration.counter == 'undefined' ) {
        getIteration.counter = 0;
    }

    getIteration.counter++;
    return getIteration.counter;
}

function getSelectedStrategy() {
	
	return $('#strategy option:selected').text().trim();
}