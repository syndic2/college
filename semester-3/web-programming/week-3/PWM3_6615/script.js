var totalsuns= 50;
var resources= $("#totalsuns");

function sunsCount() {
	resources.html(totalsuns);	
}

function createBlocks() {
	for(var i= 0; i<8 ; i++) {
		$("#baris1").append("<div id='petak"+(i+1)+"'class='petakbaris1'></div>");
	}
	for(var i= 8; i<16 ; i++) {
		$("#baris2").append("<div id='petak"+(i+1)+"'class='petakbaris2'></div>");
	}
	for(var i= 16; i<24 ; i++) {
		$("#baris3").append("<div id='petak"+(i+1)+"'class='petakbaris3'></div>");
	}
}

var dropid= 0;
var growthid= 0;
var bulletid= 0;
var zbid= 0;
var ctrshot= 0;

function line(kelas) {
	var plant;
	$("#sunflow").click(function() {
		plant= $(this).clone();
	});

	$("#peas").click(function() {
		plant= $(this).clone();
	});

	$(kelas).click(function(){
		var id = $(this).attr('id');
		$("#"+id).click(function() {	
			if(plant!=null) {
				if($(this).children().length<1) {
					if(plant.attr('id')=="sunflow" && totalsuns>=50) {
						var l= parseInt($(this).css('left'));
						var t= parseInt($(this).css('top'));
						$(this).append(plant);
						$(this).children().css('position','absolute');
						$(this).children().css('left',l+'px');
						$(this).children().css('top',t+'px');
						var t2= parseInt($(this).children().css('top'))-1;
						$(this).children().css('top',t2+'px');
						plant= null;
						totalsuns-= 50;
						generateGrowth(id);
					}else if (plant.attr('id')=="peas" && totalsuns>=100) {
						var l= parseInt($(this).css('left'));
						var t= parseInt($(this).css('top'));
						$(this).append(plant);
						$(this).children().css('position','absolute');
						$(this).children().css('left',l+'px');
						$(this).children().css('top',t+'px');
						var t2= parseInt($(this).children().css('top'))-1;
						$(this).children().css('top',t2+'px');
						plant= null;
						totalsuns-= 100;
					}else {
						alert("Not enough suns!");
					}
				}
			}
			sunsCount();
		});	
	});
}

function generateDrop() {
	var arrLeft= [150,300,450,600,750,900,1050,1200];
	var arrTop= [300,450,500];	
	var rndleft= Math.floor((Math.random()*7));
	var rndtop= Math.floor((Math.random()*3));
	var l= arrLeft[rndleft];
	var tmax= arrTop[rndtop];
	$(".listplant").append("<div id='drop"+(dropid)+"'class='sundrop'></div>");
	$("#drop"+dropid).css('left',l+'px');
	sunDrop(tmax);
	getDrop();
	dropid++;
}

function sunDrop(tmax) {
	var dt= parseInt($(".sundrop").css('top'));
	var drop= setInterval(function() {
		dt+= 10;
		$(".sundrop").css('top',dt+'px');
		if (dt>=tmax) {
			clearInterval(drop);
		}
	},40);
	setTimeout(function() {
	 	$(".sundrop").fadeOut("slow",function() {
	 		$(this).remove();
	 	});
	},3000);
}

function getDrop() {
	$(".sundrop").click(function() {
		$(this).animate({left: '100px', top: '50px'},"slow",function(){
			totalsuns+= 25;
			sunsCount();
			$(this).remove();
		});	
	});
}

var sunTimer= [];
function generateGrowth(id) {
	if($("#"+id).children().attr('id')=="sunflow") {
		var kode = parseInt(id.replace("petak","")); 
		sunTimer[kode-1]= setInterval(function(){
			var growth= "<div id='growth"+(growthid)+"'class='sungrowth'></div>";
			$("#"+id).append(growth);
			growthed(growthid);
			getGrowth();
			growthid++;
		},3000);
	}	
}

function growthed(id) {
	$("#growth"+id).animate({width: '100px', height: '90px'});
	setTimeout(function() {
		$("#growth"+id).fadeOut("slow",function() {
			$(this).remove();
		});
	},3000);
}

function getGrowth() {
	$(".sungrowth").click(function() {
		$(this).animate({left: '100px', top: '50px'},"slow",function(){
			totalsuns+= 25;
			sunsCount();
			$(this).remove();
		});
	});
}

