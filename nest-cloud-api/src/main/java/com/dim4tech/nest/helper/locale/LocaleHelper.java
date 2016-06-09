package com.dim4tech.nest.helper.locale;

import java.util.Locale;

public class LocaleHelper {
    public static Locale convertLocale(Locale locale) {
        if (isLanguageTag(locale)) {
            return Locale.forLanguageTag(locale.toString());
        }
        return locale;
    }

    private static boolean isLanguageTag(Locale locale) {
        return locale.toString() != null && locale.toString().contains("-");
    }
}
