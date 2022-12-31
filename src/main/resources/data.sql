DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS favorite_products;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_products;


CREATE TABLE customers (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(20) NOT NULL,
    last_name varchar(20) NOT NULL,
    email varchar(50) NOT NULL,
    phone_number varchar(20) NOT NULL,
    address varchar(50) NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE products (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(300) NOT NULL,
    description varchar(max) NOT NULL,
    price double(11) NOT NULL,
    img varchar(300) NOT NULL,
    quantity int(11) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE favorite_products (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) NOT NULL,
    product_id int(11) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (product_id) REFERENCES products(id),
);

create TABLE orders (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) NOT NULL,
    order_date DATE NOT NULL,
    shipping_address varchar(max) NOT NULL,
    total_products int(11) NOT NULL,
    total_price int(11) NOT NULL,
    status varchar(300) DEFAULT 'OPEN',

    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
);

create TABLE order_products (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    order_id int(11) NOT NULL,
    product_id int(11) NOT NULL,
    quantity int(11),
    price int(11),

    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id),
);

INSERT INTO customers (first_name, last_name, email, phone_number, address, username, password) VALUES
    ('jeremy', 'komarov', 'jeremy@gmail.com', '0528420101', 'Ramat Gan, Israel', 'jeremy', 'I*u7y6t5'),
    ('sapir', 'zadik', 'sapir@gmail.com', '0528420101', 'Ramat Gan, Israel','sapir', 'u7y6t5');

INSERT INTO products (name, description, price, img, quantity) VALUES
    ('basketball', 'super basketball', 25.50, 'https://www.wilson.com/sites/default/files/EXPLORE_640X640_nba.jpg?', 25),
    ('soccer  ball', 'some kick ass brand new soccer', 10.50, 'https://t3.ftcdn.net/jpg/00/92/53/50/360_F_92535040_OeiYmHwr6lzZn5cdd71abCl67I9NsSe7.jpg?', 14),
    ('tennis ball', 'super tennis ball', 13.50, 'https://upload.wikimedia.org/wikipedia/commons/4/41/Closeup_of_a_tennis_ball_%282%29.jpg', 0),
    ('basketball', 'super basketball', 25.50, 'https://www.wilson.com/sites/default/files/EXPLORE_640X640_nba.jpg?', 25),
    ('soccer  ball', 'some kick ass brand new soccer', 10.50, 'https://t3.ftcdn.net/jpg/00/92/53/50/360_F_92535040_OeiYmHwr6lzZn5cdd71abCl67I9NsSe7.jpg?', 14),
    ('tennis ball', 'super tennis ball', 13.50, 'https://upload.wikimedia.org/wikipedia/commons/4/41/Closeup_of_a_tennis_ball_%282%29.jpg', 0),
    ('basketball', 'super basketball', 25.50, 'https://www.wilson.com/sites/default/files/EXPLORE_640X640_nba.jpg?', 25),
    ('soccer  ball', 'some kick ass brand new soccer', 10.50, 'https://t3.ftcdn.net/jpg/00/92/53/50/360_F_92535040_OeiYmHwr6lzZn5cdd71abCl67I9NsSe7.jpg?', 14),
    ('tennis ball', 'super tennis ball', 13.50, 'https://upload.wikimedia.org/wikipedia/commons/4/41/Closeup_of_a_tennis_ball_%282%29.jpg', 0);

INSERT INTO favorite_products (customer_id, product_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1);