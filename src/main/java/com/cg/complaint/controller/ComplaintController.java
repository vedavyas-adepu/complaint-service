package com.cg.complaint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.complaint.dto.ClientDTO;
import com.cg.complaint.dto.ComplaintDTO;
import com.cg.complaint.dto.EngineerDTO;
import com.cg.complaint.dto.ProductDTO;
import com.cg.complaint.entity.Complaint;
import com.cg.complaint.exception.InValidComplaintException;
import com.cg.complaint.service.IComplaintService;
import com.cg.complaint.service.IComplaintServiceImpl;

@RestController
@RequestMapping(path = "/api")

public class ComplaintController {
	@Autowired
	IComplaintService icomp;

	@PostMapping("/bookComplaint")
	public ResponseEntity<String> bookComplaint(@RequestBody ComplaintDTO z,ClientDTO x, ProductDTO y) {
		ResponseEntity re;
		if(icomp.bookComplaint(z,x,y)){
			re = new ResponseEntity<String>("created", HttpStatus.OK);
		}
		else {
			re= new ResponseEntity<String>("notcreated", HttpStatus.OK);
		}
		return re;
	}

	@PutMapping("/updateComplaint/{complaintId}")
	public ResponseEntity<String> changeComplaintStatus(@PathVariable int complaintId, @RequestBody String status)
			throws Throwable {
		String a1 = icomp.changeComplaintStatus(complaintId, status);
		ResponseEntity re = new ResponseEntity<String>(a1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getAllComplaint/{clientId}")
	public ResponseEntity<List<Complaint>> getClientAllComplaints(@PathVariable String clientId) {
		List<Complaint> le = icomp.getClientAllComplaints(clientId);
		ResponseEntity re = new ResponseEntity<List<Complaint>>(le, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getAllOpenComplaint/{clientId}")
	public ResponseEntity<List<Complaint>> getClientAllOpenComplaints(@PathVariable String clientId) {
		List<Complaint> le = icomp.getClientAllOpenComplaints(clientId);
		ResponseEntity re = new ResponseEntity<List<Complaint>>(le, HttpStatus.OK);
		return re;
	}
	
	 @GetMapping("/getEngineer/{complaintId}")
	  public ResponseEntity<EngineerDTO> getEngineer(@PathVariable int complaintId) throws InValidComplaintException {
	  EngineerDTO c1=icomp.getEngineer(complaintId);
	  ResponseEntity re=new ResponseEntity<EngineerDTO>(c1,HttpStatus.OK); 
	  return re;
	  }
 
	 @GetMapping("/getProduct/{complaintId}") 
	 public ResponseEntity<ProductDTO> getProductByComplaint(@PathVariable int complaintId) throws InValidComplaintException { 
		 ProductDTO c1=icomp.getProductByComplaint(complaintId); 
	     ResponseEntity re=new ResponseEntity<ProductDTO>(c1,HttpStatus.OK); 
     	 return re; 
     	 }

}
