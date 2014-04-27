package com.dandelion.membership.exception;

public class IndefensibleErrors {

	
	public static final int SERVER_INTERNAL_ERROR_CODE = 300;
	public static final String SERVER_INTERNAL_ERROR_MESSAGE = "server internal error";

	public static final int ILLEGAL_PARAMETER_ERROR_CODE = 501;
	public static final String ILLEGAL_PARAMETER_ERROR_MESSAGE = "illegal parameter or json string";

    public static final int PARAM_ERROR_CODE = 613;
	public static final String PARAM_ERROR_MESSAGE = "Param error.";

    /**
     * Expectly should return only one record, but actually return two or more records, so throws exceptions.
     */
    public static final int RECORD_DUPLICATED_CODE = 615;
    public static final String RECORD_DUPLICATED_MESSAGE = "Mysql record duplicated error.";
	


}
