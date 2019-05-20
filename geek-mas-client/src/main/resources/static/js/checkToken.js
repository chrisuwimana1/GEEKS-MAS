
$(document).ready(function () {
    try{
        var decode = jwt_decode(localStorage.getItem("token"));
    }catch (e) {
        window.location = "http://localhost:8080/login";
    }

    switch (decoded.role) {
        case "STUDENT":
            $("#menuReportByEntry").css("display","none");
            $("#menuUpload").css("display","none");
            $("#menuReportByFaculty").css("display","none");
            $("#menuAddTmSession").css("display","none");
            break;
        case "FACULTY":
            $("#menuUpload").css("display","none");
            break;

    }

});