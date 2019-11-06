<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add Customer Details</h1>
       <form:form method="post" action="/exhibit/addedc"  modelAttribute="exhibit">  
      	<table >  
        <form:hidden path="UserName" value="${exhibit.getUserName()}"/>
         <tr>  
          <td>Name : </td> 
          <td><form:input path="Name" maxlength="30"  /></td>
         </tr>  
         <tr>  
            <td>Phone : </td> 
            <td><form:input path="Phone"  /></td>
           </tr>  
         <tr>  
          <td>Address :</td>  
          <td><form:input path="Address" maxlength="255"/></td>
         </tr> 
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  