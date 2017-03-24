<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<div class="g-doc">
    <#if content>
    <div class="n-result">
        <h3>发布成功！</h3>
        <p><a href="/edit.do?id=${content.id}">[查看内容]</a><a href="/index.do">[返回首页]</a></p>
    </div>
    <#else>
    <div class="n-result">
        <h3>发布失败！</h3>
        <p><a href="/toAddContent.do">[重新发布]</a><a href="/index.do">[返回首页]</a></p>
    </div>
    </#if>
</div>
<#include "/include/footer.ftl">
</body>
</html>