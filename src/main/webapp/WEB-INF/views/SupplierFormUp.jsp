<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <body  style="background-color: lightblue;">

         <a href="/admin/viewSupplier">Back</a>      
<h1>Update Supplier</h1>
       <form:form method="post" action="/upsup" modelAttribute="command" required = "true">  
      	<table >
        
         <tr>    
            <td>Enter Id : </td> 
            <td><form:input path="SupplierId"  required="true" /></td>
            </tr>  
         <tr> 
          <td>Company Name : </td> 
          <td><form:input path="Company"  required="true" maxlength="255"  /></td>
         </tr>  
         <tr>  
            <td>Address : </td> 
            <td><form:input path="Address" maxlength="255" required="true" /></td>
           </tr>  
         <tr>  
          <td> Phone :</td>  
          <td><form:input path="Phno"  required = "true" /></td>
         </tr> 
  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
       </body>
       </html>
       