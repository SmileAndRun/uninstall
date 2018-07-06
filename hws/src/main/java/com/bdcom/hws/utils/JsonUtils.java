package com.bdcom.hws.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JsonUtils {

	/**
	 * 工具方法写JSON
	 * @param reponse
	 * @param jsonObj
	 * @throws IOException
	 */
	public static void writeJson(HttpServletResponse response,JSONObject jsonObj){
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.print(jsonObj);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		
	}
}
