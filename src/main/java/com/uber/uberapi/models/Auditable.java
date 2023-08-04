package com.uber.uberapi.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass //don't create table for Auditable
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true; //same memory address
		if(this.getClass().equals(obj.getClass())) return false;

		if(obj instanceof Auditable){
			Auditable auditableObj = (Auditable) obj;
			if(id == null && obj == null) return true;
			if(id == null || obj == null) return false;
			return id == ((Auditable) obj).id;
		}
		else
			return super.equals(obj);
	}
}
