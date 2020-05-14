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
                   <div>
                        <form class="navbar-form navbar-left" role="search">
                          <div class="form-group">
                            <input type="text" class="form-control" placeholder="2">
                          </div>
                          <button type="submit" class="btn btn-default">Update</button>
                          <button type="submit" class="btn btn-default">Delete</button>
                        </form>
                    </div>
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
          <table class="tablecol-md-3 pull-right">
            <th>SUBTOTAL</th><th>£700</th>
            <tr>
               <td>SHIPPING</td>
               <td>Free Shipping</td>
            </tr>
            <tr>
               <td>TOTAL</td>
               <td>£700</td>
            </tr>
            </table>
        </div>
        
        
        <div class="col-md-6">      
            <form role="form">
                <div class="form-group">
                    <label for="name">First Name</label>
                    <input type="text" class="form-control" id="name" placeholder="First Name">
                </div>
                <div class="form-group">
                    <label for="name">Last Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Last Name">
                </div>
                <div class="form-group">
                    <label for="name">Email</label>
                    <input type="email" class="form-control" id="name" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="name">Address</label>
                    <input type="text" class="form-control" id="name" placeholder="Address">
                </div>
                <div class="form-group">
                    <label for="name">City</label>
                    <input type="text" class="form-control" id="name" placeholder="City">
                </div>
                <div class="form-group">
                    <label for="name">Country</label>
                    <input type="text" class="form-control" id="name" placeholder="City">
                </div>
                <div class="form-group">
                    <label for="name">Zip Code</label>
                    <input type="text" class="form-control" id="name" placeholder="Zip Code">
                </div>
                <div class="form-group">
                    <label for="name">Telephone</label>
                    <input type="text" class="form-control" id="name" placeholder="Telephone">
                </div>
                
                <div class="checkbox">
                    <label><input type="checkbox">Create an account?</label>
                </div>
                <button type="submit" class="btn btn-default">Buy Now</button>
            </form>
        </div>
        
 
       
    </section><!--/#portfolio-->

    <%@ include file="include_bottom.html" %>