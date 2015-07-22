<#compress>
<!doctype html>
<head>
    <title>${.globals.layout_title!}</title>
    <#include "/layout/layout-header.ftl" />
    ${.globals.layout_head!}
</head>
<body>
    <div>   
        ${.globals.layout_body!}
    </div>
    <#include "/layout/layout-footer.ftl" />
</body>
</html>
</#compress>