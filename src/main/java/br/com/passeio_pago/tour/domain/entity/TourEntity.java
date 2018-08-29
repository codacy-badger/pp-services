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
import javax.validation.constraints.PositiveOrZero;

import br.com.passeio_pago.location_tour.domain.LocationTourPublic;
import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;
import br.com.passeio_pago.tour.domain.TourPublic;

@Entity
@Table(name = "tour")
public class TourEntity implements TourPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6681637312687054388L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tour_sequence")
	@SequenceGenerator(name = "tour_sequence", sequenceName = "tour_sequence")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "price", nullable = false)
	@PositiveOrZero
	private BigDecimal price = BigDecimal.valueOf(Double.valueOf("0.0"));

	@Column(name = "payment_deadline", nullable = true)
	private LocalDate paymentDeadline;

	@Column(name = "publish_start_date", nullable = true)
	private LocalDate publishStartDate;

	@Column(name = "publish_end_date", nullable = true)
	private LocalDate publishEndDate;

	@Column(name = "school_id", nullable = false)
	private String schoolId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_tour_id", nullable = false)
	private LocationTourEntity locationTour;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public LocalDate getPaymentDeadline() {
		return paymentDeadline;
	}

	public void setPaymentDeadline(LocalDate paymentDeadline) {
		this.paymentDeadline = paymentDeadline;
	}

	@Override
	public LocalDate getPublishStartDate() {
		return publishStartDate;
	}

	public void setPublishStartDate(LocalDate publishStartDate) {
		this.publishStartDate = publishStartDate;
	}

	@Override
	public LocalDate getPublishEndDate() {
		return publishEndDate;
	}

	public void setPublishEndDate(LocalDate publishEndDate) {
		this.publishEndDate = publishEndDate;
	}

	@Override
	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public LocationTourPublic getLocationTour() {
		return locationTour;
	}

	public void setLocationTour(LocationTourEntity locationTour) {
		this.locationTour = locationTour;
	}

}
