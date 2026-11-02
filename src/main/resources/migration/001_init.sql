CREATE TABLE IF NOT EXISTS manufacturers (id BIGSERIAL PRIMARY KEY,name VARCHAR(255) NOT NULL,country VARCHAR(255));
CREATE TABLE IF NOT EXISTS products (id BIGSERIAL PRIMARY KEY,name VARCHAR(255) NOT NULL,price NUMERIC(12,2) NOT NULL CHECK(price>=0),manufacturer_id BIGINT NOT NULL REFERENCES manufacturers(id) ON DELETE RESTRICT);
INSERT INTO manufacturers(name,country) SELECT 'Samsung','Южная Корея' WHERE NOT EXISTS(SELECT 1 FROM manufacturers WHERE name='Samsung');
INSERT INTO manufacturers(name,country) SELECT 'Sony','Япония' WHERE NOT EXISTS(SELECT 1 FROM manufacturers WHERE name='Sony');
INSERT INTO products(name,price,manufacturer_id) SELECT 'Монитор',19990,id FROM manufacturers WHERE name='Samsung' AND NOT EXISTS(SELECT 1 FROM products WHERE name='Монитор');
INSERT INTO products(name,price,manufacturer_id) SELECT 'Наушники',4990,id FROM manufacturers WHERE name='Sony' AND NOT EXISTS(SELECT 1 FROM products WHERE name='Наушники');
