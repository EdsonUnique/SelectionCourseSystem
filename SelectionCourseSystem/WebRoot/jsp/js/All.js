

/*管理员*/

var d=new dTree("d");
d.add(0,-1,'资源管理','#','','','/SelectionCourseSystem/jsp/js/img/base.gif','/SelectionCourseSystem/jsp/js/img/base.gif'); 
d.add(1,0,'学生管理','#','','','/SelectionCourseSystem/jsp/js/img/folder.gif','/SelectionCourseSystem/jsp/js/img/folder.gif'); 
d.add(2,0,'教师管理','#','','','/SelectionCourseSystem/jsp/js/img/folder.gif','/SelectionCourseSystem/jsp/js/img/folder.gif'); 
d.add(3,0,'课程管理','#','','','/SelectionCourseSystem/jsp/js/img/folder.gif','/SelectionCourseSystem/jsp/js/img/folder.gif'); 
d.add(4,0,'选课管理','#','','','/SelectionCourseSystem/jsp/js/img/folder.gif','/SelectionCourseSystem/jsp/js/img/folder.gif'); 
d.add(5,1,'添加学生','/SelectionCourseSystem/jsp/admin/stu_add.jsp','','display_frame'); 
d.add(6,1,'查询学生','/SelectionCourseSystem/admin_findPageStudent','','display_frame'); 
d.add(7,2,'添加教师','/SelectionCourseSystem/jsp/admin/tea_add.jsp','','display_frame'); 
d.add(8,2,'查询教师','/SelectionCourseSystem/adminTea_findPageTeacher','','display_frame'); 
d.add(9,3,'添加课程','/SelectionCourseSystem/adminCourse_addCourseUI','','display_frame');
d.add(10,3,'查询课程','/SelectionCourseSystem/adminCourse_findPageCourse','','display_frame');


d.add(11,4,'添加选课内容','/SelectionCourseSystem/adminSelection_findAllCourse','','display_frame');
d.add(12,4,'开放选课','/SelectionCourseSystem/adminSelection_findAllSelection','','display_frame');
d.add(13,4,'查看选课结果','/SelectionCourseSystem/adminSelection_viewAllSelection','','display_frame');



var t=document.getElementById("menu"); 
t.innerHTML=d.toString();

d.clearCookie();

//添加学生页面
// 标签选择器$('p')、类选择器$('.myClass')、id选择器$('#myId') 

function checkLogin(){
	var str1=$.trim($('#username').val());
	var str2=$.trim($('#pwd').val());
	
	if(str1=='' || str2==''){
		alert("用户名和密码不能为空");
		return false;
	}
	
	return true;
	
}

function checkFields(){
		
	var str1=$.trim($('#stu_id').val());
	var str2=$.trim($('#stu_name').val());
	var str3=$.trim($('#stu_pwd').val());
	if(str1==''){
		$('#note1').text('*该字段不能为空');
		return false;				
	}
	
	if(str2==''){
		$('#note2').text('*该字段不能为空');
		return false;				
	}
	
	if(str3==''){
		$('#note3').text('*该字段不能为空');
			return false;				
		}
	
		return true;
};

function checkPwdFields(){
	
	var str1=$.trim($('#pwd1').val());
	var str2=$.trim($('#pwd2').val());
	if(str1==''){
		$('#s1').text('*该字段不能为空');
		return false;				
	}
	
	if(str2==''){
		$('#s2').text('*该字段不能为空');
		return false;				
	}
	
	if(str1!=str2){
		alert("两次密码不一致");
			return false;				
		}
	 var res = confirm("密码修改后将退出登录，确定修改？");
     if(res != true){
   	  	return false;
     }
		return true;
};

