# Case Study

## Description
XYZ is an e-commerce web application for a clothing retailer. A user is able to browse products, sign up for an account, log in to his/her account, add items to a shopping bag, and checkout.


## Table of Contents
1. [User-Stories](#User-Stories)
2. [Challenges](#Challenges)
3. [Tech Stack](#Tech-Stack)
4. [Credits](#Credits)
5. [Demo](#Demo-Images)

## User-Stories
* As a user who is not logged in, I can browse all products of all types
* As a user who is not logged in, I can view the details of a specific product
* As a user who is not logged in, I can view the images of a specific product
* As a user who is not logged in, I can view different style of a product if applicable
* As a user who is not logged in, I can view all the sizes of a product
* As a user who is not logged in, I can register for an account
* As a user who is logged in, I can add an item to my shopping bag
* As a user who is logged in, I can check out my shopping bag
* As a user who is logged in, I can update the quantity of an item in my shopping bag
* As a user who is logged in, I can remove an item from my shopping bag

## Challenges
* Implementing Composite Key with JPA - A composite(compound) key is an identifier that is uses two or more columns. Two of the tables in my database did not logically require any numerical key. Instead, they relied on the combinations of two separate foreign keys. To implement such a feature in JPA, two solutions exists. I could implement a surrogate key to fulfill the id column requirement. But, my solution used the @EmbeddedId annotation to specify a primary key object in addition to a field specifying a mapping. I was able to fetch any record in the database using the composite key rather than a single id field.
* Determining if a User is Already Logged In - To verify if my user has already logged in, I needed to keep track of their session. With Passport.js, the convention is to store the user's sessionId in a database and verify the user's sessionId every time a request is sent. With Spring MVC and Apache Tomcat, I learned that the HTTPSession stores attributes in memory by default. I also had to set a cookie containing the sessionId to enforce authentication.

## Tech-Stack
* Spring MVC
* Eclipselink
* Axios
* Bcrypt
* AWS S3 Buckets
* MySQL
* Bootstrap
* jQuery
* Maven
* JSP
* Apache Tomcat

## Credits
Product images rights belong to Neiman Marcus.

## Demo-Images

<details>
<summary>Schema Diagram</summary>
<br>

![](demo/erd.png)
</details>

<details>
<summary>Index</summary>
<br>

![](demo/index.png)
</details>

<details>
<summary>Products</summary>
<br>

![](demo/products.png)
</details>

<details>
<summary>Product</summary>
<br>

![](demo/product.png)
</details>

<details>
<summary>Bag</summary>
<br>

![](demo/bag.png)
</details>

<details>
<summary>Account</summary>
<br>

![](demo/account.png)
</details>

<details>
<summary>Checkout</summary>
<br>

![](demo/checkout.png)
</details>