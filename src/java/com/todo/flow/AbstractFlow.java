package com.todo.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author caoxin
 * @param <T>
 */
public abstract class AbstractFlow <T extends Object> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    abstract protected boolean canAction(T t);

    abstract protected void actionImp(T t);

    abstract protected T parse(Object... params);

    public void action(Object... params) {
        T t = parse(params);
        if (t != null && canAction(t)) {
            actionImp(t);
        } else {
            logger.info("this flow is not supported, params = {}", params);
        }
    }
}