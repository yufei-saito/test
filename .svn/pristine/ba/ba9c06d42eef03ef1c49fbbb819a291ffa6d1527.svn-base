<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
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
	<s:form id="customerForm" name="customerForm" action="linkManAction_findByPage" namespace="/" method="post" theme="simple">
		
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
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
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
													<TD>联系人名称：</TD>
													<TD><s:textfield cssStyle="WIDTH: 180px" maxLength="50" cssClass="textbox"  name="lkm_name"></s:textfield>
													<TD>联系人性别：</TD>
													<TD><s:select list="#{'男':'男','女':'女'} " name="lkm_gender" headerKey="" headerValue="--请选择--"></s:select>
													<TD>所属客户：</TD>
													<TD><s:select list="custs" name="c.cust_id" headerKey="" headerValue="--请选择--" listKey="cust_id" listValue="cust_name"></s:select>
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
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>QQ</TD>
													<TD>职位</TD>
													<TD>所属客户</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator  value="list">
													<TR
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
														<TD><s:property value="lkm_name" /></TD>
														<TD><s:property value="lkm_gender" /></TD>
														<TD><s:property value="lkm_phone" /></TD>
														<TD><s:property value="lkm_mobile" /></TD>
														<TD><s:property value="lkm_email" /></TD>
														<TD><s:property value="lkm_qq" /></TD>
														<TD><s:property value="lkm_position" /></TD>
														<TD><s:property value="c.cust_name" /></TD>
														<TD>
														<a href="${pageContext.request.contextPath }/linkManAction_updateUI?lkm_id=<s:property value="lkm_id"/>">修改</a>
														&nbsp;&nbsp;
														<a href="${pageContext.request.contextPath }/linkManAction_delete?lkm_id=<s:property value="lkm_id"/>">删除</a>
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
	</s:form>
</BODY>
</HTML>
