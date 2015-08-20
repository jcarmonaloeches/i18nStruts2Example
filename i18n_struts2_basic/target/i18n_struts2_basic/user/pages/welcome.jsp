<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
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
	<s:text name="global.welcome" />
	<s:property value="username" />
	<br>
	<s:text name="global.date" />
	<s:property value="loginDate" />
	<br>

	<s:url id="back" namespace="/" action="locale">
	</s:url>

	<sx:datetimepicker key="global.date" name="loginDate"
		displayFormat="dd-MMM-yyyy" language="%{#request.locale}" />

	<display:table id="beanTable" name="beans" pagesize="5"
		cellpadding="5px;" cellspacing="5px;"
		style="margin-left:50px;margin-top:20px;" requestURI="">
		<display:column property="id" titleKey="table.id" />
		<display:column property="description" titleKey="table.description" />
	</display:table>

	<br>
	<br>

	<i18ntag:print language="es" imageURL="\basic_struts\i18n\spain.jpg" />
	<br>
	<i18ntag:print language="en"
		imageURL=" \basic_struts\i18n\greatbritain.jpg" />
	<br>
	<br>

	<s:text name="%{formGB}" />
	<s:text name="%{formSP}" />


</body>
</html>