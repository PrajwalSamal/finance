package org.egov.receipt.consumer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.receipt.consumer.entity.VoucherIntegrationLog;
import org.egov.receipt.consumer.model.AuditDetails;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReceiptGenerationRowMapper  implements ResultSetExtractor<List<VoucherIntegrationLog>> {
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public List<VoucherIntegrationLog> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, VoucherIntegrationLog> sepMap = new HashMap<>();
		
		List<VoucherIntegrationLog> VoucherIntegrationLogList = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("id");
				VoucherIntegrationLog voucherIntegrationLog = new VoucherIntegrationLog();
				
				voucherIntegrationLog = voucherIntegrationLog.builder().build();
				if (!sepMap.containsKey(id)) {
					voucherIntegrationLog.setId(rs.getString("id"));
					voucherIntegrationLog.setReferenceNumber(rs.getString("referencenumber"));
					voucherIntegrationLog.setStatus(rs.getString("status"));
					voucherIntegrationLog.setVoucherNumber(rs.getString("vouchernumber"));
					voucherIntegrationLog.setType(rs.getString("type"));
					voucherIntegrationLog.setDescription(rs.getString("description"));
					voucherIntegrationLog.setRequestJson(rs.getString("requestjson"));
					voucherIntegrationLog.setTenantId(rs.getString("tenantid"));
					voucherIntegrationLog.setCreatedDate(rs.getDate("createddate"));
					
					sepMap.put(id, voucherIntegrationLog);
					VoucherIntegrationLogList.add(voucherIntegrationLog);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return VoucherIntegrationLogList;
	}

}

