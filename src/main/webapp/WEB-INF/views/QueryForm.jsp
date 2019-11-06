<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <body  style="background-color: lightblue;">


      <a href="/admin/viewAllOrders">Back</a>
		<h1>Search Orders by UserName</h1>
       <form:form method="post" action="/go" modelAttribute="command" required = "true">  
      	<table >
        
         <tr>    
            <td>Enter Userame : </td>
            <td><form:input path="UserName" required = "true"  /></td>
        </tr>
         
  
          <td><input type="submit" value="Go" /></td>  
         </tr>  
        </table>  
       </form:form>  
       </body>
       </html>