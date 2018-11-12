<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("${pageContext.request.contextPath }/baseDictAction_findByType.action",{"dict_type_code":"002"},function(data){
			$(data).each(function(i,n){
				$("#bdSource").append("<option value="+n.dict_id+">"+n.dict_item_name+"</option>");
			});
			$("#bdSource option[value='${bd_source.dict_id}']").prop("selected","selected");
		},"json");
		$.post("${pageContext.request.contextPath }/baseDictAction_findByType.action",{"dict_type_code":"006"},function(data){
			$(data).each(function(i,n){
				$("#bdLevel").append("<option value="+n.dict_id+">"+n.dict_item_name+"</option>");
			});
			$("#bdLevel option[value='${bd_level.dict_id}']").prop("selected","selected");
		},"json");
		$.post("${pageContext.request.contextPath }/baseDictAction_findByType.action",{"dict_type_code":"001"},function(data){
			$(data).each(function(i,n){
				$("#bdIndustry").append("<option value="+n.dict_id+">"+n.dict_item_name+"</option>");
			});
			$("#bdIndustry option[value='${bd_industry.dict_id}']").prop("selected","selected");
		},"json");
	})
</script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}
	
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/customerAction_findByPage"
		method=post>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="cust_name"></TD>
													<TD>客户来源：</TD>
													<TD><select id="bdSource" name="bd_source.dict_id">
															<option value="">--请选择--</option>
														</select>
													</TD>
													<TD>客户级别：</TD>
													<TD><select id="bdLevel" name="bd_level.dict_id">
															<option value="">--请选择--</option>
														</select>
													</TD>
													<TD>所属行业：</TD>
													<TD><select id="bdIndustry" name="bd_industry.dict_id">
															<option value="">--请选择--</option>
														</select>
													</TD>
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>客户所属行业</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator  value="list">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD><s:property value="cust_name"/></TD>
													<TD><s:property value="bd_level.dict_item_name"/></TD>
													<TD><s:property value="bd_source.dict_item_name"/></TD>
													<TD><s:property value="bd_industry.dict_item_name"/></TD>
													<TD><s:property value="cust_phone"/></TD>
													<TD><s:property value="cust_mobile"/></TD>
													<TD>
													<a href="${pageContext.request.contextPath }/customerAction_updateUI?cust_id=<s:property value="cust_id"/>">修改</a>
													&nbsp;&nbsp;
													<a  href="${pageContext.request.contextPath }/customerAction_delete?cust_id=<s:property value="cust_id"/>">删除</a>
													</TD>
												</TR>
												</s:iterator>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B><s:property value="totalCount"/></B>]条记录,[<B><s:property value="maxPage"/></B>]页
												,每页显示
												<select name="everyNum" onchange="to_page()">
													<option value="3" <s:if test="everyNum==3">selected</s:if>>3</option>
													<option value="6" <s:if test="everyNum==6">selected</s:if>>6</option>
													<option value="9" <s:if test="everyNum==9">selected</s:if>>9</option>
												</select>
												条
												<s:if test="pageNum==1">
													上一页
												</s:if>
												<s:else>
													[<A href="javascript:to_page(<s:property value="pageNum-1"/>)">上一页</A>]
												</s:else>
												<B>
													<s:iterator begin="1" end="maxPage" var="i">
														<s:if test="#i==pageNum">
															<s:property value="#i"></s:property>
														</s:if>
														<s:else>
															<A href="javascript:to_page(<s:property value="#i"/>)"><s:property value="#i"></s:property></A>
														</s:else>
													</s:iterator>
												</B>
												<s:if test="pageNum==maxPage">
													下一页
												</s:if>
												<s:else>
													[<A href="javascript:to_page(<s:property value="pageNum+1"/>)">下一页</A>] 
												</s:else>
												到
												<input type="text" size="3" id="page" name="pageNum" />
												页
												
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
