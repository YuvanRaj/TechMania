package com.tech.util;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Yuvaraj.
 * To support HashMap Multi hashkey concept this class is created.
 *
 */
public class MultiHashKey implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4475373062772262353L;
	
	private List _partKeys;
    private int _hashCode;
    private int _size;

    /** Creates a new instance of MultiHashKey */
    public MultiHashKey(List partKeys) 
    {
            if(GenUtil.listIsEmpty(partKeys))
                    throw new IllegalArgumentException("MultiHashKey cannot be constructed with empty key list");

            _partKeys = partKeys;
            _size = _partKeys.size();
            calcHashCode();
    }

    private void calcHashCode()
    {
            _hashCode = 1;
            for(Iterator iter = _partKeys.iterator(); iter.hasNext();){
                    Object obj = iter.next();
                    _hashCode = _hashCode * 31 + (obj == null ? 0 : obj.hashCode());
            }
    }

    public int hashCode()
    {
            return _hashCode;
    }

    public int size()
    {
            return _size;
    }

    @Override
    public boolean equals(Object obj)
    {
            if(obj == this)return true;
            if(obj == null || !(obj instanceof MultiHashKey))return false;

            MultiHashKey other = (MultiHashKey)obj;
            if(_size != other._size)return false;

            for(int i = 0; i < _size; i++){
                    if(!GenUtil.equals(this._partKeys.get(i), other._partKeys.get(i)))return false;
            }

            return true;		
    }

    @Override
    public String toString()
    {
            return "MultiHashKey[" + _partKeys + "]";
    }	
    
    
}
