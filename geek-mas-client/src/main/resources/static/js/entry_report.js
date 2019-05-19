$(document).ready(function () {
    $.ajax({
        //url: contextRoot + '/employee/add',
        url: "http://localhost:8888/attendance/entries" ,
        contentType: 'application/json',
        success: function (data) {
            alert("success");
        },
        error: function (e) {
            alert(e);
        }
    })

});