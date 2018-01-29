/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var currentpos = 0;
var jsonData;
var timer;
var size = 0;


function getJsonFile() {
	$.getJSON("yen.json",function(data) {
		jsonData = data;
		$("#title").text(data.title);
		$("#caption").text(jsonData.slides[currentpos].caption);
		size = data.slides.length;
		$("#sampleImage").attr('src',"img/"+data.slides[currentpos].image_file_name);
	});
}

function leftButton() {
    if(currentpos == 0)
        currentpos = size -1;
    else
        currentpos--;
    $("#sampleImage").attr('src',"img/"+jsonData.slides[currentpos].image_file_name);
	$("#caption").text(jsonData.slides[currentpos].caption);
}

function playButton() {
    imageIcon = document.getElementById('playImage');
    if(imageIcon.src.match("playbutton")) {
        imageIcon.src = "img/pausebutton.png";
        timer = setInterval(rightButton,1000);
    }
    else {
        imageIcon.src = "img/playbutton.png";
        clearInterval(timer);
    }
}

function rightButton() {
    currentpos = (currentpos + 1)%size;
	$("#sampleImage").attr('src',"img/"+jsonData.slides[currentpos].image_file_name);
	$("#caption").text(jsonData.slides[currentpos].caption);
}

function startIt() {
    rightButton();
}



