var validator = {
		
common: {
	empty: { code: 'empty', desc: '비워둘수없습니다.' },
	space: { code: 'space', desc: '공백없이 입력하세요'},
	min: { code: 'min', desc: '최소 3글자 이상으로 입력하세요' },
	pw_min: { code: 'min', desc: '최소 6글자 이상으로 입력하세요' },
	nic_min: { code: 'min', desc: '최소 2글자 이상으로 입력하세요' },
	max: { code: 'max', desc: '최대 12자이하로 입력하세요' },
},
userid: {
	valid: { code: 'valid', desc: '아이디 중복여부를 확인하세요' },
	invalid: { code: 'invalid', desc: '영문 소문자, 숫자만 입력' },
	usable: { code: 'usable', desc: '사용 가능한 아이디입니다'},
	unusable: { code: 'unusable', desc: '이미 사용중인 아이디입니다'}
},
userid_usable: function(val){
	if( val=='true' )	return this.userid.usable;
	else				return this.userid.unusable;
},
userid_status: function(val){
	var space = /\s/g;
	var reg = /[^a-z0-9]/g;
	if( val=='' ) return this.common.empty;
	else if( val.match(space) ) return this.common.space;
	else if( reg.test(val) )    return this.userid.invalid;
	else if( val.length<3 ) return this.common.min;
	else if( val.length>12 ) return this.common.max;
	else					return this.userid.valid;
},
nickname: {
	valid: { code: 'valid', desc: '닉네임 중복여부를 확인하세요' },
	usable: { code: 'usable', desc: '사용 가능한 닉네임입니다'},
	unusable: { code: 'unusable', desc: '이미 사용중인 닉네임입니다'}
},
nickname_usable: function(val){
	if( val=='true' )	return this.nickname.usable;
	else				return this.nickname.unusable;
},
nickname_status: function(val){
	var space = /\s/g;
	if( val=='' ) return this.common.empty;
	else if( val.match(space) ) return this.common.space;
	else if( val.length<2 ) return this.common.nic_min;
	else if( val.length>12 ) return this.common.max;
	else					return this.nickname.valid;
},
userpwd: {
	valid: { code: 'valid', desc: '사용 가능한 비밀번호' },
	equal: { code: 'valid', desc: '비밀번호가 일치함' },
	notequal: { code: 'invalid', desc: '비밀번호가 일치하지 않음'},
},
userpwd_status: function(val){
	var space = /\s/g;
	if( val=='' )				return this.common.empty;
	else if( val.match(space) )	return this.common.space;
	else if( val.length<6 )		return this.common.pw_min;
	else if( val.length>12 )	return this.common.max;
	else						return this.userpwd.valid;
	
},
userpwd_ck_status: function(val, userpwd){
	if( val=='' )				return this.common.empty;
	else if( val == userpwd )	return this.userpwd.equal;
	else						return this.userpwd.notequal;
},
email: {
	valid: { code: 'valid', desc: '이메일 중복여부를 확인하세요' },
	invalid: { code: 'invalid', desc: '이메일 형식이 맞지 않음'},
	usable: { code: 'usable', desc: '사용 가능한 이메일입니다'},
	unusable: { code: 'unusable', desc: '이미 사용중인 이메일입니다'}
},
email_usable: function(val){
	if( val=='true' )	return this.email.usable;
	else				return this.email.unusable;
},
email_status: function(val){
	var space = /\s/g;
	if( val=='' ) return this.common.empty;
	else if( val.match(space) ) return this.common.space;
	var reg = /^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/i;
	if( val=='' ) 				return this.common.empty;
	else if( reg.test(val) )	return this.email.valid;
	else						return this.email.invalid;
}
	
		
}



