package com.vrp.task_sf_simple.models;

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
        private Builder() {}
        public Builder name(String name) { Account.this.name = name; return this; }
        public Builder phone(String phone) { Account.this.phone = phone; return this; }
        public Account build() {return Account.this; }
    }
}
