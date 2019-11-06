<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<html>
    <body  style="background-color: lightblue;">

         <a href="/customer">Back</a>


       <h1>Insert Order Details</h1>
       <form:form method="post" action="/customer/addaddr"  modelAttribute="addr">  
      	<table>
         <tr>  
          <td>Delivery Address :</td>  
          <td><form:input path="Deliveryaddr" maxlength="255"/></td>
         </tr> 
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  

</body>
</html>