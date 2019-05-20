$(document).ready(function () {

    $("#saveSession").on('click', function (evt) {
        var studentIdInput = $("#studentID").val();
        var sessionTypeInput = $("#tmSessionType").val();
        var sessionDateInput = $("#sessionDate").val()

        var student = {id: studentIdInput}
        var objectToSend = {sessionDate: sessionDateInput, sessionType: sessionTypeInput, student: student}

        var tmSession = JSON.stringify(objectToSend);

        $.ajax({
            url: "http://localhost:8888/tmsession/save",
            type: 'POST',
            headers: {
                "token":localStorage.getItem("token")
            },
            data: tmSession,
            contentType: 'application/json',   // Sends
            success: function (session) {
                $("#sucess").text("Success!");
                $("#error").text("");
            },
            error: function (data) {
                $("#sucess").text("");

                var messages = "";

                if(data.responseJSON.validationMessages){
                    $.each( data.responseJSON.validationMessages, function (index, errorMessage){
                        messages+=errorMessage+"<br>"
                    } );
                }else{
                    messages = data.responseJSON.userMessage;
                }

                $("#error").text("");
                $("#error").append(messages);
            }
        })
    });
});
