create table posts
(
    id         serial    primary key,
    content    varchar(255) not null,
    author     varchar(255) not null,
    created_at timestamp    not null
);

ALTER TABLE posts
    ADD CONSTRAINT fk_posts_author FOREIGN KEY (author) REFERENCES users (username);