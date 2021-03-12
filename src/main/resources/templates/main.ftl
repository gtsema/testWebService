<#import "parts/common.ftl" as c>

<@c.page>
<div class="container">
  <#include "toasts.ftl">
  <div class="row">
    <div class="col-sm">
        <#include "add-user.ftl">
    <div class="col-sm">
        <#include "get-user.ftl">
    <div class="col-sm">
        <#include "set-status.ftl">
    </div>
  </div>
</div>
</@c.page>
