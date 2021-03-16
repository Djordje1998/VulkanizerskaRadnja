package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected VulkanizerskaRadnja vulkanizerskaRadnja;
	
	@Test
	void testDodajGumu() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Micheline");
		a.setPrecnik(15);
		a.setSirina(250);
		a.setVisina(50);
		vulkanizerskaRadnja.dodajGumu(a);
		
		LinkedList<AutoGuma> gume = vulkanizerskaRadnja.pronadjiGumu("Micheline");
		assertEquals(1, gume.size());
		assertEquals(a, gume.get(0));
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, 
				()->vulkanizerskaRadnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Micheline");
		a.setPrecnik(15);
		a.setSirina(250);
		a.setVisina(50);
		vulkanizerskaRadnja.dodajGumu(a);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel("Micheline");
		b.setPrecnik(15);
		b.setSirina(250);
		b.setVisina(50);
		
		assertThrows(java.lang.RuntimeException.class, 
				()-> vulkanizerskaRadnja.dodajGumu(b));
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Micheline");
		a.setPrecnik(15);
		a.setSirina(250);
		a.setVisina(50);
		vulkanizerskaRadnja.dodajGumu(a);
		
		LinkedList<AutoGuma> gume = vulkanizerskaRadnja.pronadjiGumu("Micheline");
		assertEquals(1, gume.size());
		assertEquals(a, gume.get(0));
	}
	
	@Test
	void testPronadjiGumuNepostojeca() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Micheline");
		a.setPrecnik(15);
		a.setSirina(250);
		a.setVisina(50);
		vulkanizerskaRadnja.dodajGumu(a);
		AutoGuma b = new AutoGuma();
		b.setMarkaModel("Tigar");
		b.setPrecnik(16);
		b.setSirina(251);
		b.setVisina(51);
		
		LinkedList<AutoGuma> gume = vulkanizerskaRadnja.pronadjiGumu("Tigar");
		assertEquals(0, gume.size());
	}
	
	@Test
	void testPronadjiGumuDrugeDimenzije() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("Micheline");
		a.setPrecnik(15);
		a.setSirina(250);
		a.setVisina(50);
		vulkanizerskaRadnja.dodajGumu(a);
		AutoGuma b = new AutoGuma();
		b.setMarkaModel("Micheline");
		b.setPrecnik(16);
		b.setSirina(251);
		b.setVisina(51);
		vulkanizerskaRadnja.dodajGumu(b);
		AutoGuma c = new AutoGuma();
		c.setMarkaModel("Micheline");
		c.setPrecnik(17);
		c.setSirina(252);
		c.setVisina(52);
		vulkanizerskaRadnja.dodajGumu(c);
		
		LinkedList<AutoGuma> gume = vulkanizerskaRadnja.pronadjiGumu("Micheline");
		assertEquals(3, gume.size());
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertNull(vulkanizerskaRadnja.pronadjiGumu(null));
	}
	
}
