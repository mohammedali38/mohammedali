package application;

public class GradeBookTest 
{
	private GradeBook gradeBookObject1, gradeBookObject2;
	
	@BeforeEach
	void setUp() throws Exception 
		{
			gradeBookObject1 = new GradeBook(5);
			gradeBookObject2 = new GradeBook(5);

			gradeBookObject1.addScore(45);
			gradeBookObject1.addScore(71);
			gradeBookObject1.addScore(98);
		
			gradeBookObject2.addScore(87);
			gradeBookObject2.addScore(22);
			gradeBookObject2.addScore(66);
			gradeBookObject2.addScore(12);
		}

	@AfterEach
	void tearDown() throws Exception 
		{
			gradeBookObject1 = null;
			gradeBookObject2 = null;
		}

	@Test
	void testAddScore() 
		{
			assertTrue(gradeBookObject1.toString().equals("45.0 71.0 98.0 "));
			assertTrue(gradeBookObject2.toString().equals("87.0 22.0 66.0 12.0 "));
			assertEquals(3, gradeBookObject1.getScoreSize(), 0.001);
			assertEquals(4, gradeBookObject2.getScoreSize(), 0.001);
		}

	@Test
	void testSum() 
		{
			assertEquals(214, gradeBookObject1.sum(), .0001);
			assertEquals(187, gradeBookObject2.sum(), .0001);
		}

	@Test
	void testMinimum() 
		{
			assertEquals(45, gradeBookObject1.minimum(), 0.001);
			assertEquals(12, gradeBookObject2.minimum(), 0.001);
		}

	@Test
	void testFinalScore() 
		{
			assertEquals(169, gradeBookObject1.finalScore(), 0.0001);
			assertEquals(175, gradeBookObject2.finalScore(), 0.0001);
		}
	
	
	
	
	
	
	
	
	
}
