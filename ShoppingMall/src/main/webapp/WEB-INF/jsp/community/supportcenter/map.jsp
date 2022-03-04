<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
	<div id="map" style="width:2000px;height:500px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=de11fc5c0cfd2e57a8b4b2ef5ffdf781"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
		         center: new kakao.maps.LatLng(35.86906812266416, 128.59325404649175),
		         level: 3
		      };

		var map = new kakao.maps.Map(container, options);
		
		// 마커가 표시될 위치
		var markerPosition = new kakao.maps.LatLng(35.86906812266416, 128.59325404649175); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

		// 마커가 드래그 가능하도록 설정합니다 
		marker.setDraggable(true); 
	</script>
</body>
</html>