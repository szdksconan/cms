package com.cms.model.manager;


import java.io.Serializable;




public class comboBean implements Serializable{
	 	/**
	 * 
	 */
        private static final long serialVersionUID = 1L;

		private Long id;

	    private String vaservicetype;

	    private String vaservicetypename;

	    private String vaservicename;

	    private Double price;

	    private Integer measureperiod;

	    private String measurementunit;

	    private Integer measureamount;

	    private Double marketprice;

	    private Integer deductionamount;

	    private String stauts;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getVaservicetype() {
	        return vaservicetype;
	    }

	    public void setVaservicetype(String vaservicetype) {
	        this.vaservicetype = vaservicetype == null ? null : vaservicetype.trim();
	    }

	    public String getVaservicetypename() {
	        return vaservicetypename;
	    }

	    public void setVaservicetypename(String vaservicetypename) {
	        this.vaservicetypename = vaservicetypename == null ? null : vaservicetypename.trim();
	    }

	    public String getVaservicename() {
	        return vaservicename;
	    }

	    public void setVaservicename(String vaservicename) {
	        this.vaservicename = vaservicename == null ? null : vaservicename.trim();
	    }

	    public Double getPrice() {
	        return price;
	    }

	    public void setPrice(Double price) {
	        this.price = price;
	    }

	    public Integer getMeasureperiod() {
	        return measureperiod;
	    }

	    public void setMeasureperiod(Integer measureperiod) {
	        this.measureperiod = measureperiod;
	    }

	    public String getMeasurementunit() {
	        return measurementunit;
	    }

	    public void setMeasurementunit(String measurementunit) {
	        this.measurementunit = measurementunit == null ? null : measurementunit.trim();
	    }

	    public Integer getMeasureamount() {
	        return measureamount;
	    }

	    public void setMeasureamount(Integer measureamount) {
	        this.measureamount = measureamount;
	    }

	    public Double getMarketprice() {
	        return marketprice;
	    }

	    public void setMarketprice(Double marketprice) {
	        this.marketprice = marketprice;
	    }

	    public Integer getDeductionamount() {
	        return deductionamount;
	    }

	    public void setDeductionamount(Integer deductionamount) {
	        this.deductionamount = deductionamount;
	    }

	    public String getStauts() {
	        return stauts;
	    }

	    public void setStauts(String stauts) {
	        this.stauts = stauts == null ? null : stauts.trim();
	    }
}