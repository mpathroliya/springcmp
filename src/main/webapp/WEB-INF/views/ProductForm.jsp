<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<html>
    <body  style="background-color: lightblue;">

         <a href="/admin/viewProduct">Back</a>

		<h1>Add New Product</h1>
       <form:form method="post" action="/save">  
      	<table >  
         <tr>  
          <td>Name : </td> 
          <td><form:input path="Name" maxlength="30" required = "true"  /></td>
         </tr>  
         <tr>  
            <td>Price : </td> 
            <td><form:input path="Price" required = "true"  /></td>
           </tr>  
         <tr>  
          <td>Description :</td>  
          <td><form:input path="Description" required = "true" maxlength="255"/></td>
         </tr> 

         <tr>  
            <td>SupplierId :</td>  
            <td><form:input path="SupplierId" required = "true" /></td>
           </tr> 
         <tr>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
      </body>

      <html>
      