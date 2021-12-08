package com.example.recyclerview5;

public class CountryPojo {
    String countryName, countryDescription;
    int countryFlags;

    public CountryPojo(String countryName, String countryDescription, int countryFlags) {
        this.countryName = countryName;
        this.countryDescription = countryDescription;
        this.countryFlags = countryFlags;
    }

    public CountryPojo(String countryName, String countryDescription) {
        this.countryName = countryName;
        this.countryDescription = countryDescription;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryDescription() {
        return countryDescription;
    }

    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

    public int getCountryFlags() {
        return countryFlags;
    }

    public void setCountryFlags(int countryFlags) {
        this.countryFlags = countryFlags;
    }
}
