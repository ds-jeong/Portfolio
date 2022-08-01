$(function () {
	var container = $('.slideshow'),
	slideGroup = container.find('.slideshow_slides'),
	slides = slideGroup.find('a'),
	nav = container.find('.slideshow_nav'),
	indicator = container.find('.indicator'),
	slideCount = slides.length,
	indicatorHtml = '',
	currentIndex = 0,
	duration = 500,
	easing = 'easeInOutExpo',
	interval = 3500,
	timer;
	
	
	//슬라이드를 가로로 배열
	//slides 마다 할일 , 0%, 100%, 200%, 300%
	console.log(slides);
	
	slides.each(function(i){
		var newleft = i * 100 + '%';
		$(this).CSS({left: newLeft });
		
		indicatorHtml += '<a href="">'+ (i+1) + '</a>';
		console.log(indicatorHtml);
	});
	indicator.html(indicatorHtml);
	
	//슬라이드 이동 함수
	function goToSlide(index){
		slideGroup.animage({left:-100*index + '%'}, duration, easing);
		currentIndex = index;
		console.log(currnetIndex);
		
		updatenav(); //첨인지 마지막인지 검사
		
		indicator.find('a').removeClass('active');
		indicator.find('a').eq(currentIndex).addClass('active');
		
	}
	
	function updateNav(){
		var navPrev = nav.find('prev');
		var navNext = nav.find('next');
		
		if(currentIndex == 0){
			navPrev.addClass('disabled');
		}else{
			navPrev.removeClass('disabled');
		}
		if(currentIndex == slideCount - 1){
			navNext.addClass('disabled');
		}else{
			navNext.removeClass('disabled');
		}
		
		
		
		
		
	}

	//인디케이터로 이동하기
	indicator.find('a').click(function(e){
		e.preventDefault();
		var idx = $(this).index();
		//console.log(idx);
		goToSlide(idx);
		
	});	
	
	//좌우버튼으로 이동하기
	nav.find('.prev').click(function(e){
		e.preventDefault();
		if($(this).hasClass('prev')){
			goToSlide(currentIndex -1); 
		}else{
			goToSlide(currentIndex +1);
		}
	});
	
	updatenav();
});