package com.testingmapping.demo.requestdto;

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
public class AddressRequestDTO {

	private String placeName;
	private String cityName;
	private String stateName;
	private String countryName;
}
