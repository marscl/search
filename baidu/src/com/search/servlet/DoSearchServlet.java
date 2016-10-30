package com.search.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.search.entitys.Message;
import com.search.impl.Spider;

/** 
*
* @author CL
* @date   2016年10月29日 
*/
public class DoSearchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String key=req.getParameter("key");
		String currentPage=req.getParameter("currentPage");
		if(currentPage==null||"".equals(currentPage))currentPage="2";
		int first=(Integer.parseInt(currentPage)-1)*10+1;
		//String url="http://cn.bing.com/search?q=site:pan.baidu.com "+key;
		String url="http://cn.bing.com/search?q=site%3Apan.baidu.com+"+key+"&first="+first;
		Spider spider=new Spider();
		List<Message> list=spider.getList(url);
		req.setAttribute("list", list);
		req.getRequestDispatcher("content.jsp").forward(req, resp);
		//resp.sendRedirect("content.jsp?currentPage="+list);
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
 