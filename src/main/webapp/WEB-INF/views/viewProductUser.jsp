<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
    <body  style="background-color: lightblue;">
<header>

        <table>

                <tr  style="color: DarkSlateGray ">
                  <!-- <td>  <a href="/customer/viewProduct"> View Products </a> </td> -->
                  <th> <a href ="/customer"> Home </a></th> 
                  <th> <a href ="/customer/orderPage"> Create Order </a></th>
                   <th> <a href ="/customer/viewPreviousOrders"> View Previous Orders </a></th>
                   <th> <a href ="/index"> logout </a></th>
                </tr>
        </table>



</header>
<h1>Product List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Name</th><th>Price</th><th>Description</th></tr>
<c:forEach var="pro" items="${list}"> 
<tr>
<td>${pro.getProductId()}</td>
<td>${pro.getName()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDescription()}</td>
<!-- <td><a href="/customer/productReview/${pro.getProductId()}">Write a review</a></td> -->
</tr>
</c:forEach>
</table>

</body>

<html>