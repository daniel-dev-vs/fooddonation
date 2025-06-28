CREATE TABLE IF NOT EXISTS `packet` (
  id bigint AUTO_INCREMENT primary key,
  volunteer varchar(255) not null,
  donor varchar(255) not null,
  type varchar(255) not null,
  created_at timestamp
);

CREATE TABLE IF NOT EXISTS `product` (
  id bigint AUTO_INCREMENT primary key,
  name varchar(255) not null,
  unity varchar(255) not null,
  type_unity varchar(255) not null,
  created_at timestamp
);

CREATE TABLE IF NOT EXISTS `packet_product` (
  packet_id bigint not null,
  product_id bigint not null,
  PRIMARY KEY (packet_id, product_id),

  -- Define as chaves estrangeiras que ligam às tabelas principais
  FOREIGN KEY (packet_id) REFERENCES packet(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS `stock` (
  id bigint AUTO_INCREMENT primary key,
  id_product bigint not null,
  quantity bigint not null

);

