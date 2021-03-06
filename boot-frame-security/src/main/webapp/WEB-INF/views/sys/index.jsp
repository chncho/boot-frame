<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/resources/common/taglib.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/resources/common/meta.jsp" %>

    <title>管理后台</title>
</head>

<body>

<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl">
            <a class="logo navbar-logo f-l mr-10 hidden-xs" href="javascript:void(0);">H-ui.admin</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">v3.0</span>

            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:void(0);">&#xe667;</a>
            <nav class="nav navbar-nav">
                <ul class="cl">
                    <li class="dropDown dropDown_hover"><a href="javascript:void(0);" class="dropDown_A"><i
                            class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i
                                    class="Hui-iconfont">&#xe616;</i> 资讯</a></li>
                            <li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i
                                    class="Hui-iconfont">&#xe613;</i> 图片</a></li>
                            <li><a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i
                                    class="Hui-iconfont">&#xe620;</i> 产品</a></li>
                            <li><a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i
                                    class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li><shiro:principal property="realname" /></li>
                    <li class="dropDown dropDown_hover">
                        <shiro:user>
                            <a href="#" class="dropDown_A">
                                <shiro:principal property="username" />
                                <i class="Hui-iconfont">&#xe6d5;</i>
                            </a>
                        </shiro:user>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
                            <li><a href="${ctxPath}/sys/logout">退出</a></li>
                        </ul>
                    </li>
                    <li id="Hui-msg">
                        <a href="#" title="消息">
                            <span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i>
                        </a>
                    </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover">
                        <a href="javascript:;" class="dropDown_A" title="换肤">
                            <i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i>
                        </a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:void(0);" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:void(0);" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:void(0);" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:void(0);" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:void(0);" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:void(0);" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>

<aside class="Hui-aside">
    <div id="menu-show" class="menu_dropdown bk_2"></div>
</aside>

<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>

<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="${ctxPath}/sys/welcome">我的桌面</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group">
            <a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:void(0);">
                <i class="Hui-iconfont">&#xe6d4;</i>
            </a>
            <a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:void(0);">
                <i class="Hui-iconfont">&#xe6d7;</i>
            </a>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="${ctxPath}/sys/welcome"></iframe>
        </div>
    </div>
</section>
<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前</li>
        <li id="closeall">关闭全部</li>
    </ul>
</div>

<script type="text/javascript" src="${ctxPath}/static/lib/jquery/jquery.js"></script>
<script type="text/javascript" src="${ctxPath}/static/lib/jquery/contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="${ctxPath}/static/lib/ui/admin/js/index.js"></script>
<script type="text/javascript" src="${ctxPath}/static/lib/layer/layer.js"></script>
<script type="text/javascript" src="${ctxPath}/static/lib/ui/common/js/H-ui.js"></script>
<script type="text/javascript" src="${ctxPath}/static/lib/ui/admin/js/H-ui.admin.js"></script>
</body>
</html>