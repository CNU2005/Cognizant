$(document).ready(function () {

    $("#registerBtn").click(function () {
        $("#eventCard").fadeIn(1000);

        setTimeout(function () {
            $("#eventCard").fadeOut(1000);
        }, 3000);
    });

});