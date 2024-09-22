# Spring Transaction Managment


**@Transactionl:** 
- The @Transactional annotaionIs is used to mark a method or a class as transactional ```(method annotation ovrrides class annotation)```, meaning that any database operations performed within the marked method or class will be executed within a transaction. If the transaction is successful, the changes will be committed to the database. If an error occurs and the transaction is rolled back, the changes will not be persisted in the database.

## 1- Rollback Mechanism:
- By Default it rollsback if the thrown Exception is RuntimeException not check Exception.
- To ignore the default configurations use ```@Transactional(noRollbackFor = RuntimeException.class)```
- To make it rollback if certain exception is thrown use ```@Transactional(rollbackFor = Exception.class)```
> **NOTE:** In order to rollback mechanism works, exception should be propagated outside the method. which means if u used silent Exception (try & catch) it will not works.

___

## 2- Propagation Levels:


- **REQUIRED** (default): ```@Transactional(propagation = Propagation.REQUIRED)```

```
@Transactional
public void addUsers() { //transaction will be created here
  userRepo.addUser();
}  //transaction will be committed here
```
```
@Transactional
public void addUser() {
  String sql = "INSERT INTO ... VALUSE ...";
  jdbcTemplate.update(sql);
}
```
> **REQUIRED** means if method doesn't receive a transaction, it will create one. But if it receive a transaction it will use it. which means method 1 ```addUsers()``` will create a transaction and method 2 ```addUser()``` will use the same transaction.

___

- **REQUIRES_NEW:** ```@Transactional(propagation = Propagation.REQUIRES_NEW)```

```
@Transactional
public void addUsers() { //transaction T1 is created
  userRepo.addUser();
}  //transaction T1 is committed
```
```
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void addUser() { //transaction T1 is paused, then transaction T2 is created
  String sql = "INSERT INTO ... VALUSE ...";
  jdbcTemplate.update(sql);
} //transaction T2 is committed, then T1 is resumed
```
> **REQUIRES_NEW** means even if there is a transaction you always have to create a new separate one. which means method 1 ```addUsers()``` will create a transaction and when enter to method 2 ```addUser()``` it will be paused and new transaction will be created and committed at the end of ```method2()``` then transaction of ```method1()``` will be resumed.

___

- **NOT_SUPPORTED** ```@Transactional(propagation = Propagation.NOT_SUPPORTED)```
> **NOT_SUPPORTED** means don't apply transactional on this method. can be used when you annotate class with @Transactional and want to        exclude some methods. So you can mark them with NOT_SUPPORTED propagation.

___
   
- **SUPPORTES** ```@Transactional(propagation = Propagation.SUPPORTES)```
>**SUPPORTES** means method can be called with or without transaction (inhert parent status).

___

- **MANDATORY:** ```@Transactional(propagation = Propagation.MANDATORY)```

```
@Transactional(propagation = Propagation.NOT_SUPPORTED) //transaction will be ignored
public void addUsers() {
  userRepo.addUser();
}
```
```
@Transactional(propagation = Propagation.MANDATORY)
public void addUser() {
  String sql = "INSERT INTO ... VALUSE ...";
  jdbcTemplate.update(sql);
} 
```
> **MANDATORY** means method should be called from a transactional context only. If there is a transaction use it otherwise execution will fail. like in the previous example.

___

- **NEVER:** ```@Transactional(propagation = Propagation.NEVER)```

```
@Transactional
public void addUsers() {
  userRepo.addUser();
}
```
```
@Transactional(propagation = Propagation.NEVER)
public void addUser() {
  String sql = "INSERT INTO ... VALUSE ...";
  jdbcTemplate.update(sql);
}
```
> **NEVER** the opposite of ```MANDATORY```. which means this method can't be called from transaction context otherwise execution will fail. like in the previous example.

___

## 3- Isolation Levels:


- **Read Uncommitted:** ```@Transactional(isolation = Isolation.READ_UNCOMMITTED)```
> (cause the problem of dirty read)
No isolation, any change from the outside transaction will be visible to the transaction Change will be visible irrespective of the values committed / not committed
 
- **Read Committed:** ```@Transactional(isolation = Isolation.READ_COMMITTED)```
> (solves the problem of dirty read but cause non-repetable read probleam)
The ongoing trasactiononly can sees the committed changes of another transactions

- **Repatable Read:** ```@Transactional(isolation = Isolation.REPATABLE_READ)```
> (solves the problem of non-repatable read)
The transaction will make sure that when a query reads a row, that row will not changed till this transaction is closed even if there is another transaction commiteted change to this row. Every time you run the same query, the result will be indentical. To save the data consequency
