$(document).ready(function () {

    $("#saveSession").on('click', function (evt) {
        alert("success")
        var studentIdInput = $("#studentID").val();
        var sessionTypeInput = $("#tmSessionType").val();
        var sessionDateInput = $("#sessionDate").val()
        console.log(studentIdInput);
        console.log(sessionTypeInput);
        console.log(sessionDateInput);

        var student = {id: studentIdInput}
        var objectToSend = {sessionDate: sessionDateInput, sessionType: sessionTypeInput, student: student}


        var tmSession = JSON.stringify(objectToSend);

        console.log(tmSession)
        // var tmSession = JSON.stringify(serializeObject($('#sessionForm')));
        // console.log("");
        //var contextRoot = "/" + window.location.pathname.split( '/' )[1];

        $.ajax({
            //url: contextRoot + '/employee/add',
            url: "http://localhost:8888/tmsession/save",
            type: 'POST',
            data: tmSession,
            contentType: 'application/json',   // Sends
            success: function (session) {
                alert("success");
            },
            error: function (e) {
                alert(e);
            }
        })
    });
});
// Translate form to array
// Then put in JSON format
// function serializeObject (form)
// {
//     var jsonObject = {};
//     var array = form.serializeArray();
//     $.each(array, function() {
//         jsonObject[this.name] = this.value;
//     });
//     return jsonObject;
//
// };