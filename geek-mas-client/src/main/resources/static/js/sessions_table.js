$(document).ready(function () {
    var tmSessionId = null;
    var decode = jwt_decode(localStorage.getItem("token"));
    var url = "http://localhost:8888/tmsession";
    if(decode.role == "STUDENT"){
        url = url + '/' + decode.id;
    }

   var table = $('#dtBasicExample').DataTable({
        "processing": true,
        "ajax": {
            "url": url,
            headers: {
                "token":localStorage.getItem("token")
            },
            dataSrc: ''
        },
        "columns": [
            {"data": "student.id"},
            {"data": "student.name"},
            {"data": "sessionType"},
            {"data": "sessionDate"}

            ]
    });
    //$('.dataTables_length').addClass('bs-select');

    $('#dtBasicExample').on( 'click', 'tbody tr', function () {

        if (decoded.role == "ADMIN"){
            tmSessionId = table.row(this).data().id;
            $('#tmSessionType').val(table.row(this).data().sessionType);
            $('#studentID').val(table.row(this).data().student.id);
            $('#studentName').val(table.row(this).data().student.name);
            $('#sessionDate').val(table.row(this).data().sessionDate);

            $('#myModal').modal('show');
        }

    } );


    //Update Ajax
    $('#updateSession').on('click', function () {

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

        $.ajax({
            url: "http://localhost:8888/tmsession/update/" + tmSessionId,
            type: 'PUT',
            headers: {
                "token":localStorage.getItem("token")
            },
            data: tmSession,
            contentType: 'application/json',   // Sends
            success: function (session) {
                alert("success");
                $('#myModal').modal('hide');
            },
            error: function (data) {
                alert(data.responseJSON.userMessage);
            }
        })

    })


    //Delete
    $('#deleteSession').on('click', function () {

        $.ajax({
            url: "http://localhost:8888/tmsession/delete/" + tmSessionId,
            type: 'DELETE',
            headers: {
                "token":localStorage.getItem("token")
            },
            success: function () {
                alert("success");
                $('#myModal').modal('hide');
            },
            error: function (data) {
                alert(data.responseJSON.userMessage);
            }
        })

    })

    // });

    // });
    $('#myModal').on('hidden.bs.modal', function (evt) {
        $('.modal .modal-body').empty();
        window.location = "sessions"
    });
});