/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var socket = new WebSocket("ws://localhost:8080/Formative/actions");
socket.onmessage = onMessage;

function formSubmit() {
    var txtArea = document.getElementById("messageinput");
    var msg = txtArea.value;
    socket.send(msg);
    txtArea.value = "";
}

function onMessage(message){
    console.log(message);
    var data = message.data;
    var parent = document.getElementById("msgBody");
    var bubble = document.createElement("p");
    bubble.innerHTML = data;
    parent.appendChild(bubble);
}

