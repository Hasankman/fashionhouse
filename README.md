# FashionHouse Application

By Hasan Esat Kayman 

# Introduction

  I have created a Fashion House of BackEnd system, created using Java Spring Boot, PostMan and MySQL. My project will be futher developed and linked to front end to fully function for user interaction and the transfer of data from the the database of products and meet the  needs of the Fashion House. I have created varios Crud operations like (Create, Read, Update, Delete and read by a certain statment like Name or Id or Size) the operations will help us understand how the front end will comunicate with our database and how certian operations would work. i have created two tabels as a start which will be futher developed by adding customers and a size tabel when we take our business global. This READ ME file is a breife intorduction of my project and how my project is functioning so far.
  
# Features of my Fashion House Project
  
  * Creating new products and product categories 
  * Updating products and product categories
  * Deleting products and product categories
  * Viewing products by Id
  * Viewing products by Name 
  * Viewing products by Size
  * Viewing products by Colour
  * Viewing products catageory by Id
  * Viewing products catageory by Name

 # Tools Used:
  
  To create this project i have used the following tools to run my application.
  
  * The STS IDE made managing imports, debugging my code and refactoring substantially easier.
  * We used Maven to manage most of the dependancies of my application.
  * We used Junit to run our Tests.
  * We used MySQL workbench to create a local database.
  * We used Postman to test the back end funcuality of my application without using a front end.
  
  
  
 # Fashion House Structure:
  
  * I have created a folder structure that will sperate the document depnding on their uses so all repositorys will be in one package and all controllers     will be in a single package. 
  
<p align="center">
	        <img src="images/Folder Structure.png" width="410">
</p> 

<p align="center">
	        <img src="images/Folder and Class Structure.png" width="410">
</p> 

<p align="center">
	        <img src="images/Folder and Class Structure 2.png" width="410">
</p> 
  
  
  
  
# Entity Relationships
  
  I have illustrated below an ERD diagram showing the relationship between the tabels.
  
<p align="center">
	        <img src="images/ERD diagram .png" width="410">
</p> 
  
# Product Category:
        
        
* Add Product Category

We could use crud operations to add a product category for new future markets like makeup line.

<p align="center">
	        <img src="images/addProdCat.png" width="1180">
</p> 

* View all Product Categorys

We could use crud to view all our product categorys with all the products which are in the form of a list and its details.
        
<p align="center">
	        <img src="images/allProdCat.png" width="1180">
</p> 
        
* Update Product Category

We could up date our product Categorys depending how we would like to develop our code for futre developments.
        
<p align="center">
	        <img src="images/updateProductCat.png" width="1180">
</p> 
        
* Delete a Product Category 

We could delete a Product Category depending on what we changes we would like to make to our systems.
        
<p align="center">
	        <img src="images/deleteProductCat.png" width="1180">
</p> 
        
* View Product Category By Id

We could view our Product Categorys using Product Category Id's which will show us Product Categorys and products.
        
<p align="center">
	        <img src="images/viewByProdCatId.png" width="1180">
</p> 
        
*View Product Category By Name
	
We could also view Product Categorys by the given names like Dress or Tops which could be easier to remember then Product Category Id it will out           put the same response as Product Category By Id.

<p align="center">
	        <img src="images/viewByProdCatDesc.png" width="1180">
</p>
  
# Products:
  
        
* Add Product 

We could use crud operations to add a product for to our systems.

<p align="center">
	        <img src="images/addProducts.png" width="1180">
</p>

* View all Product 

We could use our product with all the List of product which are in the form of a list and its details.

<p align="center">
	        <img src="images/allProducts.png" width="1180">
</p>

* Update Product 

We could update our Products depending on the changes we would like to make like quantity or price.

<p align="center">
	        <img src="images/updateProduct.png" width="1180">
</p>
       
* Delete a Product  

We could also delete a Product if there is no need or if a mistake has been made.

<p align="center">
	        <img src="images/deleteProduct.png" width="1180">
</p>
        
* View Product By Id

we could view a product by the Product Id 

<p align="center">
	        <img src="images/ViewByProductId.png" width="1180">
</p>
        
* View Product By Name

We could view Products by its name which gives us the advantage of viewing it in diffrent sizes that are available

<p align="center">
	        <img src="images/viewByProductName.png" width="1180">
</p>
        
* View Product By Size

We could view a Products by the Size that are available which will show us the every product in the requested size.

<p align="center">
	        <img src="images/viewByProductSize.png" width="1180">
</p>

* View Product By Colour

We could view our products by its Colour which will display every product in that colour.
  
<p align="center">
	        <img src="images/viewByProductColour.png" width="1180">
</p>  
  
# Application Tests :
  
  I have test my applications and they have failed however i am going to develop it futher to make sure it is working and all tests pass i need to figure   out how the relation 
  
 
<p align="center">
	        <img src="images/Fashion House Application.png" width="1180">
</p>  

<p align="center">
	        <img src="images/ProductTest.png" width="1180">
</p>  

<p align="center">
	        <img src="images/ProductControllerTest.png" width="1180">
</p>  
        
