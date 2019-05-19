function upload(url){
    var fileContent = new FormData();
    fileContent.append("file",$('input[type=file]')[0].files[0]);
    $.ajax({
        type: "POST",
        enctype:"multipart/form-data",
        url: "http://localhost:8888/"+url,
        data: fileContent,
        headers: {
            "token":localStorage.getItem("token")
        },
        processData: false,
        contentType: false,
        success: function(data, status, xhr) {
            $("#sucess").text("Success");
            $("#error").text("");
        },
        error: function(request, status, error){
            $("#sucess").text("");
            $("#error").text(request.responseJSON.userMessage);
        }
    });



}