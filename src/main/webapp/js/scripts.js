// type selection
$(document).ready(function(){
	$(".btn_types").click(function(e){
		e.preventDefault();
		var attr = $(this).attr("data-type");

		$(".btn_types").removeClass("active");
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
			$(".event").show();
		}
	});
});

// sorting alphabetically
$(document).ready(function(){
	$("#sort-alph").click(function(e){
		e.preventDefault();
		var list_events = $('#listEvents');
		var listitems = list_events.children('.event').get();
		listitems.sort(
			function(a, b) {
	   			return $(a).attr("data-eventName").toLowerCase().trim().localeCompare($(b).attr("data-eventName").toLowerCase().trim());
			}
		)
		$.each(listitems, function(idx, itm) { 
			list_events.append(itm); 
		});
	})
});

//sorting by date
$(document).ready(function(){
	$("#sort-date").click(function(e){
		e.preventDefault();
		var list_events = $('#listEvents');
		var listitems = list_events.children('.event').get();
		listitems.sort(
			function(a, b) {
	   			return new Date($(a).attr("data-beginDate").toLowerCase().trim()) < new Date($(b).attr("data-beginDate").toLowerCase().trim());
			}
		)
		$.each(listitems, function(idx, itm) { 
			list_events.append(itm); 
		});
	})
});


// searching
$(document).ready(function() {
	const searchBox = document.querySelector('#search-event')
	const storeItems = document.querySelectorAll('.event')
	
	searchBox.addEventListener('keyup', (e) => {
		const searchFilter = e.target.value.toLowerCase().trim()
		storeItems.forEach((item) => {
			if($(item).attr("data-eventName").toLowerCase().trim().includes(searchFilter)) {
				item.style.display = 'block';
			} else {
				item.style.display = 'none';
			}
		})
	})
});