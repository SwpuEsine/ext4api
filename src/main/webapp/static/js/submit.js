$("select").removeAttr("disabled");
$(function () {
    $('form[name="child"]').submit(function () {
        var form = $('[name="child"]');
        Defaults.submitForm(form);
        return false;
    });
});
