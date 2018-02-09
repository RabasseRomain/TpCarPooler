$(document).ready(function () {
    var stompClient = null;

    console.log('trying: ');
    var socket = new SockJS('/CarPoolerWebSocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/ride', function (ride) {
            var jsonObject = JSON.parse(ride.body);	
            updateRide(jsonObject);
        });
    });

    function sendName() {
    	var login = document.getElementById('login').value;
    	var departurePlace = document.getElementById('departurePlace').value;
    	var departureTime = document.getElementById('departureTime').value;
    	var arrivalPlace = document.getElementById('arrivalPlace').value;
    	var arrivalTime = document.getElementById('arrivalTime').value;
    	var maxSeats = document.getElementById('maxSeats').value;
    	
        stompClient.send("/app/rideListUp", {}, 
          JSON.stringify({'login':login, 'departurePlace':departurePlace, 'departureTime':departureTime, 
        	  			'arrivalPlace':arrivalPlace, 'arrivalTime': arrivalTime, 'maxSeats':maxSeats}));
    }

    function showMessageOutput(ride) {
        var listTable = document.getElementById('listTable');
        var tr = document.createElement('tr');
        var td = document.createElement('td');
			td = ride.login;
			tr.appendChild(td);
        td = ride.departurePlace
			tr.appendChild(td);
        td = ride.departureTime
			tr.appendChild(td);
        td = ride.arrivalPlace
			tr.appendChild(td);
        td = ride.arrivalTime
			tr.appendChild(td);
        td = ride.maxSeats - ride.passengers.size();
			tr.appendChild(td);
        td = ride.maxSeats;
        tr.appendChild(td);
        listTable.appendChild(tr);
    }

    
});