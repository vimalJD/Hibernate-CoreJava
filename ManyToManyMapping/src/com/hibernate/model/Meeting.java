package com.hibernate.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEETING")
public class Meeting {
	
	@Id
	@Column(name="MEETING_ID")
	@GeneratedValue
	private Long meetingId;

	@Column(name="SUBJECT" ,length=35)
	private String subject;
	
	@Column(name="MEETING_DATE")
	private Date meetingDate;
	
	@ManyToMany(mappedBy="meetings")
	private Set<Employee> employees = new HashSet<Employee>();
	
	public Meeting(String subject) {
		this.subject = subject;
		this.meetingDate = new Date();
	}

}
