function upload(url){
    var fileContent = new FormData();
    fileContent.append("file",$('input[type=file]')[0].files[0]);
    $.ajax({
        type: "POST",
        enctype:"multipart/form-data",
        url: "http://localhost:8888/"+url,
        data: fileContent,
        processData: false,
        contentType: false,
        success: function(data, status, xhr) {
            $("#sucess").append("Success");
        },
        error: function(request, status, error){
            $("#error").append(request.responseJSON.message);
        }
    });



}