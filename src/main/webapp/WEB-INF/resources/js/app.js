function requestAjax(url) {
    $.ajax({
        url: url,
        dataType: "json",
        success: successAjax(data),
        error: errorAjax(arg)
    });
}

function isEmail(email) {
    reg = /^\w{3,}@\w+(\.\w+)+$/;
    if (reg.test(email)) {
        return true;
    }
    return false;
}

function isTelephone(obj) {
    reg = /^(d{3,4}-)?[1-9]d{6,7}$/;
    if (reg.test(obj)) {
        return true;
    }
    return false;
}

function isInteger(obj) {
    reg = /^[-+]?d+$/;
    if (reg.test(obj)) {
        return true;
    }
    return false;
}