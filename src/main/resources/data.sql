DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS favorite_items;


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

CREATE TABLE items (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(300) NOT NULL,
    description varchar(max) NOT NULL,
    price double(11) NOT NULL,
    img varchar(300) NOT NULL,
    quantity int(11) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE favorite_items (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) NOT NULL,
    item_id int(11) NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (item_id) REFERENCES items(id),
);

INSERT INTO customers (first_name, last_name, email, phone_number, address, username, password) VALUES
    ('jeremy', 'komarov', 'jeremy@gmail.com', '0528420101', 'Ramat Gan, Israel', 'jeremy', 'q1w2e3r4'),
    ('sapir', 'zadik', 'sapir@gmail.com', '0528420101', 'Ramat Gan, Israel','sapir', 'q1w2e3r4');

INSERT INTO items (name, description, price, img, quantity) VALUES
    ('basketball', 'super basketball', 25.50, 'https://www.wilson.com/sites/default/files/EXPLORE_640X640_nba.jpg?', 25),
    ('soccer  ball', 'some kick ass brand new soccer', 10.50, 'https://t3.ftcdn.net/jpg/00/92/53/50/360_F_92535040_OeiYmHwr6lzZn5cdd71abCl67I9NsSe7.jpg?', 14),
    ('tennis ball', 'super tennis ball', 13.50, 'https://upload.wikimedia.org/wikipedia/commons/4/41/Closeup_of_a_tennis_ball_%282%29.jpg', 0),
    ('basketball', 'super basketball', 25.50, 'https://www.wilson.com/sites/default/files/EXPLORE_640X640_nba.jpg?', 25),
    ('soccer  ball', 'some kick ass brand new soccer', 10.50, 'https://t3.ftcdn.net/jpg/00/92/53/50/360_F_92535040_OeiYmHwr6lzZn5cdd71abCl67I9NsSe7.jpg?', 14),
    ('tennis ball', 'super tennis ball', 13.50, 'https://upload.wikimedia.org/wikipedia/commons/4/41/Closeup_of_a_tennis_ball_%282%29.jpg', 0),
    ('basketball', 'super basketball', 25.50, 'https://www.wilson.com/sites/default/files/EXPLORE_640X640_nba.jpg?', 25),
    ('soccer  ball', 'some kick ass brand new soccer', 10.50, 'https://t3.ftcdn.net/jpg/00/92/53/50/360_F_92535040_OeiYmHwr6lzZn5cdd71abCl67I9NsSe7.jpg?', 14),
    ('tennis ball', 'super tennis ball', 13.50, 'https://upload.wikimedia.org/wikipedia/commons/4/41/Closeup_of_a_tennis_ball_%282%29.jpg', 0);

INSERT INTO favorite_items (customer_id, item_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1);