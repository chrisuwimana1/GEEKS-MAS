$(document).ready(function () {
    $("#search-section").hide();

    try {
        var decode = jwt_decode(localStorage.getItem("token"));
    } catch (e) {
        window.location = "http://localhost:8080/login";
    }

    var studentId = null;

    switch (decoded.role) {
        case "ADMIN":
        case "FACULTY":
            $("#search-section").show();
            $("blocksList").hide();
            //studentId = $("#studentID").val();
            //console(studentId);
            break;
        case "STUDENT":
            studentId = decoded.id;
            loadDropDownList();
            getAccumulativeInfo();
            break;
    }

    function loadDropDownList() {
        //Populate drop down
        var dropdown = $('#blocksList');

        dropdown.empty();

        dropdown.append('<option selected="true" disabled>Select Block</option>');
        dropdown.prop('selectedIndex', 0);
        $.ajax({
            url: "http://localhost:8888/attendances/sections/students/" + studentId,
            headers: {
                "token": localStorage.getItem("token")
            },
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    dropdown.append($('<option></option>').attr('value', data[i].blockId).text(data[i].blockName));
                }
            }
        })
    }

    function getAccumulativeInfo() {

        $.ajax({
            url: "http://localhost:8888/attendances/sections/students/" + studentId + "/cumul",
            contentType: "application/json",
            dataType: 'json',
            headers: {
                "token": localStorage.getItem("token")
            },
            success: function (data) {

                var possibleDays = (data.numberOfWeeksCumul*6)-data.cancelledSessionCumul;

                var attendancePercentage = parseFloat(Math.round((data.attendedCumul/possibleDays)*100).toFixed(2));

                $("#totalSessionsPossible").text(possibleDays);
                $("#totalSessionsAttended").text(data.attendedCumul);
                $("#cumulativeCancellesSessions").text(data.cancelledSessionCumul);
                $("#attendancePercentage").text(attendancePercentage);

            }
        })
    }

    $("#blocksList").change(function () {

        $("#tbodyid").empty();
        $("#sessionsInBlock").text("");
        $("#totalSessions").text("");
        $("#percentage").text("");
        $("#extraCredit").text("");

        var blockID = $("#blocksList option:selected").val();

        $.ajax({
            url: "http://localhost:8888/attendances/details/" + studentId + "/blocks/" + blockID,
            contentType: "application/json",
            headers: {
                "token": localStorage.getItem("token")
            },
            dataType: 'json',
            success: function (data) {
                console.log(data.length)
                for (var i = 0; i < data.length; i++) {
                    $('#student-report tbody').append("<tr><td>" + data[i].reportingId.attendanceDate + "</td></tr>")
                }
            },
            error: function (e) {
                alert(e)
            }

        });

        $.ajax({
            url: "http://localhost:8888/attendances/blocks/" + blockID + "/students/" + studentId,
            contentType: "application/json",
            headers: {
                "token": localStorage.getItem("token")
            },
            dataType: 'json',
            success: function (data) {
                //console.log(data);

                var possibleSessions = data.numberOfWeeks * 6  - data.cancelledSession;

                var blockAttendancePercentage = parseFloat(Math.round((data.attended/possibleSessions)*100).toFixed(2));


               // var t = data.totalDays - ;

                $("#sessionsInBlock").text(possibleSessions);
                $("#totalSessions").text(data.attended);
                $("#percentage").text(blockAttendancePercentage);
                $("#cancelledSessions").text(data.cancelledSession);
                $("#outOfBlockSessions").text(data.totalDaysOff)
                $("#extraCredit").text(data.bonus);

            },
            error: function (e) {
                alert(e)
            }
        })
    })

    $("#searchId").click(function () {
        studentId = $("#studentId").val();
        console.log(studentId);
        $("#blocksList").show();
        loadDropDownList();
        getAccumulativeInfo();
    })

});