package com.sanjeeban.CoreApartmentService.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_amenities_booking", schema = "apt_core")
public class AmenitiesBooking extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "amenity_code", nullable = false, length = 20)
    private String amenityCode;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "payment_id", length = 50)
    private String paymentId;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAmenityCode() {
        return amenityCode;
    }

    public void setAmenityCode(String amenityCode) {
        this.amenityCode = amenityCode;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
}