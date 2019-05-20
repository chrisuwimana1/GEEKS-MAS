$(document).ready(function () {

    try{
        var decode = jwt_decode(localStorage.getItem("token"));
    }catch (e) {
        window.location = "http://localhost:8080/login";
    }


    var studentId = decoded.id;
    console.log(studentId);

    // $.ajax({
    //     url: "",
    //     contentType: "application/json",
    //     dataType: 'json',
    //     success: function(data){
    //
    //         $("#totalSessionsPossible").text(data);
    //         $("#totalSessionsAttended").text(data);
    //         $("#attendancePercentage").text(data);
    //
    //
    //         $("#sessionsInBlock").text(data);
    //         $("#totalSessions").text(data);
    //         $("#percentage").text(data);
    //         $("#extraCredit").text(data);
    //     }
    // })


});