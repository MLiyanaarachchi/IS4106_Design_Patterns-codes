//Simpleton design pattern
    public class Logger {
        private static Logger instance;

        private Logger() {
            // Initialize logger
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            // Log message to a file or console
            System.out.println(message);
        }
    }
    class displayLogger {
        public static void main(String[] args) {
            Logger logger = Logger.getInstance();
            logger.log("Application started.");

            Logger anotherLogger = Logger.getInstance();
            anotherLogger.log("Another log message.");
        }
    }


