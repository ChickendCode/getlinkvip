package com.getlink.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fshare {
	public String getFsCode(CookieManager cookie, String url) {
		Pattern p = Pattern.compile("content=\"(.*?)\"");
		Matcher m;
		CookieHandler.setDefault(cookie);
		String fs= "";
		try {
			URL tmpURL = new URL(url);
			tmpURL.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(tmpURL.openStream()));
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				m = p.matcher(tmp);
				if ((m.find() && tmp.contains("name=\"csrf-token\""))) {
					fs = m.group(1);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fs;
	}
	
	public String loginFshare(CookieManager cookie, String loginData, String loginURL) {
		CookieHandler.setDefault(cookie);
		URL url;
		String result = "";
		HttpURLConnection connection;
		OutputStream os;
		BufferedReader br;
		String tmp;
		try {
			url = new URL(loginURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
			connection.setDoOutput(true);
			connection.connect();
			
			os = connection.getOutputStream();
			os.write(loginData.getBytes());
			os.flush();
			os.close();
			
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((tmp= br.readLine())!= null) {
				result = result.concat(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getLink(CookieManager cookie, String url) {
		String result = "";
		String fs = getFsCode(cookie, url);
		String linkCode = "";
		Pattern p = Pattern.compile("https://www.fshare.vn/file/(\\w*)", Pattern.CASE_INSENSITIVE);
		Matcher m;
		m = p.matcher(url);
		if (m.find()) {
			linkCode = m.group(1);
		}
		String postData = "_csrf-app="
				+ fs
				+ "&linkcode="
				+ linkCode
				+ "&withFcode5=0"
				+ "&fcode=";
		OutputStream os;
		BufferedReader br;
		String tmp;
		try {
			HttpURLConnection connection = (HttpURLConnection)new URL("https://www.fshare.vn/download/get").openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
			connection.setDoOutput(true);
			connection.connect();
			
			os = connection.getOutputStream();
			os.write(postData.getBytes());
			os.flush();
			os.close();
			
			br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((tmp= br.readLine())!= null) {
				result = result.concat(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main( String args[] ) {
	      // String to be scanned to find the pattern.
	      String line = "<meta content=\"EKn-1YVAurzJIkKvN6DD4vp7DBQIBeobqcy_LtXbT2Ik7aGR5xjW7_pGb5h6kICArE05WG9Uoi_ovctImZYMWw==\">";
	      String pattern = "content=\"(.*?)\"";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	         System.out.println("Found value: " + m.group(1) );
	      } else {
	         System.out.println("NO MATCH");
	      }
	   }
}
