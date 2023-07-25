package com.testingmapping.demo.responsedto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.testingmapping.demo.entity.Address;
import com.testingmapping.demo.entity.Hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AdminResponseDTO {
	private String adminName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminAddress")
	private List<AddressResponseDTO> adminAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotels")
	private List<HotelResponseDTO> hotels;
}
