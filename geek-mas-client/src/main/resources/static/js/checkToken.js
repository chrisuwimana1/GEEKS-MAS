
$(document).ready(function () {
    try{
        var decode = jwt_decode(localStorage.getItem("token"));
    }catch (e) {
        window.location = "http://localhost:8080/login";
    }

    console.log("role " + decoded.role);
    if(decoded.role == "ADMIN"){
        $("#menuReportByEntry").css("display","none");
    }

});


function makeAjaxCall(){
    $.ajax({
        type: "POST",
        url: "http://localhost:8888/test",
        headers: {
            "token":localStorage.getItem("token")
        },
        data: {a:"d"},
        processData: false,
        contentType: false});


}