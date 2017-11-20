var cart = {};

$(document).ready(function () {
    loadGoods();
    checkCart();
    // showMiniCart();
});

function loadGoods() {
    $.getJSON('/getItems', function (data) {
        var out = '';
        for (var key in data) {
            out += '<div class="col-sm-6 col-md-4">';
            out += '<div class="thumbnail">';
            out += '<img src="' + data[key].image + '">';
            out += '<div class="caption">';
            out += '<h4>' + data[key].title + '</h4>';
            out += '<h4>' + data[key].description + '</h4>';
            out += '<h5>' + data[key].price + ' UAH' + '</h5>';
            out += '<button class="btn btn-primary" data-art="' + key + '">Купить</button>';
            out += '</div>';
            out += '</div>';
            out += '</div>';
        }
        $('#goods').html(out);
        $('button.btn-primary').on('click', function () {
            var articul = $(this).attr('data-art');
            if (cart[articul] != undefined) {
                cart[articul]++;
            } else {
                cart[articul] = 1;
            }
            localStorage.setItem('cart', JSON.stringify(cart));
            // showMiniCart();
        });
    });
}

function checkCart() {
    if (localStorage.getItem('cart') != null) {
        cart = JSON.parse(localStorage.getItem('cart'));
    }
}

// function showMiniCart() {
//     var out = '';
//     for (var i in cart) {
//         out += i + '---' + cart[i] + '<br>';
//     }
//     out += '<br><a href="/cart">Корзина</a>';
//     $('#mini-cart').html(out);
// }

