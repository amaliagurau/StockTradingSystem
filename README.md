# StockTradingSystem

Singleton Pattern:
Motivation:
The StockManager and UserManager classes use the Singleton pattern, ensuring that there is only one instance of these classes throughout the application.
This is beneficial for centralizing control and managing resources, especially when dealing with entities like stocks and users.

Strategy Pattern:
Motivation:
The Strategy pattern is applied in the TradingStrategy interface and its implementations (DayTradingStrategy and LongTermInvestingStrategy).
It allows different trading strategies to be defined and easily interchanged without modifying the client code (in this case, the TradeManager).

Observer Pattern:
Motivation:
The Observer pattern is used to implement a simple stock price notification mechanism in the StockObserver, StockSubject, and StockObserverImpl classes.
It enables stock observers to receive updates when the price of a stock changes.

Other Design Considerations:

Encapsulation:
The code emphasizes encapsulation by providing methods to interact with objects and hiding internal details.
For example, users interact with stocks through the StockManager, and the implementation details of stocks are encapsulated within the Stock class.

Composition:
Composition is used to create higher-level entities by combining simpler objects, such as the composition of Portfolio within the User class.
The TradeManager class uses composition to include a TradingStrategy and execute trades accordingly.
