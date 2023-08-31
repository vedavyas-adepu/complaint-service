package com.cg.complaint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientDTO {
	
	private String clientId;
	private String password;
	private String address;
	private long phoneNumber;

}
