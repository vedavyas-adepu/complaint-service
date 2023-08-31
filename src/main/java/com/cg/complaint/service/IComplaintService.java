package com.cg.complaint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.complaint.dto.ClientDTO;
import com.cg.complaint.dto.ComplaintDTO;
import com.cg.complaint.dto.EngineerDTO;
import com.cg.complaint.dto.ProductDTO;
import com.cg.complaint.entity.Complaint;
import com.cg.complaint.exception.InValidComplaintException;


public interface IComplaintService {
	
	
	boolean bookComplaint(ComplaintDTO complaintDTO, ClientDTO clientDTO, ProductDTO productDTO);

	String changeComplaintStatus(int complaintId, String status);

	List<Complaint> getClientAllComplaints(String clientId);

	List<Complaint> getClientAllOpenComplaints(String clientId);

	EngineerDTO getEngineer(int complaintId) throws InValidComplaintException;
	
	ProductDTO getProductByComplaint(int complaintId) throws InValidComplaintException;
	
}
