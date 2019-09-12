$(document).ready(function() {
	
	$("#search-form").submit(function(event) {
		
		// stop submit the form, we will post it manually
		event.preventDefault();
		
		fire_Ajax_Search();
	});
});

function fire_Ajax_Search() {
	
	var search = {};
	search['status'] = $('#status').val();
	
	$("#btn-search").prop("disabled", false);
	
	/*$.ajax({
		
		type: "POST",
		url: "https://inairdt542592/snpapp/login/PsnLandingPage.jsp",
		contentType: "text/xml",
		data: <?xml version="1.0"?>
			<samlp:logoutRequest xmlns:samlp="urn:oasis:names:tc:SAML:2.0:protocol" ID="LR-34515-bpA64cybZi7z4dmOEmHQgZr1xL7VzNuIOsM" Version="2.0" IssueInstant="2014-10-14T18:01:41Z">
		<saml:NameID xmlns:saml="urn:oasis:names:tc:SAML:2.0:assertion">@NOT_USED@</saml:NameID>
		<samlp:SessionIndex>ST-10486-zCH9qI4mS3pvTzwcgEwb-b3-rumba-int-01-01</samlp:SessionIndex>
		</samlp:logoutRequest>',
		dataType: 'xml',
		timeout: 6000,
		cache: false,
		success: function(data) {
			
			var json = "<h4>Ajax Response</h4><pre>" + JSON.stringify(data, null, 4) + "</pre>";
			$('#feedback').html(json);
			
			$("#btn-search").prop("disabled", false)
		},
		failure: function(e) {
			
			var json = "<h4>Ajax Response</h4><pre>" + e.responseText + "</pre>";
			$('#feedback').html(json);
			
			$("#btn-search").prop("disabled", true);
		}
	});*/
	
	$.ajax({
	    type: 'POST',
	    // make sure you respect the same origin policy with this url:
	    // http://en.wikipedia.org/wiki/Same_origin_policy PsnLandingPage
	    url: 'https://inairdt542592/snpapp/login/PsnLandingPage.jsp',
	    data: { 
	        'logoutRequest': '<samlp:LogoutRequest xmlns:samlp="urn:oasis:names:tc:SAML:2.0:protocol" ID="LR-34515-bpA64cybZi7z4dmOEmHQgZr1xL7VzNuIOsM" Version="2.0" IssueInstant="2014-10-14T18:01:41Z"><saml:NameID xmlns:saml="urn:oasis:names:tc:SAML:2.0:assertion">@NOT_USED@</saml:NameID><samlp:SessionIndex>ST-34341-sk1bQVVC2Up7TgwDgfnb-b3-rumba-int-01-06</samlp:SessionIndex></samlp:LogoutRequest>', 
	        'ca$libri': 'no$libri' // <-- the $ sign in the parameter name seems unusual, I would avoid it
	    },
	    success: function(msg){
	        alert('wow' + msg);
	    }
	});
	
	/**
	 * 
	 * $.ajax({
		
		type: "POST",
		url: "/jquery-app/todos-search",
		contentType: "application/json",
		data: JSON.stringify(search),
		dataType: 'json',
		timeout: 6000,
		cache: false,
		success: function(data) {
			
			var json = "<h4>Ajax Response</h4><pre>" + JSON.stringify(data, null, 4) + "</pre>";
			$('#feedback').html(json);
			
			$("#btn-search").prop("disabled", false)
		},
		failure: function(e) {
			
			var json = "<h4>Ajax Response</h4><pre>" + e.responseText + "</pre>";
			$('#feedback').html(json);
			
			$("#btn-search").prop("disabled", true);
		}
	});
	 */
}