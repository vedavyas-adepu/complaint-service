package com.cg.complaint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.complaint.dto.ClientDTO;
import com.cg.complaint.dto.ComplaintDTO;
import com.cg.complaint.dto.EngineerDTO;
import com.cg.complaint.dto.ProductDTO;
import com.cg.complaint.entity.Complaint;
import com.cg.complaint.exception.InValidComplaintException;
import com.cg.complaint.repository.IComplaintRepository;

@Service
public class IComplaintServiceImpl implements IComplaintService {

	@Autowired
	IComplaintRepository repo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean bookComplaint(ComplaintDTO complaintDTO, ClientDTO clientDTO, ProductDTO productDTO) {
		boolean created = false;
		Complaint complaint = Complaint.builder().clientId(clientDTO.getClientId()).status(complaintDTO.getStatus())
				.productModelNumber(productDTO.getModelNumber()).complaintName(complaintDTO.getComplaintName()).build();
		repo.save(complaint);
		if (repo.findById(complaint.getComplaintId()).isPresent()) {

			created = true;
		}

		return created;
	}

	@Override
	public String changeComplaintStatus(int complaintId, String status) {
		Complaint a1 = repo.findById(complaintId).orElseThrow(() -> {
			throw new RuntimeException("no complaint found");
		});
		a1.setStatus(status);
		repo.save(a1);
		Complaint a = repo.findById(complaintId).orElseThrow();
		if (a.getStatus() == status) {
			return "successfully updated";
		} else {
			return "failed";
		}
	}

	@Override
	public List<Complaint> getClientAllComplaints(String clientId) {
		List<Complaint> lc1 = repo.getClientAllComplaints(clientId);
		return lc1;
	}

	@Override
	public List<Complaint> getClientAllOpenComplaints(String clientId) {
		List<Complaint> lc1 = repo.getClientAllOpenComplaints(clientId, "open");
		return lc1;
	}

	@Override
		public EngineerDTO getEngineer(int complaintId) throws InValidComplaintException 
		{ 	
			Complaint a1=repo.findById(complaintId).orElseThrow(()->{
				throw new RuntimeException("no complaint found");
			});	
			var employeeId = a1.getEngineerId();
			EngineerDTO engineer = restTemplate.getForObject("http://localhost:8083/", EngineerDTO.class);
			return engineer;
		}

	@Override
	public ProductDTO getProductByComplaint(int complaintId) throws InValidComplaintException {
		Complaint a1 = repo.findById(complaintId).orElseThrow();
		ProductDTO c = restTemplate.getForObject("http://localhost:8084/", ProductDTO.class);
		return c;
	}

}
