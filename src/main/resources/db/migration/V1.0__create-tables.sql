set search_path = @project.artifactId@;

CREATE TABLE category
(
    id           BIGINT            NOT NULL,
    name         VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE pet
(
    id           BIGINT            NOT NULL,
    category_id  BIGINT            NOT NULL,
    name         VARCHAR(255),
    status       VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE tag
(
    id           BIGINT            NOT NULL,
    name         VARCHAR(255),
    pet_id       BIGINT            NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pet_id) REFERENCES pet (id)
);

CREATE TABLE pet_photo_urls
(
    pet_id       BIGINT            NOT NULL,
    photos       VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES pet (id)
);