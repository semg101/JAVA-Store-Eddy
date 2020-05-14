<%@ include file="include_top.html" %>
    
    <section id="portfolio" class="container">
        
        <div class="panel panel-default col-md-6">
          <table class="table">
          
            <th>Product</th><th>Image</th><th>Price</th><th>Total</th><th>Quantity</th>
            <tr>
               <td>shoe 1</td>
               <td><img src="images/shoesmen/1.jpg" width="50" height="50" alt=""></td>
               <td>£200</td>
               <td>£400</td>
               <td>
                   
                        <form class="navbar-form navbar-left" role="search">
                          <div class="form-group">
                            <input type="text" class="form-control" placeholder="2">
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
                   <div>
                        <form class="navbar-form navbar-left" role="search">
                          <div class="form-group">
                            <input type="text" class="form-control" placeholder="3">
                          </div>
                          <button type="submit" class="btn btn-default">Update</button>
                          <button type="submit" class="btn btn-default">Delete</button>
                        </form>
                    </div>
               </td>
            </tr>
        
          </table>
        </div>  
        
        <div><a href="index.jsp" ><h5 align="center">Continue Shopping</h5></a></div>
        <div><a href="checkout.jsp"><h1 align="center">Checkout</h1></a></div>
    </section><!--/#portfolio-->

    <%@ include file="include_bottom.html" %>