package com.thebookhouse.util.enums;

public enum Gender {
    FEMALE(0),
    MALE(1),
    OTHER(2);

    private int gender;

    Gender(int gender) {
        this.gender = gender;
    }
}
