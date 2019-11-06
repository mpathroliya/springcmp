package com.example1.demo1.models;

public class Exhibit {

        private String UserName; 
        private String City;
        private int Phone;
        private String Curator;

        public String getUserName() {
                return UserName;
        }

        public void setUserName(String userName) {
                UserName = userName;
        }

        public String getCity() {
                return City;
        }

        public void setCity(String city) {
                City = city;
        }

        public String getCurator() {
                return Curator;
        }

        public void setCurator(String curator) {
                Curator = curator;
        }

        public int getPhone() {
                return Phone;
        }

        public void setPhone(int phone) {
                Phone = phone;
        }

       
}