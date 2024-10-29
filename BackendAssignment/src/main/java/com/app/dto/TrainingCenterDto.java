package com.app.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TrainingCenterDto {
	 	private Long id;
	    private String centerName;
	    private String centerCode;
	    private Integer studentCapacity;
	    
	    private String contactEmail;
	    private String contactPhone;

}
