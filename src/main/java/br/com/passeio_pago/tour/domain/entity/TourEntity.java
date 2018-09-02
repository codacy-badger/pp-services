package br.com.passeio_pago.tour.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;

@Entity
@Table(name = "tour")
public class TourEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tour_sequence")
	@SequenceGenerator(name = "tour_sequence", sequenceName = "tour_sequence")
	private Long id;

	@Column(name = "name", nullable = false, length=400)
	private String name;

	@Column(name = "price", nullable = false)
	private BigDecimal price = BigDecimal.valueOf(Double.valueOf("0.0"));

	@Column(name = "payment_deadline", nullable = true)
	private LocalDate paymentDeadline;

	@Column(name = "publish_start_date", nullable = true)
	private LocalDate publishStartDate;

	@Column(name = "publish_end_date", nullable = true)
	private LocalDate publishEndDate;

	@Column(name = "school_id", nullable = false, length=100)
	private String schoolId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_tour_id", nullable = false)
	private LocationTourEntity locationTour;

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

	public LocationTourEntity getLocationTour() {
		return locationTour;
	}

	public void setLocationTour(LocationTourEntity locationTour) {
		this.locationTour = locationTour;
	}

}
