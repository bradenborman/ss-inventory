$(document).ready(function () {

	$('#guideTxt').text("Please Scan ID-Badge To Begin")


    $("#user").focusout(function () {
    		if ($(this).val().trim() == "" || $(this).val().trim() == null) {
    			$("#user").focus();
    		} else {
    			$("#user").prop("disabled", true);
    			$("#scanner").focus();
    			$('#guideTxt').html("Please Scan Barcode on Scanner<br><small>Enter to clear</small>")
    		}
    });

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


    $('#user').on('keydown', function (e) {
    		if (e.keyCode == 9)
    			e.preventDefault();
    		if(e.keyCode == 13 && $(this).val().length > 2)         //If enter -- try to submit
    		    $("#scanner").focus();
    	});


	$('#scanner').on('keydown', function (e) {
		if (e.keyCode == 9)         //Prevent tabbing on scanner input
			e.preventDefault();
		if(e.keyCode == 13)         //If enter -- try to submit
		    submitForm()
	});

});



function submitForm() {
    if(validateForm()) {
		    document.forms["form"].submit();
    } else {
        reset()
    }
}


function reset() {
    $('#guideTxt').text("Please Scan ID-Badge To Begin")
    $("#user").val("")
    $("#scanner").val("")
    $("#scanner").prop("disabled", false);
    $("#user").prop("disabled", false);
    $("#user").focus();
}

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