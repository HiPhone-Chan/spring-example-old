package com.chf.sample.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manyB")
public class ManyB {

	@Id
	@GeneratedValue
	private Long id;

	private String value;

	@ManyToMany
	private List<ManyA> manyAs;

	@ManyToOne
	private One one;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<ManyA> getManyAs() {
		return manyAs;
	}

	public void setManyAs(List<ManyA> manyAs) {
		this.manyAs = manyAs;
	}

	public One getOne() {
		return one;
	}

	public void setOne(One one) {
		this.one = one;
	}

}
