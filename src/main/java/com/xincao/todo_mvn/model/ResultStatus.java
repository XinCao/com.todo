package com.xincao.todo_mvn.model;

/**
 *
 * @author caoxin
 */
public enum ResultStatus {

    YES(1),
    NO(2);

    private int no;

    private ResultStatus(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }
}