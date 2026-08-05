class Logger {
    HashMap<String, Integer> messages;
    public Logger() {
        messages = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean shouldPrint = !messages.containsKey(message) || messages.get(message) + 10 <= timestamp;

        if(shouldPrint) {
            messages.put(message, timestamp);
        }
        
        return shouldPrint;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
