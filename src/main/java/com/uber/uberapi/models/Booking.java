package com.uber.uberapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking extends Auditable{
    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private Driver driver;
    @Enumerated(value = EnumType.STRING)
    private BookingType bookingType;
    @OneToOne
    private Review reviewByUser;
    @OneToOne
    private Review reviewByDriver;

    private Long totalDistanceMeters;

    @OneToOne
    private PaymentReceipt paymentReceipt;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToMany
    private List<ExactLocation> route = new ArrayList<>();
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;
    @OneToOne
    private OTP rideStartOTP;
}
