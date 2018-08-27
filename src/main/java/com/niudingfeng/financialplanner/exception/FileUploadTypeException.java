package com.niudingfeng.financialplanner.exception;

/**
 * Title: 自定义的RuntimeException
 * Description:Token过期时抛出
 * @author lin
 * @created 2018年8月22日 下午4:56:44
 */
public class FileUploadTypeException extends RuntimeException {

	private static final long serialVersionUID = 1123L;

	private String msg;

	public FileUploadTypeException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
