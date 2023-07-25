package com.testingmapping.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminID;
	private String adminName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminAddress")
	private List<Address> adminAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotels")
	private List<Hotel> hotels;
}
