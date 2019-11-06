<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
        <body  style="background-color: lightblue;">


<a href ="/admin/viewAllOrders"> Back </a>
<h1>Products in this order</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Price</th><th>Description</th></tr>
<c:forEach var="pro" items="${list}"> 
<tr>
<td>${pro.getProductId()}</td>
<td>${pro.getName()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDescription()}</td>
</tr>
</c:forEach>
</table>
<br/>
</body>

</html>