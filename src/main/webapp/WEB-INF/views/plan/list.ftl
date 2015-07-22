<#global layout_title>
    Plan List
</#global>

<#global layout_body>
    <ul>
        <#list plans as plan>
            <li>${plan.code!}:${plan.name!}</li>
        </#list>
    </ul>
</#global>

<#include "/layout/layout.ftl" />