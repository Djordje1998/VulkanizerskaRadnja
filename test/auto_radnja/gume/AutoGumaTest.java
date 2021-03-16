package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	
	private AutoGuma a;

	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	void testAutoGuma() {
		assertNotNull(a);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		a.setMarkaModel("Micheline");
		a.setPrecnik(15);
		a.setSirina(250);
		a.setVisina(50);
		
		assertNotNull(a);
		assertEquals("Micheline", a.getMarkaModel());
		assertEquals(15, a.getPrecnik());
		assertEquals(250, a.getSirina());
		assertEquals(50, a.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("MichelineWinter");
		assertEquals("MichelineWinter", a.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,
				()->a.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelMinLength() {
		assertThrows(java.lang.RuntimeException.class,
				()->a.setMarkaModel("AT"));
	}

	@ParameterizedTest
	@CsvSource({
		"13","14","15","16","17","18","19","20","21","22",
	})
	void testSetPrecnik(int precnik) {
		a.setPrecnik(precnik);
		assertEquals(precnik, a.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({
		"10","11","12","23","24"
	})
	void testSetPrecnikVanOpsega(int precnik) {
		assertThrows(java.lang.RuntimeException.class, 
				()->a.setPrecnik(precnik));
	}

	@ParameterizedTest
	@CsvSource({
		"135","136","200","250","300","350","354","355"
	})
	void testSetSirina(int sirina) {
		a.setSirina(sirina);
		assertEquals(sirina, a.getSirina());
	}

	@ParameterizedTest
	@CsvSource({
		"1","100","134","356","400","1000"
	})
	void testSetSirinaVanOpsega(int sirina) {
		assertThrows(java.lang.RuntimeException.class, 
				()-> a.setSirina(sirina));
	}
	
	@ParameterizedTest
	@CsvSource({
		"25","30","50","60","90","95"
	})
	void testSetVisina(int visina) {
		a.setVisina(visina);
		assertEquals(visina, a.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"1","23","24","96","97","100"
	})
	void testSetVisinaVanOpsega(int visina) {
		assertThrows(java.lang.RuntimeException.class, 
				()-> a.setVisina(visina));
	}

	@Test
	void testToString() {
		a.setMarkaModel("Micheline");
		a.setPrecnik(15);
		a.setSirina(250);
		a.setVisina(50);
		String guma = a.toString();
		assertTrue(guma.contains("Micheline"));
		assertTrue(guma.contains("15"));
		assertTrue(guma.contains("250"));
		assertTrue(guma.contains("50"));
	}

	@ParameterizedTest
	@CsvSource({
		"Micheline, 15, 250, 50, Micheline, 15, 250, 50, true",
		"MichelineF, 15, 250, 50, Micheline, 15, 250, 50, false",
		"Micheline, 16, 250, 50, Micheline, 15, 250, 50, false",
		"Micheline, 15, 251, 50, Micheline, 15, 250, 50, false",
		"Micheline, 15, 250, 51, Micheline, 15, 250, 50, false",
		"MichelineF, 16, 251, 51, Micheline, 15, 250, 50, false"	
	})
	void testEqualsObject(String model1,int p1, int s1, int v1,String model2,int p2, int s2,int v2, boolean ispravnost) {
		a.setMarkaModel(model1);
		a.setPrecnik(p1);
		a.setSirina(s1);
		a.setVisina(v1);
		AutoGuma b = new AutoGuma(model2,p2,s2,v2);
		assertTrue(ispravnost==b.equals(a));
	}

}
