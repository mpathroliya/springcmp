<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <body  style="background-color: lightblue;">
<header>

        <table>

                <tr  style="color: DarkSlateGray ">
                    <th> <a href ="/admin"> Menu </a></th>
                    <th> <a href ="/admin/viewProduct">Products</a></th>
                    <th> <a href="/admin/viewSupplier">Suppliers</a> </th>
                   <th> <a href ="/admin/viewAllOrders">Orders</a></th>
                   
                   
                </tr>
        </table>




</header>

<br>

<h1>Customers</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>UserName</th><th>Name</th><th> Phone</th><th>Address</th></tr>
<c:forEach var="pro" items="${list1}"> 
<tr>
<td>${pro.getUserName()}</td>
<td>${pro.getName()}</td>
<td>${pro.getPhone()}</td>
<td>${pro.getAddress()}</td>
</tr>

</c:forEach>
</table>
<!-- 
<h1>Exhibits</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th>

    <th>Price</th><th>Delivery Address</th><th>Status</th></tr>
<c:forEach var="pro" items="${list2}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>
</tr>

</c:forEach>
</table> -->

</body>
</html>
