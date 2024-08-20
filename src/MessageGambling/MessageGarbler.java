package MessageGambling;

public class MessageGarbler {
    // The size of the blocks used in this MessageGarbler
    public int m;

    /**
     * Creates a MessageGarbler that splits any messages it receives into blocks of size m, the last block will contain the remainder
     *
     * @param m
     */
    public MessageGarbler(int m) {
        this.m = m;
    }

    /**
     * Encrypts a message by splitting the message into blocks of size m and reversing each block.
     *
     * @param message the message to be encrypted
     * @return
     */
    public char[] encrypt(char[] message) {
        if (message == null || message.length == 1) {
            return message;
        }
        for (int i = 0; i < message.length; i += m) {
            int start = i;
            int end = i + m - 1;
            if (end >= message.length - 1) {
                end = message.length-1;
            }
            while (start <= end) {
                char temp = message[start];
                message[start] = message[end];
                message[end] = temp;
                start++;
                end--;
            }
        }
        return message;
    }

    public static void main(String[] args) {
        String message = "attack the coatis.";
        MessageGarbler mg = new MessageGarbler(3);
        System.out.println(mg.encrypt(message.toCharArray()));
    }
}
