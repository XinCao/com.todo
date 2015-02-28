package com.xincao.todo.util;

import static com.xincao.todo.util.RunnableStatsManager.handleStats;

/**
 * 目的，运行对象内块的同时，统计运行状况
 * 
 * @author caoxin
 */
public abstract class MethodRuntimeStats {

    /**
     * 运行的块的同时，对块的状况进行统计
     * 
     * @param params 
     */
    public void runBlock(Object... params) {
        long startTime = System.currentTimeMillis();
        defineBlock(params);
        handleStats(this.getClass(), "defineBlock", System.currentTimeMillis() - startTime);
    }

    /**
     * 定义运行块
     * 
     * @param params 
     */
    protected abstract void defineBlock(Object... params);
}