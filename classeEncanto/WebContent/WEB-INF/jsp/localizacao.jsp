<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/geral.css">
		<link rel="stylesheet" type="text/css" href="css/localizacao.css">
		<meta charset="UTF-8">
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    	<style type="text/css">
      		html { height: 100% }
     	 	body { height: 100%; margin: 0; padding: 0 }
      		#map_canvas { height: 50% }
    	</style>
		<title>Localização</title>
		<script src="js/faleConosco.js"></script>
	<script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDl8gRUgEBhN-Q5pIOxAwz-FNgE6RHDR1Q&sensor=true">
    </script>
    <script type="text/javascript">
      function initialize() {
        var mapOptions = {
          center: new google.maps.LatLng(-23.553169, -46.647822),
          zoom: 15,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
      }
    </script>
	</head>
	<body onload="initialize()">
		<%@ include file="/WEB-INF/jsp/header.jsp" %>
		<%@ include file="/WEB-INF/jsp/menuLateral.jsp" %>
		<h1>Localização</h1>
		
	    <div id="map_canvas"></div>
		
		<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	</body>
</html>