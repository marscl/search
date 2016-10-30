package com.search.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/** 
*
* @author CL
* @date   2016年10月29日 
*/
public class searchServlet extends HttpServlet {
	/**
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <String> arrays=new ArrayList<String>();
		List <String> result=new ArrayList<String>();
		arrays.add("java");
		arrays.add("jump");
		arrays.add("j");
		arrays.add("abc");
		arrays.add("array");
		
		String keyword=req.getParameter("keyword");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		for(String array:arrays){
			if(array.contains(keyword)){
				result.add(array);
			}
		}
		
		resp.getWriter().write(JSONArray.fromObject(result).toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
 