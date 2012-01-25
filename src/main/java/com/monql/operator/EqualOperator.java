package com.monql.operator;

import java.util.Collection;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * 等于(=)
 * 
 * @author monql
 * @since 2012-1-23 上午11:14:36
 */
public class EqualOperator extends AbstractOperator {

    static Operator INSTANCE = new EqualOperator();
    
    @Override
    public DBObject execute(String key, Object value) {
        return new BasicDBObject(key, value);
    }
    
    @Override
    public void checkValue(Object value) {
        if (value.getClass().isArray()) 
            throw new IllegalArgumentException("operator = don't support a array value");
        if (value instanceof Collection)
            throw new IllegalArgumentException("operator = don't support a collection value");
    }
    
    @Override
    public String toString() {
        return "=";
    }
    
}
