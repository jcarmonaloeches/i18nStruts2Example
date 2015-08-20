<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://www.iecisa.com/oca3/tlds/i18ntag"
	prefix="i18ntag"%>
<html>
<head>
<sx:head locale="%{#request.locale}" extraLocales="es,en" />
</head>

<body>
	<h1>
		<s:text name="global.title" />
	</h1>

	<s:form action="validateUser" namespace="/user">

		<s:textfield key="global.username" name="username" />
		<s:password key="global.password" name="password" />

		<sx:datetimepicker key="global.date" name="loginDate"
			displayFormat="dd-MMM-yyyy" language="%{#request.locale}" />

		<s:submit key="global.submit" name="submit" />
	</s:form>

	<br>
	<br>

	<display:table id="beanTable" name="beans" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="">
		<display:column property="id" titleKey="table.id" />
		<display:column property="description" titleKey="table.description" />
	</display:table>

	<br>
	<br>
	<i18ntag:print language="es" imageURL="spain.jpg" />
	<br>
	<i18ntag:print language="en" imageURL="greatbritain.jpg" />
	<br>


</body>
</html>