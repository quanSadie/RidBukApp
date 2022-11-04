<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <section style="height:auto;">
        <div class="container" style="height: auto !important;">
            <a href="index.jsp" title="Bookstore" style="text-decoration: none;">Home</a>
             > 
            <a href="#" title="Books" style="text-decoration: none;" >Account</a>
             > 
            <b>Book</b>
            <hr>
        </div>
        <!--books-->
        <%@ page import="java.util.ArrayList, Model.Account" %>
    <%	Account acc = (Account )request.getSession().getAttribute("person");%>
    <div class="container" id="bookContainer">
        <div class="row ">
            <div class="col-md-4">
                    <section class="user-sidebar">
                        <div class="userinfo ">
                            <div class="useritem">
                                <figure>
                                    <img alt="" src="//st.ntcdntempv3.com/data/siteimages/anonymous.png" class="avatar user-img">
                                    <figcaption>
                                        <div class="user-name"><%=acc.getFullName() %></div>    
                                    </figcaption>
                                </figure>
                            </div>          
                        </div>
                    </section>
                    <nav class="user-sidelink" style="background-color: #222;">
                        <ul id="property1" class="" role="tablist">
                            <li role="presentation" class="active">
                                <a class="linklist"  href="userPage.jsp" ><i class="fa fa-tachometer"></i>  User profile</a>
                            </li>
                            <li role="presentation" class="active">
                                <a class="linklist" href="userInfo.jsp" ><i class="fa fa-info-circle"></i>  Information</a>
                            </li>
                            <li role="presentation" class="active">
                                <a class="linklist" href="#" ><i class="fa fa-book"></i>  Books owned</a>
                            </li>
                            <li role="presentation" class="active">
                                <a class="linklist" href="changePass.jsp"><i class="fa fa-lock"></i>  Change password</a>
                            </li>
                        </ul>
                    </nav>
                    
            </div>
            <div class="col-md-6">
            <form action="changePass" method="post">
            <input type="hidden" name="person_idd" id="person_idd" value="<%=acc.getUserID()%>">
                    <h2>Change Password</h2>
                    <label>New Password</label>
                    <div class="form-group pass_show">
                        <input name="newPassword" id="newPassword" type="password" class="form-control" placeholder="New Password">
                    </div>
                    <label>Confirm Password</label>
                    <div class="form-group pass_show">
                        <input name="cnewPassword" id="cnewPassword" type="password" class="form-control" placeholder="Confirm Password">
                    </div>
                    <div class="form-group" style="margin-top: 10% ;">
                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Change Password" type="submit">
                    </div>
                     </form>
                     <span id='message'></span>
                </div>
               
        </div>
    </div>
    <script>
    $('#newPassword, #cnewPassword').on('keyup', function () {
    	  if ($('#newPassword').val() == $('#cnewPassword').val()) {
    	    $('#message').html('Matching').css('color', 'green');
    	  } else 
    	    $('#message').html('Passwords not match').css('color', 'red');
    	});
    </script>
    </section>