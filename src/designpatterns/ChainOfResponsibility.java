package designpatterns;





public class ChainOfResponsibility 
{
	public static void main(String[] args) 
	{
		// Setup Chain of Responsibility
		Handler h1 = new ConcreteHandlerOne();
		Handler h2 = new ConcreteHandlerTwo();
		Handler h3 = new ConcreteHandlerThree();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);

		// Send requests to the chain
		h1.handleRequest(new Request("Negative Value ", -1));
		h1.handleRequest(new Request("Zero Value ",  0));
		h1.handleRequest(new Request("Positive Value ",  1));
		h1.handleRequest(new Request("Positive Value ",  2));
		h1.handleRequest(new Request("Negative Value ", -5));	    
	}
}
