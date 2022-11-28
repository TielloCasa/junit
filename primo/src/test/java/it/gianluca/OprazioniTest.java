package it.gianluca;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OprazioniTest{

	Operazione op;
	
	@BeforeAll
	static void printAll() {
		System.out.println("I'm gonna print all MF");
	}
	
	
	@BeforeEach		//lo fa tutte le volte prima che un test parta
	void init() {
		op = new Operazione();
		//System.out.println("I have instanced the class");
	}
	
	
	@Test
	@DisplayName("Test per l'addizione")
	@Tag("Math")
	void AddTest() {
		assumeTrue(true); //if is false, dont continue the test
		assertEquals(2, op.add(1, 1));
	}
	
	@Test
	@DisplayName("Test che fallisce")
	@Disabled
	@Tag("Prova")
	void disabled() {
		fail("mannagia");
	}
	
	@Test
	@DisplayName("Test multpli")
	@Tag("Math")
	void multpleTest() {
		
		assertAll(
				()-> assertEquals(2, op.add(1, 1)),
				()-> assertEquals(0, op.sott(1, 1)),
				()-> assertEquals(1, op.molt(1, 1))
				);
	}
	
	@RepeatedTest(3)
	@Tag("Prova")
	void reapet(RepetitionInfo repettionInfo) {
		System.out.println(repettionInfo.getCurrentRepetition());
	}
	 /*
	 @DisplayName("test") ci dà la possibilità di dare un nome al nostro test
	 @Disabled posso disabiltare momentaneamente un test
	 */
	
	
	/*
	 assumption, se usaimo qeusti costrutti diciamo a junit:
	 -se questa cosa è falsa non continuare col test
	*/
	
	//assertAll take all these assert that a give you and control if there is a problem
	
	/*
	 @BeforeAll		//fai questa funzione prima di qualsiasi cosa ci sia(has to be static)
	 @AfterAll		//fai questa cosa dopo qualsiasi cosa ci sia(has to be static)
	 @BeforeEach  //fai questa funzione prima che partano le altre
	 @AfterEach   //fai dopo che ppartano le altre*/
	
	/*
	 @TestInstance(TestInstance.Lifecycle.PER_METHOD)
	 in questo modo vado a creare un istanza del test per ogni metodo al suo interno
	 in più non abbiamo bisgno dei metodi statici con i BeforeAll
	 
	 @TestInstance(TestInstance.Lifecycle.PER_CLASS)
	 un istanza per classe, not matter how many method you have */
	
	//@RepeatedTest
	// ci permette di ripetere un test a couple of time
	//RepetitionInfo invece, è un oggetto che possiamo craere che ci da
	//tutte le info sulla ripetizione della classe
	
	//@Tag("nome")
	//ci permette di dare dei tag ai test
	//grazie a questa feature possiamo gestire i test tramite i tag nel pom, configuration
	
	//TestInfo e TestReporter
	//class that we can used just like the repetitioninfo
}
