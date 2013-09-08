FilterLib
=========

Filtering library which extends JPA 2 query posibilities, in similar way as Hibernates Query By Example.

About
-----

This library provides different somewhat more declarative approach for querying database data. 
Simple **POJOs** serves as basic query objects. These pojos are then parsed by this library and field values together with
optional annotations are used to construct DB queries using JPA Criteria API. This apporach can be seen as filtering 
database tables using prearanged filters. 
(Later should be provided also way for projections and construction of new objects from these results). It's also similar 
to Hibernates Query By Example mechanism.

How to use it
-------------

Main function of this library is provided by abstract class org.obozek.filterlib.AbstractFilteringRepository. So you have 
to provide some subclass extending this abstract class. 
To get you started quickly there is one suitable implementation of Generic dao - org.obozek.filterlib.dao.GenericDaoImpl 
which extends AbstractFilteringRepository. This small library is also used in few projects together with Spring Data. 
So it should integrate well with this framework. (Instructions will be provided later)





