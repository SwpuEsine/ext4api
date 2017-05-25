var TableInit = {
    init: function (options) {
        if (options.tableId == null) {
            options.tableId = "#table";
        }
        TableInit.options = options;
        TableInit.SelRow = undefined;

        TableInit._this = $(options.tableId).bootstrapTable({
            url: TableInit.options.url,
            method: "POST",
            showRefresh: true,
            showToggle: true,
            classes: 'table table-no-bordered',
            showColumns: true,
            contentType: "application/x-www-form-urlencoded",
            toolbar: '#toolbar',
            cache: false,
            pagination: true,
            sidePagination: "server",
            pageNumber: 1,
            pageSize: 10,
            pageList: [10, 20, 50, 100],
            clickToSelect: true,
            columns: TableInit.options.columns,
            queryParams: function (params) {
                var p = TableInit.options.params();
                p.limit = params.limit;
                p.offset = params.offset;
                return p;
            },
            onClickRow: function (row, $el) {
                TableInit.SelRow = row;
                $('#table').find('.info').removeClass('info');
                $el.addClass('info');
            },
            formatLoadingMessage: function () {
                return "请稍等，正在加载中...";
            },
            formatNoMatches: function () {  //没有匹配的结果
                return '无符合条件的记录';
            },
            onLoadSuccess: function (data) {
                if (data.result_code != undefined && data.result_code != "000000") {
                    toastrerror(data.result_msg);
                }
            },
            onLoadError: function () {
                toastrerror("请求地址无效!");

            }
        });
        return TableInit;
    },
    refresh: function () {
        TableInit._this.bootstrapTable('refresh');
    },
    formatDate: function (value) {
        return formatDate(value);
    },
    getRecord: function () {
        var obj = TableInit.SelRow;
        if (obj == undefined) {
            toastrwarning();
            return null;
        }
        return obj;
    },
    getRecords: function () {
        var obj = TableInit._this.bootstrapTable('getSelections');
        if (obj == "") {
            toastrwarning();
            return null;
        }
        return obj;
    }

};
