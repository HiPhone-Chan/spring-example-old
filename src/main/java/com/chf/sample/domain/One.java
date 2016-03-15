package com.chf.sample.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "one")
public class One {

	@Id
	@GeneratedValue
	private Long id;

	private String value;

	@OneToOne
	private One one;

	@OneToMany
	private List<ManyA> manys;

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

	public One getOne() {
		return one;
	}

	public void setOne(One one) {
		this.one = one;
	}

	public List<ManyA> getManys() {
		return manys;
	}

	public void setManys(List<ManyA> manys) {
		this.manys = manys;
	}

	@Override
	public String toString() {
		return "One [id=" + id + ", value=" + value + ", one=" + one
				+ ", manys=" + manys + "]";
	}

}
