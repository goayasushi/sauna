const  UPDATE_MESSAGE = "更新してもよろしいですか？"
$('form').submit(function() {
	if(confirm(UPDATE_MESSAGE)){
		return true;
	}else{
		return false;
	}
});