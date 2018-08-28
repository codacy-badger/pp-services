package br.com.passeio_pago.tour.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Registration form for a new Role.
 */
@ApiModel
public class TourRegistrationDto {

	@ApiModelProperty(required = true, example = "Hopi Hari", value = "Property to define tour's name. For example, Praia, Museu do Ipiranga.")
	@NotBlank
	private String name;

	@ApiModelProperty(required = true, example = "danilo@email.com", value = "Property to define account's email login.")
	@NotBlank
	@Email
	private BigDecimal price;

	@ApiModelProperty(required = false, example = "psw123", value = "Property to define account's password.")
	@NotBlank
	private LocalDate paymentDeadline;

	@ApiModelProperty(required = false, example = "psw123", value = "Property to validate the password.")
	@NotBlank
	private LocalDate publishStartDate;

	@ApiModelProperty(required = false, example = "9993033828", value = "Property to define user's contact.")
	private LocalDate publishEndDate;

	@ApiModelProperty(required = true, example = "2", value = "Property to define account's role. For example, 1 = parent, 2 = teacher or 3 = both.")
	@NotNull
	private String schoolId;

	@ApiModelProperty(required = true, example = "2", value = "Property to define account's role. For example, 1 = parent, 2 = teacher or 3 = both.")
	@NotNull
	private LocationTourEntity locationTour;

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

	public LocationTourEntity getLocationTour() {
		return locationTour;
	}

	public void setLocationTour(LocationTourEntity locationTour) {
		this.locationTour = locationTour;
	}

}
