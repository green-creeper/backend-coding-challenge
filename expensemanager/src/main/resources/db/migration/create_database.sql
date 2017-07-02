create table EXPENSE (
    ID serial primary key,
    date timestamp not null,
    amount numeric(10,2) not null,
    reason text not null
);