<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
        <head>
                <style>
                        header {
                          margin-top: 10px;
                          margin-left: 10px;
                          font-size: 40px;
                        }
    
                </style>
    
        </head>
        <body  style="background-color: lightblue;">
    <header>
    
            <table>
    
                    <tr  style="color: DarkSlateGray ">
                      <!-- <td>  <a href="/customer/viewProduct"> View Products </a> </td> -->
                      <th> <a href ="/customer"> Home </a></th> 
                      <th> <a href ="/customer/orderPage"> Create Order </a></th>
                       <th> <a href ="/customer/viewProduct"> View Previous Orders </a></th>
                       <th> <a href ="/index"> logout </a></th>
                    </tr>
            </table>
    
    
    
    </header>

<h1>Previous Orders</h1>

<h2>Placed Orders</h2>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th>
    <th>Date</th>

    <th>Price</th><th>Delivery Address</th><th>Status</th></tr>
<c:forEach var="pro" items="${list1}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getDate()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>
<td><a href="/customer/orderProducts/${pro.getOrderId()}">View Products in Order</a></td>
<td><a href="/customer/cancelOrder/${pro.getOrderId()}">Cancel Order</a></td>
</tr>

</c:forEach>
</table>

<h2>Processing Orders</h2>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th>
    <th>Date</th>

    <th>Price</th><th>Delivery Address</th><th>Status</th></tr>
<c:forEach var="pro" items="${list2}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getDate()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>
<td><a href="/customer/orderProducts/${pro.getOrderId()}">View Products in Order</a></td>
</tr>

</c:forEach>
</table>

<h2>Delivered Orders</h2>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th>
    <th>Date</th>

    <th>Price</th><th>Delivery Address</th><th>Status</th></tr>
<c:forEach var="pro" items="${list3}"> 
<tr>
<td>${pro.getOrderId()}</td>
<td>${pro.getDate()}</td>
<td>${pro.getPrice()}</td>
<td>${pro.getDeliveryaddr()}</td>
<td>${pro.getStatus()}</td>
<td><a href="/customer/orderProducts/${pro.getOrderId()}">View Products in Order</a></td>
</tr>

</c:forEach>
</table>


</body>
</html>


