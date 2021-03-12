<#import "parts/common.ftl" as c>

<@c.page>
    <#include "toasts.ftl">
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <#include "add-user.ftl">
            </div>
            <div class="col-sm">
                <#include "get-user.ftl">
            </div>
            <div class="col-sm">
                <#include "set-status.ftl">
            </div>
        </div>
    </div>
</@c.page>
