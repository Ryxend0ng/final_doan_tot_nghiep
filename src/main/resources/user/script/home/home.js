$(document).ready(function () {
    $('.close-btn-alert').click(function () {
        $('.alert').removeClass("show");
        $('.alert').addClass("hide");
    });
});


function detail(id) {
    window.location.href = '/ryxen-shop/detail-product/' + $("#view_" + id).val();
};

function getProductByCategory(idCategory) {
    window.location.href = '/ryxen-shop/product-category/' + $("#view_category_" + idCategory).val();
}