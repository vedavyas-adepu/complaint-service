package com.cg.complaint.entity;

import org.springframework.data.annotation.Id;

import com.cg.complaint.dto.ClientDTO;
import com.cg.complaint.dto.EngineerDTO;
import com.cg.complaint.dto.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complaintId;
	@Column(nullable = false)
	private String productModelNumber;
	@Column(nullable = false)
	private String complaintName;
	private String status; 
	private String clientId; 
	private int engineerId;

	
	@OneToOne
	@JoinColumn(name="employeeId")
	private EngineerDTO engineer;
	
	@OneToOne
	@JoinColumn(name="clientId")
	private ClientDTO client;

}
