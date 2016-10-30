package com.search.entitys; 
/** 
*
* @author CL
* @date   2016年10月29日 
*/
public class Message {
	private String url;
	private String title;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Message [url=" + url + ", title=" + title + "]\n";
	}
	
	
}
 