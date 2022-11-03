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
        <%@ page import="java.util.ArrayList, Model.Account, Model.Book" %>
    <%	Account acc = (Account )request.getSession().getAttribute("person");%>
     <%	ArrayList<Book> ownBook = (ArrayList<Book>)request.getSession().getAttribute("ownedBooks");%>
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
            <div class="col-md-8">
                    <!--The book info start-->
                    <% for (Book i: ownBook) {%>
                   
                    <div style="margin: auto; box-shadow:8px 5px 5px 8px #888888;" class="row mb-3 d-flex justify-content-between">
                        <div class="col-md-9 col-sm-6 col-xl-4 text-center">
                            <a href="#" class="thumbnail bge">
                                <img src="<%=i.getImageUrl() %>" alt="Book cover" class="lazy" style="display:inline-block; width: 25vh;">
                            </a>
                        </div>
                        <div style="margin: auto;" class="col-md-9 col-sm-6 desc col-xl-8">
                            <p>
                                <a style="color: #2a6496;font-size: 1.2rem; font-weight: bold;" href="ShowOneBookServlet?currentISBN13=<%=i.getIsbn() %>" class="b text-decoration-none">
                                        <%=i.getTitle() %>
                                    </a>          
                            </p>
                            <p>
                            </p>
                            <p class="desClass"> <%=i.getDescription() %>
                            </p>
                        </div>
                    </div>
    			<% } %>
            </div>
        </div>
    </div>
    </section>