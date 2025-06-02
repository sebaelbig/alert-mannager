package com.recondo.lookup.dto;

import java.util.Date;

public class DateDTO {
    private String datePeriodQlfr;
    private String datePeriodQlfrDesc;
    private Long startDate;
    private Long endDate;

    private Date startDateAsDate;
    private Date endDateAsDate;

    public Date getStartDateAsDate() {
        return startDateAsDate;
    }

    public void setStartDateAsDate(Date startDateAsDate) {
        this.startDateAsDate = startDateAsDate;
    }

    public Date getEndDateAsDate() {
        return endDateAsDate;
    }

    public void setEndDateAsDate(Date endDateAsDate) {
        this.endDateAsDate = endDateAsDate;
    }

    public String getDatePeriodQlfr() {
        return datePeriodQlfr;
    }

    public void setDatePeriodQlfr(String datePeriodQlfr) {
        this.datePeriodQlfr = datePeriodQlfr;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }
}