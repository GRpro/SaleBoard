package com.saleboard.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    private float price;

    private boolean paid;

    @ManyToOne(cascade = CascadeType.ALL)
    private Board board;

    @ManyToOne(cascade = CascadeType.ALL)
    private Sail sail;

    @ManyToOne(cascade = CascadeType.ALL)
    private Trainer trainer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tariff tariff;

    @Temporal(TemporalType.DATE)
    private Date orderingDate;

    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date startPoint;

    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date endPoint;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Date endPoint) {
        this.endPoint = endPoint;
    }

    public Date getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Date startPoint) {
        this.startPoint = startPoint;
    }

    public Date getOrderingDate() {
        return orderingDate;
    }

    public void setOrderingDate(Date orderingDate) {
        this.orderingDate = orderingDate;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Sail getSail() {
        return sail;
    }

    public void setSail(Sail sail) {
        this.sail = sail;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean isPaid) {
        this.paid = isPaid;
    }


    @Override
    public String toString() {
        return "Ordering{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", price=" + price +
                ", paid=" + paid +
                ", board=" + board +
                ", sail=" + sail +
                ", trainer=" + trainer +
                ", tariff=" + tariff +
                ", orderingDate=" + orderingDate +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }


}
