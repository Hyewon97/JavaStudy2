/**
 * 모듈파일 생성하기
 * 
 * 모듈파일을 생성하기 위해서 필요한 모듈 exports
 */

/**
 * 모듈파일 생성하기
 * 
 * 모듈파일을 생성하기 위해서 필요한 모듈 exports
 */


//2.함수를 선언하는 방법
exports.even = (num)=>{
	var tot =0;
	for(i=2; i<=num; i+=2){
		tot += i;
	}
	return "1~"+ num + "까지의 짝수 합은" + tot + "이다.";
}

exports.odd = (num)=>{
	var tot =0;
	for(i=1; i<=num; i+=2){
		tot += i;
	}
	return "1~"+ num + "까지의 홀수의 합은" + tot + "이다.";
}

exports.sum = (num)=>{
	var tot =0;
	for(i=1; i<=num; i+=2){
		tot += i;
	}
	return "1~"+ num + "까지의 합은" + tot + "이다.";
}
