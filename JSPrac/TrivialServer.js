var http = requires('http');

function handle_incoming_request(req, res){
	console.log("INCOMING REQUEST: "+req.method+""+req.url);
	res.writeHead(200, {"Content-Type":"application/json"});
	res.end(JSON.stringfy({error:null})+"\n");
}

var s = http.createServer(handle_incoming_request);
s.listen(8080);