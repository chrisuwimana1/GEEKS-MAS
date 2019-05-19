$(document).ready(function () {
    var tmSessionId = null;
    //$('#dtBasicExample').DataTable();
   var table = $('#dtBasicExample').DataTable({
        "processing": true,
        "ajax": {
            "url": "http://localhost:8888/tmsession",
            dataSrc: ''
        },
        "columns": [
            {"data": "student.id"},
            {"data": "student.name"},
            {"data": "sessionType"},
            {"data": "sessionDate"}
            //{"data": "id"}
            ]
    });
    //$('.dataTables_length').addClass('bs-select');

    $('#dtBasicExample').on( 'click', 'tbody tr', function () {
        console.log(table.row(this).data());

         tmSessionId = table.row(this).data().id;
        $('#studentID').val(table.row(this).data().student.id)
        $('#studentName').val(table.row(this).data().student.name)
        //$('#tmSessionType').val(table.row(this).data().sessionType)
        $('#sessionDate').val(table.row(this).data().sessionDate)

        // $('#tmSessionType').text(dtRow[0].cells[2].innerHTML);
        //


        $('#myModal').modal('show');

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
            //url: contextRoot + '/employee/add',
            url: "http://localhost:8888/tmsession/update/" + tmSessionId,
            type: 'PUT',
            data: tmSession,
            contentType: 'application/json',   // Sends
            success: function (session) {
                alert("success");
                $('#myModal').modal('hide');
            },
            error: function (e) {
                alert(e);
            }
        })

    })


    //Delete
    $('#deleteSession').on('click', function () {


        $.ajax({
            //url: contextRoot + '/employee/add',
            url: "http://localhost:8888/tmsession/delete/" + tmSessionId,
            type: 'DELETE',

           // contentType: 'application/json',   // Sends
            success: function () {
                alert("success");
                $('#myModal').modal('hide');
            },
            error: function (e) {
                alert(e);
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