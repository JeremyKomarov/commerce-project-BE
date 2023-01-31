DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS wish_list;
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
    view_description varchar(max) NOT NULL,
    full_description varchar(max) NOT NULL,
    price double(11) NOT NULL,
    img varchar(300) NOT NULL,
    quantity int(11) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE wish_list (
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
    order_date DATE,
    country varchar(300),
    city varchar(300),
    phone_number varchar(300),
    total_products int(11),
    total_price int(11),
    status varchar(300) DEFAULT 'OPEN',

    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
);

create TABLE order_products (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) NOT NULL,
    order_id int(11),
    product_id int(11) NOT NULL,
    quantity int(11),
    price int(11),

    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (product_id) REFERENCES products(id),
);

INSERT INTO customers (first_name, last_name, email, phone_number, address, username, password) VALUES
    ('test', 'tester', 'test@gmail.com', '054123654', 'Ramat Gan, Israel', 'test', '123456');

INSERT INTO products (name, view_description, full_description, price, img, quantity) VALUES
    ('Mitre Sabre Rugby Ball', 'The Mitre Sabre rugby ball represents amazing value for money', 'The Mitre Sabre rugby ball represents amazing value for money. This attractive rugby ball has a unique design and is suitable for rugby players of all ages and experience levels' , 25.50, 'https://www.sportsballshop.co.uk/acatalog/SabreRedWhite.jpg', 25),
    ('Rhino Cyclone Rugby Ball', 'The Rhino Cyclone rugby balls is a great quality training', 'Rhino have an amazing reputation for producing rugby balls to a high specification and the Cyclone is no different. The ball has a durable 3 dimensional grip which makes the ball last longer and is suitable for use in all weather conditions.' ,10.50, 'https://www.sportsballshop.co.uk/acatalog/CycloneSingle.jpg', 14),
    ('Baden Equalizer Basketball', 'A high quality synthetic leather match ball', 'This aesthetically pleasing basketball features the impressive ultra-grip technology which improves handling and accuracy.' , 13.50, 'https://www.sportsballshop.co.uk/acatalog/BadenEqualizer.jpg', 0),
    ('Molten BG4500 Indoor Basketball', 'The latest basketball to hit the courts', 'The new model has a completely different grip which has been applied to all of the new models rolling out over 2020/21. The BG4500 ball has a premium grade official composite leather textured surface and is available in size 6 and 7. The new style surface gives the player a far better chance to grip the ball as the surface area is 95% greater.' , 25.50, 'https://www.sportsballshop.co.uk/acatalog/BG4500.jpg', 25),
    ('Kookaburra County Club Cricket Ball', 'The Kookaburra County Club cricket ball', 'This ball has been tested for durability and has come through as very highly recommended. This cricket ball has the Kookaburra stamp of quality and is already proving popular with clubs and schools.' , 10.50, 'https://www.sportsballshop.co.uk/acatalog/KookaburraCountyClub1.jpg', 14),
    ('GM Skills Training Cricket Ball', 'New Lower Price, making this even better value', 'The Gunn & Moore Skills cricket balls have a PVC outer and contain a specially formulated core. The skills ball is designed to aid cricketers, of all ages to develop their technique, skills and confidence. The durable raised seam gives the feel of a real cricket ball but the pvc outer ensures it is safer to use.' , 13.50, 'https://www.sportsballshop.co.uk/acatalog/GMBucket2.jpg', 0),
    ('I-Pro Galaxy  Soccer', 'The I-Pro Galaxy match football is a high quality ball', 'The I-Pro Galaxy match football is a high quality ball and is the perfect ball for use in clubs and schools across the UK. The Galaxy is constructed using TPU and is fully waterproof. This hard wearing match ball is available in sizes 4 and 5.' , 25.50, 'https://www.sportsballshop.co.uk/acatalog/Galaxy1.jpg', 25),
    ('PT Rotario Match Soccer', 'The range of match footballs from Precision Training', 'The range of match footballs from Precision Training include the NEW FIFA Quality Precision Rotario match ball. This ball is available in size 5 and is one of the highest spec balls from Precision Training which has seen a further upgrade in 2020.' , 10.50, 'https://www.sportsballshop.co.uk/acatalog/Rotario20.jpg', 14),
    ('Gilbert High 5 Netball', 'The Gilbert High 5 ball is an entry level', 'The Gilbert High 5 ball is an entry level ball for children aged between 9-11 years. Only available in a size 4 and is designed for use in schools.' , 9.50, 'https://www.sportsballshop.co.uk/acatalog/GilbertHigh5NETBALL.jpg', 15),
    ('Slazenger Club Dimple Hockey Ball', 'affordable club match hockey ball, as it is very durable', 'The Slazenger Club Dimple hockey ball is designed to assist water dispertion and is ideal for use on Astro turf pitches. This ball has a hollow centre and is designed for training and matches.' , 3.49, 'https://www.sportsballshop.co.uk/acatalog/SlazengerClubDimple1.jpg', 2),
    ('Kookaburra Elite Indoor Hockey Ball', 'This indoor hockey ball is available in white, orange.', 'The Elite Indoor hockey ball is a smooth, durable indoor hockey ball that will have a positive impact on the performance of the users. The Kookaburra Elite Indoor hockey ball is designed to be used for indoor.' , 7.50, 'https://www.sportsballshop.co.uk/acatalog/KookaburraEliteIndoor1.jpg', 1),
    ('Lusum Space Marker 50 Cone Set', 'The cones measure 180mm and have a height of 50mm', 'One of the best value space marker sets available today. This Lusum Space Marker 50 Cone Set contains 5 sets of 10 coloured cones as follows.' , 8.00, 'https://www.sportsballshop.co.uk/acatalog/LusumConesMain.jpg', 5),
    ('Pro Rebounder', 'This is an excellent net and is ideal for use in various sports and training drills', 'This is the classic style of rebounder from Precision Training. It can be adjusted to alter the angle of rebound. It is made from a steel construction and the net is made from nylon which.' , 150.20, 'https://www.sportsballshop.co.uk/acatalog/ProRebounder.jpg', 13),
    ('Training Medi run-on first aid kit', 'This is our best selling sports first aid kit. The bag for this kit', 'This First aid, sports medical kit is compliant with The FA. It is an excellent value run-on bag, suitable for use by any standard of sports clubs. Comes complete with a jet spray bottle.' , 100.00, 'https://www.sportsballshop.co.uk/acatalog/PTRunOnMediaKit2019.jpg', 0),
    ('Gilbert Reversible Bib', 'so allow for structured training sessions and are available in junior and senior sizes.', 'The Gilbert Reversible bibs have been designed for use by rugby players of all levels and ages. With the lightweight, breathable construction.' , 54.00, 'https://www.sportsballshop.co.uk/acatalog/ReversibleBibsGilbert.jpg', 52),
    ('Slazenger Foam training balls', 'The ball is used extensively in clubs and schools. Each pack of 12 balls.', 'The foam ball is used extensively in clubs and schools. It is suitable for use both indoors and out. Each pack of 12 balls comes in a clear plastic bag with a drawstring.' , 24.25, 'https://www.sportsballshop.co.uk/acatalog/SlazengerFoamTraining1.jpg', 8),
    ('Ransome Tennis balls', 'Not only is this ball popular with tennis clubs but we see this ball.', 'This Tennis ball is a high quality ball that is ideal for club or school use. The Ransome tennis ball is available to buy in buckets of 96 or individually.' , 2.50, 'https://www.sportsballshop.co.uk/acatalog/SingleBall.jpg', 42),
    ('Ball Pump Buying Guide', 'However if you are having to inflate.', 'his is a question often asked and to be honest it seems very much an individual preference as to what suits them. Some people will be totally sold on the stirrup pump.' , 32.20, 'https://www.sportsballshop.co.uk/acatalog/Stirrup-Pump.jpg', 5);
