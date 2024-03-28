<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <ul>
        <c:forEach var="product" items="${products}">
            <li>${product.name} - ${product.price}</li>
        </c:forEach>
    </ul>
    <a href="/add">Add Product</a>
</body>
</html>
