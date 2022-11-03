$(document).ready(function() {
            $.getJSON('https://api.itbook.store/1.0/new', function(data) {
              $.each(data.books, function(index, val) {
                   $.getJSON('https://api.itbook.store/1.0/books/' + val.isbn13, function(data1) {
					var pdff = '';
					var dk = false;
                    $.each(data1.pdf, function(index, value) {
	 					if (value.includes('pdf')){
							pdff = value;
							dk = true;
						}
                        
                    });
                    $('#recommendBooks').append('<div class="col-md-3">' +
                     '<div class="card">' +
                     '<div class="card-img">' + 
                     ' <img src="' + data1.image + '" class="img-fluid ">' + 
                     +'</div>' + 
                     '<div class="card-img-overlay ">Slide 1</div>' + 
                     ' </div>' +
                     ' </div>');
					$('#productRow').append('<div class="imgFrame col mb-5">' +
                     '<div class="card h-100">' +
                     '<img class="card-img-top" src="' + data1.image + '" alt="cover image" />' + 
                     +'<div class="card-body p-4">' + 
                     '<div class="text-center">' + 
                     ' <h5 class="fw-bolder"> <a style="text-decoration: none; color=#8c5a20;" download="myfile.pdf" href="'+ pdff + '">' + data1.title + ' </a></h5>' +
                                          
                    ' </div>' +
                     ' </div>' + 
                     ' </div>' +

                    '</div>');
  					$(".imgFrame").css("color", "#D8C3A5");
                });

              });
            });
            
        });