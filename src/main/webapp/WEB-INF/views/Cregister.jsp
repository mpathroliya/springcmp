<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
    <body  style="background-color: lightblue;">



		<h1>Register Customer</h1>
       <form:form method="post" action="/savex" modelAttribute="command">  
      	<table >  
         <tr>  
          <td>Username : </td> 
          <td><form:input path="UserName" maxlength="30" required = "true"  /></td>
         </tr>  
         <tr>  
            <td>Password : </td> 
            <td><form:input type="password" path="Pwd" required = "true" /></td>
         </tr>
         <td><input type="submit" value="Save" /></td>  
      </tr>  
     </table>  
    </form:form>  
       
    </body>
    </html>
