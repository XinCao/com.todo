function requestAjax(url) {
    $.ajax({
        url: url,
        dataType: "json",
        success: successAjax(data),
        error: errorAjax(arg)
    });
}