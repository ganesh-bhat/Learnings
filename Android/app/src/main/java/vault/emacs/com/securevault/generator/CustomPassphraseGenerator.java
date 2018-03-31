package vault.emacs.com.securevault.generator;

import android.util.Log;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ganes on 27-05-2017.
 */

public class CustomPassphraseGenerator {

    private static final String TAG = "PassphraseGen";

    public static enum PhraseWalkAlgorithm {
        FIBONACCI, PRIME_NUMBER, ODD_NUMBER, EVEN_NUMBER, ODD_EVEN, UPPERCASE_ALONE;
    }

    public static class PassphraseGeneratorParam {
        int uppercaseCharCount;
        int lowercaseCharCount;
        int digitCount;
        int specialCharCount;
        String fixedSpecialCharSet;
        int passwordLength;
        String customPhraseToInclude;
        boolean useOnlyCustomPhrase;
        PhraseWalkAlgorithm phraseWalkAlgorithm;


        public void setUppercaseCharCount(int uppercaseCharCount) {
            this.uppercaseCharCount = uppercaseCharCount;
        }

        public void setLowercaseCharCount(int lowercaseCharCount) {
            this.lowercaseCharCount = lowercaseCharCount;
        }

        public void setDigitCount(int digitCount) {
            this.digitCount = digitCount;
        }

        public void setSpecialCharCount(int specialCharCount) {
            this.specialCharCount = specialCharCount;
        }

        public void setPasswordLength(int passwordLength) {
            this.passwordLength = passwordLength;
        }

        public void setFixedSpecialCharSet(String fixedSpecialCharSet) {
            this.fixedSpecialCharSet = fixedSpecialCharSet;
        }
    }

    public static String generatePassword(final PassphraseGeneratorParam param) {
        if (param == null) {
            //just run the default password generation, this case shouldnt happen, but this is our fallback mechansim
            Log.e(TAG, "Passphrase generator received an null param input, henece generating default password");
            List<CharacterRule> rules = Arrays.asList(
                    // at least one upper-case character
                    new CharacterRule(EnglishCharacterData.UpperCase, 1),

                    // at least one lower-case character
                    new CharacterRule(EnglishCharacterData.LowerCase, 1),

                    // at least one digit character
                    new CharacterRule(EnglishCharacterData.Digit, 1),

                    // at least one symbol (special character)
                    new CharacterRule(EnglishCharacterData.Special, 1));

            PasswordGenerator generator = new PasswordGenerator();
            // Generated password is 12 characters long, which complies with policy
            String password = generator.generatePassword(8, rules);
            return password;
        }

        if(param.useOnlyCustomPhrase) {
            return generateUsingUserAlgorithm(param);
        }

        List<CharacterRule> rules = new ArrayList<>();
        if (param.digitCount > 0) {
            rules.add(new CharacterRule(EnglishCharacterData.Digit, param.digitCount));
        }

        if (param.lowercaseCharCount > 0) {
            rules.add(new CharacterRule(EnglishCharacterData.LowerCase, param.lowercaseCharCount));
        }

        if (param.uppercaseCharCount > 0) {
            rules.add(new CharacterRule(EnglishCharacterData.UpperCase, param.uppercaseCharCount));
        }

        if (param.fixedSpecialCharSet == null || param.fixedSpecialCharSet.length() <= 0) {
            //no excluded special chars
            if (param.specialCharCount > 0) {

                CharacterRule defaultSpecialCharSet = new CharacterRule(new CharacterData() {
                    String allChars = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

                    @Override
                    public String getErrorCode() {
                        return "ERR_SPECIAL_CHARS";
                    }

                    @Override
                    public String getCharacters() {
                        return allChars;
                    }
                }, param.specialCharCount);

                rules.add(defaultSpecialCharSet);
            }
        } else {
            //fixed set of special chars
            CharacterRule customizedSpecialCharSet = new CharacterRule(new CharacterData() {

                @Override
                public String getErrorCode() {
                    return "ERR_SPECIAL_CHARS";
                }

                @Override
                public String getCharacters() {
                    return param.fixedSpecialCharSet;
                }
            }, param.specialCharCount);

            rules.add(customizedSpecialCharSet);
        }

        if (param.passwordLength <= 0) {
            //set default length of 8
            param.passwordLength = 8;

        }

        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(param.passwordLength, rules);

        return password;

    }

    private static String generateUsingUserAlgorithm(PassphraseGeneratorParam param) {
        StringBuilder sb = new StringBuilder();
        char currentChar;


        int index = 0;
        switch(param.phraseWalkAlgorithm) {
            case EVEN_NUMBER:
                index = 0;
            case ODD_NUMBER:
                index = 1;
                while(sb.length()<param.passwordLength){
                    if(index >= param.customPhraseToInclude.length()) {
                        index = index % param.customPhraseToInclude.length();
                    }
                    currentChar = param.customPhraseToInclude.charAt(index);
                    sb.append(currentChar);
                    index+=2;
                }
                break;
            case FIBONACCI:
                int first = 1;
                int second = 1;

                index = first;
                while(sb.length()<param.passwordLength){
                    if(index >= param.customPhraseToInclude.length()) {
                        index = index % param.customPhraseToInclude.length();
                    }
                    currentChar = param.customPhraseToInclude.charAt(index);
                    sb.append(currentChar);

                    first = second;
                    second = first+second;
                    index=second;
                }
                break;
            case PRIME_NUMBER:
                index =1;
                while(sb.length()<param.passwordLength){
                    if(index >= param.customPhraseToInclude.length()) {
                        index = index % param.customPhraseToInclude.length();
                    }
                    currentChar = param.customPhraseToInclude.charAt(index);
                    sb.append(currentChar);

                    while(true) {
                        boolean isPrime = true;//assume
                        index+=1;
                        for(int i=index+1;i<Math.sqrt(index);i++) {
                            if(index % i == 0) {
                                isPrime = false;
                                break;
                                //not a prime
                            }
                        }
                        if(isPrime) {
                            break;
                        }
                    }
                }

                break;
            case UPPERCASE_ALONE:
                sb.setLength(0);
                index = 0;

                for(;index<param.customPhraseToInclude.length();index++) {
                    char val = param.customPhraseToInclude.charAt(index);
                    if(Character.isUpperCase(val)) {
                        sb.append(val);
                    }
                }
        }

        return sb.toString();
    }




}
