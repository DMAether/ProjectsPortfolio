/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var socket = new WebSocket("ws://localhost:8080/ITEJAAssign/actions");
socket.onmessage = onMessage;

function formSubmit() {
    var txtArea = document.getElementById("messageinput").value;
    console.log(txtArea);
    console.dir(WebSocket);
    socket.send(txtArea);
}

function onMessage(message){
    var parent = document.getElementById("msgBody");
    var bubble = document.createElement("p");
    bubble.innerHTML = message;
    parent.appendChild(bubble);
}