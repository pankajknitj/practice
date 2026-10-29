# Design Patterns
## Table of Contents

- [Strategy](#Strategy-Design-Pattern)
- [Iterator](#Iterator-Design-Pattern)
- [Observer](#Observer-Design-Pattern)
- [Command](#Command-Design-Pattern)
- [State](#State-Design-Pattern)
- [Template Method](#Template-Method-Design-Pattern)
- [Chain of Responsibility](#Chain-of-Responsibility-Design-Pattern)
- [Visitor](#Visitor-Design-Pattern)
- [Mediator](#Mediator-Design-Pattern)
- [Memento](#Memento-Design-Pattern)

## Strategy Design Pattern
This pattern becomes valuable when:
- You have multiple ways to perform the same operation, and the choice might change at runtime.
- You want to avoid bloated conditional statements that select between different behaviors.
- You need to isolate algorithm-specific data and logic from the code that uses it.

```text
The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. 
Strategy lets the algorithm vary independently from clients that use it.
```
Two characteristics define the pattern:
- Encapsulation of algorithms
- Runtime interchangeability

![img_1.png](resources/img_1.png)

**Practical Example:** Payment Processing

we are building a payment processing system that supports multiple payment methods: credit card, PayPal, and cryptocurrency. Each method has a different processing flow, but the checkout service should not care which one is being used.

**Naive Approach:** Checkout service contains all the payment logic and have switch cases to select which logic to invoke.

Issues:
- One class contains many unrelated payment methods.
- new payment method requires changes in checkout service (open close violation)
- bloated switch case/if-else

**Efficient Approach:** Strategy Pattern

- Defined options(ways) as concrete strategies.
- Define Context (Processor), which holds strategy object.
- At runtime change the strategy based on requirement by setter.


![img_2.png](resources/img_2.png)
<details>
<summary>View Java Code</summary>

```java
//Strategy Interface
public interface PaymentProcessor {
    public void processPayment(double amount);
}

//Concrete Strategy-1
public class CreditCardPayment implements PaymentProcessor {
    private CardDetails cardDetails;
    @Override
    public void processPayment(double amount) {
        if(cardDetails==null){
            throw new IllegalArgumentException("Card details cannot be null");
        }
        System.out.println("Processing credit card payment of amount: " + amount);
        System.out.println("Card Number: " + cardDetails.getCardNumber());
        System.out.println("Card Holder: " + cardDetails.getCardHolder());
    }
}
//concrete Strategy-2
public class PaypalPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of amount: " + amount);
    }
}
//concrete Strategy-3
public class StripePayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment of amount: " + amount);
    }
}
//concrete Strategy-4
public class UpiPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of amount: " + amount);
    }
}
```
```java
//service that need to change the strategy dynamically
public class CheckoutService {
    private PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.processPayment(amount);
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        // Create a CheckoutService with PaypalPayment strategy
        PaymentProcessor paypalPayment = new PaypalPayment();
        CheckoutService checkoutService = new CheckoutService(paypalPayment);

        // Process payment using PaypalPayment strategy
        checkoutService.checkout(100.0);

        // Change the strategy to CreditCardPayment
        PaymentProcessor creditCardPayment = new CreditCardPayment(new CardDetails("446646","pk",2443));
        checkoutService.setPaymentProcessor(creditCardPayment);

        // Process payment using CreditCardPayment strategy
        checkoutService.checkout(200.0);
    }
}
```
</details>

[Home](#Table-of-Contents)
## Iterator Design Pattern
It’s particularly useful in situations where:
- You need to traverse a collection (like a list, tree, or graph) in a consistent and flexible way.
- You want to support multiple ways to iterate (e.g., forward, backward, filtering, or skipping elements).
- You want to decouple traversal logic from collection structure, so the client doesn't depend on the internal representation.
- Parallel traversal
```text
The Iterator Pattern defines a separate object, the iterator, that encapsulates the details of traversing a collection.
Instead of exposing its internal structure, the collection provides an iterator that clients use to access elements sequentially.
```
Two characteristics define the pattern:
- Separation of traversal from storage
- Multiple independent traversals

![img_3.png](resources/img_3.png)

Practical Example: Notification System

We are building a notification system where a NotificationCenter stores notifications of different types: email, SMS, and push. We need iterators that can traverse all notifications, filter by type, and show only unread notifications.

**Naive Approach:**

Return the underlying collection of notifications and let client traverse as per the requirement OR keep separate method for each iterator type and create based on condition.

Issues:

- if we return underlying collection, client is bound to that data structure, if we change client have to change the code.
- we can't traverse parallel.

**Efficient Approach:** Iterator pattern

- It defined 2 separate concrete classes, iterator(FilteredIterator, UnreadIterator) and the collection(Inbox).
- Defined a contract for collection to support creation of all type of iterators.
- Iterator will have minimum hasNext() and next() method, it can have remove() and add().

![img_5.png](resources/img_5.png)

<details>
<summary>View Java Code</summary>

```java
public enum NotificationType {
    EMAIL, SMS, PUSH_NOTIFICATION;
}
//pojo
public class Notification {
    private String message;
    private NotificationType type;
    private boolean isRead=false;
}
```
```java
// A Contract for collection.
public interface Iterable<T> {
    Iterator<T> emailIterator();
    Iterator<T> smsIterator();
    Iterator<T> unreadIterator();
}

// Concrete collection class
public class NotificationCenter implements Iterable<Notification> {
    private List<Notification> notifications = new ArrayList<>();

    @Override
    public Iterator<Notification> emailIterator() {
        return new EmailIterator(this);
    }

    @Override
    public Iterator<Notification> smsIterator() {
        return new SMSIterator(this);
    }

    @Override
    public Iterator<Notification> unreadIterator() {
        return new UnreadIterator(this);
    }

    public int getSize(){
        return notifications.size();
    }

    public Notification getNotification(int index){
        return notifications.get(index);
    }

    public void addNotification(Notification notification){
        notifications.add(notification);
    }
}
```
```java
// Iterator contract
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Concrete iterator class-1
public class EmailIterator implements Iterator<Notification> {
    private final NotificationCenter center;
    private int currentIndex = 0;

    public EmailIterator(NotificationCenter center){
        this.center = center;
        currentIndex = findNextIndex();
    }

    @Override
    public boolean hasNext() {
        return currentIndex<center.getSize();
    }

    @Override
    public Notification next() {
        Notification nextElement = center.getNotification(currentIndex++);
        currentIndex = findNextIndex();
        return nextElement;
    }

    private int findNextIndex(){
        for(int i=currentIndex;i<center.getSize();i++){
            if(EMAIL.equals(center.getNotification(i).getType())){
                return i;
            }
        }

        return center.getSize();
    }
}

// Concrete iterator class-2
public class SMSIterator implements Iterator<Notification> {
    private final NotificationCenter center;
    private int currentIndex = 0;

    public SMSIterator(NotificationCenter center){
        this.center = center;
        currentIndex = findNextIndex();
    }
    @Override
    public boolean hasNext() {
        return currentIndex<center.getSize();
    }

    @Override
    public Notification next() {
        Notification nextElement = center.getNotification(currentIndex++);
        currentIndex = findNextIndex();
        return nextElement;
    }

    private int findNextIndex(){
        for(int i=currentIndex;i<center.getSize();i++){
            if(SMS.equals(center.getNotification(i).getType())){
                return i;
            }
        }

        return center.getSize();
    }
}
// Concrete iterator class-3
public class UnreadIterator implements Iterator<Notification> {
    private final NotificationCenter center;
    private int currentIndex = 0;

    public UnreadIterator(NotificationCenter center){
        this.center = center;
    }
    @Override
    public boolean hasNext() {
        return currentIndex< center.getSize();
    }

    @Override
    public Notification next() {
        Notification nextElement = center.getNotification(currentIndex++);
        for(int i=currentIndex;i<center.getSize();i++){
            if(!center.getNotification(i).isRead()){
                currentIndex = i;
                return nextElement;
            }
        }
        return nextElement;
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        NotificationCenter center = new NotificationCenter();

        center.addNotification(new Notification("email1",EMAIL,false));
        center.addNotification(new Notification("email2",EMAIL,false));
        center.addNotification(new Notification("email3",EMAIL,true));

        center.addNotification(new Notification("sms1",SMS,false));
        center.addNotification(new Notification("sms2",SMS,false));

        Iterator<Notification> smsIterator = center.smsIterator();
        while(smsIterator.hasNext()) {
            Notification notification = smsIterator.next();
            System.out.println(notification);
        }

        Iterator<Notification> unreadEmailIterator = center.unreadIterator();
        while(unreadEmailIterator.hasNext()) {
            Notification notification = unreadEmailIterator.next();
            System.out.println(notification);
        }
    }
}
```
</details>

[Home](#Table-of-Contents)
## Observer Design Pattern
![img_6.png](resources/img_6.png)

This pattern shines in scenarios where:
- You have multiple parts of the system that need to react to a change in one central component.
- You want to decouple the publisher of data from the subscribers who react to it.
- You need a dynamic, event-driven communication model without hardcoding who is listening to whom.
```text
The Observer Design Pattern provides a clean and flexible solution to the problem of broadcasting
changes from one central object (the Subject) to many dependent objects (the Observers) all while keeping them loosely coupled.
```
Two characteristics define the pattern: One-to-many notification and Loose coupling between subject and observers

![img_8.png](resources/img_8.png)

- This pattern says to create separate concrete listeners with a method update/receive.
- Subject holds all the listeners who has subscribed to subject and on changing of state it notifies all the listeners.
- Subject provides methods to register and unregister listeners.

**Practical Example:** Stock Price Ticker

Let us work through a second example to reinforce the pattern. This time, we are building a stock price notification system. A StockExchange subject publishes price updates for stocks.
Multiple observers react to these updates: a PriceDisplay shows current prices, an AlertService notifies traders when prices cross thresholds, and a TradingBot executes trades based on price movements.

![img_10.png](resources/img_10.png)

<details>
<summary>View Java Code</summary>

```java
public enum EventType {
    STOCK_PRICE_UPDATE, STOCK_REGISTRATION, STOCK_DELISTING;
}
public class StockEvent {
    private String stockName;
    private double stockPrice;
    private EventType eventType;
}
```
```java
//subject interface
public interface StockExchange {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(StockEvent event);
    void registerStock(String stockName, double price);
    void updateStockPrice(String stockName, double price);
    void unregisterStock(String stockName);
    Map<String,Double> getStockPrices();
}

//this should be a singleton class, but for simplicity, we are not implementing singleton pattern here
@Data
public class StockExchangeImpl implements StockExchange {
    private List<StockObserver> observers = new ArrayList<>();
    private Map<String, Double> stockPrices = new HashMap<>();

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(StockEvent event) {
        observers.forEach(obs -> obs.processStockEvent(event));
    }

    @Override
    public void registerStock(String stockName, double price) {
        stockPrices.put(stockName,price);

        //notify: notify observers when a new stock is registered
        StockEvent stockEvent = new StockEvent(stockName, price, EventType.STOCK_REGISTRATION);
        notifyObservers(stockEvent);
    }

    @Override
    public void updateStockPrice(String stockName, double price) {
        stockPrices.put(stockName,price);

        //notify: notify observers when a new stock is registered
        StockEvent stockEvent = new StockEvent(stockName, price, EventType.STOCK_PRICE_UPDATE);
        notifyObservers(stockEvent);
    }

    @Override
    public void unregisterStock(String stockName) {
        stockPrices.remove(stockName);

        //notify: notify observers when a new stock is registered
        StockEvent stockEvent = new StockEvent(stockName,0.0, EventType.STOCK_DELISTING);
        notifyObservers(stockEvent);
    }

    @Override
    public Map<String, Double> getStockPrices() {
        return stockPrices;
    }
}
```
```java
//Observer-1
public class AlertService implements StockObserver {
    private Map<String,Double> thresholdMap = new HashMap<>();

    @Override
    public void processStockEvent(StockEvent stockEvent) {
        if(STOCK_PRICE_UPDATE.equals(stockEvent.getEventType())){
            Double threshold = thresholdMap.get(stockEvent.getStockName());
            if(threshold != null && stockEvent.getStockPrice() > threshold){
                System.out.println("Alert: Stock " + stockEvent.getStockName() + " price has crossed the threshold of " + threshold + ". Current price: " + stockEvent.getStockPrice());
            }
        }
    }
}

//observer-2
public class PriceDisplay implements StockObserver {
    Map<String, Double> stockPrices = new HashMap<>();

    public PriceDisplay(){
        displayStockPrices();
    }

    @Override
    public void processStockEvent(StockEvent stockEvent) {
        switch (stockEvent.getEventType()){
            case STOCK_REGISTRATION:
                stockPrices.put(stockEvent.getStockName(), stockEvent.getStockPrice());
                System.out.println("Registered stock: " + stockEvent.getStockName() + " with price: " + stockEvent.getStockPrice());
                break;
            case STOCK_PRICE_UPDATE:
                stockPrices.put(stockEvent.getStockName(), stockEvent.getStockPrice());
                System.out.println("Updated stock: " + stockEvent.getStockName() + " with new price: " + stockEvent.getStockPrice());
                break;
            case STOCK_DELISTING:
                stockPrices.remove(stockEvent.getStockName());
                System.out.println("Unregistered stock: " + stockEvent.getStockName());
                break;
        }
        displayStockPrices();
    }

    private void displayStockPrices() {
        for (Map.Entry<String, Double> entry : stockPrices.entrySet()) {
            String stockName = entry.getKey();
            double stockPrice = entry.getValue();
            System.out.println("Stock: " + stockName + ", Price: " + stockPrice);
        }

    }
}

//observer-3
public class TradeBot implements StockObserver {
    Map<String, Double> buyThreshold = new HashMap<>();
    Map<String, Double> sellThreshold = new HashMap<>();

    @Override
    public void processStockEvent(StockEvent stockEvent) {
        if(STOCK_PRICE_UPDATE.equals(stockEvent.getEventType())){
            String stockName = stockEvent.getStockName();
            double stockPrice = stockEvent.getStockPrice();
            if(buyThreshold.containsKey(stockName) && stockPrice <= buyThreshold.get(stockName)){
                System.out.println("Buying stock: " + stockName + " at price: " + stockPrice);
            } else if(sellThreshold.containsKey(stockName) && stockPrice >= sellThreshold.get(stockName)){
                System.out.println("Selling stock: " + stockName + " at price: " + stockPrice);
            }
        }
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchangeImpl();

        //observers
        StockObserver alertService = new AlertService();
        StockObserver priceDisplay = new PriceDisplay();
        StockObserver tradeBot = new TradeBot();

        //REGISTER OBSERVERS
        stockExchange.registerObserver(alertService);
        stockExchange.registerObserver(priceDisplay);
        stockExchange.registerObserver(tradeBot);

        stockExchange.updateStockPrice("AAPL", 150.0);
        stockExchange.updateStockPrice("GOOGL", 2800.0);
        stockExchange.updateStockPrice("AAPL", 155.0);
    }
}
```
</details>

[Home](#Table-of-Contents)
## Command Design Pattern
![img_11.png](resources/img_11.png)

It’s particularly useful in situations where:
- You want to encapsulate operations as objects.
- You need to queue, delay, or log requests.
- You want to support undo/redo functionality.
- You want to decouple the object that invokes an operation from the one that knows how to perform it.
```text
The Command pattern is a behavioral design pattern that turns a request into a standalone object containing all the information needed to perform that request. 
This lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.
```
**Two characteristics define the pattern:**
- Encapsulation of requests as objects
- Decoupling of invoker and receiver.
```text
Real-World Analogy
Think about ordering at a restaurant. You tell the waiter what you want (your request), and the waiter writes it on an order slip. 
The waiter does not cook the food. They carry the slip to the kitchen and hand it to the chef. The chef reads the slip and prepares the dish.
The order slip is the command object. The waiter is the invoker, carrying and delivering the request. The chef is the receiver, doing the actual work.
The customer is the client, creating the request.The waiter does not need to know how to cook, and the chef does not need to know who ordered. The slip decouples them completely.
If you want to cancel, the waiter pulls the slip from the queue, the same slip that started the process can undo it.
```
![img_13.png](resources/img_13.png)

**The Problem: The Tightly Coupled Smart Home Controller**

Imagine you are building a smart home hub. The hub needs to control various devices: lights, thermostats, and more. You need a controller that can send commands to these devices.

**Naive Approach:**
Controller holds references of all the equipment (light, fan) and have methods for each operation (lightOn(), lightOff()) which directly interact with equipment.

Issues:

- Tight Coupling: controller is tightly coupled to each devices and their methods.
- Addition of any new device requires changes in controller (open close violation).
- No undo/redo support.
- No scheduling or queuing.

**Efficient Approach:** Command Pattern

- Define Receivers (Light, Fan), these are the entities which actually perform the actions.
- Define concrete commands (based on contract to have execute() and undo() operation), each command class holds the receiver object.
- Define Invoker(Remote), which is unaware of command operations(internals), it just invoke the execute/undo methods of command.
- At runtime set the command and call execute/undoLast method to perform the operation.

![img_14.png](resources/img_14.png)

<details>
<summary>View Java Code</summary>

```java
//Receiver-1
public class Fan {
    private int speed;;

    public int getCurrentSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
        if(speed >0)
            System.out.println("Fan speed set to: " + speed);
        else System.out.println("Fan is turned off");
    }
}
//Receiver-2
public class Light {
    public void on(){
        System.out.println("Light is ON");
    }

    public void off(){
        System.out.println("Light is OFF");
    }
}
```
```java
//command contract
public interface Command {
    void execute();
    void undo();
}

//Concrete command-1
public class LightOnCommand implements Command {
    private Light light;
    @Override
    public void execute() {
        System.out.print("Turning light ON: ");
        light.on();
    }

    @Override
    public void undo() {
        System.out.print("Undoing Light ON command: ");
        light.off();
    }
}

//Concrete command-2
public class LightOffCommand implements Command {
    private Light light;

    @Override
    public void execute() {
        System.out.print("Turning light off: ");
        light.off();
    }

    @Override
    public void undo() {
        System.out.print("Undoing Light Off Command: ");
        light.on();
    }
}

//concrete command-3
public class FanSpeedCommand implements Command {
    private int previousSpeed;
    private int newSpeed;
    private final Fan fan;

    @Override
    public void execute() {
        previousSpeed = fan.getCurrentSpeed();
        System.out.print("Setting Fan speed: ");
        fan.setSpeed(newSpeed);
    }

    @Override
    public void undo() {
        System.out.print("Undoing fan setting: ");
        fan.setSpeed(previousSpeed);
    }
}
```
```java
//Invoker contract
public interface HomeInvoker {
    public void executeCommand(Command command);
    public void undoLastCommand();
}

public class HomeInvokerImpl implements HomeInvoker {
    //supporting only 10 commands in history
    private Deque<Command> history = new LinkedList<>();

    @Override
    public void executeCommand(Command command) {
        history.add(command);
        command.execute();
        if(history.size()>10){
            history.pollLast();
        }
    }

    @Override
    public void undoLastCommand() {
        Objects.requireNonNull(history.pollLast()).undo();
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        HomeInvoker smartHome = new HomeInvokerImpl();

        //receivers
        Light light = new Light();
        Fan fan = new Fan();

        // Create commands
        Command turnOnLights = new LightOnCommand(light);
        Command turnOffLights = new LightOffCommand(light);
        Command fanSpeedCmd = new FanSpeedCommand(0,5,fan);

        //invoke
        smartHome.executeCommand(turnOnLights);
        smartHome.executeCommand(turnOffLights);
        smartHome.undoLastCommand();
        smartHome.executeCommand(fanSpeedCmd);
        smartHome.undoLastCommand();
    }
}
```
</details>

[Home](#Table-of-Contents)
## State Design Pattern
It’s particularly useful in situations where:
- An object can be in one of many distinct states, each with different behavior.
- The object’s behavior depends on current context, and that context changes over time.
- You want to avoid large, monolithic if-else or switch statements that check for every possible state.
```text
The State pattern allows an object (the Context) to alter its behavior when its internal state changes. 
The object appears to change its class because its behavior is now delegated to a different state object.
```
**Two characteristics define the pattern:**
- Encapsulation of state-specific behavior
- State-driven transitions

![img_18.png](resources/img_18.png)

**Practical Example:** Document Workflow

We are building a document management system where documents move through a workflow: Draft, Under Review, Approved and Published. Each state has different rules for what operations are allowed.
In Draft state, authors can edit the document and submit it for review. In Review state, reviewers can approve or reject it. In Published state, the document is read-only and can only be unpublished to go back to Draft.

**Naive Approach:**
We can have a class (Document) and for each operation have a method consists of switch statement based on state to perform the operation
i.e: edit(state) if state is draft then only allow editing else reject.

Issues:

- Violates Single responsibility principle as single class holds all the logic for all the states.
- cluttered if-else/switch statements.
- Hard to extend: addition of a new state requires modification in all the operation's method as written with switch case.

**Efficient Approach:** state design pattern

- Define concrete state with contract to have methods for possible operation on context(document), context is parameterized.
- Define Context(Document) which holds the one of concrete state at a time and methods for all operations and delegates the actions to state object.
- All the operations on context will be performed by state object if allowed or reject.
- this is how we implement the logic based on the state of context.

![img_19.png](resources/img_19.png)

<details>
<summary>View Java Code</summary>

```java
//Context
public class Document {
    private String content;
    private DocumentState state;

    public void edit(String newContent) {
        System.out.println("Editing document...");
        state.edit(this, newContent);
    }

    public void sendForReview() {
        System.out.println("Sending document for review...");
        state.review(this);
    }

    public void approve() {
        System.out.println("Approving document...");
        state.approve(this);
    }

    public void reject() {
        System.out.println("Rejecting document...");
        state.reject(this);
    }

    public void publish() {
        System.out.println("Publishing document...");
        state.publish(this);
    }

    public void unpublish() {
        System.out.println("Unpublishing document...");
        state.unpublish(this);
    }
}
```
```java
//State interface
public interface DocumentState {
    void publish(Document document);
    void approve(Document document);
    void edit(Document document, String content);
    void review(Document document);
    void reject(Document document);
    void unpublish(Document document);
}

//Concrete state-1
public class Draft implements DocumentState {
    //allowed
    @Override
    public void publish(Document document) {
        System.out.println("Cannot publish document in Draft state. Please send it for review first.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve document in Draft state. Please send it for review first.");
    }

    @Override
    public void edit(Document document, String content) {
        document.setContent(content);
        System.out.println("Document content updated in Draft state.");
    }

    //allowed
    @Override
    public void review(Document document) {
        System.out.println("Document sent for review. Transitioning to Review state.");
        document.setState(new Review());
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject document in Draft state. Please send it for review first.");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Cannot unpublish document in Draft state. Document is not published yet.");
    }
}

//State-2
public class Review implements DocumentState {

    @Override
    public void publish(Document document) {
        System.out.println("Cannot publish document in Review state. Please approve it first.");
    }

    //allowed
    @Override
    public void approve(Document document) {
        System.out.println("Document approved. Transitioning to Approved state.");
        document.setState(new Approved());
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("Cannot edit document in Review state. Please reject it first.");
    }

    @Override
    public void review(Document document) {
        System.out.println("Document is already in Review state.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document rejected. Transitioning back to Draft state.");
        document.setState(new Draft());
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Cannot unpublish document in Review state. Document is not published yet.");
    }
}

//State-3
public class Approved implements DocumentState {
    @Override
    public void publish(Document document) {
        System.out.println("Document published. Transitioning to Publishing state.");
        document.setState(new Publishing());
        System.out.println("Document is now in Publishing state.");
        document.setState(new Published());
    }

    @Override
    public void approve(Document document) {
        System.out.println("Rejected: Already Approved");
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("Rejected: Not allowed");
    }

    @Override
    public void review(Document document) {
        System.out.println("Rejected:not allowed");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Rejected: Not allowed");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Document unpublished. Transitioning back to Draft state.");
    }
}


//State-4
public class Publishing implements DocumentState {
    @Override
    public void publish(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void approve(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void review(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void reject(Document document) {
        System.out.println("not Supported. document is publishing...");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("not Supported. document is publishing...");
    }
}

//State-5
public class Published implements DocumentState {
    @Override
    public void publish(Document document) {
        System.out.println("Document is already published. No further action needed.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document is already approved and published. No further action needed.");
    }

    @Override
    public void edit(Document document, String content) {
        System.out.println("Cannot edit document in Published state. Please unpublish it first.");
    }

    @Override
    public void review(Document document) {
        System.out.println("Cannot review document in Published state. Please unpublish it first.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject document in Published state. Please unpublish it first.");
    }

    @Override
    public void unpublish(Document document) {
        System.out.println("Document unpublished. Transitioning back to Draft state.");
        document.setState(new Draft());
    }
}

```
```JAVA
public class Client {
    public static void main(String[] args) {
        Document document = new Document("", new Draft());
        document.edit("This is a draft document.");
        document.sendForReview();
        document.approve();
        document.publish();
        document.unpublish();
        document.reject();
    }
}
```
</details>

[Home](#Table-of-Contents)
## Template Method Design Pattern
![img_20.png](resources/img_20.png)

It’s particularly useful in situations where:
- You have a well-defined sequence of steps to perform a task.
- Some parts of the process are shared across all implementations.
- You want to allow subclasses to customize specific steps without rewriting the whole algorithm.

**The Problem:** Exporting Reports

Let’s say you’re building an analytics platform that lets users export reports in different formats. Right now, the product needs CSV and PDF support, with Excel coming soon.
Each exporter follows the same high-level workflow:

Prepare Data -> Open File -> Write Header -> Write Data Rows -> Write Footer -> Close File.

The workflow is the same across formats. Only the **header writing and data row formatting** differ. But if you implement each exporter independently, you end up duplicating the shared logic in every class.

```text
The Template Method pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. 
It allows you to keep the overall structure of the process consistent, while giving subclasses the flexibility to 
customize specific parts of the algorithm.
```
**Two characteristics define the pattern:**
- Algorithm skeleton in the base class
- Subclasses override specific steps.

![img_22.png](resources/img_22.png)

**Practical Example:** Online Order Processing

Let us work through a second example to reinforce the pattern. This time, we are building an order processing pipeline for an e-commerce platform. Every order goes through the same sequence of steps: validate the order, calculate the total, process the payment, and send a confirmation.

But the details differ based on the order type: standard orders, Prime orders (free shipping, priority processing), and international orders (customs handling, currency conversion).

**Naive Approach:**
We can have a class OrderProcessor having method for each order type which execute all the logics like validation, calculation, payment, confirmation.

Issues:

- Single class handling all types or orders (violating single responsibility principle)
- Dev can add extra step to any particular order type, this will make system to behave different in each order types.
- new order type requires modification in OrderProcessor.

**Efficient Approach:** Template Method.

- Define an abstract class(OrderProcessor) with template method which holds the sequence of method calls.
- It leaves the method as abstract which is dependent on the concrete implementation.
- It defined few methods with empty body, these are Hooks and optional for concretes.
- Define concrete classes(standardOrderProcessor, PrimeOrderProcessor) and override specific behavior.

![img_23.png](resources/img_23.png)

<details>
<summary>View Java Code</summary>

```java
//Here we will define the template method
public abstract class OrderProcessor {
    // template method
    public void processOrder(Order order){
        //specific validation,total calculation and payment processing for each order type
        validateOrder(order);
        double total = calculateTotal(order);
        double payable = applyDiscount(total);
        processPayment(payable);
        sendConfirmation(order);
    }

    protected abstract void validateOrder(Order order);
    protected abstract double calculateTotal(Order order);
    protected abstract void processPayment(double payable);
    //Hook - Optional
    protected double applyDiscount(double total){return total;}
    //common for all
    protected void sendConfirmation(Order order){
        System.out.println("Order confirmation has been sent for order-id: "+order.getOrderId());
    }
}

//Concrete processor with override abstract methods
public class StandarrdOrderProcessor extends OrderProcessor {
    @Override
    protected void validateOrder(Order order) {
        System.out.println("Standard Order Processor: Validating order.");
    }

    @Override
    protected double calculateTotal(Order order) {
        System.out.println("Standard Order Processor: Calculating total");
        double total = 0;
        for(Item item : order.getItems()){
            total += item.getPrice();
        }
        return total;
    }

    @Override
    protected void processPayment(double payable) {
        System.out.println("Standard Order Processor: Processing payment");
    }
}

public class PrimeOrderProcessing extends OrderProcessor{
    @Override
    protected void validateOrder(Order order) {
        System.out.println("PrimeOrder: Validating order.");
    }

    @Override
    protected double calculateTotal(Order order) {
        System.out.println("PrimeOrder: Calculating total");
        double total = 0;
        for(Item item : order.getItems()){
            total += item.getPrice();
        }
        return total;
    }

    @Override
    protected void processPayment(double payable) {
        System.out.println("PrimeOrder: Processing payment");
    }
    //Discount only for prime customer
    @Override
    protected double applyDiscount(double total){
        System.out.println("PrimeOder: Applying 10% Discount");
        return total * 0.9;
    }
}
public class InternationalOrderProcessor extends OrderProcessor{
    @Override
    protected void validateOrder(Order order) {
        System.out.println("International order: Validating order.");
    }

    @Override
    protected double calculateTotal(Order order) {
        System.out.println("International order: Calculating total");
        double total = 0;
        for(Item item : order.getItems()){
            total += item.getPrice();
        }
        // In dollar
        return total/80.00;
    }

    @Override
    protected void processPayment(double payable) {
        System.out.println("International order: Processing payment");
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(List.of(new Item("mac",150000), new Item("charger",10000)));
        Order order = new Order(1001, items);

        OrderProcessor standardOP = new StandarrdOrderProcessor();
        standardOP.processOrder(order);

        OrderProcessor primeOP = new PrimeOrderProcessing();
        primeOP.processOrder(order);

        OrderProcessor internationalOP = new InternationalOrderProcessor();
        internationalOP.processOrder(order);
    }

}

```
</details>

[Home](#Table-of-Contents)
## Chain of Responsibility Design Pattern
This pattern is useful when:
- A request must be handled by one of many possible handlers, and you don’t want the sender to be tightly coupled to any specific one.
- You want to decouple request logic from the code that processes it.
- You want to flexibly add, remove, or reorder handlers without changing the client code.
```text
The Chain of Responsibility Design Pattern is a behavioral pattern that lets you pass requests along a chain of handlers, 
allowing each handler to decide whether to process the request or pass it to the next handler in the chain.
```
handler in the chain can either:
- **Handle** the request and stop the chain
- **Pass** it to the next handler in the chain
- **Handle** the request and then pass it along

![img_24.png](resources/img_24.png)

![img_25.png](resources/img_25.png)

**The Problem:** Handling HTTP Requests

![img_26.png](resources/img_26.png)

Naive Approach: We can have a class RequestHandler having all the logics under a if conditions, if fails return else pass.

Issues:

- Single class holds all the unrelated task operation (violated SRP).
- Adding any new logic required modification in the RequestHandler.

**Efficient Approach:** Chain of Responsibility Pattern, where each handler know about the next handler in the chain.

- Define a Interface(Contract) with method setNextHandler(Handler) and handle(Request).
- Define a base handler as abstract class with a field to hold handler and forward request to next handler, as these are common operations for all handlers.
- Define Concrete handlers, and link them in client to form a chain, each handler do it task and pass to next if required else terminate.

<details>
<summary>View Java Code</summary>

```java
public class Request {
    private String user;
    private String userRole;
    private int reqCount;
    private String payload;
}
```
```java
//Handler Contract
public interface RequestHandler {
    void setNextHandler(RequestHandler handler);
    void handle(Request request);
}
//Base handler have common methods to avoid duplication
public abstract class BaseHandler implements RequestHandler{
    private RequestHandler nextHandler;

    @Override
    public void setNextHandler(RequestHandler handler){
        this.nextHandler = handler;
    }

    public void forward(Request request){
        if(nextHandler != null){
            System.out.println("forwarding request to next handler");
            nextHandler.handle(request);
        }
    }
}
```
```java
//authentication Handler
public class AuthHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getUser() != null){
            System.out.println("Auth completed");
            forward(request);
        }else{
            System.out.println("Auth Denied");
        }
    }
}
//Authorization handler
public class Authzhandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getUserRole().equals("Admin")){
            System.out.println("Authorization Completed");
            forward(request);
        }else{
            System.out.println("Authorization denied");
        }
    }
}
public class RateLimitingHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getReqCount()>5){
            System.out.println("Too Many Request, canceling request");
        }else{
            forward(request);
        }
    }
}
public class DataValidationHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if(request.getPayload() != null){
            System.out.println("Data Validation Successful");
            forward(request);
        }else{
            System.out.println("Data validation failed");
        }
    }
}
public class BussinessLogicHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        System.out.println("Reached Business Logic");
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        //Handlers
        RequestHandler authHandler = new AuthHandler();
        RequestHandler authzHandler = new Authzhandler();
        RequestHandler rateLimitHandler = new RateLimitingHandler();
        RequestHandler dataValidationHandler = new DataValidationHandler();
        RequestHandler bussLogicHandler = new BussinessLogicHandler();

        //Handlers chain building
        authHandler.setNextHandler(authzHandler);
        authzHandler.setNextHandler(rateLimitHandler);
        rateLimitHandler.setNextHandler(dataValidationHandler);
        dataValidationHandler.setNextHandler(bussLogicHandler);

        Request request1 = new Request("pankaj","Admin",4,"knok knok");
        //invoking first member of chain
        authHandler.handle(request1);
    }

}
```
</details>

[Home](#Table-of-Contents)
## Visitor Design Pattern
It’s particularly useful in situations where:
- You have a complex object structure (like ASTs, documents, or UI elements) that you want to perform multiple unrelated operations on.
- You want to add new behaviors to classes without changing their source code.
- You need to perform different actions depending on an object’s concrete type, without resorting to a long chain of if-else or instanceof checks.
```text
The Visitor Design Pattern lets you separate algorithms from the objects on which they operate. 
It enables you to add new operations to a class hierarchy without modifying the classes themselves.

if we add another concrete class (element) then we have to modify all the operation classes, this is a trade off.
```
Two characteristics define the pattern:
- Separation of algorithm and structure.
- **Double dispatch:** The correct method to call is determined by both the type of the element and the type of the visitor. The element calls back the visitor with **this**, which resolves the element's concrete type at runtime.

**Real-World Analogy**:
Think about a home inspection. You have a house with different components: plumbing, electrical wiring, structural framing, and HVAC. Each specialist (a plumber, an electrician, a structural engineer, and an HVAC technician) "visits" the house and inspects only what they understand.

The house does not need to know how to evaluate its own plumbing or wiring. It just opens the door and lets each inspector do their job. Adding a new type of inspection (say, a fire safety audit) does not require remodeling the house. You just bring in a new inspector.

The Visitor pattern works the same way: the elements (house components) accept visitors (inspectors), and new operations are new visitors.
![img_27.png](resources/img_27.png)

**The Problem:** Adding Operations to a Shape Hierarchy, operations are rendering on screen, calculate area, export to SVG and JSON.
It is expected to add new operations/features to the existing object.
**Naive Approach:** Have a class Shape (Element) consist of method for each operation.

Issues:

- Single class handling unrelated operation like rendering and exporting.
- As new addition of new operation are frequent we have to modify the class frequently (open close violation).
- Hard to extend.

**Efficient Approach:** Visitor design pattern.

- Define a contract (Visitor) with containing methods (visitCircle(), visitRectangle()) for each concrete Element(circle, rectangle).
- Create concrete visitors for each operation required (calculation, display) and override each method to support this operation for all elements.
- Here Element is parameterized and calls the visit(this) of visitor (double dispatch).

![img_28.png](resources/img_28.png)

<details>
<summary>View Java Code</summary>

```java
//Element
public interface Shape {
    void accept(ShapeVisitor visitor);
}
//Concrete Element
public class Circle implements Shape {
    private double radius;

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}
public class Rectangle implements Shape {
    private double length;
    private double width;

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitRectangle(this);
    }
}
```
```java
//Visitor contract
public interface ShapeVisitor {
    void visitCircle(Circle circle);
    void visitRectangle(Rectangle rectangle);
}
//Operation on element (circle, Rectangle)
//if we add another shape then we have to modify all the operation classes
public class AreaVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        double radius = circle.getRadius();
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        double length = rectangle.getLength();
        double width = rectangle.getWidth();
        double area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class DisplayVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Displaying Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("Displaying Rectangle with length: " + rectangle.getLength() + " and width: " + rectangle.getWidth());
    }
}
```
```java
public class Client {
    public static void main(String[] args) {

        Shape c1 = new Circle(4.55);
        Shape c2 = new Circle(5.55);
        Shape r1 = new Rectangle(23,233.2);
        Shape r2 = new Rectangle(23,233.2);

        List<Shape> shapes = new ArrayList<>(List.of(c1, c2, r1, r2));

        shapes.forEach(shape -> shape.accept(new AreaVisitor()));

        shapes.forEach(shape -> shape.accept(new DisplayVisitor()));

    }
}
```
</details>

[Home](#Table-of-Contents)
## Mediator Design Pattern
![img_29.png](resources/img_29.png)
```text
The Mediator Pattern promotes loose coupling by centralizing communication between objects. 
Instead of having components refer to and interact with each other directly, they communicate through a mediator.
```
It’s particularly useful in situations where:
- You have a group of tightly coupled classes or UI components that need to communicate.
- Changes in one component require updates in multiple others.
- You want to centralize communication logic to simplify maintenance and testing.

Two characteristics of the pattern:
- Centralized communication. All interaction logic lives in one place: the mediator. Components do not call methods on each other. When a component's state changes, it notifies the mediator, and the mediator coordinates the response.
- Loose coupling between components.

![img_30.png](resources/img_30.png)

**The Problem:** Tightly Coupled UI Components

Imagine you're building a login form with the following UI components:
- A username field
- A password field
- A login button
- A status label

The logic of the form is simple:
The login button should be enabled only when both username and password fields are non-empty.
When the button is clicked, it should attempt login and display the result in the status label.

**Naive Approach:**
One implementation could be button is holding references of each text field and label and each text fields holding reference of button, when any field gets changes, field triggers a validation method of button to each if it can get enabled.

Issues:
- Onboarding of new component (text field) requires changes in button and all the component which communicates to this.
- Tight coupling.

**Efficient Approach:** Mediator design pattern

- Define a contract (Mediator) with a single method to be called by component when changes occur, it holds all the unrelated concrete components.
- Define an Abstract class Component which holds the reference of mediator and a method to notify mediator by passing self reference.
- Mediator acts on each change received and change the state of other components, in this way component doesn't have to communicate directly.

<details>
<summary>View Java Code</summary>

```java
//Component contract
public abstract class UIComponent {
    private UIMediator mediator;
    //after performing the operation concrete component notifies the mediator
    protected void notifyMediator(){
        mediator.componentChange(this);
    }
}

//concrete component
public class TextField extends UIComponent {
    private String text;
    public TextField(UIMediator mediator) {
        super(mediator);
    }

    public void setText(String text){
        this.text = text;
        notifyMediator();
    }
    public String getText(){ return text;}
}

public class Button extends UIComponent {
    private boolean enabled = false;
    public Button(UIMediator mediator) {
        super(mediator);
    }
    public void setEnabled(boolean flag){
        enabled = flag;
        notifyMediator();
    }
    public void click(){
        if(enabled){
            System.out.println("Login Successful");
        }else{
            System.out.println("Login Failed");
        }
        //required to set status of login
        notifyMediator();
    }
    public boolean getEnabled(){return enabled;}
}

public class Label extends UIComponent {
    private String label;
    public Label(UIMediator mediator) {
        super(mediator);
    }
    public void setLabel(String label){
        this.label = label;
        notifyMediator();
    }
    public String getLabel(){return label;}
}
```
```java
//Mediator contract
public interface UIMediator {
    void componentChange(UIComponent component);
}

//Concrete implementation of mediator
public class FormMediator implements UIMediator {
    private TextField username;
    private TextField password;
    private Label label;
    private Button button;

    //For mediator it is expected to know the type of component to perform action
    @Override
    public void componentChange(UIComponent component) {
        if(component == username || component ==password){
            boolean enabled = !StringUtils.isEmpty(username.getText()) && !StringUtils.isEmpty(password.getText());
            button.setEnabled(enabled);
        }else if(component == button){
            if(button.getEnabled()) label.setLabel("Logged In");
            else label.setLabel("Failed Login");
        }
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        FormMediator form = new FormMediator();

        TextField username = new TextField(form);
        TextField pass = new TextField(form);
        Label label = new Label(form);
        Button button = new Button(form);

        form.setButton(button);
        form.setPassword(pass);
        form.setUsername(username);
        form.setLabel(label);

        username.setText("pankaj");
        button.click(); //failed
        pass.setText("122323");
        button.click(); //success
    }
}
```
</details>

[Home](#Table-of-Contents)
## Memento Design pattern

```text
The Memento Design Pattern is a behavioral design pattern that lets you capture and store an object’s internal state so it can be restored later, without violating encapsulation.
```
![img_31.png](resources/img_31.png)

It’s particularly useful in situations where:
- You need to implement undo/redo functionality.
- You want to support checkpointing or versioning of an object’s state.
- You want to separate the concerns of state storage from state management logic.

**The Problem: Implementing Undo in a Text Editor**

Imagine you’re building a simple text editor. The editor supports basic operations like: type(String text), getContent(), undo(String txt)

**Naive Approach:** Client manages the snapshot and whenever required it will call the undo method with snapshot.

Issues:

- Editor exposing the internal state to client directly (Broke Encapsulation).
- Each change in the internal state of editor requires changes in the client to manage the snapshot (adding cursor position).

**Efficient Approach:** Use Memento Pattern.

- Define a Memento class which holds the internals of the originator(document) as a black box.
- Define Caretaker (mementoManager) to store and apply the snapshot on originator (document).
- Define Originator with internal states to hold the state, and 2 methods to create snapshot and apply snapshot.
- client interact with manager(caretaker) to take and restore snapshot.

![img_32.png](resources/img_32.png)

![img_33.png](resources/img_33.png)

<details>
<summary>View Java Code</summary>

```java
public class TextEditorMemento {
    private final String state;
    private final int cursorPosition;
}

public class TextEditorUndoManager {
    Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditor textEditor){
        history.push(textEditor.save());
    }
    public void restore(TextEditor textEditor){
        if(!history.isEmpty())
            textEditor.undo(history.pop());
        else System.out.println("Not have any saved state");
    }
}

public class TextEditor {
    private String txt = "";
    private int cursorPosition = 0;

    public void type(String txt){
        System.out.println("Typed: " + txt);
        this.txt += txt;
        cursorPosition += txt.length();
    }
    public TextEditorMemento save(){
        System.out.println("Taking Snapshot...");
        return new TextEditorMemento(txt,cursorPosition);
    }
    public void undo(TextEditorMemento memento){
        System.out.println("Restoring the Snapshot");
        txt = memento.getState();
        cursorPosition = memento.getCursorPosition();
    }
    public void print(){
        System.out.println("Content: " + txt + ", Cursor Position: " + cursorPosition);
    }
}
```

```java
public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorUndoManager undoManager = new TextEditorUndoManager();

        editor.type("Hello");
        editor.type(" World");

        undoManager.save(editor);

        editor.type("!");

        editor.print();

        undoManager.restore(editor);
        editor.print();

    }
}
```
</details>


#### Prepared by Pankaj