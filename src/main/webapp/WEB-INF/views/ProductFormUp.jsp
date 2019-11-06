<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <body  style="background-color: lightblue;">

         <a href="/admin/viewProduct">Back</a>

		<h1>Update Product</h1>
       <form:form method="post" action="/uppro" modelAttribute="command" >  
      	<table >
        
         <tr>    
            <td>Enter Id : </td> 
            <td><form:input path="ProductId"  required = "true" /></td>
            </tr>  
         <tr> 
          <td>Name : </td> 
          <td><form:input path="Name" maxlength="255" required = "true" /></td>
         </tr>  
         <tr>  
            <td>Price : </td> 
            <td><form:input path="Price" maxlength="255" required = "true" /></td>
           </tr>  
         <tr>  
          <td> Description :</td>  
          <td><form:input path="Description"  required = "true" /></td>
         </tr> 
  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
       </body>
       </html>