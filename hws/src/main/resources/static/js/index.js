var barr={}
var num = 0;
$(function(){
	
	//弹幕
	var length = $('.scroll li').length;
	var job = setInterval(function() {
		barr.initBarr();
	}, 500);
	if(num >= length){
		clearInterval(job);
	}
	//关闭弹幕
	$(this).click(function(){
		$('.scroll').css("display","none");
	});
	
});
barr.initBarr = function (){
	barr.scroll(num);
	num++;
}
barr.scroll = function(num){
	var arrColor = [ '#5dd9ff', '#fbe091', '#ff0', '#b5d8f4', '#0f0', '#0ff',
		     			'#83dd57', '#fff', '#b4f4ff', '#ccc', '#fff' ];
	var height = $(window).height()- 30;
	$('.scroll li').eq(num).css('color',
			arrColor[parseInt(10 * Math.random())]);
	
	$('.scroll li').eq(num).css('top',parseInt(height * Math.random()) + 30);
	$('.scroll li').eq(num).animate({
		'left' : -300
	}, 30000, function() {
		$('.scroll li').eq(num).css('left', '100%');
	});
}
