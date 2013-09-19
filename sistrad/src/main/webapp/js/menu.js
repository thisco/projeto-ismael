
var ww = document.body.clientWidth;

$(window).bind('resize orientationchange', function() {
	ww = document.body.clientWidth;
	adjustMenu();
});

$(document).ready(function() {

    $.ajax({
    	async:false,
    	url: "template/menu.tmpl",
        dataType: "html",
        success: function( data ) {
            $( "head" ).append( data );
            updateMenuTable();
//            console.log("teste");
        }
    });
	
    bootstrapMenu();

});
/* Builds the updated table for the Livro list */
function builMenuRows(livros) {
	return _.template( $( "#menu-tmpl" ).html(), {"livros": livros});
}

/* Uses JAX-RS GET to retrieve current livros list */
function updateMenuTable() {
    $.ajax({
    	async:false,
    	url: "api/livro",
        cache: false,
        success: function(data) {
            $('#livros').empty().append(builMenuRows(data));
        },
        error: function(error) {
            console.log("error updating table -" + error.status);
        }
    });
}
function bootstrapMenu() {
	$(".nav li a").each(function() {
		if ($(this).next().length > 0) {
			$(this).addClass("parent");
		};
	});
	
	$(".header_logo").click(function(e) {
		e.preventDefault();
		$(this).toggleClass("active");
		$(".nav").toggle();
		console.log("teste1");
	});
	adjustMenu();
	
}

function adjustMenu() {
	if (ww < 768) {
		$(".header_logo").css("display", "inline-block");
		if (!$(".header_logo").hasClass("active")) {
			$(".nav").hide();
		} else {
			$(".nav").show();
		}
		$(".nav li").unbind('mouseenter mouseleave');
		$(".nav li a.parent").unbind('click').bind('click', function(e) {
			// must be attached to anchor element to prevent bubbling
			e.preventDefault();
			$(this).parent("li").toggleClass("hover");
			console.log("teste2");
		});
	} 
	else if (ww >= 768) {
		$(".header_logo").css("display", "none");
		$(".nav").show();
		$(".nav li").removeClass("hover");
		$(".nav li a").unbind('click');
		$(".nav li").unbind('mouseenter mouseleave').bind('mouseenter mouseleave', function() {
		 	// must be attached to li so that mouseleave is not triggered when hover over submenu
		 	$(this).toggleClass('hover');
		});
	}
}

