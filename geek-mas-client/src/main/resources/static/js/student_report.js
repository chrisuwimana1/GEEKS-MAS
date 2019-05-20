$(document).ready(function () {

    var studentId = "studentId"

    $.ajax({
        url: "",
        contentType: "application/json",
        dataType: 'json',
        success: function(data){

            $("#totalSessionsPossible").text(data);
            $("#totalSessionsAttended").text(data);
            $("#attendancePercentage").text(data);


            $("#sessionsInBlock").text(data);
            $("#totalSessions").text(data);
            $("#percentage").text(data);
            $("#extraCredit").text(data);
        }
    })


}