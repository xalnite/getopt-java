/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.xalnite.util;

import static com.github.xalnite.util.Option.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OptionTest {
    private static final String NL = System.getProperty("line.separator");

    @BeforeMethod
    public void initialize() {
        opterr = true;
        optind = 0;
        optarg = null;
        optopt = EOF;
    }

    @Test
    public void initialState() {
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isZero();
                softly.assertThat(optopt).isEqualTo(EOF);

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void noArguments() {
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt("cmd", new String[0], ":abf:o:")).isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isZero();
                softly.assertThat(optopt).isEqualTo(EOF);

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void noOptions() {
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt("cmd", new String[] {"foo", "bar", "baz"}, ":abf:o:"))
                        .isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isZero();
                softly.assertThat(optopt).isEqualTo(EOF);

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void combinedOptions() {
        String progname = "cmd";
        String[] args = new String[] {"-ab", "foo", "bar", "baz"};
        String optstring = ":abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('a');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isZero();
                softly.assertThat(optopt).isEqualTo('a');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('b');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void separatedOptions() {
        String progname = "cmd";
        String[] args = new String[] {"-a", "-b", "foo", "bar", "baz"};
        String optstring = ":abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('a');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('a');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('b');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(2);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(2);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void combinedOptionsWithArgument() {
        String progname = "cmd";
        String[] args = new String[] {"-ba", "-oarg", "foo", "bar", "baz"};
        String optstring = ":abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('b');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isZero();
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('a');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('a');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('o');
                softly.assertThat(optarg).isEqualTo("arg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(2);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isEqualTo("arg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(2);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void separatedOptionsWithArgument() {
        String progname = "cmd";
        String[] args = new String[] {"-o", "arg", "-b", "foo", "bar", "baz"};
        String optstring = ":abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('o');
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(optarg).isEqualTo("arg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(2);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('b');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(3);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(3);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void combinedAllOptions() {
        String progname = "cmd";
        String[] args = new String[] {"-aobarg", "foo", "bar", "baz"};
        String optstring = ":abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('a');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isZero();
                softly.assertThat(optopt).isEqualTo('a');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('o');
                softly.assertThat(optarg).isEqualTo("barg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isEqualTo("barg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void terminateOptionParsing() {
        String progname = "cmd";
        String[] args = new String[] {"-o", "arg", "--", "-b", "foo", "bar", "baz"};
        String optstring = ":abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('o');
                softly.assertThat(optarg).isEqualTo("arg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(2);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isEqualTo("arg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(3);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void terminateOptionParsingFromTheBeginning() {
        String progname = "cmd";
        String[] args = new String[] {"--", "-o", "arg", "-b", "foo", "bar", "baz"};
        String optstring = ":abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo(EOF);

                softly.assertThat(stream.size()).isZero();
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void withoutOptionArgument() {
        String progname = "cmd";
        String[] args = new String[] {"-a", "-b", "-f"};
        String optstring = "abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('a');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('a');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('b');
                softly.assertThat(optarg).isNull();;
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(2);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('?');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(3);
                softly.assertThat(optopt).isEqualTo('f');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(3);
                softly.assertThat(optopt).isEqualTo('f');

                softly.assertThat(stream.toString())
                        .isEqualTo("cmd: option requires an argument -- f" + NL);
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }

    @Test
    public void unknownOption() {
        String progname = "cmd";
        String[] args = new String[] {"-a", "-o", "arg", "-k", "-b", "foo", "bar", "baz"};
        String optstring = "abf:o:";
        PrintStream stderr = System.err;
        try {
            SoftAssertions.assertSoftly(softly -> {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                PrintStream output = new PrintStream(stream);
                System.setErr(output);

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('a');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(1);
                softly.assertThat(optopt).isEqualTo('a');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('o');
                softly.assertThat(optarg).isEqualTo("arg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(3);
                softly.assertThat(optopt).isEqualTo('o');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('?');
                softly.assertThat(optarg).isEqualTo("arg");
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(4);
                softly.assertThat(optopt).isEqualTo('k');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo('b');
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(5);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(getopt(progname, args, optstring)).isEqualTo(EOF);
                softly.assertThat(optarg).isNull();
                softly.assertThat(opterr).isTrue();
                softly.assertThat(optind).isEqualTo(5);
                softly.assertThat(optopt).isEqualTo('b');

                softly.assertThat(stream.toString()).isEqualTo("cmd: illegal option -- k" + NL);
                softly.assertThat(output.checkError()).isFalse();
            });
        }
        finally {
            System.setErr(stderr);
        }
    }
}
