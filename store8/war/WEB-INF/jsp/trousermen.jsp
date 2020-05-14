<%@ include file="include_top.html" %>
    
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Products</h3>
    <c:forEach items="${model.products}" var="prod">
      <c:out value="${prod.image}"/>
      <c:out value="${prod.size}"/><c:out value="${prod.description}"/>
      <i>£</i><c:out value="${prod.price}"/></i><c:out value="${prod.id}"/><br><br>
    </c:forEach>
    <section id="portfolio" class="container">
        
      
        <ul class="portfolio-items col-3">
          <c:forEach items="${model.products}" var="prod">
            <li class="portfolio-item apps">
                <div class="item-inner">
                    <img src="images/trousersmen/<c:out value="${prod.image}"/>"  alt="">
                    <h6>SIZE:<c:out value="${prod.size}"/></h6>
                    <div class="overlay">
                        <a class="preview btn btn-danger" href="images/trousersmen/<c:out value="${prod.image}"/>" rel="prettyPhoto"><i class="icon-eye-open"></i></a> 
                        <P><h20><c:out value="${prod.description}"/></h20></P>             
                    </div>  
                            
                </div> 
                  <div><a href="<c:url value="viewcart.htm"/>?id=<c:out value="${prod.id}"/>&action=add"><i>£</i><c:out value="${prod.price}"/></i>::Add to Cart</a></div>         
            </li>
          </c:forEach>  
        </ul>
         
<%@ include file="include_bottom.html" %>    

    