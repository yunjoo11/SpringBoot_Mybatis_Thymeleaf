/**
 * 
 */
/*검색 후 다른페이지로 넘어갔을때 title값을 넘기기위한 script*/
$(".pager").click(function() {
	let p = $(this).attr("title");
	$("#curPage").val(p);
	$("#frm").submit();
});