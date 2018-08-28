package br.com.passeio_pago.tour.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.passeio_pago.location_tour.domain.entity.LocationTourEntity;
import br.com.passeio_pago.tour.domain.TourPublic;
import io.swagger.annotations.ApiModel;

/**
 * Returns Role public information from the Rest controller.
 */
@ApiModel
public class TourPublicDto implements TourPublic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3304698195608256621L;
	private Long id;
	private String name;
	private BigDecimal price = BigDecimal.valueOf(Double.valueOf("0.0"));
	private LocalDate paymentDeadline;
	private LocalDate publishStartDate;
	private LocalDate publishEndDate;
	private String schoolId;
	private LocationTourEntity locationTour;

	public TourPublicDto() {
		super();
	}

	public TourPublicDto(TourPublic tour) {
		this(tour.getId(), tour.getName(), tour.getPrice(), tour.getPaymentDeadline(), tour.getPublishStartDate(), tour.getPublishEndDate(), tour.getSchoolId(), tour.getLocationTour());
	}

	public TourPublicDto(Long id, String name, BigDecimal price, LocalDate paymentDeadline, LocalDate publishStartDate, LocalDate publishEndDate, String schoolId, LocationTourEntity locationTour) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.paymentDeadline = paymentDeadline;
		this.publishStartDate = publishStartDate;
		this.publishEndDate = publishEndDate;
		this.schoolId = schoolId;
		this.locationTour = locationTour;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public BigDecimal getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public LocalDate getPaymentDeadline() {
		// TODO Auto-generated method stub
		return paymentDeadline;
	}

	@Override
	public LocalDate getPublishStartDate() {
		// TODO Auto-generated method stub
		return publishStartDate;
	}

	@Override
	public LocalDate getPublishEndDate() {
		// TODO Auto-generated method stub
		return publishEndDate;
	}

	@Override
	public String getSchoolId() {
		// TODO Auto-generated method stub
		return schoolId;
	}

	@Override
	public LocationTourEntity getLocationTour() {
		// TODO Auto-generated method stub
		return locationTour;
	}

}
