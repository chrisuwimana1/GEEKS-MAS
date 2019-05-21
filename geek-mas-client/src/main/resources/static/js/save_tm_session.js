$(document).ready(function () {

    $('[type="date"]').prop('max', function () {
        return new Date().toJSON().split('T')[0];
    });

    function validateDate(myDate) {
        var currentDate = new Date();

        if (myDate > currentDate) {
            //$("#error-date").text(" The session date is a Future Date");
            return false;
        } else {
            return true;
        }
    }


    $("#saveSession").on('click', function (evt) {
        var sessionDateInput = $("#sessionDate").val();
        var studentIdInput = $("#studentID").val();
        var sessionTypeInput = $("#tmSessionType").val();

        var student = {id: studentIdInput}
        var objectToSend = {sessionDate: sessionDateInput, sessionType: sessionTypeInput, student: student}

        var tmSession = JSON.stringify(objectToSend);

        $.ajax({
            url: "http://localhost:8888/tmsession/save",
            type: 'POST',
            headers: {
                "token": localStorage.getItem("token")
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

                if (data.responseJSON.validationMessages) {
                    $.each(data.responseJSON.validationMessages, function (index, errorMessage) {
                        messages += errorMessage + "<br>"
                    });
                } else {
                    messages = data.responseJSON.userMessage;
                }

                $("#error").text("");
                $("#error").append(messages);
            }
        })

    });
});