package com.getlink.api;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getlink.constants.Constants;

@RestController
@RequestMapping(value = "/api")
public class DemoController {

	@RequestMapping(value = "/anhtindeptrai", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<?> getDemo() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("statusCode", Constants.STATUS_OK);
		jsonObject.put("question", "Anh Tin co dep trai khong?");
		jsonObject.put("answer", "Co. Rat dep trai");
		ResponseEntity<String> retult = new ResponseEntity<String>(jsonObject.toString(), new HttpHeaders(),
				HttpStatus.OK);
		return retult;
	}
	
	@RequestMapping(value = "/anhtindeptrai2", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<?> getDemo1(@RequestParam String id) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		
		JSONObject persion = new JSONObject();
		persion.put("name", "Tran Dang Tin");
		persion.put("age", "26");
		persion.put("handsome", "yes");
		persion.put("sex", "Nam");
		
		JSONObject persion2 = new JSONObject();
		persion2.put("name", "Anh Duc Nguyen");
		persion2.put("age", "23");
		persion2.put("handsome", "no");
		persion2.put("sex", "nu");
		
		if (!id.equals("001") && !id.equals("002") && !id.equals("All")) {
			jsonObject.put("statusCode", Constants.STATUS_FAIL);
			jsonObject.put("message", "Khong tim thay voi id = " + id);
		}
		else if (id.equals("001")) {
			jsonObject.put("statusCode", Constants.STATUS_OK);
			jsonObject.put("persion", persion);
		} else if (id.equals("002")) {
			jsonObject.put("statusCode", Constants.STATUS_OK);
			jsonObject.put("persion", persion2);
		} else if (id.equals("All")) {
			ArrayList<JSONObject> persions = new ArrayList<JSONObject>();
			persions.add(persion);
			persions.add(persion2);
			jsonObject.put("statusCode", Constants.STATUS_OK);
			jsonObject.put("persions", persions);
		}
		
		ResponseEntity<String> retult = new ResponseEntity<String>(jsonObject.toString(), new HttpHeaders(),
				HttpStatus.OK);
		return retult;
	}
}
