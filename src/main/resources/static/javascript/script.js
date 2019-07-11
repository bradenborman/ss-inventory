$(document).ready(function () {
	$('#guideTxt').text("Please Scan ID-Badge To Begin")


	$("#user").focusout(function () {
		if ($(this).val().trim() == "" || $(this).val().trim() == null) {
			$("#user").focus();
		} else {
			$("#user").prop("disabled", true);
			$("#scanner").focus();
			$('#guideTxt').text("Please Scan Barcode on Scanner")
		}
	});


	//clear scanner Id if user is empty
	$("#user").keyup(function () {
		if ($(this).val().trim() == "" || $(this).val().trim() == null) {
			$("#scanner").val("")
		}
	});


        $("#scanner").focusin(function () {
    		if ($("#user").val().trim() == "" || $("#user").val().trim() == null) {
    			$("#user").focus();
    		}
    	});


	$("#scanner").focusout(function () {
		if ($(this).val().trim() == "" || $(this).val().trim() == null) {
			$(this).focus()
		} else {
			$("#scanner").prop("disabled", true);
			$('#guideTxt').text("Press submit to complete")
		}
	});


	function reset() {
		$('#guideTxt').text("Please Scan ID-Badge To Begin")
		$("#user").val("")
		$("#scanner").val("")
		$("#scanner").prop("disabled", false);
		$("#user").prop("disabled", false);
		$("#user").focus();
	}


	//prevent tabbing on scanner input
	$('#scanner').on('keydown', function (e) {
		if (e.keyCode == 9 && $(this).val().trim() == "") {
			e.preventDefault();
		}
	});



    //submit form on tab leave
	$("#scanner").blur(function () {

	    if(validateForm()) {
		    document.forms["form"].submit();
//		    jQuery.event.trigger({ type: 'keydown', which: 116 });
		}
		else
		   reset()
	});


});





function validateForm() {

	var user = $("#user").val().trim()
	var scanner = $("#scanner").val().trim()

	if (user.length > 2 && scanner.length > 1) {

		$("#user").prop("disabled", false);
		$("#scanner").prop("disabled", false);
		return true;
	} else {
		return false;
	}


}