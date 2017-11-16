package com.quyen.ch10.converter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

@CheckName(message = "Ten khong hop le")
public class VietnameseName {
    private String ho;
    @Size(min=5, max=60)
    private String ten;
    private String chulot;

    @Override
    public String toString() {
        return "VietnameseName{" +
                "ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", chulot='" + chulot + '\'' +
                '}';
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChulot() {
        return chulot;
    }

    public void setChulot(String chulot) {
        this.chulot = chulot;
    }

    public VietnameseName(String ho, String chulot, String ten) {

        this.ho = ho;
        this.ten = ten;
        this.chulot = chulot;
    }

    public VietnameseName() {

    }

    @AssertTrue
    public boolean isGoodName(){
        return false;
    }
}
