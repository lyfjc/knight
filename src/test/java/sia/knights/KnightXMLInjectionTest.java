package sia.knights;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sia.knights.Knight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
/*
If you omit both the locations and the value attributes from the @ContextConfiguration annotation,
 the TestContext framework tries to detect a default XML resource location. Specifically,
  GenericXmlContextLoader and GenericXmlWebContextLoader detect a default
   location based on the name of the test class. If your class is named com.example.MyTest,
    GenericXmlContextLoader loads your application context from
    "classpath:com/example/MyTest-context.xml"
 */
//@ContextConfiguration("KnightXMLInjectionTest-context.xml")
//@ContextConfiguration("/sia/knights/KnightXMLInjectionTest-context.xml")
/*
A plain or relative path (for example, context.xml) is treated as
a classpath resource that is relative to the package in which the test class is defined.
A path starting with a slash is treated as an absolute classpath location (for example,
 /org/example/config.xml). A path that represents a resource URL
 (i.e., a path prefixed with classpath:, file:, http:, etc.) is used as is.
 */
public class KnightXMLInjectionTest {

  @Autowired
  Knight knight;

  @Autowired
  FakePrintStream printStream;

  @After
  public void clearPrintStream() {
    printStream.clear();
  }

  @Test
  public void shouldInjectKnightWithSlayDragonQuest() {
    knight.embarkOnQuest();
    assertEquals(
        "Fa la la, the knight is so brave!\n" +
        "Embarking on quest to slay the dragon!\n" +
        "Tee hee hee, the brave knight did embark on a quest!\n", 
        printStream.getPrintedString());
  }

}
