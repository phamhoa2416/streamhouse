CREATE TABLE IF NOT EXISTS categories
(
    category_id        VARCHAR(20) PRIMARY KEY,
    name               VARCHAR(100) NOT NULL,
    description        TEXT,
    is_active          BOOLEAN                  DEFAULT true,
    created_at         TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at         TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO categories (category_id, name, description)
VALUES ('ELEC', 'Electronics', 'Electronic devices and accessories'),
       ('CLOTH', 'Clothing', 'Apparel and fashion items'),
       ('BOOK', 'Books', 'Books and publications'),
       ('HOME', 'Home & Garden', 'Home improvement and garden supplies'),
       ('SPORT', 'Sports & Outdoors', 'Sports equipment and outdoor gear'),
       ('BEAUTY', 'Beauty & Health', 'Beauty products and health supplies'),
       ('TOY', 'Toys & Games', 'Toys, games, and entertainment'),
       ('AUTO', 'Automotive', 'Automotive parts and accessories'),
       ('BABY', 'Baby & Kids', 'Baby products and children''s items'),
       ('PET', 'Pet Supplies', 'Pet food, toys, and accessories'),
       ('JEWL', 'Jewelry', 'Fine jewelry and watches'),
       ('TOOLS', 'Tools & Hardware', 'Tools and hardware supplies'),
       ('OFFICE', 'Office Supplies', 'Office equipment and supplies'),
       ('FOOD', 'Food & Beverages', 'Food and beverage products'),
       ('FURN', 'Furniture', 'Home and office furniture'),
       ('MUSIC', 'Music & Instruments', 'Musical instruments and equipment'),
       ('ART', 'Art & Crafts', 'Art supplies and craft materials'),
       ('TRAVEL', 'Luggage & Travel', 'Luggage and travel accessories'),
       ('PHONE', 'Phones & Accessories', 'Mobile phones and accessories'),
       ('COMP', 'Computers', 'Computers, laptops, and accessories');
