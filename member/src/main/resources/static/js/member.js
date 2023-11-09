const  UPDATE_MESSAGE = "更新してもよろしいですか？"
const  DELETE_MESSAGE = "削除してもよろしいですか？"
$('form').submit(function() {
	if(confirm(UPDATE_MESSAGE)){
		return true;
	}else{
		return false;
	}
});

$('#delete').on('click', function() {
	if(confirm(DELETE_MESSAGE)){
		return true;
	}else{
		return false;
	}
});