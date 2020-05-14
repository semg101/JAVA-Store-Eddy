<%@ include file="include_top.html" %>

    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h1>Parameter_ID=<c:out value="${model.param}"/></h1>
    <h1>Parameter_action=<c:out value="${model.param_action}"/></h1>
    <h1>cookies=<c:out value="${model.cookies}"/></h1>
    <h1>user_session_id=<c:out value="${model.user_session_id}"/></h1>
    <h1>Cookies2=<c:out value="${model.cookies2}"/></h1>
    <h3>Items</h3>
    <c:forEach items="${model.items}" var="item">
      <h6>Image=<c:out value="${item.image}"/></h6>
      <h6>Sex=<c:out value="${item.sex}"/></h6>
      
      <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid1)}">
           <img src="images/teeshirtmen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid2)}">
           <img src="images/trousersmen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid3)}">
           <img src="images/hatsmen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid4)}">
           <img src="images/shoesmen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex) && (item.category_id == model.categoryid5)}">
           <img src="images/accessoriesmen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      
      <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid1)}">
           <img src="images/teeshirtwomen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid2)}">
           <img src="images/trouserswomen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid3)}">
           <img src="images/hatswomen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid4)}">
           <img src="images/shoeswomen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      <c:if test="${(item.sex == model.sex2) && (item.category_id == model.categoryid5)}">
           <img src="images/accessorieswomen/<c:out value="${item.image}"/>" width="50" height="50" alt="">
      </c:if>
      
      <h6>Quantity=<c:out value="${item.quantity}"/></h6>
      <h6>Total=£<c:out value="${item.total}"/></h6>
      <h6>Product_ID=<c:out value="${item.product_id}"/></h6>
      <h6>Category_ID=<c:out value="${item.category_id}"/></h6>
      <h6>Price=<i>£</i><c:out value="${item.price}"/></i></h6>
      <h6>Item_ID=<c:out value="${item.id}"/></h6><br>Another Item from cart
    </c:forEach>
    
    <section id="portfolio" class="container">
        
        <div class="container">
          <table class="table-responsive col-md-12" >
           <thead>
            <tr><th>Product</th><th>Image</th><th>Price</th><th>Total</th><th>Quantity</th></tr>
           </thead>
           <tbody>

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
                   
                        <form class="navbar-form navbar-left" role="search">
                          <div class="form-group">
                            <!--<input type="text" class="form-control" placeholder="<c:out value="${item.quantity}"/>">-->
                            <input type="text" name="quantity" class="form-control" required="required" value="<c:out value="${item.quantity}"/>">
                          </div>
                          <input type="hidden" name="action" value="updatedelete" />
                          <input type="submit" class="btn btn-mini btn-primary" name="updatedelete" value="update" />
                          <input type="submit" class="btn btn-mini btn-danger " name="updatedelete" value="delete" />
                          <i class="icon-trash"></i><input type="hidden" name="id" value="<c:out value="${item.product_id}"/>" />
                          <c:if test="${!(item.message == model.message) }">
                            <div><c:out value="${item.message}"/></div>
                          </c:if>
                          
                        </form>
                    
               </td>
            </tr>
           </c:forEach>
           
            <tr>
               <td>shoe 1</td>
               <td><img src="images/shoesmen/1.jpg" width="50" height="50" alt=""></td>
               <td>£200</td>
               <td>£400</td>
               <td>
                   
                        <form class="navbar-form navbar-left" role="search">
                          <div class="form-group">
                            <!--  <input type="text" class="form-control" placeholder="2">-->
                            <input type="text" name="quantity" class="form-control" value="2">
                          </div>
                          <button type="submit" class="btn btn-default">Update</button>
                          <button type="submit" class="btn btn-default">Delete</button>
                        </form>
                    
               </td>
            </tr>
          
            
            <tr>
             
               <td>shoe 2</td>
               <td><img src="images/shoesmen/2.jpg" width="50" height="50" alt=""></td>
               <td>£100</td>
               <td>£300</td>
               
               <td>
                        <form role="form" action="viewcart.htm?action="""  class="navbar-form navbar-left" role="search">
                          <div class="form-group">
                           
                            <input type="text" name="quantity" class="form-control" value="3">
                          </div>
                          
                          <input type="submit" name="updatebutton" value="update" />
                          <input type="submit" name="delete-button" value="delete" />
                          <input type="hidden" name="id" value="5" />
                          <input type="hidden" name="action" value="all" />
                          
                        </form>
                        
                   </td>
              
             </tr>
           </tbody>
          </table>
          
          <div><a href="index.jsp" ><h5 align="center">Continue Shopping</h5></a></div>
          <c:if test="${(model.j == model.one)}">
           <div><a href="<c:url value="checkout.htm"/>"><h1 align="center">Checkout</h1></a></div>
          </c:if>
          
        
       </div>  
        
        
    </section><!--/#portfolio-->

    <%@ include file="include_bottom.html" %>