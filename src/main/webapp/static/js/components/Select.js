/**
 * 远程分页select2
 * @param conId
 * @param url
 * @param options
 * @constructor
 */
var Select = {
    init: function (options) {
        Select.options = options;
        $("select[name='" + options.conName + "']").select2({
            language: "zh-CN",
            tags: true,
            separator: ",",
            placeholder: '',
            allowClear: true,
            multiple: options.multiple,
            ajax: {
                url: options.url,
                type: 'get',
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        text: params.term,
                        page: params.page
                    };
                },
                processResults: function (data, params) {
                    params.page = params.page || 1;

                    return {
                        results: data.items,
                        pagination: {
                            more: (params.page * data.limit) < data.total //每页30条数据
                        }
                    };
                },
                createSearchChoice: function (term, data) {           // 创建搜索结果（使用户可以输入匹配值以外的其它值）
                    return {id: term, text: term};
                },
                escapeMarkup: function (markup) {
                    return markup;
                },
            }
        });
        return Select;
    },
    selected: function (val) {
        if (val !== "") {
            $.ajax(Select.options.url, {
                type: 'get',
                data: {id: val},
                dataType: "json"
            }).done(function (data) {
                $.each(data.items, function (i, item) {
                    $("select[name='" + Select.options.conName + "']").append(new Option(item.text, item.id, false, true));
                });
            });
        }
        return Select;
    },
    clear: function (conName) {
        $("select[name='" + conName + "']").val("").trigger("change");
    }
}
