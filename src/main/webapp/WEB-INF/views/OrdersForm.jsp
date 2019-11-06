<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
    <body  style="background-color: lightblue; color: DarkSlateGray ">
      <th>  <a href="/customer"> Back</a> </th>
		<h1 style="color: Black ">add products in Order</h1><br>
       <form:form method="post" action="/customer/addpo" modelAttribute="command">  
      	<table >
               <tr>  
                     <td><form:hidden path="OrderId"/></td>
               </tr> 
         <tr>  
          <td>ProductId : </td> 
          <td><form:input path="ProductId" required = "true" /></td>
         </tr>  
         <tr>  
            <td>Quantity : </td> 
            <td><form:input path="Quantity" required = "true" /></td>
           </tr>  
         <tr>  
          
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>


       <h1 style="color: Black ">products</h1>
       <table border="2" width="70%" cellpadding="2">
         <tr><th>Id</th><th>Name</th><th>Price</th><th>Description</th></tr>
         <c:forEach var="pro" items="${list1}"> 
         <tr>
         <td>${pro.getProductId()}</td>
         <td>${pro.getName()}</td>
         <td>${pro.getPrice()}</td>
         <td>${pro.getDescription()}</td>
         </tr>
         </c:forEach>
         </table>
         <br/>
         


         <h1 style="color: Black ">added products</h1>
       <table border="2" width="70%" cellpadding="2">
         <tr><th>Id</th><th>Name</th><th>Price</th></tr>
         <c:forEach var="apro" items="${list2}"> 
         <tr>
         <td>${apro.getProductId()}</td>
         <td>${apro.getName()}</td>
         <td>${apro.getPrice()}</td>
         </tr>
         </c:forEach>
         </table>
         <br>
         <h2 style="color: Black "> <a href="/customer/done">done with order</a></h2><br><br>
        

         </body>
         </html>

         
