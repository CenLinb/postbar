var everyPageDataCount=10;
var postPageIndex=0;
var postAllPage=0;

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
$(function(){
  
	KindEditor.options.cssData = 'body {font-family:微软雅黑;}',
	editor = KindEditor.create('textarea[id="COM_ADD_DES"]', {
		allowUpload : true,
	    uploadJson: '/postbar/postController/kindEditorImgInput',
	    allowFileManager: false,
	    width:'900px',
	    height: '300px',
	    items: [ 'fullscreen','|','undo', 'redo', '|', 'preview', 'print', 'cut', 'copy', 'paste',
	            'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
	            'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
	            'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
	            'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image',
	             'table', 'hr', 'emoticons', ]
	});
	
	getPostList(true,"/postbar/myCommentController/selectMyCommentByUserUUID",0,everyPageDataCount);
});


function getPostList(SynOrAsyn,url,pageIndex,everyPageDataCount){


	  		


}


function allCommentlist(allCommentlist,postAllNum,allPage,pageIndex){
	
}

function post_detailed(postUUID){

	window.location.replace("comment.html?page=myCom&postid="+postUUID);

}
function DELETE_COM(){
	var chk_value =[]; 
	$('input[name="DELETE_CHECK_NAME"]:checked').each(function(){ 
	    chk_value.push($(this).val()); 
	}); 
	if(chk_value.length==0){
		$.MsgBox.Alert("消息","请先选择需要删除的评论！");
		return;
	}
	
	
}
function returnComList(){
	editor.html("");
	$("#tishi").html("");
	$("#COM_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#COM_ADD_DIV_ID").attr("style","display:none;");//隐藏div
}
function EDIT_COM(cmUUID){
	
	    		editor.html("测试评论1");
	    		var html="";
	    		html+='<button type="button" class="btn btn-info" onclick="editComCheck(\''+cmUUID+'\')">编辑</button>';
	    		html+='<button type="button" class="btn btn-default" onclick="returnComList()">返回</button>';
	    		$("#editButtion").html(html);
	    		

	
	
    
    
	$("#COM_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	$("#COM_ADD_DIV_ID").attr("style","display:block;");//隐藏div
	
}
function GOTO_POST_NEXT_PAGE(){

	getPostList(true,"/postbar/myCommentController/selectMyCommentByUserUUID",postPageIndex+1,everyPageDataCount);
	
}

function GOTO_POST_TAIL_PAGE(){
	getPostList(true,"/postbar/myCommentController/selectMyCommentByUserUUID",postAllPage-1,everyPageDataCount);

}

function GOTO_POST_PAGE(){
	var jumpVal=$("#JUMP_INPUT_ID").val().trim();
	if(jumpVal==""){
		$.MsgBox.Alert("消息","跳转页不能为空");
		return;
	}
	if(!(/^[0-9]+$/.test(jumpVal))){
		$.MsgBox.Alert("消息","页码必须为数字");
		return;
	}
	if(jumpVal<=0){
		$.MsgBox.Alert("消息","页码必须大于等于1");
		return;
	}
	if(jumpVal>postAllPage){
		$.MsgBox.Alert("消息","页码超出上限");
		return;
	}
	getPostList(true,"/postbar/myCommentController/selectMyCommentByUserUUID",jumpVal-1,everyPageDataCount);
}


function GOTO_POST_HOME_PAGE(){
	getPostList(true,"/postbar/myCommentController/selectMyCommentByUserUUID",0,everyPageDataCount);
}

function GOTO_POST_PREVIOUS_PAGE(){
	getPostList(true,"/postbar/myCommentController/selectMyCommentByUserUUID",postPageIndex-1,everyPageDataCount);
	 
}

function editComCheck(cmUUID){
	var cmText=editor.html().trim();

	if(cmText==""){
		$("#tishi").html("评论内容不能为空");
		return;
	}
	

	    		window.location.replace("myComment.html?radm="+Math.random());
	    		

	
}
