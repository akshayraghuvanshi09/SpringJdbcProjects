package com.testingmapping.demo.responsedto;

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
public class AddressResponseDTO {
	private String placeName;
	private String cityName;
	private String stateName;
	private String countryName;
}
