package org.egov.receipt.consumer.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class paymentDetails {
	

    private String paidBy;
    private String mobileNumber;
    private String payerName; 
    private String payerAddress; 
    private String narration; 
    private String payerEmail; 
    private String payerId; 
    private String bankName;
    private String bankBranch; 
    private String subdivison; 
    private String servicename;    
    private String collectedbyname;     
    private String gstno;
    private String paymentMode;
    private String paymentStatus;
    private String paymentId;
    private String receiptNumber;
    private Long receiptDate;
    private BigDecimal totalAmountPaid;
    private Long instrumentDate;
    private String instrumentNumber;
    
    
}
