package br.com.passeio_pago.qrcode.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class QrCodeCreateDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4370539015829761385L;

	public class QrCodeSize implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5094451330276551518L;

		@ApiModelProperty(required = false, example = "200", value = "Property to define the image width of QR code. Must be equals to length. Default 200.", allowableValues = "rande[10, 1000]")
		@Max(1000)
		@Min(10)
		private Integer width = 200;

		@ApiModelProperty(required = false, example = "200", value = "Property to define the image length of QR code. Must be equals to width. Default 200.", allowableValues = "rande[10, 1000]")
		@Max(1000)
		@Min(10)
		private Integer length = 200;

		public Integer getWidth() {
			return width;
		}

		public void setWidth(Integer width) {
			this.width = width;
		}

		public Integer getLength() {
			return length;
		}

		public void setLength(Integer length) {
			this.length = length;
		}

	}

	@ApiModelProperty(required = true, example = "152", value = "Property to define the QR code's data. In this case, the TOUR_ID.")
	@NotEmpty
	private String data;

	@ApiModelProperty(required = false, example = "jpeg", value = "Property to define the image's format of QR code. Default jpeg.", allowableValues = "png, gif, jpeg, jpg, svg, eps")
	private String format = "jpeg";

	@ApiModelProperty(required = false, value = "Property to define the image's size of QR code.")
	private QrCodeSize size;

	@ApiModelProperty(required = false, value = "Property to define the image's margin of QR code. Default 1.", allowableValues = "range[0, 50]")
	@Max(50)
	@PositiveOrZero
	private Integer margin = 1;

	@ApiModelProperty(required = false, value = "Thickness of a margin (='quiet zone', an area without disturbing elements to help readers locating the QR code), in modules as measuring unit.", allowableValues = "range[0, 100]")
	@Max(100)
	@PositiveOrZero
	private Integer qZone = 0;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public QrCodeSize getSize() {
		return size;
	}

	public void setSize(QrCodeSize size) {
		this.size = size;
	}

	public Integer getMargin() {
		return margin;
	}

	public void setMargin(Integer margin) {
		this.margin = margin;
	}

	public Integer getqZone() {
		return qZone;
	}

	public void setqZone(Integer qZone) {
		this.qZone = qZone;
	}

}
