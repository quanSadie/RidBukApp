$(document).ready(function() {
            $.getJSON('https://api.itbook.store/1.0/new', function(data) {
              $.each(data.books, function(index, val) {
                   $.getJSON('https://api.itbook.store/1.0/books/' + val.isbn13, function(data1) {
	
					$('#recommendBooks').append('<div class="carousel-item ">' +
                     '<div class="col-md-3 ">' +
                     '<div class="card ">' +
                     '<div class="card-img ">' + 
                     '<img src="' + data1.image +' " class="img-fluid ">' + 
                     +'</div>' + 
                     '<div class="card-img-overlay ">Slide 6</div>' + 
                     ' </div>' +
                     ' </div>' + 
                     ' </div>');
                    
                });

              });
            });
            
        });