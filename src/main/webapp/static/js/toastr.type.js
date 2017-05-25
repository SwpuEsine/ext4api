function toastrwarning(msg) {
    if (msg == null || msg == "") {
        msg = "操作失败，请先选择数据!";
    }
    toastr.options.positionClass = "toast-bottom-center";
    toastr.options.timeOut = 1000;
    toastr.warning(msg);
}

function toastrsuccess(msg) {
    if (msg == null || msg == "") {
        msg = "操作错误!";
    }
    toastr.options.positionClass = "toast-bottom-center";
    toastr.options.timeOut = 2000;
    toastr.success(msg);
}

function toastrerror(msg) {
    if (msg == null || msg == "") {
        msg = "操作错误";
    }
    toastr.options.positionClass = "toast-bottom-center";
    toastr.options.timeOut = 2000;
    toastr.error(msg);
}