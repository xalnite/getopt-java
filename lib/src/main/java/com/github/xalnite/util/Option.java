/*
 * Here's something you've all been waiting for:  the AT&T public domain
 * source for getopt(3).  It is the code which was given out at the 1985
 * UNIFORUM conference in Dallas.  I obtained it by electronic mail
 * directly from AT&T.  The people there assure me that it is indeed
 * in the public domain.
 *
 * There is no manual page.  That is because the one they gave out at
 * UNIFORUM was slightly different from the current System V Release 2
 * manual page.  The difference apparently involved a note about the
 * famous rules 5 and 6, recommending using white space between an option
 * and its first argument, and not grouping options that have arguments.
 * Getopt itself is currently lenient about both of these things White
 * space is allowed, but not mandatory, and the last option in a group can
 * have an argument.  That particular version of the man page evidently
 * has no official existence, and my source at AT&T did not send a copy.
 * The current SVR2 man page reflects the actual behavor of this getopt.
 * However, I am not about to post a copy of anything licensed by AT&T.
 */
package com.github.xalnite.util;

/**
 * A command-line option parser class.
 *
 * Provides the methods and fields to parse command-line arguments.
 */
public class Option {
    /* interface */
    /**
     * return value when all command-line options are parsed
     */
    public static final char EOF = (char) -1;
    /**
     * argument which the option takes
     */
    public static String optarg = null;
    /**
     * index of the next element of the args array to be processed
     */
    public static int optind = 0;
    /**
     * print a diagnostic message to stderr when an error occurs in option parse
     */
    public static boolean opterr = true;
    /**
     * option character that caused the error
     */
    public static char optopt = EOF;

    /* internal use */
    private static int sp = 1;

    private static void ERR(String progname, String s, char c) {
        System.err.println(progname + s + c);
    }

    /**
     * A command-line parser.
     *
     * Parses command-line arguments given in args to get options and indicate non-optional
     * arguments.
     *
     * @param progname program name represented by argv[0] in C language
     * @param args command-line argument array
     * @param optstring option string
     * @return the next option character specified on the command-line.
     *         otherwize, ':' when a missing argument is detected, '?' when an option character not
     *         in optstring is encountered or {@link EOF} when all command line options are parsed
     */
    public static char getopt(String progname, String[] args, String optstring) {
        return EOF;
    }
}
