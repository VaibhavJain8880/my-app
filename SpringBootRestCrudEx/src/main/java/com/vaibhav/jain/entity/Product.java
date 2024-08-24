package com.vaibhav.jain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "pro_id")
	private Integer proId;
	
	@Column(name = "pro_code")
	private String proCode;
	
	@Column(name="pro_cost")
	private Double proCost;
	
	@Column(name = "pro_vendor")
	private String proVendor;

	public Product(Integer proId, String proCode, Double proCost, String proVendor) {
		super();
		this.proId = proId;
		this.proCode = proCode;
		this.proCost = proCost;
		this.proVendor = proVendor;
	}
	

	


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public Double getProCost() {
		return proCost;
	}

	public void setProCost(Double proCost) {
		this.proCost = proCost;
	}

	public String getProVendor() {
		return proVendor;
	}

	public void setProVendor(String proVendor) {
		this.proVendor = proVendor;
	}

	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proCode=" + proCode + ", proCost=" + proCost + ", proVendor=" + proVendor
				+ "]";
	}
	
	
}
