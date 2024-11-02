package model;



public class Address {
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private Double latitude;
    private Double longitude;
    private String destination;
    private String source;
    private int numA;
    

    public Address(int numA,String street, String city, String postalCode, String country, Double latitude, Double longitude) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numA=numA;
    }

    public void setPostalCode(String postalCode) {
        if (postalCode.length() == 5) {
            this.postalCode = postalCode;
        } else {
        	 System.out.println(" code postal n'est pas valide");
        }
    }

    public String getWilayaCode() {
        int code = 0; 
        if (code >= 0 && code <= 58) {
            return String.format("%02d", code);
        } else {
            return "Code invalide";
        }
    }


    @Override
    public String toString() {
        return "Adresse{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public int getnumA() {
        return numA;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}

