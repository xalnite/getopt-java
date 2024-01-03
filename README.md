# getopt-java

Java port of public domain getopt

## specification

- import static com.github.xalnite.util.Option.\*
- public static final char EOF = (char)-1
- public static char getopt(String progname, String[] args, String optstring)
- public static String optarg
- public static int optind
- public static boolean opterr
- public static char optopt

## about

- [getopt - Wikipedia](https://en.wikipedia.org/wiki/Getopt)

## references

### specification of original C language version

- [getopt - IEEE Std 1003.1, 2004 Edition](https://pubs.opengroup.org/onlinepubs/009696799/functions/getopt.html)
- [getopt(3) - SunOS 4.1.3](https://man.freebsd.org/cgi/man.cgi?query=getopt&apropos=0&sektion=3&manpath=SunOS+4.1.3&arch=default&format=html)
- [getopt(3) - Linux manual page](https://man7.org/linux/man-pages/man3/getopt.3.html)

### implementations of original C language version

- [public domain AT&amp;T getopt source](https://www.tuhs.org/Usenet/mod.std.unix/1985-November/000057.html)
- [getopt.c](https://www.x.org/archive/unsupported/programs/maze/getopt.c)
- [public domain AT&amp;T getopt source](https://www.linux.co.cr/unix-source-code/review/1985/1103.html)
- [getopt.c](https://opensource.apple.com/source/patch_cmds/patch_cmds-17/diffstat/porting/getopt.c.auto.html)
