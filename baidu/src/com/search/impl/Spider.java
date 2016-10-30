package com.search.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.search.entitys.Message;
import com.search.interfaces.ISpider;

/** 
*
* @author CL
* @date   2016年10月29日 
*/
public class Spider implements ISpider {
	protected String crawl(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient=HttpClientBuilder.create().build();
		CloseableHttpResponse httpResponse=httpClient.execute(new HttpGet(url));
		String result=EntityUtils.toString(httpResponse.getEntity());
		return result;
	}

	@Override
	public List<Message> getList(String url) {
		String result = null;
		List<Message> list=new ArrayList<Message>();
		Message msg=null;
		try {
			result = crawl(url);
			Document doc=Jsoup.parse(result);
			Elements es=doc.select(".b_algo h2 a");
			for(Element e:es){
				msg=new Message();
				msg.setTitle(e.text());
				msg.setUrl(e.attr("href"));
				list.add(msg);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
 