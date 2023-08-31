package com.cg.complaint.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private String modelNumber;
	private String productName;
	private String productCategoryName;
	private LocalDate dateofPurchase;
	private int warrentyYears;

}
