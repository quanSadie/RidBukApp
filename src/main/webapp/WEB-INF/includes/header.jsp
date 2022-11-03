<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>
ul {
  display: inline;
  margin: 0;
  padding: 0;
}
ul li {display: inline-block;}
ul li:hover ul {color: green;display: block;}
ul li ul {
  position: absolute;
  width: 100px;
  display: none;
}
ul li ul li { 
  background: rgba(10,10,10,0.7); 
  display: block; 
}
ul li ul li a {display:block !important;} 

.cate{
text-decoration: none;
color: whitesmoke;
}
#categorize{
border-radius: 5px;
}
</style>
 <header  class="header sticky-top" style="background-color: #dde6b5;">
        <nav class="navbar  navbar-expand-lg">
            <div class="container px-4 px-lg-5">
                <div class="navbar-brand" style="font-family: didot; font-weight: bold; color: grey"><i style="color: black;" class="fa fa-book" aria-hidden="true"></i> RidBuk</div>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="index.jsp"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                    
                    <li style="margin: auto;">
     					 <a style="text-decoration: none;" href="#"><i class="fa fa-bars" aria-hidden="true"></i> Category</a>
     				 <ul id="categorize">
      				   <li><a class="cate" href="SearchBookServlet?searchinfo=Art"> <i class="fa fa-paint-brush" aria-hidden="true"></i> Art</a></li>
        			   <li><a class="cate" href="SearchBookServlet?searchinfo=Biography"> <i class="fa fa-caret-square-o-up" aria-hidden="true"></i> Biography</a></li>
        			   <li><a class="cate" href="SearchBookServlet?searchinfo=Comic"> <i class="fa fa-bolt" aria-hidden="true"></i> Comic</a></li>
        			   <li><a class="cate" href="SearchBookServlet?searchinfo=Horror"> <i class="fa fa-bug" aria-hidden="true"></i> Horror</a></li>
        			   <li><a class="cate" href="SearchBookServlet?searchinfo=Mystery"> <i class="fa fa-leaf" aria-hidden="true"></i> Mystery</a></li>
        			   <li><a class="cate" href="SearchBookServlet?searchinfo=Poetry"> <i class="fa fa-moon-o" aria-hidden="true"></i> Poetry</a></li>
      				</ul>
   				 </li>
                    
                    </ul>


                    <!-- Login page -->
                    <%if (request.getSession().getAttribute("this_id") != null ){ %>
                    <%String name = (String) request.getSession().getAttribute("this_name"); %>
                    <%String role = (String) request.getSession().getAttribute("this_role"); %>
                    <%String userID = (String) request.getSession().getAttribute("this_id"); %>
                    
                    	Welcome <span style="color: green; font-weight: bolder; margin-right: 10px; margin-left: 5px;"> <%=name%>   </span>
                    	<a style="margin-right: 5px;" class="btn btn-success" href="profile?role=<%=role%>" role="button"><i class="fa fa-address-card" aria-hidden="true"></i> Profile</a>
                    	<a class="btn btn-success" href="logout" role="button"><i class="fa fa-sign-out" aria-hidden="true"></i> Logout</a>
                    <%} else {%>
                    	<a class="btn btn-success" href="login.jsp" role="button"><i class="fa fa-sign-in" aria-hidden="true"></i>
                    	 Login</a>
                    <%} %>
                    
                </div>
            </div>
        </nav>
    </header>

    <!-- Header-->
    <header style="background: url('https://static.vecteezy.com/system/resources/previews/002/051/222/original/large-bookcase-with-books-library-book-shelf-interior-books-and-knowledge-illustration-pattern-free-vector.jpg');" class="bg-color py-5">
        <div class="container px-4 px-lg-5 my-5">
            <div class="text-center text-white">
                <h1 style="color: lightgreen; text-shadow: 2px 2px green;" class="display-4 fw-bolder">Welcome to RidBuk</h1>
                <p style="color: whitesmoke; text-shadow: 1px 1px black;" class="lead fw-normal mb-0">Broaden your horizon across interesting books</p>
            </div>
            <div class="container">

                <div class="row height d-flex justify-content-center align-items-center">

                    <div class="col-md-8">

                        <div class="search">
                            <i class="fa fa-search"></i>
                            <form action="SearchBookServlet">
                            <input id="searchinfo" name="searchinfo" type="text" class="form-control" style="display: inline-block; width: 80%;background-color: rgba(0, 0, 0, 0.5); color: white;" placeholder="Search books by Title, Author">
                    		<input id="searchbtn" type="submit" class="btn btn-primary" style="margin-bottom: 4px;background-color: rgba(0, 0, 0, 0.5);" value="Search">
                            </form>
                            
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </header>