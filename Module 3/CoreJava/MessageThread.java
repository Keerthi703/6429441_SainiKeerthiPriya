class MessageThread extends Thread {
    private final String message;
    public MessageThread(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message);
        }
    }
    public static void main(String[] args) {
        new MessageThread("Thread 1").start();
        new MessageThread("Thread 2").start();
    }
}
