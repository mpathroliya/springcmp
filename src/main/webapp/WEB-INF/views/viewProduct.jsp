<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <body  style="background-color: lightblue;">
<header>

        <table>

                <tr  style="color: DarkSlateGray ">
                    <th> <a href ="/admin"> Menu </a></th>
                    <th> <a href="/admin/viewSupplier">Suppliers</a> </th>
                   <th> <a href ="/admin/viewUsers">Users</a></th>
                   <th> <a href ="/admin/viewAllOrders">Orders</a></th>
                   
                   
                </tr>
        </table>




</header>


<br>
<br>
<a href="/admin/addProduct">Add New Product</a>
<a href="/admin/updateProduct">update a Product</a>

<h1>Product List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Price</th><th>Description</th><th>Supplier</th></tr>
<c:forEach var="pro" items="${list}"> 
<tr>
<td>${pro.getProductId()}</td>
<td>${pro.getName()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDescription()}</td>
<td>${pro.getSupplierId()}</td>

<!-- <td><a href="/admin/deleteProduct/${pro.getProductId()}">Delete</a></td> -->
</tr>
</c:forEach>
</table>
<br/>


</body>

<html>