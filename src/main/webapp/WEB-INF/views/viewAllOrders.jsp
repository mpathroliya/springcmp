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
                               <th> <a href ="/admin/viewUsers">Users</a></th>
                               
                               
                            </tr>
                    </table>
            
            
            
            
            </header>


<table border="2" width="70%" cellpadding="2"></table>
<tr>
     <!-- <a href="/admin">Back to Menu</a> -->
     <a href="/admin/viewCustomerOrders">Customer Orders</a>
     <!-- <a href="/admin/viewExhibitOrders">Exhibit Orders</a> -->
     <a href="/admin/viewDeliveredOrders">Delivered Orders</a>
     <a href="/admin/viewProcessingOrders">Processing Orders</a>
     <a href="/admin/viewPlacedOrders">Placed Orders</a>
     <a href = "/admin/queryByUsername">Search by Username</a>
</tr>
</table>
<br>
<br>
<h1>All Orders</h1>
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
<td><a href="/admin/orderProcessing/${pro.getOrderId()}">Status Processing</a></td>
<td><a href="/admin/orderDelivered/${pro.getOrderId()}">Status Delivered</a></td>
</tr>

</c:forEach>
</table>

</body>
</html>
