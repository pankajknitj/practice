package main.streamExample.model;

import java.util.List;

public class Address {
    String cityName;
    List<String> villages;

    public Address(String cityName, List<String> villages) {
        this.cityName = cityName;
        this.villages = villages;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<String> getVillages() {
        return villages;
    }

    public void setVillages(List<String> villages) {
        this.villages = villages;
    }
}
