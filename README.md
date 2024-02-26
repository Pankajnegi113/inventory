
**Develop a Product Inventory API using Spring Boot, Kubernetes, REST API, and Mongo DB. The goal is to create a scalable and performant API for managing product inventory.**
```
Requirements:
1.Microservice Setup: Create a single Spring Boot microservice that serves as a Product Inventory API.
2.Kubernetes Deployment: Deploy the microservice on Kubernetes to ensure scalability and fault tolerance. Implement resource management and auto-scaling.
3.RESTful API: Develop a RESTful API that allows users to perform the following operations on the product inventory:
   o Create a new product with details like name, description, price, and quantity.
   o Retrieve product information by ID.
   o Update product details, including price and quantity.
   o Delete a product by ID.
   o List all products with pagination support (page number and page size).
   o Filter products based on their status (e.g., 'available,' 'out of stock').
4.OpenAPI Specification: Generate and provide an OpenAPI specification (e.g., Swagger) for the API, describing endpoints and data models.
5.Security: 
  o Initially, the ideal approach is to implement OAuth 2.0 Client Credential flow with JWT for securing the API. However, considering the potential unavailability of the Authorization Server during development, please implement Basic Authentication as a fallback mechanism to secure the API. 
  o If you are implementing only basic Authentication, please provide clear documentation and highlight the sections of the code that would require modification if switching from Basic Authentication to OAuth JWT authentication in the future

```



**Swagger URL** - http://localhost:{kubernateClusterPort}/swagger-ui/index.html

**Inital SAMPLE API DATA** <br>
POST User - roles can be ROLE_ADMIN/ROLE_USER
```json
{
    "name”:”pankaj",
    "email":"p@gmail.com",
    "password":"pankaj123",
    "roles":"ROLE_ADMIN"
}
```

POST Product
```json
{
  "name": "pen",
  "description": "pen boxes",
  "price": 200,
  "quantity": 1000,
  "status": "available"
}
```

->**docker pull mongo**   
<br/> 
-> **docker build -t inventory:1.0 .**
<br/>

->**minikube start**
<br/>
-> **eval $(minikube docker-env)**    : To sync minikube and docker run command locally 
<br/>


We need two files one DeploymentObject(# of instances) and ServiceObject(load balanced, url for outer world) ->both are merged into single deployment.yaml file <br/>
**kubectl apply -f deployment.yaml** <br/>
**kubectl get deployment** <br/>
**kubectl get pods** <br/>



**kubectl apply -f service.yaml** <br/>
**Kubectl get service** <br/>

**minikube service inventory-service --url**      -> Gives url where our app can be access to eg. http://127.0.0.1:59291 <br/>
**minikube dashboard** -> we can scale up or down number of pods <br/>









