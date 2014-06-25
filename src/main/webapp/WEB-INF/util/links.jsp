<!-- RESOURCES -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<meta http-equiv="X-UA-Compatible" content="IE=8" />

<script type="text/javascript" src="${context}/js/jquery-1.js"></script>
<link href="${context}/style/index.css" rel="stylesheet">
<%-- <link href="${context}/style/default.css" rel="stylesheet"> --%>
<script type="text/javascript">
    (function($){
        $.ART = {};
        $.ART.context = "${context}";
        $.ART.id = "${sessionScope.SESSION_ADMIN_USER.id}";
        $.ART.type = 0;
        $.ART.newsId = 0;
        $.ART.fileSize = 100;
    })(jQuery);
</script>
<!-- /RESOURCES -->
