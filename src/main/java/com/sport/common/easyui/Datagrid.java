package com.sport.common.easyui;

import com.sport.util.DateUtil;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * eayui的数据表格模型--其中字段名称必须是下面的固定名称
 * @date 2016-8-6 下午12:26:57
 */
public class Datagrid<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**当数据为null时，初始化list容量的大小*/
	private static final int initSize = 1;
	
	/**数据的总行数*/
    private long total;
    /**数据行，数据行不能为null*/
    private List<T> rows;
    /**页脚*/
    private List<T> footer;
	
	
	
	public Datagrid() {
		
	}
	
	public Datagrid(List<T> rows) {
		this(0L, rows);
	}
	
	public Datagrid(long total, List<T> rows) {
		this(total, rows, null);
	}
	
	public Datagrid(long total, List<T> rows, List<T> footer) {
		if (rows == null) {
			rows = new ArrayList<T>(initSize);
		}
		this.total = total < 0L ? 0L : total;
		this.rows = rows;
		this.footer = footer;
	}

	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total < 0L ? 0L : total;
	}
	
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		if (rows == null) {
			rows = new ArrayList<T>(initSize);
		}
		this.rows = rows;
	}
	
	public List<T> getFooter() {
		return footer;
	}
	public void setFooter(List<T> footer) {
		this.footer = footer;
	}
	
	@Override
	public String toString() {
        String jsonStr = null;
        try {
            JsonConfig jsonCon = new JsonConfig();
//			jsonCon.setExcludes(new String[]{"createTime", "relvo"});//设置不需要转换成json的字段
            //格式化日期类型
            jsonCon.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
                /**
                 * @param str 字段名称
                 * @param obj 日期对象
                 * @param jc JsonConfig对象
                 */
                @Override
                public Object processObjectValue(String str, Object obj, JsonConfig jc) {
                    if (obj == null) {
                        return null;
                    }
                    if (obj instanceof Date) {
                        return DateUtil.formateTime((Date)obj);
                    }
                    return obj.toString();
                }
                @Override
                public Object processArrayValue(Object obj, JsonConfig jc) {
                    if (obj == null) {
                        return null;
                    }
                    if (obj instanceof Date) {
                        return DateUtil.formateTime((Date)obj);
                    }
                    return obj.toString();
                }
            });
            jsonStr = JSONObject.fromObject(this, jsonCon).toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonStr;
	}
}
