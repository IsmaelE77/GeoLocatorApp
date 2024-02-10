-- Create the address table
CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(100),
    county VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    postalcode VARCHAR(20),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_address_search ON address (street, city, county, state, country, postalcode);
