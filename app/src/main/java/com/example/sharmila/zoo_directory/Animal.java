package com.example.sharmila.zoo_directory;

import java.io.Serializable;

/**
 * Created by sharmila on 1/29/2016.
 */


    public class Animal implements Serializable {

        private static final long serialVersionUID = 1L;
        private int image;
        private String name;
        private String description;

        public Animal(){
            super();
        }

        public Animal(int icon, String title, String description){
            super();
            this.image = icon;
            this.name = title;
            this.description = description;
        }

        public int getImage() {
            return image;
        }

        public void setImaget(int icon) {
            this.image = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String title) {
            this.name = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


