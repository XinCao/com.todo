package com.xincao.todo.model;

public class SwitchInfo extends SwitchInfoKey {

    private String switchInfo;

    public String getSwitchInfo() {
        return switchInfo;
    }

    public void setSwitchInfo(String switchInfo) {
        this.switchInfo = switchInfo == null ? null : switchInfo.trim();
    }
}