/**
 *  系统参数表name，value转换
 * @param mapKeys java map对象key
 * @param mapValues  java map对象value
 * @param val
 * @returns {*}
 */
function getParams(mapKeys, mapValues, val) {
    var keys = mapKeys.replace("[", "").replace("]", "").replace(" ", "").split(",");
    var values = mapValues.replace("[", "").replace("]", "").replace(" ", "").split(",");
    var result = val;
    try {
        keys.forEach(function (value, index) {
            if (value == val) {
                result = values[index];
                forEach.break = new Error("正常退出");
            }
        });
    } catch (e) {
    }
    return result;
}
/**
 * 日期格式化
 * @param val
 * @returns {*}
 */
function formatDate(val) {
    if (val == null) {
        return val;
    }
    if (val.length == 8) {
        return val.substring(0, 4) + "-" + val.substring(4, 6) + "-" + val.substring(6, 8);
    } else if (val.length == 14) {
        return val.substring(0, 4) + "-" + val.substring(4, 6) + "-" + val.substring(6, 8)
            + " " + val.substring(8, 10) + ":" + val.substring(10, 12) + ":" + val.substring(12, 14);
    }
    return val;
}

//两个日期的差值(d1 - d2).
function DateDiff(d1, d2) {
    var day = 24 * 60 * 60 * 1000;
    var checkDate = new Date();
    checkDate.setFullYear(d1.substring(0, 4), d1.substring(4, 6), d1.substring(6, 8));
    var checkTime = checkDate.getTime();

    var checkDate2 = new Date();
    checkDate2.setFullYear(d2.substring(0, 4), d2.substring(4, 6), d2.substring(6, 8));
    var checkTime2 = checkDate2.getTime();
    var cha = (checkTime - checkTime2) / day;
    return cha;
}

var Defaults = {
    //跳转增加界面
    openAdd: function (_this) {
        var url = $(_this).attr("url");
        if (url == null || url == "" || url == undefined) {
            toastrwarning("菜单工具栏按钮未设置URL");
            return;
        }
        reload(url);
    },
    /**
     * 默认跳转修改
     * @param _this 控件对象
     * @param dataId 选中数据ID
     */
    openEdit: function (_this, selId) {
        var record = TableInit.getRecord();
        if (record == null) {
            return;
        }
        var menuId = record[selId];
        var url = $(_this).attr("url") + "?id=" + menuId;
        reload(url);
    },
    //默认跳转详情
    openDetail: function (_this, selId) {
        var record = TableInit.getRecord();
        if (record == null) {
            return;
        }
        var menuId = record[selId];
        var url = $(_this).attr("url") + "?id=" + menuId;
        reload(url);
    },
    openDel: function (_this, selId) {
        var record = TableInit.getRecord();
        if (record == null) {
            return;
        }
        var val = record[selId];
        modal({
            type: 'confirm',
            title: '删除',
            text: '确认立即删除？',
            callback: function (result) {
                if (result) {
                    var menuId = val;
                    Defaults.submitEvent({
                        url: $(_this).attr("url"),
                        data: {
                            id: menuId,
                        }
                    });
                }
            }
        });
    },
    /**
     * 默认表单提交
     * @constructor
     */
    submitForm: function (form) {
        show();
        $.ajax({
            url: form.attr('action'),
            type: 'post',
            dataType: 'json',
            data: form.serializeArray(),
            success: function (data) {
                hide();
                if (data.result_code == "000000") {
                    modal({
                        type: 'info',
                        title: '消息',
                        text: data.result_msg,
                        callback: function () {
                            back();
                            query();
                        }
                    });
                } else {
                    modal({
                        type: 'error',
                        title: '错误',
                        text: data.result_msg
                    });
                }
            },
            error: function (data) {
                hide();
                modal({
                    type: 'error',
                    title: '错误',
                    text: data
                });
            }
        });
    },
    //默认ajax事件提交
    submitEvent: function (options) {
        $.ajax({
            url: options.url,
            data: options.data,
            type: 'post',
            dataType: 'json',
            success: function (json) {
                if (json.result_code == "000000") {
                    modal({
                        type: 'success',
                        title: '成功',
                        text: json.result_msg
                    });
                    query();
                } else {
                    modal({
                        type: 'error',
                        title: '失败',
                        text: json.result_msg
                    });
                }
            }
        });
        return this;
    },

}
