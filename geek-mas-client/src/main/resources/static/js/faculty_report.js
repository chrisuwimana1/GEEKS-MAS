$(document).ready(function () {

    var table = $('#faculty-report').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'csv', 'excel', 'pdf', 'print'
        ],
        "processing": true,
        "ajax": {
            "url": "http://localhost:8888/attendances/sections/students",
            dataSrc: '',
            headers: {
                "token": localStorage.getItem("token")
            }
        },

        "columns": [
            {"data": "studentId"},
            {"data": "studentName"},
            {"data": "possibleDays"},
            {"data": "attended"},
            {"data": "tmPercent"},
            {"data": "extraPoint"}
        ]
    });
});