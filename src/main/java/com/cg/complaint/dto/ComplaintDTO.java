package com.cg.complaint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ComplaintDTO {
	
	private int complaintId;
	private String productModelNumber;
	private String complaintName;
	private String status; 
	private String clientId; 
	private int engineerId;

}
