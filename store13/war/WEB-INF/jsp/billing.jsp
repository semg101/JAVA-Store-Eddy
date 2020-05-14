<%@ include file="include_top.html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section id="portfolio" class="container">
<h1>Billing Information</h1>
<p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
<h1>cookies=<c:out value="${model.cookies2}"/></h1>
<h1>Same address=<c:out value="${model.cookies3}"/></h1>

 <div class="col-md-6">      
            <form role="form">
                <div class="form-group">
                    <label for="name">Card Number</label>
                    <input type="text" name="card_number" class="form-control" required="required" placeholder="Card Number" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="First Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">Expiration Date</label>
                    <input type="text" name="exp_date" class="form-control" required="required" placeholder="Expiration Date" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="Last Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">CVV</label>
                    <input type="text" name="cvv" class="form-control" required="required" placeholder="CVV" />
                   <!-- <input type="email" class="form-control" id="name" placeholder="Email"> -->
                </div>
                <div class="form-group">
                    <label for="name">First Name</label>
                    <input type="text" name="first_name" class="form-control" required="required" placeholder="First Name" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="First Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">Last Name</label>
                    <input type="text" name="last_name" class="form-control" required="required" placeholder="Last Name" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="Last Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">Email</label>
                    <input type="email" name="email" class="form-control" required="required" placeholder="Email" />
                   <!-- <input type="email" class="form-control" id="name" placeholder="Email"> -->
                </div>
                <div class="form-group">
                    <label for="name">Address</label>
                    <input type="text" name="address" class="form-control" required="required" placeholder="Address" />
                   <!--  <input type="text" class="form-control" id="name" placeholder="Address"> -->
                </div>
                <div class="form-group">
                    <label for="name">City</label>
                    <input type="text" name="city" class="form-control" required="required" placeholder="City" />
                    <!--  <input type="text" class="form-control" id="name" placeholder="City"> -->
                </div>
                <div class="form-group">
                    <label for="name">Country</label>
                    <input type="text" name="country" class="form-control" required="required" placeholder="Country" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="City"> -->
                </div>
                <div class="form-group">
                    <label for="name">Zip Code</label>
                    <input type="text" name="zip_code" class="form-control" required="required" placeholder="Zip Code" />
                    <!--  <input type="text" class="form-control" id="name" placeholder="Zip Code"> -->
                </div>
                <div class="form-group">
                    <label for="name">Telephone</label>
                    <input type="text" name="telephone" class="form-control" required="required" placeholder="Telephone" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="Telephone"> -->
                </div>
               
               
                <!--<button type="submit" class="btn btn-default">Submit</button>-->
                <input type="submit" name="submit" value="submit" />
            </form>
        </div>

</section>

<%@ include file="include_bottom.html" %> 