<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<html>
    <body  style="background-color: lightblue;">
<header>

        <table>

                <tr  style="color: DarkSlateGray ">
                    <th> <a href ="/admin"> Menu </a></th>
                    <th> <a href="/admin/viewProduct">Products</a> </th>
                   <th> <a href ="/admin/viewUsers">Users</a></th>
                   <th> <a href ="/admin/viewAllOrders">Orders</a></th>
                </tr>
        </table>




</header>


<br/>
<a href="/admin/addSupplier">Add New Supplier</a>
<a href="/admin/updateSupplier">update a Supplier</a>

<br>

<h1>Supplier List</h1>
<table border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>Company Name</th><th>Address</th><th>Phno</th></tr>
<c:forEach var="pro" items="${list}"> 
<tr>
<td>${pro.getSupplierId()}</td>
<td>${pro.getCompany()}</td>
<td>${pro.getAddress()}</td>
<td>${pro.getPhno()}</td>
<!-- <td><a href="/manager/deleteSupplier/${pro.getSupplierId()}">Delete</a></td> -->
</tr>
</c:forEach>
</table>


</body>
</html>
