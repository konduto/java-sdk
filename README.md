# Welcome to Konduto's Java SDK documentation.

Konduto is a service that receives orders from merchants and analyzes them, looking for fraud evidence.

After the analysis, which is based on AI techniques over buying behavior, personal data, 
fingerprinting and customized rules, the system responds with a score telling how suspicious the transaction is
and with a recommendation, which is either approve, decline or review.

This SDK should be used by merchants who wish to integrate their Java-based e-commerce with Konduto's
anti-fraud technology.

## Setting up Konduto class.

This project contains a class named Konduto, which is able to send HTTP messages to Konduto's RESTful API
and receive responses from it.

/* setting up Konduto class */

Konduto.setApiKey(YOUR_API_KEY); // your API key is visible at Konduto's Dashboard
								 // if you have any difficulties obtaining it, send an email to support@konduto.com

## Creating an order

Before sending an order for analysis we must create it.

KondutoOrder is a class that models the attributes and behavior of an order.

All entities involved in Konduto's analysis process (e.g customer, shopping cart, payment, etc.) inherit 
from KondutoModel and are under the models package.

/* Code below creates an order and sends it for analysis */

KondutoOrder order = new KondutoOrder()
		.with("id","123")
		.with("totalAmount", 123.4)
		.with("customer", customer); // customer is an instance of KondutoCustomer
		
Besides this fluent way of initializing an order - and any instance of KondutoModel -, 
one can use the more conventional set-based approach as seen below.

KondutoOrder order = new KondutoOrder();
order.setId("123");
order.setTotalAmount(123.4);
order.setCustomer(customer);

Another way of initializing an instance of KondutoModel is to call KondutoModel's fromMap method 
and pass a Map and the instance class as arguments.

Map<String, Object> attributes = new HashMap<>();
attributes.put("id", "123"); 
attributes.put("totalAmount", 123.4);
attributes.put("customer", customer);

KondutoOrder order = (KondutoOrder) KondutoModel.fromMap(attributes, KondutoOrder.class);

NOTICE: the order created above is really, really simple. 
Remember: the more detail you provide, the more accurate Konduto's analysis will be. 

## Sending an order for analysis.

After creating the order, sending it to Konduto's analysis is very simple.

if(order.isValid()){
	try {
		Konduto.analyze(order); // order is an instance of KondutoOrder	
	// a KondutoException will be thrown if Konduto responds with anything other than 200 OK.
	// You can catch more specific exceptions if you want to (e.g KondutoHTTPBadRequestException).
	catch(KondutoException e) {
		// Put any exception handling here. In the example below, one decided to print the stack trace,
		// to persist the order in the database marking it as not analyzed and to keep the error message. 
		e.printStackTrace();
		persistAsNotAnalyzed(order, e.getMessage());
	}
} else {
    LOGGER.debug(order.getErrors());
}

Notice that if the analysis fails, a KondutoException will be thrown. Handle it as you wish.

Every KondutoModel instance (therefore any KondutoOrder instance) has a isValid method that checks if required fields
are present and an errors array. When isValid is called, if there are any errors they will be added to the errors array.
For reading errors, just call order.getErrors() and a pretty-printed message will be displayed.

After the analysis, some order attributes will be filled. For example the recommendation.

// The command below should print something like "Konduto recommendation is to APPROVE".
System.out.println("Konduto recommendation is to: " + order.getRecommendation());

## Querying an order from our servers.

In order to do that use the Konduto class in the following way:

```java
try {
	KondutoOrder order = Konduto.getOrder(orderId); // orderId is a String
} catch (KondutoException e) {
	// Exception handling code
}
```

## Updating an order status

try {
	// the order status will be set to newStatus if the request succeeds.
	Konduto.updateOrderStatus(order, newStatus, "some comments"); 
} catch (KondutoException e) {
	// Exception handling code
}

## Troubleshooting

If you experience problems sending orders for analysis, querying orders or updating order status, it might be a good idea
to call Konduto.debug(). This will print out the API Key, the endpoint, the request body and the response body.

If you need help send an email to support@konduto.com

Feel free to suggest improvements or report bugs.