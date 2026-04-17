<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8"%>
<!--Generic tag library given by Spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h1 Style="color:green;text-align:center"><sp:message code="homepage.title"/></h1>

<br>
<b><center>current Active Local is :: ${pageContext.response.locale}</center></b>

<!--Set current Local -->
<fmt:setLocale value="${pageContext.response.locale}"/>


<!--Format date,time values -->
<fmt:formatDate var="fdate" value="${sysDate}" type="DATE" dateStyle="MEDIUM"/>
<fmt:formatDate var="ftime" value="${sysDate}" type="TIME" dateStyle="SHORT"/>
<fmt:formatDate var="fdatetime" value="${sysDate}" type="BOTH" dateStyle="FULL"/>


<!--Number Format -->
<fmt:formatNumber var="fnumber" value="${distance}" type="NUMBER"/>
<fmt:formatNumber var="fcurrency" value="${price}" type="CURRENCY"/>
<fmt:formatNumber var="favg" value="${percentage}" type="PERCENT"/>

<br><br>

<center>
<b>Formated Date::${fdate}</b><br>
<b>Formated Time::${ftime}</b><br>
<b>Formated Date-Time::${fdatetime}</b><br>
<b>Format number::${fnumber}</b><br>
<b>Formated Price::${fcurrency}</b><br>
<b>Formated Percentage::${favg}</b>
</center>


<h3 style="text-align:center"><a href="register"><sp:message code="homepage.link"/></a></h3>
<center><a href="?lang=fr_FR">French</a>&nbsp;&nbsp;
        <a href="?lang=de_DE">Germany</a>&nbsp;&nbsp;
        <a href="?lang=hi_IN">Hindi</a>&nbsp;&nbsp;
        <a href="?lang=zh_CN">Chinese</a>&nbsp;&nbsp;
        <a href="?lang=en_US">English</a>
</center> 