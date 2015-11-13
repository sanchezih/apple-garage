// index.js

var globalWord;
var whitespace;
var correctLetters;
var globalArrayIndex;
var globalImageArray = ["img/hangImage0.png","img/hangImage1.png","img/hangImage2.png","img/hangImage3.png","img/hangImage4.png",
                        "img/hangImage5.png","img/hangImage6.png"];


function loadWord(category) {
	dojo.xhrPost({
			url: "game.do",
			postData: "action=loadWord&value="+category,
		    handleAs: "text",
		    load: function(text){
		    	updateWord(text);
		    	},
		    error: function(error){
		    	alert(error);
		      }	    	
	});
}

function updateWord(word) {
	 document.getElementById("hangmanImage").style.visibility = "visible";
	 globalWord = word;
	 whitespace = word.split(" ").length - 1;
	 correctLetters = 0;
	 globalArrayIndex = 0;
	 loadWordTable(word);
	 loadLettersTable();
	 updateImage(globalArrayIndex);
}

function loadWordTable(word){
	var table = "<tr>";
	for(var index=0; index<word.split('').length; index++){
		table += "<td ><a id='wordLetter"+index+"' class='wordLetter'>_</a></td>";
	}
	table += "</tr>";
	document.getElementById("wordTable").innerHTML = table;
}

function loadLettersTable(){
	var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split('');

	var table = "<tr>";
	for(var index=0; index<=12; index++){
		table += "<td ><a id='"+alphabet[index]+"' onClick='javascript:verifyLetter(this.id);' class='letterActive'>"+alphabet[index]+"</a></td>";
	}
	table += "</tr>";
	table += "<tr>";
	for(var index=13; index<=25; index++){
		table += "<td ><a id='"+alphabet[index]+"' onClick='javascript:verifyLetter(this.id);' class='letterActive'>"+alphabet[index]+"</a></td>";
	}
	table += "</tr>";
	document.getElementById("lettersTable").innerHTML = table;
}

function updateImage(index){
	document.getElementById("hangmanImage").src = globalImageArray[index];
}

function verifyLetter(letter) {
	if(correctLetters<globalWord.split('').length-whitespace){
		if (globalArrayIndex < 6){
			globalArrayIndex+= updateGame(letter);
			if(globalArrayIndex == 6){
				alert("Game Over!");
			}
		} else{
			alert("Try another category!");
		}
	}else{
		alert("You Win!");
	}
}

function updateGame(letter) {
	var find = false;
	var wordSplit = globalWord.split('');
	for(var index=0; index<wordSplit.length; index++){
		if(letter == wordSplit[index]){
			document.getElementById("wordLetter"+index).innerHTML = wordSplit[index];
			correctLetters+=1;
			find = true;
		}
	}
	document.getElementById(letter).className = "letterInactive";
	document.getElementById(letter).onclick = "";
	if(find){
		return 0;
	}else{		
		updateImage(globalArrayIndex+1);
		return 1;
	}	
}

