const express = require('express')
const app = express()
const port = 8000;
const bodyParser = require('body-parser');

app.use(express.static(__dirname + '/public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.get('/',(req, res) =>  {
	res.sendFile("index.html");
});

app.get('/calculate',(req, res) =>  {

	var opsChoice = parseInt(req.query.opsChoice);
	var date1 = req.query.date1;
	var date2 = req.query.date2;
	var n = parseInt(req.query.n);
	var ntype = req.query.ntype;
	var phrase = req.query.phrase;
	var addsub = parseInt(req.query.addsub);
	var dateObj1 = new Date(date1);
	var dateObj2 = new Date(date2);
	console.log(opsChoice);
	console.log(dateObj1);
	console.log(dateObj2);
	console.log(n);
	console.log(ntype);
	console.log(phrase);
	if(opsChoice == 1) //Addition Subtraction of two dates
	{
		if(addsub==1)
		{
			dateObj1.addDays(dateObj2.getDate());
			dateObj1.addMonths(dateObj2.getMonth());
			dateObj1.addYears(dateObj2.getFullYear());
			res.send("After adding two dates: " + dateObj1);
		}
		else if(addsub==2){
			dateObj1.minusDays(dateObj2.getDate());
			dateObj1.minusMonths(dateObj2.getMonth());
			dateObj1.minusYears(dateObj2.getFullYear());
			res.send("After subtracting two dates: " + dateObj1);
		}
		else{
			res.send("Please select appropriate choice");
		}
	}
	else if(opsChoice==2)
	{
		if(addsub==1)
		{
			if(ntype==1)
			{
				dateObj1.addDays(n);
				res.send("After calculation: " + dateObj1);
			}
			else if(ntype==2)
			{
				dateObj1.addDays(n*7);
				res.send("After calculation: " + dateObj1);
			}
			else if(ntype==3)
			{
				dateObj1.addMonths(n);
				res.send("After calculation: " + dateObj1);
			}
			else if(ntype==2)
			{
				dateObj1.addYears(n);
				res.send("After calculation: " + dateObj1);
			}
			else res.send("Incorrect Option"); 
		}
		else if(addsub==2)
		{
			if(ntype==1)
			{
				dateObj1.minusDays(n);
				res.send("After calculation: " + dateObj1);
			}
			else if(ntype==2)
			{
				dateObj1.minusDays(n*7);
				res.send("After calculation: " + dateObj1);
			}
			else if(ntype==3)
			{
				dateObj1.minusMonths(n);
				res.send("After calculation: " + dateObj1);
			}
			else if(ntype==2)
			{
				dateObj1.minusYears(n);
				res.send("After calculation: " + dateObj1);
			}
			else res.send("Incorrect Option"); 
		}
		else res.send("Incorrect Option");
	}
	else if(opsChoice==3)
	{
		res.send(dateObj1.getWeek());
	}
	else if(opsChoice==4)
	{
		var weekNum =dateObj1.getWeekNumber();
		res.send("Week No. " + String(weekNum));
	}
	else if(opsChoice==5)
	{
		var today = new Date();
		var nlp = {
			"today": 0,
			"tomorrow": 1,
			"yesterday": -1,
		};
		today.addDays(nlp[phrase]);
		res.send(today);
	}
	res.send("Please select appropriate choice");

});

Date.prototype.addDays = function(days) {
	this.setDate(this.getDate() + parseInt(days));
	return this;
};

Date.prototype.addMonths = function(months) {
	console.log(this.getMonth());
	this.setMonth(this.getMonth()  + parseInt(months));
	return this;
};

Date.prototype.addYears = function(years) {
	console.log(this.getMonth());
	this.setFullYear(this.getFullYear() + parseInt(years));
	return this;
};

Date.prototype.minusDays = function(days) {
	this.setDate(this.getDate() - parseInt(days));
	return this;
};

Date.prototype.minusMonths = function(months) {
	this.setMonth(this.getMonth() - parseInt(months) );
	return this;
};

Date.prototype.minusYears = function(years) {
	this.setFullYear(this.getFullYear() - parseInt(years));
	return this;
};

Date.prototype.getWeek = function() {
	var date = this;
	var day = date.getDay();
	var days = {
		0:"Sunday",
		1:"Monday",
		2:"Tuesday",
		3:"Wednesday",
		4:"Thursday",
		5:"Friday",
		6:"Saturday",
	};
	return days[day];
}

Date.prototype.getWeekNumber = function() {
	var onejan = new Date(this.getFullYear(),0,1);
	var today = new Date(this.getFullYear(),this.getMonth(),this.getDate());
	var dayOfYear = ((today - onejan + 86400000)/86400000);
	return Math.ceil(dayOfYear/7)
};

app.listen(port, () => {
	console.log(`App listening on port: ${port}`)
});