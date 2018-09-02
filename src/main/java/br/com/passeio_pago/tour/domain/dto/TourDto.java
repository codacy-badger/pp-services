package br.com.passeio_pago.tour.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.passeio_pago.common.util.SalaryDeserializer;
import br.com.passeio_pago.common.util.SalarySerializer;
import io.swagger.annotations.ApiModel;

@ApiModel
public class TourDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1924544611823501290L;
	private Long id;
	private String name;
	
	@JsonSerialize(using = SalarySerializer.class)
	@JsonDeserialize(using = SalaryDeserializer.class)
//	@PositiveOrZero
	private BigDecimal price;
	private LocalDate paymentDeadline;
	private LocalDate publishStartDate;
	private LocalDate publishEndDate;
	private String schoolId;
	private Long locationTourId;

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
