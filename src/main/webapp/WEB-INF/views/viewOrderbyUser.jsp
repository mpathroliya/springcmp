<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
        <body  style="background-color: lightblue;">


<a href ="/admin/queryByUsername"> Back </a>
<h1>Orders of this Username</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>OrderId</th><th>Date</th><th>Price</th><th>Delivery Address</th><th>Status</th></tr>
<c:forEach var="pro" items="${list}"> 
<tr>
    <td>${pro.getOrderId()}</td>
    <td>${pro.getDate()}</td>
    <td>${pro.getPrice()}</td>
    <td>${pro.getDeliveryaddr()}</td>
    <td>${pro.getStatus()}</td>
</tr>
</c:forEach>
</table>
<br/>
</body>

</html>