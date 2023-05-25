CREATE TABLE products
(
    id              UUID NOT NULL,
    sku             VARCHAR(255) NOT NULL,
    name            VARCHAR(255) NOT NULL,
    price           NUMERIC(38,2) NOT NULL,
    quantity        NUMERIC(38,2) NOT NULL,
    PRIMARY KEY     (id)
);