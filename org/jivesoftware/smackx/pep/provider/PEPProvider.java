package org.jivesoftware.smackx.pep.provider;

import java.util.HashMap;
import java.util.Map;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.xmlpull.v1.XmlPullParser;

public class PEPProvider extends ExtensionElementProvider<ExtensionElement> {
    private static final Map<String, ExtensionElementProvider<?>> nodeParsers;

    static {
        nodeParsers = new HashMap();
    }

    public static void registerPEPParserExtension(String str, ExtensionElementProvider<?> extensionElementProvider) {
        nodeParsers.put(str, extensionElementProvider);
    }

    public ExtensionElement parse(XmlPullParser xmlPullParser, int i) {
        ExtensionElement extensionElement = null;
        Object obj = null;
        while (obj == null) {
            Object obj2;
            int next = xmlPullParser.next();
            if (next != 2) {
                if (next == 3 && xmlPullParser.getName().equals("event")) {
                    obj2 = 1;
                }
                obj2 = obj;
            } else if (xmlPullParser.getName().equals("event")) {
                obj2 = obj;
            } else {
                if (xmlPullParser.getName().equals("items")) {
                    ExtensionElementProvider extensionElementProvider = (ExtensionElementProvider) nodeParsers.get(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "node"));
                    extensionElement = extensionElementProvider != null ? (ExtensionElement) extensionElementProvider.parse(xmlPullParser) : extensionElement;
                    obj2 = obj;
                }
                obj2 = obj;
            }
            obj = obj2;
        }
        return extensionElement;
    }
}
