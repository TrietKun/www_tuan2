
    function buyProduct(productName) {
    document.getElementById("customerForm").style.display = "block";

    // Đặt tên sản phẩm vào mẫu thêm mới khách hàng
    document.getElementById("customerName").value = "Khách hàng mua " + productName;
}

    document.getElementById("customerForm").addEventListener("submit", function (event) {
    event.preventDefault();

    var customerName = document.getElementById("customerName").value;
    var customerEmail = document.getElementById("customerEmail").value;

    alert("Đã thêm mới khách hàng: " + customerName);
});
    function buyProduct(productName, productPrice) {
    var product = {
    name: productName,
    price: productPrice
};

    cartItems.push(product);

    updateCartDisplay();
}
    var cartItems = [];
    function updateCartDisplay() {
        var cartList = document.getElementById("cart-items");
        cartList.innerHTML = '';

        cartItems.forEach(function (item) {
            var listItem = document.createElement("li");
            listItem.textContent = item.name + ': Giá $' + item.price;
            cartList.appendChild(listItem);
        });
    }