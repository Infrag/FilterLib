FilterLib
=========

Filtering library which extends JPA 2 query posibilities, in similar way as Hibernates Query By Example.

About
-----

FilterLib provides different somewhat more declarative approach for querying database data. 
Simple **POJOs** serves as basic query objects. These pojos are parsed by this library and field values together with
optional annotations are used to construct DB queries using JPA Criteria API. This apporach can be seen as filtering 
database tables using prearanged filters. 
(Later should be provided also way for projections and construction of new objects from these results). It's also similar 
to Hibernates Query By Example mechanism.

How to use it
-------------

Main function of this library is provided by abstract class `org.obozek.filterlib.AbstractFilteringRepository` and its `filter()` 
method. So you have to provide some subclass extending this abstract class. 
To get you started quickly there is one suitable implementation of Generic dao - `org.obozek.filterlib.dao.GenericDaoImpl` 
which extends `AbstractFilteringRepository`. This small library is also used in few projects together with [Spring Data](http://www.springsource.org/spring-data). 
So it should integrate well with this framework. (Instructions will be provided later)

So lets start with simple example which will outline basic usage of this library. Lets have table called `Customer`. 
This table has few attributes and also two one-to-many associations to `Payment` and `Order` tables. See below:

    +---------------------+         +-------------------------------+           +------------------------+
    |       Payment       |         |           Customer            |           |         Order          |
    +---------------------+         +-------------------------------+           +------------------------+
    |PaymentPK paymentPK; |         |Integer customerNumber;        |           |Integer orderNumber;    |
    |Date paymentDate;    |0------->|String customerName;           |<---------0|Date orderDate;         |
    |Double amount;       |         |String contactLastname;        |           |Date requiredDate;      |
    |Customer customer;   |         |String contactFirstname;       |           |Date shippedDate;       |
    +---------------------+         |String phone;                  |           |String status;          |
                                    |String addressLine1;           |           |String comments;        |
                                    |String addressLine2;           |           |Customer customerNumber;|     
                                    |String city;                   |           +------------------------+
                                    |String state;                  |           
                                    |String postalCode;             |
                                    |String country;                |
                                    |Integer salesrepEmployeeNumber;|
                                    |Double creditLimit;            |
                                    |List<Payment> paymentList;     |
                                    |List<Order> orderList;         |
                                    +-------------------------------+

Corresponding entity classes are located in test directory in package `org.obozek.filterlib.test.entities`.

Lets say we want to query `Customer` entities by `customerNumber`. All we need to have is some kind of POJO object 
which contains field named <i>cutomerNumeber</i> of comparable type. All the other fields present in this POJO filter 
have to be `null`(or annotated with special annotation more later). Otherwise the they would be also processed 
by FilterLib. So we can eg use empty `Customer` object with only `customerNumber` field filled, or we can create 
special filtering object just for querying our `Customer` entities. Then simply 

