package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private AddressType addressType;

    @JsonBackReference(value = "student-address-reference")
    private StudentDTO student;
    @JsonBackReference(value = "parent-address-reference")
    private ParentDTO parent;
    @JsonBackReference(value = "teacher-address-reference")
    private TeacherDTO teacher;

    private Integer currentTemperature;

    /**TODO
     * consume a third-party API: weatherstack API
     * Be sure to get your access key
     * query with the city name
     * use http, not https because it is free
     * use FeignClient
     * In short, we need to call individual address endpoint and take city from there. Then we need to call weatherstack api and pass the city as the parameter. Then extract the temperature value from weatherstack api response and update individual address response with that temperature.
     */

}