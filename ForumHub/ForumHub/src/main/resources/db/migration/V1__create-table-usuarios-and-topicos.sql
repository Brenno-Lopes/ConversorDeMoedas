create table usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(255) not null,
    email varchar(100) not null unique,


    primary key(id)

);

CREATE TABLE topicos (
    id bigint not null auto_increment,
    mensagem text not null,
    data datetime not null default current_timestamp,
    duvida_resolvida boolean default false,
    autor_id bigint not null,
    curso varchar(25) not null,
    primary key (id),
    foreign key (autor_id) references autores(id)
);