package com.example.finance;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.Identifiable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account implements Identifiable<Long> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private int priority;
	
	private @Version @JsonIgnore Long version;

	private @ManyToOne UserApp user;

	private Account() {
		this.priority = 1;
	}

	public Account(String name, int priority, UserApp user) {
		this.name = name;
		this.priority = priority;
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return Objects.equals(id, account.id) &&
			Objects.equals(name, account.name) &&
			Objects.equals(priority, account.priority) &&
			Objects.equals(version, account.version) &&
			Objects.equals(user, account.user);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, priority, version, user);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public UserApp getUser() {
		return user;
	}

	public void setUser(UserApp user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Account{" +
			"id=" + id +
			", name='" + name + '\'' +
			", priority='" + priority + '\'' +
			", version=" + version +
			", user=" + user +
			'}';
	}
}
