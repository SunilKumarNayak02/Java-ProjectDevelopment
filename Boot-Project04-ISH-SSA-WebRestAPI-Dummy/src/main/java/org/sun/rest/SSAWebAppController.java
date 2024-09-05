package org.sun.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebAppController {
      @GetMapping("/find/{ssn}")
	  public ResponseEntity<String>showAllStates(@PathVariable Integer ssn){
		    //checking the condition
    	  if(String.valueOf(ssn).length()<9||String.valueOf(ssn).length()>9)
    		  return new ResponseEntity<String>("Invalid ssn",HttpStatus.BAD_REQUEST);
    	  //state code check
    	  int stateCode=ssn%100;
    	  String stateName=null;
    	  if(stateCode==01)
    		  stateName="CaliFornia";
    	  else if(stateCode==02)
    	      stateName="NewWork";
    	  else if(stateCode==03)
    		  stateName="America";
    	  else if(stateCode==04)
    		  stateName="Texas";
    	  else
    		  stateName="Invalid State Code Please Enter Valid Code: ";
    	  
    	  return new ResponseEntity<String>(stateName,HttpStatus.OK);
	  }
}
