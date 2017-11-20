var cart = {};


$.getJSON('/getItems', function (data) {
    var goods = data;

    checkCart();
    showCart();

    function showCart() {
        if ($.isEmptyObject(cart)) {
            var out = 'Корзина пуста. Добавить<a href="/goods"> товар</a>';
            $('#cart').html(out);
        } else {
            out = '';
            for (var key in cart) {
                out += '<button class="glyphicon glyphicon-remove-circle" data-art="' + key + '" ></button>';
                out += ' ';
                out += '<img src="' + goods[key].image + '" width="48">';
                out += ' ';
                out += goods[key].title;
                out += ' ';
                out += '<button class="glyphicon glyphicon-minus" data-art="' + key + '"></button>';
                out += ' ';
                out += cart[key];
                out += ' ';
                out += '<button class="glyphicon glyphicon-plus" data-art="' + key + '"></button>';
                out += ' ';
                out += cart[key] * goods[key].price + ' UAH';
                out += '<br>';
            }
            $('#cart').html(out);
            $('.glyphicon-plus').on('click', plusGoods);
            $('.glyphicon-minus').on('click', minusGoods);
            $('.glyphicon-remove-circle').on('click', deleteGoods);
        }
    }


    function plusGoods() {
        var id = $(this).attr('data-art');
        cart[id]++;
        saveCartToLS();
        showCart();
    }

    function minusGoods() {
        var id = $(this).attr('data-art');
        if (cart[id] > 1) {
            cart[id]--;
        }
        else {
            delete cart[id];
        }
        saveCartToLS();
        showCart();
    }

    function deleteGoods() {
        var id = $(this).attr('data-art');
        delete cart[id];
        saveCartToLS();
        showCart();
    }
});

function saveCartToLS() {
    localStorage.setItem('cart', JSON.stringify(cart));
}

function checkCart() {
    if (localStorage.getItem('cart') != null) {
        cart = JSON.parse(localStorage.getItem('cart'));
    }
}

$('#buy').click(function () {
    $.ajax({
        type: "POST",
        url: "/submitOrder",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.parse(localStorage.getItem('cart')),
        beforeSend: function (xhr) {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            xhr.setRequestHeader(header, token);
        },
        success: function (data) {
            if (data.status === "OK") {
                window.localStorage.clear();
                window.location.reload();
                $('#status').text('Заказ успешно оформлен');
            } else {
                alert(data.errorMessage);
            }
        }
    })
});
