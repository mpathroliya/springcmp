<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Register Exhibit</h1>
       <form:form method="post" action="/savem" modelAttribute="command">  
      	<table >  
         <tr>  
          <td>Username : </td> 
          <td><form:input path="UserName" maxlength="30"  /></td>
         </tr>  
         <tr>  
            <td>Password : </td> 
            <td><form:input path="Pwd"  /></td>
         </tr>
         <td><input type="submit" value="Save" /></td>  
      </tr>  
     </table>  
    </form:form>  
       
    }