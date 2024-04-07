package com.todolist.form.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "listitems")
public class ListItems {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	@NotEmpty(message="	required field")
	@Pattern(regexp="^[a-zA-Z\s]+" ,message="Invalid title")
	private String title;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "date in the past not allowed")
	@NotNull(message="required field")
	@Temporal(TemporalType.DATE )
	private Date date;

	@Column(name = "status")
	@NotEmpty(message = "you must detect the status")
    @Pattern(regexp = "^(complete|notcompleted)+",message = "complete or not complete is required")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
