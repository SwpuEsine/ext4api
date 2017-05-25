var callback;
$(function () {
    var obji = null;
    var objli = null;
    $('.treeview-menu li a').click(function () {
        if (obji != null && objli != null) {
            //obji.attr('class', 'icon-circle-blank');
           objli.removeClass("active");
        }

        obji = $(this).children('i');
        objli = $(this).parent('li');
        //obji.attr('class', 'icon-circle');
        objli.attr('class', 'active');
        //var title = $(this).text();
        var url = $(this).attr("target");
        //$('#main-title').html(title);
        reload(url, 'content');
    });
});

function loginOut() {
    window.location.href = 'web/loginOut';
}

function menuPers() {
    $("ul[class='treeview-menu'] li").each(function () {
        var href = $(this).children('a').attr('target');
        var url = href.substring(href.indexOf('/', 1));
        if (menus.indexOf(url) == -1) {
            this.remove();
            //alert($(this).parent().prev().);
        }
    });
}
function show() {
    Pace.start();
}
function hide() {
    Pace.stop();
}
//页面跳转
function reload(url, showType) {
    show();
    callback = $("#iframe-content2").html();
    $.get(url, function (data) {
        try {
            var json = $.parseJSON(data);
            if (json.result_code != undefined && json.result_code != "000000") {
                if ("000003" == json.result_code) {
                    modal({
                        type: 'error',
                        title: '错误',
                        text: json.result_msg,
                        callback: function () {
                            loginOut();
                        }
                    });
                } else {
                    modal({
                        type: 'error',
                        title: '错误',
                        text: json.result_msg,
                    });
                }
                return;
            }
        } catch (e) {

        }

        if (showType == 'content') {
            $("#iframe-content").show();
            $("#iframe-content").html(data);
            $("#iframe-child").empty();
            var btns = $('#toolbar button');
            $.each(btns, function (i, item) {
                var url = $(item).attr("url");
                if (url == undefined || url == null || url == "") {
                    $(item).remove();
                    return;
                }
                if (url.indexOf("/") == 0) {
                    url = url.substring(url.indexOf("/", 1));
                }
                if (menus.toString().lastIndexOf(url) == -1) {
                    $(item).remove();
                }
            });
        } else {
            $("#iframe-child").show();
            $("#iframe-child").html(data);
            $("#iframe-content").hide();
        }
        hide();
    });
}

//返回列表
function back() {
    $("#iframe-content").show();
    $("#iframe-child").empty();
}

