
$(document).ready(function () {

    $("#btnSignIn").click(function (event) {
        var username = $("input[name='username']").val();
        var password = $("input[name='password']").val();

        $.ajax("http://localhost:8888/login", {
            method : "POST",
            contentType: 'application/json',
            data : JSON.stringify( {
                username: username,
                password: password
            })
        }).done(function (data) {
            localStorage.setItem("token",data);
            window.location = "http://localhost:8080/home";
        }).fail(function (data) {
            alert(data.responseJSON.userMessage);
        });

    });

});
