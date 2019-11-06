<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<html>
    <body  style="background-color: lightblue;">
<table border="2" width="70%" cellpadding="2"></table>
<tr>
     <a href="/admin">Back to Menu</a>
     <a href="/admin/viewAllOrders">All Orders</a>
     <!-- <a href="/admin/viewExhibitOrders">Exhibit Orders</a> -->
     
</tr>
</table>
<br>
<br>
<h1>Customer Orders</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th>
    <th>Date</th>
    <th>Price</th><th>Delivery Address</th><th>Status</th></tr>
<c:forEach var="pro" items="${list}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getDate()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>

<td><a href="/admin/orderProducts/${pro.getOrderId()}">View Products in Order</a></td>

</tr>
</c:forEach>
</table>

</body>
</html>

