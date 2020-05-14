<%@ include file="include_top.html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section id="portfolio" class="container">
<p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
<h1>Shipping Information</h1>     
           
                 
        <form:form method="post" commandName="customer">
          <table>
            <tr>
              <td>First Name</td>
              <td>
               <form:input path="first_name"/>
              </td>
            </tr>
            <tr>
              <td>Last Name</td>
              <td>
               <form:input path="last_name"/>
              </td>
            </tr>
            <tr>
              <td>Email</td>
              <td>
               <form:input path="email"/>
              </td>
            </tr>
            <tr>
              <td>Address</td>
              <td>
               <form:input path="address"/>
              </td>
            </tr>
            <tr>
              <td>City</td>
              <td>
               <form:input path="city"/>
              </td>
            </tr>
            <tr>
              <td>Country</td>
              <td>
               <form:input path="country"/>
              </td>
            </tr>
            <tr>
              <td>Zip Code</td>
              <td>
               <form:input path="zip_code"/>
              </td>
            </tr>
            <tr>
              <td>Telephone</td>
              <td>
               <form:input path="telephone"/>
              </td>
            </tr>
          </table>
          <br>
          <input type="submit" align="center" value="Execute">
        </form:form>
          

</section>

<%@ include file="include_bottom.html" %> 