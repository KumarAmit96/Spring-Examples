package net.customer.com.exception;

public class ResourceNotFoundException extends Exception{
	
    private static final long serialVersionUID = 1L;
    
    public ResourceNotFoundException(Object resourID)
    {
    	super(resourID != null ? resourID.toString() : null);
    }

}
