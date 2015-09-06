package com.env.web.tags;

import com.env.core.domain.DomainObject;



public abstract class AbstractDomainObjectSelectTag<T extends DomainObject>
        extends AbstractSelectTag<T> {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @Override
    protected Object getOptionValue(T obj) {
        return obj.getId();
    }
}