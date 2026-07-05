package org.egov.receipt.consumer.model;

import java.util.List;

import org.egov.receipt.consumer.model.VoucherResponse.VoucherResponseBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoucherAndMisResponse {
	
	private VoucherResponse voucherResponse;
    private boolean misSuccess;

}
