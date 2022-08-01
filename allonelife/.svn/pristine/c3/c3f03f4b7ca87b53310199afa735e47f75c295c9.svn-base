function checkInput(){
	var need = true;
	$('.need').each(function(){
		if( $(this).val().trim()=='' ){
			alert( $(this).attr('title') + ' 입력하세요!');
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
	}else if( $('.category').val() == '카테고리선택' ){
		alert( $('.category').attr('title') + ' 선택하세요!');
		return false;		
	}else if( $('.purpose').val() == '목적선택' ){
		alert( $('.purpose').attr('title') + ' 선택하세요!');
		return false;		
	}
	return true;
}

function checkInputRecipe(){
	if( $('.category').val() == '카테고리선택' ){
		alert( $('.category').attr('title') + ' 선택하세요!');
		return false;		
	}
	return true;
}