package com.xincao.todo.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author caoxin
 * @param <T> 作为数据Model
 */
public abstract class AbstractFlow <T extends Object> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    abstract protected boolean canPerform(T t);

    abstract protected void perform(T t);

    abstract protected T parse(Object... params);

    public void start(Object... params) {
        T t = parse(params);
        if (t != null && canPerform(t)) {
            perform(t);
        } else {
            logger.info("this flow is not supported, params = {}", params);
        }
    }
}