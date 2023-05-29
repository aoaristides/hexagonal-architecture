-- CREATE MONEY TRANSFER TABLE
DROP TABLE IF EXISTS money_transfers;

CREATE TABLE IF NOT EXISTS money_transfers
(
    id                     UUID NOT NULL,
    sender_account_id      VARCHAR(250) NOT NULL,
    receiver_account_id    VARCHAR(250) NOT NULL,
    amount  	           NUMERIC(38,2) NOT NULL,
    result                 VARCHAR(100) NOT NULL,
    detail                 VARCHAR(300),
    created_at             TIMESTAMP WITH TIME ZONE NOT NULL,
    PRIMARY KEY            (id)
);