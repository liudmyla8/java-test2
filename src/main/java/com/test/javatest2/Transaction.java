package com.test.javatest2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Date date;

	private int sum;

	public Integer getId() {
			return id;
		}

	public void setId(Integer id) {
			this.id = id;
		}

	public Date getDate() {
			return date;
		}

	public void setDate(Date date) {
			this.date = date;
		}

	public int getSum() {
			return sum;
		}

	public void setSum(int sum) {
			this.sum = sum;
		}

}
