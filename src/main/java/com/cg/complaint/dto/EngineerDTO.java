package com.cg.complaint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineerDTO {
	
	private int employeeId;
	private String password;
	private String engineerName;
	private String domain;

}
