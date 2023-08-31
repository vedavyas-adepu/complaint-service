//package com.ABCelectronics.Complaintservice;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.complaint.entity.Complaint;
//import com.cg.complaint.repository.IComplaintRepository;
//import com.cg.complaint.service.IComplaintServiceImpl;
//
//@SpringBootTest
//class ComplaintServiceApplicationTests {
//
//	@Autowired
//	IComplaintServiceImpl icomp;
//
//	@MockBean
//	IComplaintRepository repo;
//
//	@Test
//	void testBookComplaint() {
//		Complaint c1=new Complaint();
//		c1.setComplaintId(1);
//		c1.setProductModelNumber("A7");
//		c1.setComplaintName("damage");
//		c1.setStatus("open");
//		c1.setClientId("97");
//		c1.setEngineerId(13);
//		
//		List<Complaint> complaintList = new ArrayList<>();
//		complaintList.add(c1);
//		
//		Mockito.when(repo.saveAll(complaintList)).thenReturn(complaintList);
//		
//
//	}
//}
