package com.vrp.task_sf_simple.models;

import java.util.Objects;

public class Account {
    private String name;
    private String phone;

    public static Builder newBuilder() {
        return new Account().new Builder();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public class Builder {
        private Builder() {
        }

        public Builder name(String name) {
            Account.this.name = name;
            return this;
        }

        public Builder phone(String phone) {
            Account.this.phone = phone;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(name, account.name) && Objects.equals(phone, account.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }
}
