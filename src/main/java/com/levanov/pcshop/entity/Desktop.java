package com.levanov.pcshop.entity;

import com.levanov.pcshop.entity.type.FormFactor;

import javax.persistence.Entity;

@Entity

public class Desktop extends Product {

    private FormFactor formFactor;

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }

    public Desktop() {
    }

    public Desktop(FormFactor formFactor) {
        this.formFactor = formFactor;
    }
}
