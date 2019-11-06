<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>CustomerOrders</h1>

<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>CustomerId</th><th>Date</th><th>Price</th><th>Quantity</th><th>Delivery Add.</th><th>Status</th></tr>
<c:forEach var="pro" items="${list2}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getSid()}</td>
<td>${pro.getDate()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getQuantity()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>
<!-- <td><a href="/deleteProduct/${pro.getProductId()}">Delete</a></td> -->
</tr>
</c:forEach>
</table>
<br/>

<h1>StoreOrders</h1>

<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>StoreId</th><th>Date</th><th>Price</th><th>Quantity</th><th>Delivery Add.</th><th>Status</th></tr>
<c:forEach var="pro" items="${list3}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getSid()}</td>
<td>${pro.getDate()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getQuantity()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>
<!-- <td><a href="/deleteProduct/${pro.getProductId()}">Delete</a></td> -->
</tr>
</c:forEach>
</table>

<h1>ExhibitOrders</h1>

<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>ExhibitId</th><th>Date</th><th>Price</th><th>Quantity</th><th>Delivery Add.</th><th>Status</th></tr>
<c:forEach var="pro" items="${list1}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getSid()}</td>
<td>${pro.getDate()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getQuantity()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>
<!-- <td><a href="/deleteProduct/${pro.getProductId()}">Delete</a></td> -->
</tr>
</c:forEach>
</table>
<br/>

<br/>



<!-- <a href="/save">Add New Product</a> -->