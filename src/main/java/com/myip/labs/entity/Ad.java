package com.myip.labs.entity;


import javax.persistence.*;

@Entity
@Table(name = "ad")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String topic;

    @Column
    private String price;

    @Column
    private String text;

    @Column
    private String telnum;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "use_id")
    private Use use;

    public Ad() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public Use getUse() {
        return use;
    }

    public void setUse(Use use) {
        this.use = use;
    }


    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", price='" + price + '\'' +
                ", text=" + text + '\'' +
                ", telnum=" + telnum + '\'' +
                ", use=" + use +
                '}';
    }
}
