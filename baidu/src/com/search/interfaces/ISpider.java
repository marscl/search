package com.search.interfaces;

import java.util.List;

import com.search.entitys.Message;

/** 
*
* @author CL
* @date   2016年10月29日 
*/
public interface ISpider {
	public List<Message> getList(String url);
}
 