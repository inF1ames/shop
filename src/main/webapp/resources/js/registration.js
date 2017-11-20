$(document).ready(function () {

    $('#submitRegistration').click(function () {
        var username = $('#login').val();
        var password = $('#password').val();
        var firstName = $('#firstName').val();
        var lastName = $('#lastNameName').val();
        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");
        $.ajax({
            type: "POST",
            url: "/registration",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: '{"username": "' + username + '", "password": "' + password + '", "firstName": "' + firstName + '", ' +
            '"lastName": "' + lastName + '"}',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token)
            },
            success: function (data) {
                if (data.status === "OK") {
                    window.location.href = "/main"
                } else {
                    alert(data.errorMessage)
                }

            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status + ": " + thrownError);
            }
        });
    });
});