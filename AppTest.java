

import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class AppTest 
{
    
  App a1=new App();
  
  @Test
  public void sadAdd()
  {
	 int a=3,b=4;
	 Assertions.assertEquals(7, a1.add(a, b));
  }
}
