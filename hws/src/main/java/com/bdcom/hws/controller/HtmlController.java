package com.bdcom.hws.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bdcom.hws.model.Barrage;
import com.bdcom.hws.service.BarrageService;
import com.bdcom.hws.utils.JsonUtils;

@Controller
public class HtmlController {
	
	@Autowired
	private BarrageService barService;
	
	@RequestMapping(value="/login")
	public String initLogin(){
		
		return "login";
	}
	@RequestMapping(value="/home")
	public String initHomePage(HttpServletRequest req){
		/*            适合不跳转页面
		 * JSONObject jsonObj = new JSONObject();
		List<Barrage> barList = barService.getAllBar();
		jsonObj.put("result", barList);
		response.setCharacterEncoding("UTF-8");
		JsonUtils.writeJson(response, jsonObj);*/
		
		List<Barrage> barList = barService.getAllBar();
		req.setAttribute("barList", barList);
		
		return "index";
	}

}
