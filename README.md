[![Maven Central](https://img.shields.io/maven-central/v/com.konduto.sdk/java-sdk.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.konduto.sdk%22%20AND%20a:%22java-sdk%22)

## Intro

Welcome! This document will explain how to integrate with Konduto's anti-fraud service so you can begin to spot fraud on your e-commerce website.

Our service uses the visitor's behavior to analyze browsing patterns and detect fraud. You will need to add a **JavaScript** snippet to your website and tag your pages, so we can see your visitors, and call our **REST API** to send purchases, so we can analyze them.

This document refers to the **Java SDK** used for our API.

## Requirements

* Java 8

## Installation

To get started add our SDK as a dependency in your **pom.xml**:

```xml
<dependency>
	<groupId>com.konduto.sdk</groupId>
	<artifactId>java-sdk</artifactId>
	<version>2.15.0</version>
</dependency>
```

## Getting Started

When a customer makes a purchase you must send the order information to us so we can analyze it. We perform a real-time analysis and return you a **recommendation** of what to do next and a score, a numeric confidence level about that order.

While many of the parameters we accept are optional we recommend you send all you can, because every data point matters for the analysis. The **billing address** and **credit card information** are specially important, though we understand there are cases where you don't have that information.


## Set your API key

You will need an API key to authenticate the requests. Luckily for you the examples below have been populated with a working key, so you can just copy and paste to see how it works.

```java
// creates a Konduto instance, which is a class that communicates with our API by using HTTP methods.
Konduto konduto = new Konduto("T738D516F09CAB3A2C1EE"); // T738D516F09CAB3A2C1EE is the API key
```

## Creating an order

`KondutoOrder` is a class that models the attributes and behavior of an order.

All entities involved in Konduto's analysis process (e.g customer, shopping cart, payment, etc.) inherit 
from KondutoModel and are under the models package.

```java
KondutoOrder order = new KondutoOrder()
		.with("id","123")
		.with("totalAmount", 123.4)
		.with("customer", customer); // customer is an instance of KondutoCustomer
```		
One can also use the more conventional set-based approach as seen below.

```java
KondutoOrder order = new KondutoOrder();
order.setId("123");
order.setTotalAmount(123.4);
order.setCustomer(customer);
```

Another way of initializing an instance of KondutoModel is to call KondutoModel's fromMap method 
and pass a Map and the instance class as arguments.

```java
Map<String, Object> attributes = new HashMap<String, Object>();
attributes.put("id", "123"); 
attributes.put("totalAmount", 123.4);
attributes.put("customer", customer);

KondutoOrder order = (KondutoOrder) KondutoModel.fromMap(attributes, KondutoOrder.class);
```

>
**NOTICE**: the order created above is really, really simple. The more detail you provide, more accurate Konduto's analysis will be.
>

### Order parameters

| Parameter          | Description                                                                              |
| ------------------ | ---------------------------------------------------------------------------------------- |
| id                 | _(required)_ Unique identifier for each order.                                           |
| visitor            | _(required)_ Visitor identifier obtained from our JavaScript snippet.                    |
| total_amount       | _(required)_ Total order amount.                                                         |
| shipping_amount    | _(optional)_ Shipping and handling amount.                                               |
| tax_amount         | _(optional)_ Taxes amount.                                                               |
| currency           | _(optional)_ Currency code with 3 letters (ISO-4712).                                    |
| installments       | _(optional)_ Number of installments in the payment plan.                                 |
| ip                 | _(optional)_ Customer's IPv4 or IPV6 address.                                            |
| customer           | _(required)_ Object containing the customer details.                                     |
| payment            | _(optional)_ Array containing the payment methods.                                       |
| billing            | _(optional)_ Object containing the billing information.                                  |
| shipping           | _(optional)_ Object containing the shipping information.                                 |
| shopping_cart      | _(optional)_ Array containing the items purchased.                                       |
| analyze            | _(optional)_ A boolean indicating if the order should be analyzed. Defaults to **true**. |
| first_message      | _(optional)_ Time when the first message was exchanged between customer and seller.      |
| messages_exchanged | _(optional)_ Number of messages exchanged between customer and seller.                   |
| purchased_at       | _(optional)_ Time when the customer purchased from the seller.                           |
| vehicle            | _(optional)_ Object containing information regarding vehicles.                           |

#### Customer information

| Parameter  | Description                                                                                                                                               |
| ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
| id         | _(required)_ **Unique** identifier for each customer. Can be anything you like (counter, id, e-mail address) as long as it's consistent in future orders. |
| name       | _(required)_ Customer's full name.                                                                                                                        |
| email      | _(required)_ Customer's e-mail address                                                                                                                    |
| tax_id     | _(optional)_ Customer's tax id.                                                                                                                           |
| phone1     | _(optional)_ Customer's primary phone number                                                                                                              |
| phone 2    | _(optional)_ Customer's secondary phone number                                                                                                            |
| new        | _(optional)_ Boolean indicating if the customer is using a newly created account for this purchase.                                                       |
| vip        | _(optional)_ Boolean indicating if the customer is a VIP or frequent buyer.                                                                               |
| created_at | _(optional)_ Date when customer was created.                                                                                                              |


#### Payment information

Payments may contain a `description` and a `amount` field. The former is a
 description of the payment, for example: "Thanksgiving discount voucher". 
 The latter is the amount that was charged in that specific payment type. For
  example, a transaction total amount could be 100.00, of which 10.00 are
   paid via a discount voucher and 90.00 via credit card.

##### Credit card
| Parameter       | Description                                                                                                                                                         |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| status          | _(required)_ The status of the transaction returned by the payment processor. Accepts `approved`, `declined` or `pending` if the payment wasn't been processed yet. |
| bin             | _(optional)_ First six digits of the customer's credit card. Used to identify the type of card being sent.                                                          |
| last4           | _(optional)_ Four last digits of the customer's credit card number.                                                                                                 |
| expiration_date | _(optional)_ Card's expiration date under MMYYYY format.                                                                                                            |

##### Boleto
| Parameter       | Description                                         |
| --------------- | --------------------------------------------------- |
| expiration_date | _(optional)_ Boleto's expiration date (yyyy-MM-dd). |

##### Other payment types available
* DEBIT
* TRANSFER
* VOUCHER

#### Billing address

| Parameter | Description                                                      |
| --------- | ---------------------------------------------------------------- |
| name      | _(optional)_ Cardholder's full name.                             |
| address1  | _(optional)_ Cardholder's billing address on file with the bank. |
| address2  | _(optional)_ Additional cardholder address information.          |
| city      | _(optional)_ Cardholder's city.                                  |
| state     | _(optional)_ Cardholder's state.                                 |
| zip       | _(optional)_ Cardholder's ZIP code.                              |
| country   | _(optional)_ Cardholder's country code (ISO 3166-2)              |


#### Shipping address

| Parameter | Description                                            |
| --------- | ------------------------------------------------------ |
| name      | _(optional)_ Recipient's full name.                    |
| address1  | _(optional)_ Recipient's shipping address.             |
| address2  | _(optional)_ Additional recipient address information. |
| city      | _(optional)_ Recipient's city.                         |
| state     | _(optional)_ Recipient's state.                        |
| zip       | _(optional)_ Recipient's ZIP code.                     |
| country   | _(optional)_ Recipient's country code (ISO 3166-2)     |


#### Shopping cart

| Parameter    | Description                                                                                                    |
| ------------ | -------------------------------------------------------------------------------------------------------------- |
| sku          | _(optional)_ Product or service's SKU or inventory id.                                                         |
| product_code | _(optional)_ Product or service's UPC, barcode or secondary id.                                                |
| category     | _(optional)_ Category code for the item purchased. [See here](http://docs.konduto.com/#n-tables) for the list. |
| name         | _(optional)_ Name of the product or service.                                                                   |
| description  | _(optional)_ Detailed description of the item.                                                                 |
| unit_cost    | _(optional)_ Cost of a single unit of this item.                                                               |
| quantity     | _(optional)_ Number of units purchased.                                                                        |
| discount     | _(optional)_ Discounted amount for this item.                                                                  |
| created_at   | _(optional)_ Date when this item was created.                                                                  |

#### Seller

| Parameter  | Description                                   |
| ---------- | --------------------------------------------- |
| id         | _(required)_ Seller's id                      |
| name       | _(optional)_ Sellers's name                   |
| created_at | _(optional)_ Date when the seller was created |


#### Travel
| Parameter     | Description                                                                                                                               |
| ------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| type          | _(required)_ The travel type (**flight** or **bus**).                                                                                     |
| departure_leg | _(required)_ An instance of either *KondutoBusTravelLeg* (if **type** is **bus**) or *KondutoFlightTravelLeg* (if **type** is **flight**) |
| return_leg    | _(optional)_ An instance of either *KondutoBusTravelLeg* or *KondutoFlightTravelLeg*.                                                     |
| passengers    | _(optional)_ A list of *KondutoPassenger*                                                                                                 |

##### Common travel leg attributes
 | Parameter             | Description                             |
 | --------------------- | --------------------------------------- |
 | date                  | _(required)_ The travel date            |
 | number_of_connections | _(optional)_ The number of connections  |
 | class                 | _(optional)_ see **KondutoTravelClass** |
 | fare_basis            | _(optional)_                            |

##### Bus travel leg specifics
| Parameter        | Description                           |
| ---------------- | ------------------------------------- |
| origin_city      | _(required)_ The leg origin city      |
| destination_city | _(required)_ The leg destination city |

##### Flight travel leg specifics
| Parameter           | Description                                                   |
| ------------------- | ------------------------------------------------------------- |
| origin_airport      | _(required)_ The leg origin airport IATA code (e.g: GRU, LAX) |
| destination_airport | _(required)_ The leg destination airport IATA code            |
| origin_city         | _(optional)_ The leg origin city                              |
| destination_city    | _(optional)_ The leg destination city                         |

##### Passenger
| Parameter         | Description                                                                            |
| ----------------- | -------------------------------------------------------------------------------------- |
| name              | _(required)_ The travel type (**flight** or **bus**)                                   |
| document          | _(required)_ The passenger's document                                                  |
| document_type     | _(required)_ The passenger's document type (e.g passport). See **KondutoDocumentType** |
| frequent_traveler | _(optional)_ A boolean. Is this passenger a frequent traveler?                         |
| special_needs     | _(optional)_ A boolean. Does the passenger have special needs?                         |


##### Events
| Parameter | Description                                                                                                                  |
| --------- | ---------------------------------------------------------------------------------------------------------------------------- |
| name      | _(required)_ The name of the event                                                                                           |
| date      | _(required)_ When the event is going to happen                                                                               |
| type      | _(required)_ The type of the event (e.g., show, sports, theater, etc). For the complete list, see **KondutoEventType** enum. |
| subtype   | _(optional)_                                                                                                                 |
| venue     | _(optional)_ The event's location address. See **Event Venue** bellow.                                                       |
| tickets   | _(optional)_ A list of tickets for the given event. See **Event Ticket** below.                                              |

##### Event Venue
| Parameter | Description                                                                    |
| --------- | ------------------------------------------------------------------------------ |
| name      | _(optional)_ The name of the place (e.g. Wembley Stadium, World Trade Center). |
| capacity  | _(optional)_ The total amount of available tickets for sale.                   |
| address   | _(optional)_ The specific location.                                            |
| city      | _(optional)_                                                                   |
| state     | _(optional)_                                                                   |
| country   | _(optional)_ The country abbreviation code (e.g., BR, US, AU, etc)             |

##### Event Ticket
| Parameter | Description                                                                                                                       |
| --------- | --------------------------------------------------------------------------------------------------------------------------------- |
| id        | _(optional)_ A unique identifier for the ticket.                                                                                  |
| category  | _(required)_ The ticket type, such as senior, student or regular. For the complete list, see **KondutoEventTicketCategory** enum. |
| section   | _(optional)_ The location of the ticket (e.g., lower seats, upper seats, unseated, etc).                                          |
| premium   | _(required)_ Boolean that indicates if the ticket is a premium one.                                                               |
| attendee  | _(optional)_ Information about the ticket owner. See **KondutoEventTicketAttendee** bellow.                                       |

##### Event Ticket Attendee
| Parameter    | Description                                                                                                                                               |
| ------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
| name         | _(optional)_ The attendee's name.                                                                                                                         |
| document     | _(required)_ The attendee document value.                                                                                                                 |
| documentType | _(optional)_ The type of document informed, such as CPF, CNPJ, passport, etc. For the complete list, see **KondutoEventTicketAttendeeDocumentType** enum. |
| dateOfBirth  | _(optional)_ A string with the attendee's date of birth.                                                                                                  |
=======
##### Vehicle
| Parameter    | Description                                                                                                                      |
| ------------ | -------------------------------------------------------------------------------------------------------------------------------- |
| vid          | _(optional)_ Vehicle's ISO unique identifier.                                                                                    |
| renavam      | _(optional)_ Brazilian RENAVAM identifier.                                                                                       |
| registration | _(optional)_ License plate for cars, registration for aircraft or boats.                                                         |
| make         | _(required)_ Name of the vehicle manufacturer company (e.g. Fiat).                                                               |
| model        | _(required)_ Name of the vehicle model (e.g. Camaro).                                                                            |
| type         | _(optional)_ Enum containing several vehicle types such as CAR, AIRCRAFT, BUS, etc. See **KondutoVehicleType**.                  |
| usage        | _(optional)_ Enum containing several usage scenarios for vehicles such as PRIVATE, GOVERNMENT, etc. See **KondutoVehicleUsage**. |
| owner        | _(required)_ Object containing information regarding the owner of the vehicle. See **Vehicle Owner** below.                      |

##### Vehicle Owner
| Parameter | Description                          |
| --------- | ------------------------------------ |
| tax_id    | _(required)_ Vehicle owner's tax id. |
| name      | _(optional)_ Vehicle owner's name.   |

##### Delivery
| Parameter               | Description                                                                              |
|-------------------------|------------------------------------------------------------------------------------------|
| delivery_company        | _(optional)_ Adds the name of the company that will deliver the product to the customer. |
| delivery_method         | _(optional)_ Details the type of withdrawal type, if applicable.                         |
| estimated_shipping_date | _(optional)_ Informs the shipping date of the product.                                   |
| estimated_delivery_date | _(optional)_ Informs the delivery date of the product.                                   |


## Sending an order for analysis.

After creating the order, sending it to Konduto's analysis is very simple.

```java
if(order.isValid()){
	try {
		konduto.analyze(order);
		System.out.println("Konduto recommendation is to: " + order.getRecommendation());

	// A KondutoException will be thrown if the response is anything other than 200 OK.
	// You can catch more specific exceptions if you want to (e.g KondutoHTTPBadRequestException).
	catch(KondutoException e) {
		// Put any exception handling here.
		e.printStackTrace();
		persistAsNotAnalyzed(order, e.getMessage());
	}
} else {
    LOGGER.debug(order.getErrors());
}
```

Notice that if the analysis fails, a **KondutoException** will be thrown. Handle it as you wish.

## Querying an order from our servers.

In order to do that use the Konduto class in the following way:

```java
try {
	KondutoOrder order = konduto.getOrder(orderId); // orderId is a String
} catch (KondutoException e) {
	// Exception handling code
}
```

## Updating an order status

```java
try {
	// the order status will be set to newStatus if the request succeeds.
	konduto.updateOrderStatus(order, newStatus, "some comments"); 
} catch (KondutoException e) {
	// Exception handling code
}
```

| Parameter | Description                                                                                                                             |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------- |
| status    | _(required)_ New status for this transaction. Either `approved`, `declined` or `fraud`, when you have identified a fraud or chargeback. |
| comments  | _(required)_ Reason or comments about the status update.                                                                                |

## Sending requests through a proxy
To send requests through a proxy just build a new Konduto instance and set the proxy host passing both hostname and port as parameters of `setProxyHost` method. If the proxy requires username and password, set these credentials using the `setProxyCredentials` method.

```java
String proxyHostname = "proxy.hostname";
int proxyPort = 1234;
Konduto konduto = new Konduto(API_KEY);
konduto.setProxyHost(proxyHostname, proxyPort);
// any object of kind org.apache.commons.httpclient.Credentials works 
// (as an example we use an instance of UsernamePasswordCredentials)
konduto.setProxyCredentials(new UsernamePasswordCredentials("username", "password")); 
// use Konduto's API as usual
konduto.getOrder(ORDER_ID);
```

## Reference Tables

Please [click here](http://docs.konduto.com/#n-tables) for the Currency and Category reference tables.

## Troubleshooting

If you experience problems sending orders for analysis, querying orders or updating order status, it might be a good idea
to call `konduto.debug()`. This will print out the API Key, the endpoint, the request body and the response body.

## Support

Feel free to contact our [support team](mailto:support@konduto.com) if you have any questions or suggestions!
