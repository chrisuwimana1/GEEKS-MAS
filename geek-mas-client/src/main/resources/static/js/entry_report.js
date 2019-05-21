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
            {"data": "requiredAttended"},
            {"data": null, "render": function (data, type, row) {
                    return (data["numberOfWeeks"]*6-data["totalDaysOff"]-data["cancelledSession"])
                }},
            {"data": null, "render": function (data, type, row) {
                    return ((data["requiredAttended"])*100 /(data["numberOfWeeks"]*6-data["totalDaysOff"]-data["cancelledSession"])).toFixed(2)+'%'
                }}
        ]
    });
});