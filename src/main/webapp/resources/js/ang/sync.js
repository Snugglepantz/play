
var wsUri = "ws://localhost:8080/Play/person/sync";
var websocket = new WebSocket(wsUri);
websocket.onopen = function(evt) {
  onOpen(evt);
};
websocket.onmessage = function(evt) {
  onMessage(evt);
};
websocket.onerror = function(evt) {
  onError(evt);
};


//function syncClients(id) {
//  websocket.send(id);
//  console.log("SENT: " + id);
//}

function onOpen(evt) {
  console.log("CONNECTED");
}

function onMessage(evt) {
  writeToScreen("RECEIVED: " + evt.data);
}

function onError(evt) {
  console.error('<span style="color: red;">ERROR:</span> ' + evt.data);
}
