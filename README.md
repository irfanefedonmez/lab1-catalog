# CICD1 Catalog Service

This service runs on port 8081 and manages the product catalog and inventory details.

## Endpoints

- `GET /products` - Returns all products.
- `POST /products` - Creates a new product with an existing category.
- `GET /products/min-price?price=100` - Returns products with a price greater than or equal to 100, ordered by price ascending.
- `GET /products/by-category?name=Computers` - Returns products belonging to the specified category, ordered by price ascending.

## Create Product

POST `/products`

Example request:

```json
{
  "name": "Keyboard",
  "price": 79.99,
  "categoryId": 2
}
```

The categoryId must refer to an existing category. An invalid or missing categoryId returns HTTP 400 Bad Request.

## Database

The service uses Spring Data JPA and H2.

Products have a Many-to-One relationship with Categories using the `category_id` foreign key.

JPQL is used to query products by minimum price and category name.

## Other Service

Order Service:

https://github.com/irfanefedonmez/cicd1-order-service

## Testing

API endpoints can be tested using Swagger UI:

http://localhost:8081/swagger-ui.html
