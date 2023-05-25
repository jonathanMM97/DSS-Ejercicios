package creditCardTest.jonathan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import creditCardTest.jonathan.core.CreditCard;

@SpringBootTest
class TestAutoCreditCard {

	@Test
	public void testIsValid()
	{
		LocalDate expirationDate = LocalDate.of(2023,06,07);
		CreditCard c = new CreditCard("1234567890123456", "John Doe", expirationDate, 123, 5000.0);//Si compila perfectamente pasa el test.
		try{
			c = new CreditCard("1234567890123456", "Pepe", LocalDate.now().minusDays(3), 325, 2000.0);
			c.isValid();
		}catch(IllegalArgumentException e)
		{
			assertEquals(e.getMessage(), "La tarjeta ha expirado.");
		}
	}

	@Test
	public void testCharge()
	{
		LocalDate expirationDate = LocalDate.of(2023,06,07);
		CreditCard c = new CreditCard("1234567890123456", "John Doe", expirationDate, 123, 5000.0);//Si compila perfectamente pasa el test.
		
		String request = "";
		double amount = 5000.0;

		request = c.charge(amount);//llamamos al metodo por primera vez para que no lance una excepcion si hay alguna excepcion el test fallaria

		assertEquals(request, "Cantidad ingresada: $" + amount);

		try{
			request = c.charge(-200);//error en la cantidad
		}catch(IllegalArgumentException e)
		{
			assertEquals(e.getMessage(), "Cantidad introducida no valida.");
		}

		try{
			request = c.charge(100);//limite de credito superado
		}catch(IllegalArgumentException e)
		{
			assertEquals(e.getMessage(), "Limite de credito superado.");
		}
	}

	@Test
	public void testMakePayment()
	{
		LocalDate expirationDate = LocalDate.of(2023,06,07);
		CreditCard c = new CreditCard("1234567890123456", "John Doe", expirationDate, 123, 5000.0);//Si compila perfectamente pasa el test.
		
		String request = "";
		double amount = 5000.0;

		request = c.charge(amount);

		request = c.makePayment(amount);//dejamos el saldo a 0 (Opcion valida)

		assertEquals(request, "Cantidad retirada: $" + amount);

		try{
			request = c.makePayment(-200);//cantidad no valida
		}catch(IllegalArgumentException e)
		{
			assertEquals(e.getMessage(), "Cantidad introducida no valida.");
		}

		try{
			request = c.makePayment(amount);//saldo insuficiente
		}catch(IllegalArgumentException e)
		{
			assertEquals(e.getMessage(), "No hay suficiente saldo.");
		}
	}

	@Test
	public void testGet()
	{
		LocalDate expirationDate = LocalDate.of(2023,06,07);
		CreditCard c = new CreditCard("1234567890123456", "John Doe", expirationDate, 123, 5000.0);//Si compila perfectamente pasa el test.
		
		assertEquals(c.getCardNumber(), "1234567890123456");
		assertEquals(c.getCardHolderName(), "John Doe");
		assertEquals(c.getExpirationDate(), LocalDate.of(2023,06,07));
		assertEquals(c.getCvv(), 123);
		assertEquals(c.getCreditLimit(), 5000.0);
	}

	@Test
	public void testSet()
	{
		LocalDate expirationDate = LocalDate.of(2023,9,07);
		CreditCard c = new CreditCard("0004567890123456", "Jonathan", expirationDate, 789, 1000.0);//Si compila perfectamente pasa el test.
		
		c.setCardNumber("1234567890123456");
		assertEquals(c.getCardNumber(), "1234567890123456");

		c.setCardHolderName("John Doe");
		assertEquals(c.getCardHolderName(), "John Doe");

		c.setExpirationDate(LocalDate.of(2023,06,07));
		assertEquals(c.getExpirationDate(), LocalDate.of(2023,06,07));

		c.setCvv(123);
		assertEquals(c.getCvv(), 123);

		c.setCreditLimit(5000.0);
		assertEquals(c.getCreditLimit(), 5000.0);
	}

}
