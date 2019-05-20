$(document).ready(function () {

    var table = $('#entry-report').DataTable({
            "processing": true,
            "ajax": {
                "url": "http://localhost:8888/attendances/entries",
                dataSrc: ''
            },
            "columns": [
                {"data": "studentId"},
                {"data": "studentName"},
                {"data": "possible"},
                {"data": "attended"},
                {
                    "data": "attended",

                    "render": function (data, type, row) {
                        return (data.possible / data.attended)/100;
                        // if (type === 'display') {
                        //     return '<span id="' + data.ID + '">' + data.FullName + '</span>';
                        // } else if (type === 'sort') {
                        //     return data.LastName;
                        // } else {
                        //     return data;
                        // }

                    }
                }

                //{"data": "id"

            ]
        }
        )
    ;


    /*





        var entryId = null;
        $.ajax({
            //url: contextRoot + '/employee/add',
            url: "http://localhost:8888/attendances/entries",
            contentType: 'application/json',
            success: function (data) {

                console.log(data.length)

                //for
                //alert("success");

                var percentage = null;
                var txt = null
                for (var i = 0; i < data.length; i++) {

                    percentage = (data[i].attended / data[i].possible) * 100;

                    txt += "<tr><td>" + data[i].studentId + "</td><td>" + data[i].studentName + "</td><td>" + data[i].possible + "</td><td>" + data[i].attended + "</td><td>" + percentage + " </td></tr>";
                }

                $("#entry-report").append(txt)

            },
            error: function (e) {
                alert(e);
            }
        });


        $('#entryList').on('change', function () {
            //var optionValue = $(this).val();
            //var optionText = $('#dropdownList option[value="'+optionValue+'"]').text();
            var optionText = $("#entryList option:selected").val();
            //alert("Selected Option Text: " + optionText);

            $("#entry-report > tr").remove();
            $.ajax({
                //url: contextRoot + '/employee/add',
                url: "http://localhost:8888/attendances/entries/" + 1,
                contentType: 'application/json',
                success: function (data) {

                    console.log(data.length)

                    //for
                    //alert("success");

                    var percentage = null;
                    var txt = null
                    for (var i = 0; i < data.length; i++) {

                        percentage = (data[i].attended / data[i].possible) * 100;

                        txt += "<tr><td>" + data[i].studentId + "</td><td>" + data[i].studentName + "</td><td>" + data[i].possible + "</td><td>" + data[i].attended + "</td><td>" + percentage + " </td></tr>";
                    }

                    $("#entry-report").append(txt)

                },
                error: function (e) {
                    alert(e);
                }
            });
        });
    */
});