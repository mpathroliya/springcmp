<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>add products in Order</h1>
       <form:form method="post" action="/customer/ReviewinDB" modelAttribute="Pid">  
      	<table >
               <tr>  
                     <td><form:hidden path="ProductId"/></td>
               </tr> 
      >  
         <tr>  
            <td>Review : </td> 
            <td><form:input path="Review"  /></td>
           </tr>  
         <tr>  
          
          <td><input type ="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>