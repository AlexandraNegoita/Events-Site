$(document).ready(function(){
	$(".btn").click(function(){
		var attr = $(this).attr("data-type");

		$(".btn").removeClass("active");
		$(this).addClass("active");

		$(".event").hide();

		if(attr == "Concerts"){
			$("." + attr).show();
		}
		else if(attr == "Shows"){
			$("." + attr).show();
		}
		else if(attr == "Fairs"){
			$("." + attr).show();
		}
		else if(attr == "Sports"){
			$("." + attr).show();
		}
		else if(attr == "Exhibitions"){
			$("." + attr).show();
		}
		else{
			$(".item").show();
		}
	});
});

window.onbeforeunload = function() {
	return "v";
	}