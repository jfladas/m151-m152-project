package com.example.aufgabenverwaltung.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

    @Column(name = "duedate")
	private String duedate;

    @Column(name = "person")
	private String person;
	
	public Task() {

	}

	public Task(String title, String description, String status, String duedate, String person) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.duedate = duedate;
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", desc=" + description + ", status=" + status + ", due=" + duedate + ", pers=" + person + "]";
	}

}