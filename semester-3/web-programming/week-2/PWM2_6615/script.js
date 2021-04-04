window.onload= generateCard();
window.onload= diTangan();
document.addEventListener("keydown", moveCard, false);

var scoreboard= document.getElementById("score");
var score= 0, ctrwin= 0;

function getScore() {
    scoreboard.innerHTML= score;
}

function generateCard() {
    var arrNumb= [2,4,8,16,32,64];
    var r= Math.floor(Math.random()*6);
    var value= arrNumb[r];
    var pack= document.getElementById("pack");
    var card= document.createElement("DIV");
    card.innerHTML= value;
    card.className= "card";
    card.style.marginTop= "50px";
    card.style.marginLeft= "25px";
    color(value, card);
    pack.appendChild(card);
 }

 function color(value, card) {
    if (value == 2) {
        card.style.backgroundColor= "gold";
    } else if (value == 4) {
        card.style.backgroundColor= "orange";
    } else if (value == 8) {
        card.style.backgroundColor= "darkorange";
    } else if (value == 16) {
        card.style.backgroundColor= "red";
    } else if (value == 32) {
        card.style.backgroundColor= "lightgreen";
    } else if (value == 64) {
        card.style.backgroundColor= "violet";
    } else if (value == 128) {
        card.style.backgroundColor= "hotpink";
    } else if (value == 256) {
        card.style.backgroundColor= "green";
    } else if (value == 512) {
        card.style.backgroundColor= "salmon";
    } else if (value == 1024) {
        card.style.backgroundColor= "blue";
    } else if (value == 2048) {
        card.style.backgroundColor= "lightpink";
    }
 }

function diTangan() {
    var pack= document.getElementById("pack");
    var onhand= document.getElementById("onhand");
    var card= pack.firstChild;
    onhand.appendChild(card);
    pack.innerHTML= "";
    generateCard(); 
}   

function moveCard(e) {
    var key= e.key;
    if (key == "1") {
        if (firstCol()) {
            diTangan();
        }
        gameOver();
    } else if (key == "2") {
        if (secondCol()) {
            diTangan();
        }
        gameOver();
    } else if ( key == "3") {
        if (thirdCol()) {
            diTangan();
        }
        gameOver();
    } else if ( key == "4") {
        if (fourthCol()) {
            diTangan();
        }
        gameOver();
    } else if (key == "x" || key == "X") {
        remove();
        diTangan();
    }
}

var top1= 0;
function firstCol() {
    var onhand= document.getElementById("onhand");
    var first= document.getElementById("satu");
    var size= first.children.length;
    if (size < 11) {
        var card= onhand.firstChild;
        var recurr= (4*size)+1;
        card.id= "div"+(4*size+1);
        card.style.marginTop= top1+"px";
        card.style.marginLeft= "25px";
        first.appendChild(card);
        onhand.innerHTML= "";
        inOne(recurr);
        generateCard();
        top1+= 25;
        return true;
    } else {
        return false;
    }
}

var top2= 0;
function secondCol() {
    var onhand= document.getElementById("onhand");
    var second= document.getElementById("dua");
    var size= second.children.length;
    if (size<11) {
        var card= onhand.firstChild;
        var recurr= (4*size)+2;
        card.id= "div"+(4*size+2);
        card.style.marginTop= top2+"px";
        card.style.marginLeft= "25px";
        second.appendChild(card);
        onhand.innerHTML= "";
        inOne(recurr);
        generateCard();
        top2+= 25;
        return true;
    } else {
        return false;
    }
}

var top3= 0;
function thirdCol() {
    var onhand= document.getElementById("onhand");
    var third= document.getElementById("tiga");
    var size= third.children.length;
    if (size < 11) {
        var card= onhand.firstChild;
        var recurr= (4*size)+3;
        card.id= "div"+(4*size+3);
        card.style.marginTop= top3+"px";
        card.style.marginLeft= "25px";
        third.appendChild(card);
        onhand.innerHTML= "";
        inOne(recurr); 
        generateCard();
        top3+= 25;
        return true;
    } else {
        return false;
    }
}

var top4= 0;
function fourthCol() {
    var onhand= document.getElementById("onhand");
    var fourth= document.getElementById("empat");
    var size= fourth.children.length;
    if (size < 11) {
        var card= onhand.firstChild;
        var recurr= (4*size)+4;
        card.id= "div"+(4*size+4);
        card.style.marginTop= top4+"px";
        card.style.marginLeft= "25px";
        fourth.appendChild(card);
        onhand.innerHTML= "";
        inOne(recurr);    
        generateCard();
        top4+= 25;
        return true;
    } else {
        return false;
    }
}

function remove() {
    var pack= document.getElementById("pack");
    var nextcard= pack.firstChild.innerHTML;
    var onhand= document.getElementById("onhand");
    var currcard= onhand.firstChild;
    onhand.removeChild(currcard);
    generateCard();
    alert("Card removed!"+"\n"+
          "Next card is "+nextcard);
}

function inOne(idx) {
    if (idx == 1 || idx == 2 || idx == 3 || idx == 4) {
        return idx;
    } else {
        var prevcard= document.getElementById("div"+(idx-4)); 
        var currcard= document.getElementById("div"+idx);
        var parent= currcard.parentNode;
        if (currcard.innerHTML == prevcard.innerHTML) {
            var value1= parseInt(currcard.innerHTML);
            var value2= parseInt(prevcard.innerHTML);   
            var newValue= value1+value2;
            prevcard.innerHTML= newValue;
            color(newValue, prevcard);
            parent.removeChild(parent.lastChild);
            if (parent == document.getElementById("satu")) {
                top1-= 25;
            } else if (parent == document.getElementById("dua")) {
                top2-= 25;
            } else if (parent == document.getElementById("tiga")) {
                top3-= 25;
            } else if (parent == document.getElementById("empat")) {
                top4-= 25;
            }
            score+= newValue;
            getScore();
            if (newValue == 2048) {
                if (parent == document.getElementById("satu")) {
                    top1= 0;
                } else if (parent == document.getElementById("dua")) {
                    top2= 0;
                } else if (parent == document.getElementById("tiga")) {
                    top3= 0;
                } else if (parent == document.getElementById("empat")) {
                    top4= 0;
                }
                parent.innerHTML= "";
                ++ctrwin;
                score= score*(2*ctrwin);
                getScore();
                alert("2048 reached !!!");
            } else {
                return inOne(idx-4);
            }
        }
    }
}

function gameOver() {
    var satu= document.getElementById("satu").children.length;
    var dua= document.getElementById("dua").children.length;
    var tiga= document.getElementById("tiga").children.length;
    var empat= document.getElementById("empat").children.length;
    var totalCard= satu+dua+tiga+empat;
    if (satu > 11) {
        alert("Box 1 full!");
    } else if(dua > 11) {
        alert("Box 2 full!");
    } else if(tiga > 11) {
        alert("Box 3 full!");
    } else if(empat > 11) {
        alert("Box 4 full!");
    }
    if (totalCard == 44) {
        alert("Game Over!"+"\n"+
              "Score: "+score);
        location.reload();
    }
}