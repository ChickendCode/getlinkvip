package com.getlink.api;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getlink.constants.Constants;

@RestController
@RequestMapping(value = "/api")
public class DemoController {

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ResponseEntity<?> getDemo(@RequestParam String linkFshare) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("statusCode", Constants.STATUS_OK);
		jsonObject.put("demo", "demo nè");
		ResponseEntity<String> retult = new ResponseEntity<String>(jsonObject.toString(), new HttpHeaders(),
				HttpStatus.OK);
		return retult;
	}
}
