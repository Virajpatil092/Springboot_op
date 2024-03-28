<!DOCTYPE html>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
    <form action="/edit/${product.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${product.name}" required>
        <br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${product.price}" required>
        <br>
        <button type="submit">Save Changes</button>
    </form>
    <a href="/list">Back to Product List</a>
</body>
</html>
