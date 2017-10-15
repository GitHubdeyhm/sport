package com.sport.common;

import net.sf.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static com.sport.common.CommonCode.SUCCESS_CODE;

/**
 * 响应请求结果类，返回用户操作结果的提示信息
 * @date 2017-09-09 13:59
 */
public class ResponseResult<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*响应结果编码*/
    private int code;
    /**响应结果信息*/
    private String msg;
    /**响应结果的数据*/
    private T data;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

	public ResponseResult(Message msg) {
        this.code = msg.getCode();
        this.msg = MessageHelper.getMessage(msg.getKey());
    }
	/**
	 * 默认操作成功的方法
	 */
	public static ResponseResult<String> successResult() {
		return new ResponseResult<>(Message.SUCCESS);
	}
	/**
	 * 默认操作失败的方法
	 */
	public static ResponseResult<String> errorResult() {
		return new ResponseResult<>(Message.ERROR);
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
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回请求成功的结果为json数据的方法。
     * @date 2017-09-17 23:35
     */
    public static Map<String, Object> successJSON() {
        Map<String, Object> jsonMap = new HashMap();
        jsonMap.put(Constant.CODE_KEY, SUCCESS_CODE);
        jsonMap.put(Constant.MESSAGE_KEY, "");
        return jsonMap;
    }

	
	@Override
	public String toString() {
        return JSONObject.fromObject(this).toString();
	}
}
