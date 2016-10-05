package org.imie.test;

import static org.junit.Assert.*;

import org.imie.ISerialiser;
import org.imie.Jeux;
import org.imie.Serialiser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestLoadTennisMockito {

	@Mock
	private ISerialiser serialiser;
	
	private Jeux jeux;
	
	@Before
	public void setUp() throws Exception {
		jeux= new Jeux();
		jeux.setSerialiser(serialiser);
	}

	@Test
	public void testUnitaireResetMockito() {
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		jeux.marquerJoueur2();
		jeux.marquerJoueur2();

		jeux.save();
		jeux.reset();
		//
		assertEquals("0-0", jeux.getScore());
		verify(serialiser).persist(any(Jeux.class));
	}
	
	@Test
	public void testUnitaireLoadMockito() {
		Jeux savedJeux = new Jeux();
		savedJeux.marquerJoueur1();
		savedJeux.marquerJoueur1();
		savedJeux.marquerJoueur2();
		savedJeux.marquerJoueur2();
	
		when(serialiser.read()).thenReturn(savedJeux);
		
		jeux.marquerJoueur1();
		jeux.marquerJoueur1();
		jeux.marquerJoueur2();
		jeux.marquerJoueur2();
		jeux.save();
		jeux.reset();
		jeux.load();
		assertEquals("30-30", jeux.getScore());
	}

}
