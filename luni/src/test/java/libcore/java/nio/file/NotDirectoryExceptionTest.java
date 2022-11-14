/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package libcore.java.nio.file;

import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.NotDirectoryException;
import libcore.libcore.util.SerializationTester;

public class NotDirectoryExceptionTest extends TestCase {
    public void test_constructor$String() {
        NotDirectoryException exception = new NotDirectoryException("file");
        assertEquals("file", exception.getFile());
        assertNull(exception.getOtherFile());
        assertNull(exception.getReason());

        assertTrue(exception instanceof FileSystemException);
    }

    public void test_serialization() throws IOException, ClassNotFoundException {
        String hex = "ACED0005737200236A6176612E6E696F2E66696C652E4E6F744469726563746F7279457863657"
                + "074696F6E82F0DF36F87CE379020000787200216A6176612E6E696F2E66696C652E46696C6553797"
                + "374656D457863657074696F6ED598F27876D360FC0200024C000466696C657400124C6A6176612F6"
                + "C616E672F537472696E673B4C00056F7468657271007E0002787200136A6176612E696F2E494F457"
                + "863657074696F6E6C8073646525F0AB020000787200136A6176612E6C616E672E457863657074696"
                + "F6ED0FD1F3E1A3B1CC4020000787200136A6176612E6C616E672E5468726F7761626C65D5C635273"
                + "977B8CB0300044C000563617573657400154C6A6176612F6C616E672F5468726F7761626C653B4C0"
                + "00D64657461696C4D65737361676571007E00025B000A737461636B547261636574001E5B4C6A617"
                + "6612F6C616E672F537461636B5472616365456C656D656E743B4C001473757070726573736564457"
                + "863657074696F6E737400104C6A6176612F7574696C2F4C6973743B787071007E0009707572001E5"
                + "B4C6A6176612E6C616E672E537461636B5472616365456C656D656E743B02462A3C3CFD223902000"
                + "07870000000097372001B6A6176612E6C616E672E537461636B5472616365456C656D656E746109C"
                + "59A2636DD8502000449000A6C696E654E756D6265724C000E6465636C6172696E67436C617373710"
                + "07E00024C000866696C654E616D6571007E00024C000A6D6574686F644E616D6571007E000278700"
                + "000002574002F6C6962636F72652E6A6176612E6E696F2E66696C652E4E6F744469726563746F727"
                + "9457863657074696F6E5465737474001E4E6F744469726563746F7279457863657074696F6E54657"
                + "3742E6A617661740012746573745F73657269616C697A6174696F6E7371007E000CFFFFFFFE74001"
                + "86A6176612E6C616E672E7265666C6563742E4D6574686F6474000B4D6574686F642E6A617661740"
                + "006696E766F6B657371007E000C000000F9740028766F6761722E7461726765742E6A756E69742E4"
                + "A756E69743324566F6761724A556E69745465737474000B4A756E6974332E6A61766174000372756"
                + "E7371007E000C00000063740020766F6761722E7461726765742E6A756E69742E4A556E697452756"
                + "E6E657224317400104A556E697452756E6E65722E6A61766174000463616C6C7371007E000C00000"
                + "05C740020766F6761722E7461726765742E6A756E69742E4A556E697452756E6E657224317400104"
                + "A556E697452756E6E65722E6A61766174000463616C6C7371007E000C000000ED74001F6A6176612"
                + "E7574696C2E636F6E63757272656E742E4675747572655461736B74000F4675747572655461736B2"
                + "E6A61766174000372756E7371007E000C0000046D7400276A6176612E7574696C2E636F6E6375727"
                + "2656E742E546872656164506F6F6C4578656375746F72740017546872656164506F6F6C457865637"
                + "5746F722E6A61766174000972756E576F726B65727371007E000C0000025F74002E6A6176612E757"
                + "4696C2E636F6E63757272656E742E546872656164506F6F6C4578656375746F7224576F726B65727"
                + "40017546872656164506F6F6C4578656375746F722E6A61766174000372756E7371007E000C00000"
                + "2F97400106A6176612E6C616E672E54687265616474000B5468726561642E6A61766174000372756"
                + "E7372001F6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794C6973747AB817B43"
                + "CA79EDE02000078707874000466696C6570";
        NotDirectoryException exception = (NotDirectoryException) SerializationTester
                .deserializeHex(hex);

        String hex1 = SerializationTester.serializeHex(exception).toString();
        assertEquals(hex, hex1);
        assertEquals("file", exception.getFile());
        assertNull(exception.getOtherFile());
        assertNull(exception.getReason());
    }
}