function generateBullet() {
	for(var i= 0; i<24; i++) {
		if($("#petak"+(i+1)).children().attr('id')=="peas") {
			var parent= $("#petak"+(i+1)).parent();
			if(parent.children().hasClass('zombie')) {
				var bullet= "<div id='bult"+(bulletid)+"'class='bullet'></div>";
				$("#petak"+(i+1)).append(bullet);
				var l= parseInt($("#bult"+bulletid).css('left'))+100;
				var t= parseInt($("#bult"+bulletid).css('top'))-1;
				$("#bult"+bulletid).css('left',l+'px');
				$("#bult"+bulletid).css('top',t+'px');
				bulletShooted(bulletid);
				bulletid++;
			}
		}
	}	
}

function bulletShooted(id) {
	var dl= parseInt($("#bult"+id).css('left'));
	var shoot= setInterval(function() {
		dl+= 1;
		$("#bult"+id).css('left',dl+'px');
		shooted(id);
		if(dl>=1200) {
			clearInterval(shoot);
			$("#bult"+id).remove();
		}
	},10);
}

function spawnZombie() {
	var line= Math.floor((Math.random()*3)+1);
	var zombie= "<div id='zb"+(zbid)+"'class='zombie'></div>";
	if(line==1) {
		$("#baris1").append(zombie);
		var t= parseInt($("#baris1").css('top'));
		$("#zb"+zbid).css('top',t+'px');
		$("#zb"+zbid).attr('hp',4);
	}
	else if(line==2) {
		$("#baris2").append(zombie);
		var t= parseInt($("#baris2").css('top'));
		$("#zb"+zbid).css('top',t+'px');
		$("#zb"+zbid).attr('hp',4);
	}
	else if(line==3) {
		$("#baris3").append(zombie);
		var t= parseInt($("#baris3").css('top'));
		$("#zb"+zbid).css('top',t+'px');
		$("#zb"+zbid).attr('hp',4);
	}
	zombieWalk(zbid);
	zbid++;
}

function zombieWalk(id) {
	var dl= parseInt($("#zb"+id).css('left'));
	var walk= setInterval(function() {
		dl-= 1;
		$("#zb"+id).css('left',dl+'px');
		eat(id);
		if(dl<=100) {
			if($("#zb"+id).css('left') != undefined){
				clearInterval(walk); 
				alert("Game Over!");
				location.reload();
			}
		}
	},45);
}

function eat(id) {
	for(var i= 0; i<24; i++) {
		if($("#petak"+(i+1)).children().css('left')!=null && 
		   $("#petak"+(i+1)).children().css('top')!=null) {
		   	var size= parseInt($("#petak"+(i+1)).children().css('width'));
		    var lplant= parseInt($("#petak"+(i+1)).children().css('left'));
		    var tplant= parseInt($("#petak"+(i+1)).children().css('top'));
		    var lzb= parseInt($("#zb"+id).css('left'));
		    var tzb= parseInt($("#zb"+id).css('top'));
		    var newl= (lplant+size);
		    var collide= lzb>=lplant && lzb<=newl;
		   	if(collide && tplant==tzb) {
		   		$("#petak"+(i+1)).children().remove();
		   		clearInterval(sunTimer[i]);
		   	}
		}
	}
}

function shooted(id) {
	for(var i= zbid-1;i>=0; i--) {
		if($("#zb"+i)!=null) {
			var lbult= parseInt($("#bult"+id).css('left'));
			var tbult= parseInt($("#bult"+id).css('top'));
			var lzb= parseInt($("#zb"+i).css('left'));
			var tzb= parseInt($("#zb"+i).css('top'));
			var collide= lbult == lzb || lbult-lzb>10;
			if(collide && tbult==tzb) {
				$("#bult"+id).remove();
				$("#zb"+i).attr('hp',parseInt($("#zb"+i).attr('hp'))-1);
				if($("#zb"+i).attr('hp')==0) {
					$("#zb"+i).css('left','1200px');
					$("#zb"+i).css('display','none');
					$("#zb"+i).remove();
				}
			}
		}
	}
}

$(document).ready(function() {
	sunsCount();
	createBlocks();
	var intervalDrop= setInterval(generateDrop, 5000);
	var intervalSpawn= setInterval(spawnZombie, 5000);
	line(".petakbaris1");
	line(".petakbaris2");
	line(".petakbaris3");
	var intervalGrowth= setInterval(generateGrowth, 3000);
	var intervalShoot= setInterval(generateBullet, 2000);
	setTimeout(function(){
		alert("You Win");
		location.reload();
	}, 60000);
});