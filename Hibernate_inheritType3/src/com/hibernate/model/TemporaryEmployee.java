package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TemporaryEmployee")
@PrimaryKeyJoinColumn(name="TE_id")
public class TemporaryEmployee extends Employee{

	@Column(name = "WorkingDays", nullable = true)
	private String workingDays;

	@Column(name = "ContractorName", nullable = true, length = 20)
	private String contractorName;

	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	@Override
	public String toString() {
		return "TemporaryEmployee [workingDays=" + workingDays
				+ ", contractorName=" + contractorName + "]";
	}

}
