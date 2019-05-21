$(document).ready(function () {
    var table = $('#cancelledTable').DataTable({
        "processing": true,
        "ajax": {
            "url": "http://localhost:8888/cancelledSessions",
            headers: {
                "token":localStorage.getItem("token")
            },
            dataSrc: ''
        },
        "columns": [
            {"data": "sessionDate"},
            {"data": "reason"},
        ]
    });
});