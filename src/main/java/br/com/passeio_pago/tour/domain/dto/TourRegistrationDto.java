package br.com.passeio_pago.tour.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.passeio_pago.common.util.SalaryDeserializer;
import br.com.passeio_pago.common.util.SalarySerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TourRegistrationDto {

	@ApiModelProperty(required = true, example = "Passeio fim de ano", value = "Property to define the tour's name.")
	@NotBlank
	private String name;

	@ApiModelProperty(required = true, example = "R$ 80,50", value = "Property to define the tour's price.")
	@NotBlank
	@JsonSerialize(using = SalarySerializer.class)
	@JsonDeserialize(using = SalaryDeserializer.class)
	@Digits(fraction = 2, integer = 6)
	private BigDecimal price;

	@ApiModelProperty(required = false, example = "12/08/2019", value = "Property to define the payment dead line.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate paymentDeadline;

	@ApiModelProperty(required = false, example = "27/08/2018", value = "Property to define the start date to activate the tour warning.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate publishStartDate;

	@ApiModelProperty(required = false, example = "30/11/2018", value = "Property to define the end date to activate the tour warning.")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate publishEndDate;

	@ApiModelProperty(required = true, example = "SC787646", value = "Property to define the school id.")
	@NotBlank
	private String schoolId;

	@ApiModelProperty(required = true, example = "2", value = "Property to define the location tour id.")
	@NotNull
	private Long locationTourId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getPaymentDeadline() {
		return paymentDeadline;
	}

	public void setPaymentDeadline(LocalDate paymentDeadline) {
		this.paymentDeadline = paymentDeadline;
	}

	public LocalDate getPublishStartDate() {
		return publishStartDate;
	}

	public void setPublishStartDate(LocalDate publishStartDate) {
		this.publishStartDate = publishStartDate;
	}

	public LocalDate getPublishEndDate() {
		return publishEndDate;
	}

	public void setPublishEndDate(LocalDate publishEndDate) {
		this.publishEndDate = publishEndDate;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public Long getLocationTourId() {
		return locationTourId;
	}

	public void setLocationTourId(Long locationTourId) {
		this.locationTourId = locationTourId;
	}

}
