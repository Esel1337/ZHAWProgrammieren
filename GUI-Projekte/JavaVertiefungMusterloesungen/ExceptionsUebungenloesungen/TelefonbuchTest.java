package ExceptionsUebungenloesungen;


import org.junit.*;

public class TelefonbuchTest {
  
  private Telefonbuch t;

  @Before
  public void setUp() throws Exception {
    t = new Telefonbuch();
  }

  @Test
  public void testAddEntry() {
    
    try {
      t.addEntry("Zora", "123123");
      t.addEntry("Alfons", "987987");
      t.addEntry("", "23423");
      Assert.fail("Exception nicht aufgetreten");
    } catch (NotValidEntryException e) {
      System.out.println("Exception aufgetreten");
      Assert.assertEquals("ein parameter ist null oder leer",
          e.getMessage());
    }
    
    Assert.assertEquals("987987", t.getNumber("Alfons"));
    Assert.assertEquals("123123", t.getNumber("Zora"));
    
  }
  
  @After
  public void tearDown() throws Exception {
    t = null;
  }

}
