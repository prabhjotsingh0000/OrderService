package com.example.prabhjot.orderservice;

public class OrderServiceModel {

    private String labName;
    private boolean isFavourite;
    private String provDiag;
    private String remarks;

    public OrderServiceModel(String labName, boolean isFavourite) {
        this.labName = labName;
        this.isFavourite = isFavourite;
    }

    public String getLabName() {
        return labName;
    }

    public boolean getIsFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        this.isFavourite = favourite;
    }

    public void setProvDiag(String provDiag) {
        this.provDiag = provDiag;
    }


    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
