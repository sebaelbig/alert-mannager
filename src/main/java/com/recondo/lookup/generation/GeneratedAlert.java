package com.recondo.lookup.generation;

// import com.recondo.lookup.Product;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class GeneratedAlert implements Serializable {
	private static final long serialVersionUID = 0L;

	@ApiModelProperty(required = true, value = "Product", notes = "Product enumeration")
	@NotNull
	private String product;

	@ApiModelProperty(required = true, value = "Alert text", notes = "Max 255 characters")
	@NotBlank
	@Size(max = 255)
	private String text;

	@ApiModelProperty(required = true, value = "Alert Key", notes = "Max 100 characters")
	@Size(max = 100)
	private String key;

	@ApiModelProperty(required = true, value = "Alert Value", notes = "Max 100 characters")
	@Size(max = 100)
	private String value;

	@ApiModelProperty(value = "This is a UUID (stored as a string) representing the benefit this alert fired for.")
	private String benefitId;

	// Must have a default constructor for Jackson to use when parsing JSON
	public GeneratedAlert() {
		super();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	 public String getProduct() {
	 	return product;
	 }

	 public void setProduct(String product) {
	 	this.product = product;
	 }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}
}
