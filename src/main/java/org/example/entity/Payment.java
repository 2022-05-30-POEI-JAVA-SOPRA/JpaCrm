package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private String confidentialCode;
    private String bank;

//    Customer


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getConfidentialCode() {
        return confidentialCode;
    }

    public void setConfidentialCode(String confidentialCode) {
        this.confidentialCode = confidentialCode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setNotNullData(Payment data) {
        if(data.getCardNumber() !=null){
            this.setCardNumber(data.getCardNumber());
        }
        if(data.getConfidentialCode() !=null){
            this.setConfidentialCode(data.getConfidentialCode());
        }
        if(data.getBank() !=null){
            this.setBank(data.getBank());
        }
    }
}
