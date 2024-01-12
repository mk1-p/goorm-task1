

create table if not exists board
(
    board_id   bigserial
    primary key,
    created_at timestamp(6),
    updated_at timestamp(6),
    title      varchar(20)  not null,
    content    varchar(255) not null
    );

alter table board owner to ${POSTGRES_USER};