package fr.imie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="projet")
@NamedQuery(name="CrowdFundingDTO.findAll", query="SELECT p FROM CrowdFundingDTO p")
public class CrowdFundingDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nom")
	private String name;
	
	@Column(name="objectif")
	private Integer goal;
	private Integer aim;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGoal() {
		return goal;
	}
	public void setGoal(Integer goal) {
		this.goal = goal;
	}
	public Integer getAim() {
		return aim;
	}
	public void setAim(Integer aim) {
		this.aim = aim;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
