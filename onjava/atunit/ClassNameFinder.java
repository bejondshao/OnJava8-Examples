// onjava/atunit/ClassNameFinder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java atunit.ClassNameFinder}
package atunit;
import java.io.*;
import java.nio.file.*;
import java.util.*;


public class ClassNameFinder {
  public static String thisClass(byte[] classBytes) {
    Map<Integer,Integer> offsetTable = new HashMap<>();
    Map<Integer,String> classNameTable =
      new HashMap<>();
    try {
      DataInputStream data = new DataInputStream(
        new ByteArrayInputStream(classBytes));
      int magic = data.readInt();  // 0xcafebabe
      int minorVersion = data.readShort();
      int majorVersion = data.readShort();
      int constantPoolCount = data.readShort();
      int[] constantPool = new int[constantPoolCount];
      for(int i = 1; i < constantPoolCount; i++) {
        int tag = data.read();
        // int tableSize;
        switch(tag) {
          case 1: // UTF
            int length = data.readShort();
            char[] bytes = new char[length];
            for(int k = 0; k < bytes.length; k++)
              bytes[k] = (char)data.read();
            String className = new String(bytes);
            classNameTable.put(i, className);
            break;
          case 5: // LONG
          case 6: // DOUBLE
            data.readLong(); // discard 8 bytes
            i++; // Special skip necessary
            break;
          case 7: // CLASS
            int offset = data.readShort();
            offsetTable.put(i, offset);
            break;
          case 8: // STRING
            data.readShort(); // discard 2 bytes
            break;
          case 3:  // INTEGER
          case 4:  // FLOAT
          case 9:  // FIELD_REF
          case 10: // METHOD_REF
          case 11: // INTERFACE_METHOD_REF
          case 12: // NAME_AND_TYPE
          case 18: // Invoke Dynamic
            data.readInt(); // discard 4 bytes
            break;
          case 15: // Method Handle
            data.readByte();
            data.readShort();
            break;
          case 16: // Method Type
            data.readShort();
            break;
          default:
            throw
              new RuntimeException("Bad tag " + tag);
        }
      }
      short accessFlags = data.readShort();
      String access = (accessFlags & 0x0001) == 0 ?
        "nonpublic:" : "public:";
      int thisClass = data.readShort();
      int superClass = data.readShort();
      return access + classNameTable.get(
        offsetTable.get(thisClass)).replace('/', '.');
    } catch(IOException | RuntimeException e) {
      throw new RuntimeException(e);
    }
  }
  // Demonstration:
  public static void
  main(String[] args) throws Exception {
    PathMatcher matcher = FileSystems.getDefault()
      .getPathMatcher("glob:**/*.class");
    // Walk the entire tree:
    Files.walk(Paths.get("."))
      .filter(matcher::matches)
      .map(p -> {
          try {
            return thisClass(Files.readAllBytes(p));
          } catch(Exception e) {
            throw new RuntimeException(e);
          }
        })
      .filter(s -> s.startsWith("public:"))
      // .filter(s -> s.indexOf('$') >= 0)
      .map(s -> s.split(":")[1])
      .filter(s -> !s.startsWith("enums."))
      .filter(s -> s.contains("."))
      .forEach(System.out::println);
  }
}
/* Output:
ArrayShow
atunit.AtUnit$TestMethods
atunit.AtUnit
atunit.ClassNameFinder
atunit.Test
atunit.TestObjectCleanup
atunit.TestObjectCreate
atunit.TestProperty
BasicSupplier
CollectionMethodDifferences
ConvertTo
Count$Boolean
Count$Byte
Count$Character
Count$Double
Count$Float
Count$Integer
Count$Long
Count$Pboolean
Count$Pbyte
Count$Pchar
Count$Pdouble
Count$Pfloat
Count$Pint
Count$Plong
Count$Pshort
Count$Short
Count
CountingIntegerList
CountMap
Countries
Enums
FillMap
HTMLColors
MouseClick
Nap
Null
Operations
OSExecute
OSExecuteException
Pair
ProcessFiles$Strategy
ProcessFiles
Rand$Boolean
Rand$Byte
Rand$Character
Rand$Double
Rand$Float
Rand$Integer
Rand$Long
Rand$Pboolean
Rand$Pbyte
Rand$Pchar
Rand$Pdouble
Rand$Pfloat
Rand$Pint
Rand$Plong
Rand$Pshort
Rand$Short
Rand$String
Rand
Range
Repeat
RmDir
Sets
Stack
Suppliers
TimedAbort
Timer
Tuple
Tuple2
Tuple3
Tuple4
Tuple5
TypeCounter
*/
