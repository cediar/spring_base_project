$( document ).ready(function() {
	// Extends data-href link to the row
	$(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
	// For modify a person, buttons are enabled to Save and Delete. Also all the input fields
    $("#modifyPersonButton").click(function() {
    	$("#editPersonForm :input").prop("disabled", false);
    	$(this).prop("disabled",true);
	});
    
    // Inputs disabled for default in data person form.
    $("#editPersonForm :input[type=text]").prop("disabled", true);
    
	// Submit editPersonForm on click Save Button
	$("#savePersonButton").click(function() {
    	$("#editPersonForm").submit();
	});
	
	// Go to url for Delete a data person on click Delete Button
	$("#deletePersonButton").click(function() {
	    var url = $(this).data("target");
	    location.replace(url);
	});
	
	//If form editPersonForm has errors, Save and Delete buttons and inputs enabled
	if ($("#editPersonForm").hasClass("form-with-errors")) {
		$("#editPersonForm :input[type=text]").prop("disabled", false);
		$("#modifyPersonButton").prop("disabled",true);
		$("#deletePersonButton").prop("disabled",false);
		$("#savePersonButton").prop("disabled",false);
	}

});