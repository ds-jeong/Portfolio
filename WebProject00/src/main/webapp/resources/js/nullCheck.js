function checkInput(){
	var need = true;
	$('.need').each(function(){
		if($(this).val().trim()==''){
			alert ($(this).attr('title') + '을 입력하세요');
			$(this).val('');
			$(this).focus();
			need = false;
			return need;
		}
	});
	return need;
}

function checkInputSelect(){
	if( $('.sido').val() == '지역선택' ){
			alert( $('.sido').attr('title') + ' 선택하세요!');
			return false;		
	}
	return true;
}

