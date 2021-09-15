package com.example;

import org.hibernate.annotations.Immutable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Drink {

    @EmbeddedId
    private DrinkId id;

    private String name;

    public Drink() {
        this.id = DrinkId.of(UUID.randomUUID().toString());
    }

    public DrinkId getId() {
        return id;
    }

    public void setId(DrinkId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Immutable
    @Embeddable
    public static class DrinkId implements Serializable {

        private final String id;

        public DrinkId() {
            this.id = null;
        }

        private DrinkId(String id) {
            this.id = id;
        }

        public static DrinkId of(String string) {
            return new DrinkId(string);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DrinkId)) return false;
            DrinkId drinkId = (DrinkId) o;
            return Objects.equals(id, drinkId.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