//+++++页码跳转
function gotoPagenum(path,totalPage){
	
	var num=$.trim($('#pagenum').val());
	num=num-0;
	totalPage=totalPage-0;
	if(num=='' || num<1 || num>totalPage){
		alert("页码错误");
	}else{
		window.location.href='${pageContext.request.contextPath}'+path+'?num='+num;
	}
	
	
	
	
}
//学生页面
function checkStuId(){
	
	
	if($.trim($('#stu_id').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/admin_searchStuById?stu_id='+$('#stu_id').val();
	}

}

function checkStuName(){
	
	if($.trim($('#stu_name').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/admin_searchStuByName?stu_name='+$('#stu_name').val();
	}
}

function deleteStu(stu_id){
	  
      var res = confirm("确定删除这条记录？");
      if(res == true){
    	  window.location.href='${pageContext.request.contextPath}/admin_deleteStudent?stu_id='+stu_id;
       }
}

//教师页面
function checkTeaId(){
	
	
	if($.trim($('#tea_id').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/adminTea_searchTeaById?tea_id='+$('#tea_id').val();
	}

}

function checkTeaName(){
	
	if($.trim($('#tea_name').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/adminTea_searchTeaByName?tea_name='+$('#tea_name').val();
	}
}

function deleteTea(tea_id){
	  
      var res = confirm("确定删除这条记录？");
      if(res == true){
    	  window.location.href='${pageContext.request.contextPath}/adminTea_deleteTeacher?tea_id='+tea_id;
       }
}

//课程页面
function checkCourseId(){
	
	
	if($.trim($('#course_id').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/adminCourse_searchCourseById?course_id='+$('#course_id').val();
	}

}

function checkCourseName(){
	
	if($.trim($('#course_name').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/adminCourse_searchCourseByName?course_name='+$('#course_name').val();
	}
}

function deleteCourse(course_id){
	  
    var res = confirm("确定删除这条记录？");
    if(res == true){
  	  window.location.href='${pageContext.request.contextPath}/adminCourse_deleteCourse?course_id='+course_id;
     }
}

//选课页面
function deleteSelection(course_id){
	  
    var res = confirm("确定不将该课程作为选课内容？");
    if(res == true){
  	  window.location.href='${pageContext.request.contextPath}/adminSelection_deleteSelection?course_id='+course_id;
     }
}

function checkCapacity(course_id){
	
	var c=$.trim($('#capacity'+course_id).val());
	if(c==null || c==""){
		alert("课程容量不能为空！");
		return false;
	}
	var re = /^\+?[1-9][0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/ 
	　　
	　　if (!re.test(c)) {
	　　　　alert("请输入整数");
	　　　　return false;
	　　}
		
		return true;
	
}

function checkSelectionName(){
	
	if($.trim($('#course_name').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/adminSelection_searchBySelectionName?course_name='+$('#course_name').val();
	}
}

function checkSelectionId(){
	
	if($.trim($('#course_id').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/adminSelection_searchBySelectionId?course_id='+$('#course_id').val();
	}
}

function endSelection(){
	window.location.href='${pageContext.request.contextPath}/adminSelection_endSelection';
}

function confirmSelection(course_id){
	window.location.href='${pageContext.request.contextPath}/adminSelection_confirmSelection?course_id='+course_id;
}
function cancelConfirmSelection(course_id){
	window.location.href='${pageContext.request.contextPath}/adminSelection_cancelConfirmSelection?course_id='+course_id;
}

function deleteSelectionConfirm(){
	var res = confirm("确定删除？");
    if(res == true){
  	  return true;
     }
    return false;
}

function checkStartTime(){
	var t1=$('#t1').val();
	var t2=$('#t2').val();
	
	if(t1=='' ||  t2==''){
		alert("选课时间不能为空！");
		return false;
	}
	
	
	
	// 创建日期对象
	var date1 = new Date(t1);
	var date2=new Date(t2);
	var nowDate=new Date();
	
	if(date1.getTime()>date2.getTime() || date2.getTime()<nowDate.getTime()){
		alert("选课时间设置错误！");
		return false;
	}
	
	return true;
	
	
}

function checkStuTeaName(){
	
	if($.trim($('#tea_name').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/stu_searchCourseByTeaName?tea_name='+$('#tea_name').val();
	}
	
}

function checkStuCourseName(){
	if($.trim($('#course_name').val())==''){
		alert("查询条件不能为空");
	}else{
		window.location.href='${pageContext.request.contextPath}/stu_searchCourseByCourseName?course_name='+$('#course_name').val();
	}
}



