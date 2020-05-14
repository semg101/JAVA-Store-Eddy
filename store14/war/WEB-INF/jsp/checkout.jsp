<%@ include file="include_top.html" %>

    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h1>Total=£<c:out value="${model.total}"/></h1>
    
    
    <section id="portfolio" class="container">
        
        <div class="container col-md-9">
          <table class="table">
            <th>Product</th><th>Image</th><th>Price</th><th>Total</th><th>Quantity</th>
            <c:forEach items="${model.items}" var="item"> 
           
            <tr>
              <c:if test="${(item.category_id == model.categoryid1)}"> 
               <td>tee-shirt <c:out value="${item.product_id}"/></td>
              </c:if>  
              <c:if test="${(item.category_id == model.categoryid2)}"> 
               <td>trouser <c:out value="${item.product_id}"/></td>
              </c:if>
              <c:if test="${(item.category_id == model.categoryid3)}"> 
               <td>hat <c:out value="${item.product_id}"/></td>
              </c:if>
              <c:if test="${(item.category_id == model.categoryid4)}"> 
               <td>shoe <c:out value="${item.product_id}"/></td>
              </c:if>
              <c:if test="${(item.category_id == model.categoryid5)}"> 
               <td>accessory <c:out value="${item.product_id}"/></td>
              </c:if>
              
              <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid1)}">
               <td><img src="images/teeshirtmen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid2)}">
               <td><img src="images/trousersmen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid3)}">
               <td><img src="images/hatsmen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid4)}">
               <td><img src="images/shoesmen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid5)}">
               <td><img src="images/accessoriesmen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
      
              <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid1)}">
               <td><img src="images/teeshirtwomen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid2)}">
               <td><img src="images/trouserswomen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid3)}">
               <td><img src="images/hatswomen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid4)}">
               <td><img src="images/shoeswomen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
              <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid5)}">
               <td><img src="images/accessorieswomen/<c:out value="${item.image}"/>" width="50" height="50" alt=""></td>
              </c:if>
               <td>£<c:out value="${item.price}"/></td>
               <td>£<c:out value="${item.total}"/></td>
               <td>
                <c:out value="${item.quantity}"/>

                          <c:if test="${!(item.message == model.message) }">
                            <div><c:out value="${item.message}"/></div>
                          </c:if>
               </td>
            </tr>
           </c:forEach>
          </table>
          <table class="col-md-9 pull-right">
           <th>SUBTOTAL</th><th>£<c:out value="${model.total}"/></th>
           <tbody>
            <tr>
               <td>SHIPPING</td>
               <td>Free Shipping</td>
            </tr>
            <tr>
               <td>TOTAL</td>
               <td>£<c:out value="${model.total}"/></td>
            </tr>
           </tbody>
          </table>
            
        </div><br>
        
        
        
        
 
       
    </section><!--/#portfolio-->
   <h2> <p align="center"><a href="<c:url value="shipping.htm"/>?submit=all">Continue onto shipping</a></p></h2>
    <%@ include file="include_bottom.html" %>