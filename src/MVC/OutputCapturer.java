package MVC;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

/** A class with static methods for capturing console output.
 *  Useful for capturing the result of methods that do printlns.
 */
public class OutputCapturer {
    private static final PrintStream SYSTEM_OUT = java.lang.System.out;
    private static final PrintStream SYSTEM_ERR = java.lang.System.err;
    private static ByteArrayOutputStream outputStream = null;
    
    /** Returns true if output is currently being captured. */
    public static boolean isCapturing() {
        return outputStream != null;
    }

    /** Begins capturing output with no limit as to its length. */
    public static void start() {
        start(true);
    }
    
    /** 
     * Begins capturing output.  Will throw an exception if the student 
     * printlns too much.  Stops and discard any previously captured output.
     * @param limit if true, tells the print stream to throw an exception
     *              if the client uses it too many times or prints too much.
     */
    public static void start(boolean limit) {
        if (isCapturing()) {
            stop();
        }
        
        outputStream = new ByteArrayOutputStream(16384);
        PrintStream out;
        if (limit) {
            out = new LimitedPrintStream(outputStream);
        } else {
            out = new PrintStream(outputStream);
        }
        System.setOut(out);
        System.setErr(out);
    }
    
    /** Stops capturing output and returns the string of captured output. */
    public static String stop() {
        System.out.flush();
        System.err.flush();
        System.setOut(SYSTEM_OUT);
        System.setErr(SYSTEM_ERR);
        String actualOutput = "";
        if (isCapturing()) {
            // fix line endings on Windows systems
            actualOutput = outputStream.toString().replace("\r", "");
        }
        outputStream = null;
        return actualOutput;
    }

    /** A special output print stream that can constrain how many times it can be used
     *  before it will throw an exception.
     */
    private static class LimitedPrintStream extends PrintStream {
        private static final int MAX_CALLS = 5000;
        private static final int MAX_CHARS = 50000;

        private int calls = 0;
        private int chars = 0;
        private int maxCalls = 0;
        private int maxChars = 0;

        /** Constructs a new print stream to write to the given target,
         *  using a default max allowed number of characters and calls.
         */
        public LimitedPrintStream(java.io.OutputStream stream) {
            this(stream, MAX_CALLS, MAX_CHARS);
        }

        /** Constructs a new print stream to write to the given target,
         *  using a default max allowed number of characters and calls.
         */
        public LimitedPrintStream(File file) throws java.io.FileNotFoundException {
            this(file, MAX_CALLS, MAX_CHARS);
        }

        /** Constructs a new print stream to write to the given target,
         *  using a default max allowed number of characters and calls.
         */
        public LimitedPrintStream(String file) throws java.io.FileNotFoundException {
            this(file, MAX_CALLS, MAX_CHARS);
        }

        /** Constructs a new print stream to write to the given target,
         *  using the given allowed number of characters and calls.
         *  @throws IllegalArgumentException if either max is negative.
         */
        public LimitedPrintStream(java.io.OutputStream stream, int maxCalls, int maxChars) {
            super(stream);
            setMax(maxCalls, maxChars);
        }

        /** Constructs a new print stream to write to the given target,
         *  using the given allowed number of characters and calls.
         *  @throws IllegalArgumentException if either max is negative.
         */
        public LimitedPrintStream(File file, int maxCalls, int maxChars) throws java.io.FileNotFoundException {
            super(file);
            setMax(maxCalls, maxChars);
        }

        /** Constructs a new print stream to write to the given target,
         *  using the given allowed number of characters and calls.
         *  @throws IllegalArgumentException if either max is negative.
         */
        public LimitedPrintStream(String file, int maxCalls, int maxChars) throws java.io.FileNotFoundException {
            super(file);
            setMax(maxCalls, maxChars);
        }

        // shouldn't close System.out anyway
        public void close() {}
        
        // all methods below wrap java.io.PrintStream methods; see those API docs

        public void print(int x) {
            print(String.valueOf(x));
        }

        public void print(double x) {
            print(String.valueOf(x));
        }

        public void print(float x) {
            print(String.valueOf(x));
        }

        public void print(long x) {
            print(String.valueOf(x));
        }

        public void print(short x) {
            print(String.valueOf(x));
        }

        public void print(byte x) {
            print(String.valueOf(x));
        }

        public void print(boolean x) {
            print(String.valueOf(x));
        }

        public void print(char x) {
            print(String.valueOf(x));
        }

        public void print(Object x) {
            print(String.valueOf(x));
        }

        public void print(String x) {
            // count one call and the number of characters printed
            calls++;
            chars += (x == null) ? 4 : x.length();

            if (calls < maxCalls && chars < maxChars) {
                super.print(x);
            } else {
                throw new ExcessiveOutputException();
            }
        }

        public void println(int x) {
            println(String.valueOf(x));
        }

        public void println(double x) {
            println(String.valueOf(x));
        }

        public void println(float x) {
            println(String.valueOf(x));
        }

        public void println(long x) {
            println(String.valueOf(x));
        }

        public void println(short x) {
            println(String.valueOf(x));
        }

        public void println(byte x) {
            println(String.valueOf(x));
        }

        public void println(boolean x) {
            println(String.valueOf(x));
        }

        public void println(char x) {
            println(String.valueOf(x));
        }

        public void println(Object x) {
            println(String.valueOf(x));
        }

        public void println(String x) {
            print(x);     // funnel all calls to println through print method
            print("\n");
            calls--;      // called print twice; shouldn't count as 2 calls
        }
        
        /** Sets this stream to use the given allowed number of chars/calls.
         *  @throws IllegalArgumentException if either max is negative.
         */
        private void setMax(int maxCalls, int maxChars) {
            if (maxCalls < 0 || maxChars < 0) {
                throw new IllegalArgumentException("illegal max calls/chars: " + 
                        maxCalls + " " + maxChars);
            }
            this.maxCalls = maxCalls;
            this.maxChars = maxChars;
        }
    }

    /** Class representing an exception to throw if too much output is produced. */
    public static class ExcessiveOutputException extends RuntimeException {
        private static final long serialVersionUID = 0;
        
        /** Constructs a new exception with a default message. */
        public ExcessiveOutputException() {
            super();
        }    

        /** Constructs a new exception with the given message. */
        public ExcessiveOutputException(String message) {
            super(message);
        }    
    }
}