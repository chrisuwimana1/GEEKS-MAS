$(document).ready(function () {

    try{
        var decode = jwt_decode(localStorage.getItem("token"));
    }catch (e) {
        window.location = "http://localhost:8080/login";
    }

    //Populate drop down
    var dropdown = $('#blocksList');

    dropdown.empty();

    dropdown.append('<option selected="true" disabled>Select Block</option>');
    dropdown.prop('selectedIndex', 0);
    $.ajax({
        url: "http://localhost:8888/blocks",
        headers: {
            "token": localStorage.getItem("token")
        },
        contentType: "application/json",
        dataType: 'json',
        success: function(data){
            for (var i =0; i <data.length; i++) {
                dropdown.append($('<option></option>').attr('value', data[i].id).text(data[i].name));
            }
        }
    });

    var studentId = decoded.id;
    console.log(studentId);

    $.ajax({
        url: "http://localhost:8888//attendances/sections/students/"+studentId+"/cumul",
        contentType: "application/json",
        dataType: 'json',
        headers: {
            "token": localStorage.getItem("token")
        },
        success: function(data){

            $("#totalSessionsPossible").text(data.totalDaysCumul);
            $("#totalSessionsAttended").text(data.attendedCumul);
            $("#attendancePercentage").text(data.tmPercentCumul);

        }
    })

    $( "#blocksList" ).change(function() {

        $("#tbodyid").empty();
        $("#sessionsInBlock").text("");
        $("#totalSessions").text("");
        $("#percentage").text("");
        $("#extraCredit").text("");

        var blockID = $("#blocksList option:selected").val();

        $.ajax({
            url: "http://localhost:8888/attendances/details/"+studentId+"/blocks/"+blockID,
            contentType: "application/json",
            headers: {
                "token": localStorage.getItem("token")
            },
            dataType: 'json',
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    console.log(data[i].reportingId.attendanceDate)
                    $('#student-report tbody').append("<tr><td>" + data[i].reportingId.attendanceDate+"</td></tr>")
                }
            },
            error: function (e) {
                alert(e)
            }

        });

        alert("second ajax call");

        $.ajax({
            url: "http://localhost:8888/attendances/blocks/"+blockID+"/students/"+studentId,
            contentType: "application/json",
            headers: {
                "token": localStorage.getItem("token")
            },
            dataType: 'json',
            success: function (data) {
                //console.log(data);

                $("#sessionsInBlock").text(data.totalDays);
                $("#totalSessions").text(data.attended);
                $("#percentage").text(data.tmPercent);
                $("#extraCredit").text(data.extraPoint);
            },
            error: function (e) {
                alert(e)
            }

        })


    })





       /// alert( "Handler for .change() called." );
    //});


});