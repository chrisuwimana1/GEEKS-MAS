$(document).ready(function () {
    var facultyId = null;
    var urlToSend= null;


    try{
        var decode = jwt_decode(localStorage.getItem("token"));
    }catch (e) {
        window.location = "http://localhost:8080/login";
    }


    switch (decoded.role) {
        case "ADMIN":
            urlToSend= "http://localhost:8888/attendances/faculties/";
            break;
        case "FACULTY":
            facultyId =decoded.id;;
            urlToSend="http://localhost:8888/attendances/faculties/"+facultyId+"/students";
            break;
    }


    var table = $('#faculty-report').DataTable({
        dom: 'lBfrtip',
        buttons: [
            'csv', 'excel', 'pdf', 'print'
        ],
        "processing": true,
        "ajax": {
           // "url": "http://localhost:8888/attendances/faculties/"+facultyId+"/students",
            "url": urlToSend,
            dataSrc: '',
            headers: {
                "token": localStorage.getItem("token")
            }
        },

        "columns": [
            {"data": "studentSectionId.studentId"},
            {"data": "studentName"},
            {"data": "totalPossibleDays"},
            {"data": "attended"},
            {"data": "tmPercent"},
            {"data": "extraPoint"},
            {"data": "blockName"}
        ]
    });
});