var express = require('express');
var router = express.Router();

var users = {};

router.get('/getfreeid', function(req, res, next) {
	var id, length = 10;

	do {
		id = Math.round((Math.pow(36, length + 1) - Math.random() * Math.pow(36, length))).toString(36).slice(1);
	} while (users[id]);
	res.send(id);
});

router.get('/getusers', function(req, res, next) {
    var userArray = [];
    for(var key in users) {
        if(users.hasOwnProperty(key)) {
            userArray.push(users[key]);
        }
    }
	res.send(userArray);
});

router.post('/updatelocation', function(req, res, next) {
    var key = req.body.id;
	users[key] = req.body;
    res.json(req.body);
});

router.post('/logoff', function(req, res, next) {
	users[req.body.id] = undefined;
	res.send('OK');
});

module.exports = router;
