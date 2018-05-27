package com.sport.common;

import net.sf.json.JSONObject;

import java.io.Serializable;

/**
 * 响应请求结果类，返回用户操作结果的提示信息
 * @date 2017-09-09 13:59
 */
public class ResponseResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*响应结果编码*/
    private int code;
    /**响应结果信息*/
    private String msg;
    /**响应结果的数据*/
    private Object data;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

	public ResponseResult(Message message) {
        this.code = message.getCode();
        this.msg = Message.getMessage(message.getKey());
    }
	/**
	 * 默认操作成功的方法
	 */
	public static ResponseResult successResult() {
		return new ResponseResult(Message.SUCCESS);
	}
	/**
	 * 默认操作失败的方法
	 */
	public static ResponseResult errorResult() {
		return new ResponseResult(Message.ERROR);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
        this.data = data;
    }
	
	@Override
	public String toString() {
        return JSONObject.fromObject(this).toString();
	}
}
