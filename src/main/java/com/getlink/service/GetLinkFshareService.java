package com.getlink.service;

import java.net.CookieManager;
import java.net.CookiePolicy;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.getlink.model.User;
import com.getlink.util.Fshare;

@Service
public class GetLinkFshareService {
	
	public String getLinkVip(String linkFshare) throws JSONException {
		String linkVip = "";
		CookieManager cookie = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
		String loginURL = "https://www.fshare.vn/login";
		String fshareHome = "https://www.fshare.vn";
		User u = new User("thantienbut@gmail.com", "thantienbut150392");
		Fshare f = new Fshare();
		String fs = f.getFsCode(cookie, fshareHome);
		String data = u.getLoginData(fs);
		
		f.loginFshare(cookie, data, loginURL);
		String vipData = f.getLink(cookie, linkFshare);
		
		JSONObject jsonObject = new JSONObject(vipData);
		linkVip = jsonObject.getString("url");
		return linkVip;
	}
}
