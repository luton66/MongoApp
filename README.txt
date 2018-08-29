This push is essentially intending to test the possibility of using BOTH MongoRepository AND MongoTemplate for queries within the same RestController

The test that uses the MongoTemplate also uses the Query, and criteria builder to feed the query in to the MongoTemplate.

To be honest, there may never be a need to do this, as effective use of the @Query annotations should cover everything, but in case the Query builder, and
MongoTemplate is ever required, this is how you can use both in this scenario. 