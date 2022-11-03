<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
    <div style="font-weight: bolder;" class="container" style="height: auto !important;">
            <a href="index.jsp" title="Bookstore">Bookstore</a>
             > 
            <a href="#" title="Books" >Search results</a>
             >  
            <b><span style="font-style: italic; color: #2a6496; ">
                ${requestScope.searchKey}
                </span></b>
            <hr>
        </div>
    <br>

    <!--books-->
    <div class="container" id="bookContainer">
        <div class="row ">
        
        <c:forEach items="${requestScope.mylist}" var="value">
        
        
       
    <div class="col-md-6 mb10 bookRs" style="margin-bottom: 20px; margin-top: 20px;box-shadow: 5px 5px 8px #888888;">
      <div class="row">
      <div class="col-md-4">
        <a href="ShowOneBookServlet?currentISBN13=<c:out value="${value.isbn}" />" class="thumbnail bge" title="<c:out value="${value.title}" />"><img style="width: 150px;" src="<c:out value="${value.imageUrl}" />" alt="HackSpace Magazine: Issue 58"></a>
      </div>    
      <div class="col-md-8 justify">
      <p class="desClass" style="font-family: 'Lato','Helvetica Neue',Helvetica,Arial,sans-serif;font-size: 15px;">
      <a class="b text-decoration-none" style="color: #2a6496;font-size: 1.2rem; font-weight: bold;" href="ShowOneBookServlet?currentISBN13=<c:out value="${value.isbn}" />" title="<c:out value="${value.title}" />"><c:out value="${value.title}" /></a>
       <span class="nobr">
       <span class="nobr" title="Without ratings">
       <img src="img/star.png" width="16" height="16" alt="" class="star">
       <img src="img/star.png" width="16" height="16" alt="" class="star">
       <img src="img/star.png" width="16" height="16" alt="" class="star">
       <img src="img/star0.png" width="16" height="16" alt="" class="star">
       <img src="img/star0.png" width="16" height="16" alt="" class="star">
       </br>
       </span>
       </span>
       <c:out value="${value.description}" />
      </p>      
      </div>
      </div>    
  </div>
    
        
		</c:forEach>
        
        
        
			     </div>
                </div>