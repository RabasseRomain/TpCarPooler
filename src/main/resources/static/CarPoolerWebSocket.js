$(document).ready(function () {
    var stompClient = null;

    console.log('trying: ');
    var socket = new SockJS('/CarPoolerWebSocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/rideList', function (ride) {
            var jsonObject = JSON.parse(ride.body);	
            updateRide(jsonObject);
        });
    });

    function sendName() {
    	stompClient.send("/app/rideCreate", {}, JSON.stringify({	
    		'login':			document.getElementById('login').value, 
        	'departurePlace': 	document.getElementById('departurePlace').value, 
        	'departureTime': 	document.getElementById('departureTime').value, 
        	'arrivalPlace': 	document.getElementById('arrivalPlace').value, 
        	'arrivalTime': 		document.getElementById('arrivalTime').value, 
        	'maxSeats': 		document.getElementById('maxSeats').value}));
    }

    function updateRide(ride) {
        var tr = document.createElement('tr');
        var td = document.createElement('td');
			td = ride.login;
				tr.append(td);
			td = ride.departurePlace
				tr.append(td);
			td = ride.departureTime
				tr.append(td);
			td = ride.arrivalPlace
				tr.append(td);
			td = ride.arrivalTime
				tr.append(td);
			td = ride.maxSeats;
				tr.append(td);
			$("#rides").append(tr);
    }

    
});