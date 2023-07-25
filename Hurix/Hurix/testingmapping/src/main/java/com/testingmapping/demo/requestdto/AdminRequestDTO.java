package com.testingmapping.demo.requestdto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.testingmapping.demo.entity.Address;
import com.testingmapping.demo.entity.Hotel;
import com.testingmapping.demo.responsedto.CommonResponseDTO;

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
public class AdminRequestDTO {

	private String adminName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminAddress")
	private List<AddressRequestDTO> adminAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotels")
	private List<HotelRequestDTO> hotels;
}
