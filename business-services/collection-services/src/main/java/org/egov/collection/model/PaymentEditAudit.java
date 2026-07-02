package org.egov.collection.model;


import org.egov.collection.validation.SanitizeHtml;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEditAudit {
	
	
	   @Size(max=64)
	   @JsonProperty("id")
	   private String id;
	   
	   @NotNull
	   @Size(max=64)
	   @JsonProperty("paymentId")
	   private String paymentId;
	   
	   @NotNull
	   @SanitizeHtml
	   @Size(max=64)
	   @JsonProperty("receiptNumber")
	   private String receiptNumber;
	   
	   
	   @NotNull
	   @Size(max=2048)
	   @SanitizeHtml
	   @JsonProperty("modifiedFields")
	   private String modifiedFields;
	   
	   @NotNull
	   @Size(max=64)
	   @SanitizeHtml
	   @JsonProperty("modifiedBy")
	   private String modifiedBy;
	   
	   @NotNull
	   @JsonProperty("modifiedTime")
	   private Long modifiedTime;

}
