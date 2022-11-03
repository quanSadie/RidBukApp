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
            <div class="col-md-8 col-sm-8">
                    <div id="ctl00_mainContent_pnlUser" class="user-page clearfix" onkeypress="javascript:return WebForm_FireDefaultButton(event, 'ctl00_mainContent_btnUpdate')">
                        <h1 class="postname">
                            Account information
                        </h1>
                        <div class="account-info clearfix">
                            <h2 class="posttitle">Update information</h2>
                            <form action="updateProfile">
                            <div class="account-form clearfix">
                                <div class="row">
                                    <div class="col-sm-9">
                                        <div id="ctl00_mainContent_divUserName" class="form-group">
                                            <label for="ctl00_mainContent_txtName" class="control-label">Username</label>
                                            <input name="ctl00$mainContent$txtName" type="text" value="<%=acc.getUserName() %>" maxlength="100" id="ctl00_mainContent_txtName" disabled="disabled" tabindex="10" class="aspNetDisabled form-control">
                                            <span id="ctl00_mainContent_rfvName" style="display:none;"></span>
                                            <span id="ctl00_mainContent_regexUserName" style="display:none;"></span>
                                        </div>
                                        <div class="form-group">
                                            <label for="ctl00_mainContent_txtEmail" class="control-label">Email</label>
                                            <input name="ctl00$mainContent$txtEmail" type="text" value="<%=acc.getUserEmail() %>" id="ctl00_mainContent_txtEmail" disabled="disabled" tabindex="10" class="aspNetDisabled form-control">
                                            <span id="ctl00_mainContent_regexEmail" style="display:none;"></span>
                                            <span id="ctl00_mainContent_rfvEmail" style="display:none;"></span>
                                        </div>
                                        <div class="form-group">
                                            <label for="ctl00_mainContent_txtFirstName" class="control-label">Display name</label>
                                            <input name="ctl00$mainContent$txtFirstName" type="text" name="personName" value="<%=acc.getFullName() %>" maxlength="100" id="ctl00_mainContent_txtFirstName" class="form-control">
                                            <span id="ctl00_mainContent_FirstNameRequired" class="error" style="display:none;">Vui lòng nhập Tên</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="button-wrap">
                                    <input type="submit" name="ctl00$mainContent$btnUpdate" value="Cập nhật" id="ctl00_mainContent_btnUpdate" class="btn btn-primary" style="margin-top: 10px; margin-bottom: 100px;">
                                </div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
        </div>
    </div>
    </section>