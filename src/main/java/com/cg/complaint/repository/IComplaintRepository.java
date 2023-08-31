package com.cg.complaint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.complaint.entity.Complaint;

@Repository
public interface IComplaintRepository extends JpaRepository<Complaint,Integer> {

	List<Complaint> getClientAllComplaints(String clientId);

	List<Complaint> getClientAllOpenComplaints(String clientId, String string);
	
	
}
