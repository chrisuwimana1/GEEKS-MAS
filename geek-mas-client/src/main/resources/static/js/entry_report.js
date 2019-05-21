$(document).ready(function () {

    var table = $('#entry-report').DataTable({
        dom: 'lBfrtip',
        buttons: [
            'csv', 'excel', 'pdf', 'print'
        ],
        "processing": true,
        "ajax": {
            "url": "http://localhost:8888/attendances/entries",
            dataSrc: '',
            headers: {
                "token": localStorage.getItem("token")
            }
        },
        "columns": [
            {"data": "entryName"},
            {"data": "studentId"},
            {"data": "studentName"},
            {"data": "attended"},
            {"data": "totalPossibleDays"},
            {"data": "tmPercent"}
        ]
    });
});