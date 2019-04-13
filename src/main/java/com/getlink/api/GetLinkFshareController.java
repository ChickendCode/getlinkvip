package com.getlink.api;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getlink.constants.Constants;
import com.getlink.service.GetLinkFshareService;

@RestController
@RequestMapping(value = "/fshare")
public class GetLinkFshareController {
	@Autowired
	private GetLinkFshareService getLinkFshareService;

	@RequestMapping(value = "/getlinkvip", method = RequestMethod.GET)
	@CrossOrigin
    public ResponseEntity<?> getLinkVip(@RequestParam String linkFshare) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		ResponseEntity<String>  retult;
        try {
        	String linkVip = getLinkFshareService.getLinkVip(linkFshare);
			jsonObject.put("statusCode", Constants.STATUS_OK);
	        jsonObject.put("linkVip", linkVip);
	        retult = new ResponseEntity<String>(jsonObject.toString(), new HttpHeaders(), HttpStatus.OK);
	        
		} catch (JSONException e) {
			jsonObject.put("statusCode", Constants.STATUS_FAIL);
			retult = new ResponseEntity<String>(jsonObject.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
        
        return retult;
    }
}
