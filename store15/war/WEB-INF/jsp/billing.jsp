<%@ include file="include_top.html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section id="portfolio" class="container">
<h1>Billing Information</h1>
<p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
<h1>cookies0 or ID=<c:out value="${model.cookies0}"/></h1>
<h1>cookies1 or total=<c:out value="${model.cookies1}"/></h1>
<h1>cookies2 or use same address=<c:out value="${model.cookies2}"/></h1>
<h1>cookies3 or email address=<c:out value="${model.cookies3}"/></h1>
<h1>cookies4 or first name=<c:out value="${model.cookies4}"/></h1>
<h1>cookies5 or last name=<c:out value="${model.cookies5}"/></h1>
<h1>cookies6 or address=<c:out value="${model.cookies6}"/></h1>
<h1>cookies7 or city=<c:out value="${model.cookies7}"/></h1>
<h1>cookies8 or country=<c:out value="${model.cookies8}"/></h1>
<h1>cookies9 or zip code=<c:out value="${model.cookies9}"/></h1>
<h1>cookies10 or telephone=<c:out value="${model.cookies10}"/></h1>


 <div class="col-md-6">      
            <form role="form">
                <div class="form-group">
                    <label for="name">Card Number</label>
                    <input type="text" name="card_number" class="form-control" required="required" placeholder="Card Number" autocomplete="off" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="First Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">Expiration Date</label>
                    <input type="text" name="exp_date" class="form-control" required="required" placeholder="Expiration Date" autocomplete="off"/>
                    <!-- <input type="text" class="form-control" id="name" placeholder="Last Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">CVV</label>
                    <input type="text" name="cvv" class="form-control" required="required" placeholder="CVV" autocomplete="off"/>
                   <!-- <input type="email" class="form-control" id="name" placeholder="Email"> -->
                </div>
                <div class="form-group">
                    <label for="name">First Name</label>
                    <input type="text" name="first_name" class="form-control" required="required" placeholder="First Name" value="<c:out value="${model.cookies4}"/>"/>
                    <!-- <input type="text" class="form-control" id="name" placeholder="First Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">Last Name</label>
                    <input type="text" name="last_name" class="form-control" required="required" placeholder="Last Name" value="<c:out value="${model.cookies5}"/>"/>
                    <!-- <input type="text" class="form-control" id="name" placeholder="Last Name"> -->
                </div>
                <div class="form-group">
                    <label for="name">Email</label>
                    <input type="email" name="email" class="form-control" required="required" placeholder="Email" value="<c:out value="${model.cookies3}"/>" />
                   <!-- <input type="email" class="form-control" id="name" placeholder="Email"> -->
                </div>
                <div class="form-group">
                    <label for="name">Address</label>
                    <input type="text" name="address" class="form-control" required="required" placeholder="Address" value="<c:out value="${model.cookies6}"/>" />
                   <!--  <input type="text" class="form-control" id="name" placeholder="Address"> -->
                </div>
                <div class="form-group">
                    <label for="name">City</label>
                    <input type="text" name="city" class="form-control" required="required" placeholder="City" value="<c:out value="${model.cookies7}"/>" />
                    <!--  <input type="text" class="form-control" id="name" placeholder="City"> -->
                </div>
                <div class="form-group">
                    <label for="name">Country</label>
                    <input type="text" name="country" class="form-control" required="required" placeholder="Country" value="<c:out value="${model.cookies8}"/>" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="City"> -->
                </div>
                <div class="form-group">
                    <label for="name">Zip Code</label>
                    <input type="text" name="zip_code" class="form-control" required="required" placeholder="Zip Code" value="<c:out value="${model.cookies9}"/>" />
                    <!--  <input type="text" class="form-control" id="name" placeholder="Zip Code"> -->
                </div>
                <div class="form-group">
                    <label for="name">Telephone</label>
                    <input type="text" name="telephone" class="form-control" required="required" placeholder="Telephone" value="<c:out value="${model.cookies10}"/>" />
                    <!-- <input type="text" class="form-control" id="name" placeholder="Telephone"> -->
                </div>
               
               
                <!--<button type="submit" class="btn btn-default">Submit</button>-->
                <input type="submit" name="submit" value="submit" />
            </form>
        </div>

</section>

<%@ include file="include_bottom.html" %> 