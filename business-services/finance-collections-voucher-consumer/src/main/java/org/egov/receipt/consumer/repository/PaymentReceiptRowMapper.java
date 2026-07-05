package org.egov.receipt.consumer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.receipt.consumer.entity.VoucherIntegrationLog;
import org.egov.receipt.consumer.entity.paymentDetails;
import org.egov.receipt.consumer.model.AuditDetails;
import org.egov.receipt.consumer.model.MisReceiptsDetailsRequest;
import org.egov.receipt.consumer.v2.model.PaymentRequest;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PaymentReceiptRowMapper  implements ResultSetExtractor<paymentDetails> {
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public paymentDetails extractData(ResultSet rs) throws SQLException, DataAccessException {

		paymentDetails paymentRequest = new paymentDetails();
		try {
			while (rs.next()) {		
				
				paymentRequest.setBankBranch(rs.getString("bank_branch"));
				paymentRequest.setBankName(rs.getString("bank_name"));
				paymentRequest.setGstno(rs.getString("gst_no"));
				paymentRequest.setNarration(rs.getString("narration"));
				paymentRequest.setPaidBy(rs.getString("paidby"));
				paymentRequest.setPayerAddress(rs.getString("payeraddress"));
				paymentRequest.setPaymentMode(rs.getString("paymentmode"));
				paymentRequest.setPaymentStatus(rs.getString("paymentstatus"));
				paymentRequest.setPaymentId(rs.getString("paymentid"));
				paymentRequest.setReceiptNumber(rs.getString("receiptnumber"));
				paymentRequest.setReceiptDate(rs.getLong("receiptdate"));
				paymentRequest.setServicename(rs.getString("businessservice"));
				paymentRequest.setSubdivison(rs.getString("sub_divison"));
				paymentRequest.setTotalAmountPaid(rs.getBigDecimal("amountpaid"));
				paymentRequest.setInstrumentNumber(rs.getString("instrumentnumber"));	
				paymentRequest.setInstrumentDate(rs.getLong("instrumentdate"));	
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentRequest;
	}

}
