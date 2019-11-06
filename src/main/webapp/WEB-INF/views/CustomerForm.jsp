<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <body  style="background-color: lightblue;">
    

<h1>Add Customer Details</h1>  
       <form:form method="post" action="/customer/a"  modelAttribute="customer">  
      	<table >  
        <form:hidden path="UserName" value="${customer.getUserName()}"/>
         <tr>  
          <td>Name : </td> 
          <td><form:input path="Name" maxlength="30"  required = "true" /></td>
         </tr>  
         <tr>  
            <td>Phone : </td> 
            <td><form:input path="Phone" type="number" required = "true" /></td>
           </tr>  
         <tr>  
          <td>Address :</td>  
          <td><form:input path="Address" maxlength="255"/></td>
         </tr> 
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  

       </body>
       </html>