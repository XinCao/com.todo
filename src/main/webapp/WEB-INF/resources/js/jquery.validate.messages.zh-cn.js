jQuery.extend(jQuery.validator.messages, {
    required: "此项为必填项",
    remote: "请修复此项",
    email: "请输入合法的 Email 地址",
    url: "请输入合法的 URL 地址",
    date: "请输入合法的日期",
    dateISO: "请输入合法的日期(ISO).",
    number: "请输入合法的数字",
    digits: "只能输入数字",
    creditcard: "请输入合法的信用卡卡号",
    equalTo: "请再次输入相同的值",
    accept: "请输入符合要求的值",
    maxlength: jQuery.validator.format("最多能输入 {0} 个字符"),
    minlength: jQuery.validator.format("最少输入 {0} 个字符"),
    rangelength: jQuery.validator.format("只能输入 {0} ~ {1} 个字符"),
    range: jQuery.validator.format("请输入介于 {0} 和 {1} 的值"),
    max: jQuery.validator.format("最大不能超过 {0}"),
    min: jQuery.validator.format("最小不能小于 {0}."),
    regex: "请输入符合要求的值"
});