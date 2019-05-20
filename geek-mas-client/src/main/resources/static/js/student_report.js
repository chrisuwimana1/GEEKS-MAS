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

            $("#totalSessionsPossible").text(data.);
            $("#totalSessionsAttended").text(data.attendedCumul);
            $("#attendancePercentage").text(data.tmPercentCumul);


            $("#sessionsInBlock").text(data);
            $("#totalSessions").text(data);
            $("#percentage").text(data);
            $("#extraCredit").text(data);
        }
    })
    //
    // $( "#blocksList" ).change(function() {
    //
    //     alert($("#blocksList option:selected").text());
    //
    //     $.ajax({
    //         url: "http://localhost:8888//attendances/sections/students/"+studentId+"/cumul",
    //         contentType: "application/json",
    //         dataType: 'json',
    //         success: function(data){
    //
    //             $("#sessionsInBlock").text(data);
    //             $("#totalSessions").text(data);
    //             $("#percentage").text(data);
    //             $("#extraCredit").text(data);
    //         }
    //     })





       /// alert( "Handler for .change() called." );
    //});


});