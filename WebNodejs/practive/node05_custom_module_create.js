/**
 * 모듈파일 생성하기
 * 
 * 모듈파일을 생성하기 위해서 필요한 모듈 exports
 */


//2.함수를 선언하는 방법
var a= 0;
//2.함수를 선언하는 방법
exports.even =  function(n){
		for(var i=1; i<=n; i++){
			if(i % 2 === 0){
				a += i;
			}
		}
		return a;
}

exports.odd = function(n){
	for(var i=1; i<=n; i++){
		if(i % 2 === 1){
			a += i;
		}
	}
	return a;
}

exports.sum = function(n){
		for(var i=1; i<=n; i++){
			
			a = +i;
		}
		return a;
}