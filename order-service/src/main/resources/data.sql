INSERT INTO item (item_name, item_description, item_status, ITEM_AVAILABLE_COUNT, item_amount, created_by, LAST_MODIFIED_BY, VERSION) VALUES
  ('Iphone', 'Apple Iphone 13 Pro 128 GB', 'NOT_SOLD', 10, 125000, 'ADMIN', 'ADMIN', 0),
  ('Iphone', 'Apple Iphone 12 Pro 128 GB', 'NOT_SOLD', 10, 85000, 'ADMIN', 'ADMIN', 0),
  ('Ipad', 'Apple Ipad 128 GB', 'NOT_SOLD', 10, 125000, 'ADMIN', 'ADMIN', 0);

INSERT INTO user (first_name, last_name, email) VALUES
  ('Lokesh', 'Gupta', 'abc@gmail.com'),
  ('Deja', 'Vu', 'xyz@email.com'),
  ('Caption', 'America', 'cap@marvel.com');

INSERT INTO cart (cart_status, cart_amount, USER_ID) VALUES
  ('NOT_PURCHASED', 500, 1),
  ('NOT_PURCHASED', 200, 2),
  ('NOT_PURCHASED', 1000, 3);

INSERT INTO cart_item (CART_ID, ITEM_ID) VALUES
  (1, 2),
  (2, 1),
  (3, 3);